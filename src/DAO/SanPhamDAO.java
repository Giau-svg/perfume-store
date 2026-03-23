package DAO;

import DTO.SanPhamDTO;
import util.DBConnection;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class SanPhamDAO {

    public List<SanPhamDTO> getAllPerfumeViews() {
        List<SanPhamDTO> list = new ArrayList<>();
        String sql = """
        SELECT 
            p.id AS perfume_id,
            p.name,
            p.sex,
            p.images,
            p.concentration,
            b.id AS brand_id,
            b.name AS brand_name,
            p.promotion_id,
            v.id AS volume_id,
            v.size AS volume_size,
            pv.stock,
            pv.cost,
            pv.price
        FROM Perfume p
        JOIN Brand b ON p.brand_id = b.id
        JOIN Perfume_Volume pv ON p.id = pv.perfume_id
        JOIN Volume v ON pv.volume_id = v.id
        """;

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                SanPhamDTO dto = new SanPhamDTO();
                dto.setId(rs.getInt("perfume_id"));
                dto.setName(rs.getString("name"));
                dto.setSex(rs.getString("sex"));
                dto.setImages(rs.getString("images"));
                dto.setConcentration(rs.getString("concentration"));
                dto.setBrandId(rs.getInt("brand_id"));
                dto.setBrandName(rs.getString("brand_name"));
                dto.setPromotionId(rs.getInt("promotion_id"));
                dto.setVolumeId(rs.getInt("volume_id"));
                dto.setVolumeSize(rs.getInt("volume_size"));
                dto.setStock(rs.getInt("stock"));
                dto.setCost(rs.getDouble("cost"));
                dto.setPrice(rs.getDouble("price"));
                list.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Map<String, Object> getChiTietSanPham(int perfumeId, int volumeSize) {
        Map<String, Object> data = new HashMap<>();

        String sql = """
    SELECT 
        p.name AS perfume_name,
        p.sex,
        p.images,
        p.concentration,
        p.promotion_id,
        p.brand_id,
        b.name AS brand_name,
        pr.name AS promotion_name,
        v.id AS volume_id,
        v.size AS volume_size,
        pv.stock,
        pv.cost,
        pv.price
    FROM perfume p
    JOIN brand b ON p.brand_id = b.id AND b.is_deleted = 0
    LEFT JOIN promotion pr ON p.promotion_id = pr.id AND pr.is_deleted = 0
    JOIN perfume_volume pv ON p.id = pv.perfume_id
    JOIN volume v ON pv.volume_id = v.id
    WHERE p.id = ? AND v.size = ?
""";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, perfumeId);
            ps.setInt(2, volumeSize);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                data.put("name", rs.getString("perfume_name"));
                data.put("sex", rs.getString("sex"));
                data.put("images", rs.getString("images"));
                data.put("concentration", rs.getString("concentration"));
                data.put("brand_name", rs.getString("brand_name"));
                data.put("promotion_name", rs.getString("promotion_name"));  // có thể null
                data.put("volume_id", rs.getInt("volume_id"));
                data.put("volume_size", rs.getInt("volume_size"));
                data.put("stock", rs.getInt("stock"));
                data.put("cost", rs.getDouble("cost"));
                data.put("price", rs.getDouble("price"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Load các nốt hương
        data.put("top_notes", getNotes(perfumeId, "top"));
        data.put("middle_notes", getNotes(perfumeId, "heart"));
        data.put("base_notes", getNotes(perfumeId, "base"));

        return data;
    }

    private static List<String> getNotes(int perfumeId, String type) {
        List<String> notes = new ArrayList<>();
        String sql = """
        SELECT n.note_name
        FROM perfume_notes pn
        JOIN notes n ON pn.note_id = n.id
        WHERE pn.perfume_id = ? AND pn.type = ? AND n.is_deleted = 0
    """;

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, perfumeId);
            ps.setString(2, type);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                notes.add(rs.getString("note_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return notes;
    }

    public int insertSanPham(SanPhamDTO sp) {
        Connection conn = null;
        PreparedStatement psPerfume = null;
        PreparedStatement psVolume = null;
        PreparedStatement psNotes = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            // 1. Insert perfume
            String sqlPerfume = "INSERT INTO perfume (name, sex, images, concentration, brand_id, promotion_id) VALUES (?, ?, ?, ?, ?, ?)";
            psPerfume = conn.prepareStatement(sqlPerfume, Statement.RETURN_GENERATED_KEYS);
            psPerfume.setString(1, sp.getName());
            psPerfume.setString(2, sp.getSex());
            psPerfume.setString(3, sp.getImages());
            psPerfume.setString(4, sp.getConcentration());
            psPerfume.setInt(5, sp.getBrandId());
            psPerfume.setInt(6, sp.getPromotionId());
            psPerfume.executeUpdate();

            rs = psPerfume.getGeneratedKeys();
            int perfumeId = -1;
            if (rs.next()) {
                perfumeId = rs.getInt(1);
            } else {
                conn.rollback();
                return -1;
            }

            // 2. Kiểm tra trùng perfume_volume
            String checkSql = "SELECT COUNT(*) FROM perfume_volume WHERE perfume_id = ? AND volume_id = ?";
            try (PreparedStatement psCheck = conn.prepareStatement(checkSql)) {
                psCheck.setInt(1, perfumeId);
                psCheck.setInt(2, sp.getVolumeId());
                ResultSet rsCheck = psCheck.executeQuery();
                if (rsCheck.next() && rsCheck.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "Sản phẩm với dung tích này đã tồn tại!");
                    conn.rollback();
                    return -1;
                }
            }

            // 3. Insert perfume_volume
            String sqlVolume = "INSERT INTO perfume_volume (perfume_id, volume_id, price, stock, cost) VALUES (?, ?, ?, ?, ?)";
            psVolume = conn.prepareStatement(sqlVolume);
            psVolume.setInt(1, perfumeId);
            psVolume.setInt(2, sp.getVolumeId());
            psVolume.setDouble(3, sp.getPrice());
            psVolume.setInt(4, sp.getStock());
            psVolume.setDouble(5, sp.getCost());
            psVolume.executeUpdate();

            // 4. Insert perfume_notes
            String sqlNotes = "INSERT INTO perfume_notes (perfume_id, note_id, type) VALUES (?, ?, ?)";
            psNotes = conn.prepareStatement(sqlNotes);
            insertNotesBatch(psNotes, perfumeId, sp.getTopNotes(), "top");
            insertNotesBatch(psNotes, perfumeId, sp.getHeartNotes(), "heart");
            insertNotesBatch(psNotes, perfumeId, sp.getBaseNotes(), "base");

            conn.commit();
            return perfumeId;

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBConnection.close(conn);
        }

        return -1;
    }

    private void insertNotesBatch(PreparedStatement ps, int perfumeId, List<String> noteNames, String type) throws SQLException {
        for (String name : noteNames) {
            int noteId = getOrCreateNoteId(name.trim());
            ps.setInt(1, perfumeId);
            ps.setInt(2, noteId);
            ps.setString(3, type);
            ps.addBatch();
        }
        ps.executeBatch();
    }

    private int getOrCreateNoteId(String noteName) {
        String sqlSelect = "SELECT id FROM notes WHERE note_name = ? AND is_deleted = 0";
        String sqlInsert = "INSERT INTO notes (note_name) VALUES (?)";

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlSelect);
            ps.setString(1, noteName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            } else {
                ps = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, noteName);
                ps.executeUpdate();
                ResultSet keys = ps.getGeneratedKeys();
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    public boolean updateSanPham(SanPhamDTO sp) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            // 1. Cập nhật bảng perfume
            String sqlPerfume = "UPDATE perfume SET name = ?, sex = ?, images = ?, concentration = ?, brand_id = ?, promotion_id = ? WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(sqlPerfume)) {
                ps.setString(1, sp.getName());
                ps.setString(2, sp.getSex());
                ps.setString(3, sp.getImages());
                ps.setString(4, sp.getConcentration());
                ps.setInt(5, sp.getBrandId());
                ps.setInt(6, sp.getPromotionId());
                ps.setInt(7, sp.getId());
                ps.executeUpdate();
            }

            // 2. Cập nhật perfume_volume
            String sqlVolume = "UPDATE perfume_volume SET price = ?, cost = ?, stock = ? WHERE perfume_id = ? AND volume_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(sqlVolume)) {
                ps.setDouble(1, sp.getPrice());
                ps.setDouble(2, sp.getCost());
                ps.setInt(3, sp.getStock());
                ps.setInt(4, sp.getId());
                ps.setInt(5, sp.getVolumeId());
                ps.executeUpdate();
            }

            // 3. Xoá nốt hương cũ
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM perfume_notes WHERE perfume_id = ?")) {
                ps.setInt(1, sp.getId());
                ps.executeUpdate();
            }

            // 4. Chèn lại nốt hương mới
            String sqlNotes = "INSERT INTO perfume_notes (perfume_id, note_id, type) VALUES (?, ?, ?)";
            try (PreparedStatement psNotes = conn.prepareStatement(sqlNotes)) {
                insertNotesBatch(psNotes, sp.getId(), sp.getTopNotes(), "top");
                insertNotesBatch(psNotes, sp.getId(), sp.getHeartNotes(), "heart");
                insertNotesBatch(psNotes, sp.getId(), sp.getBaseNotes(), "base");
            }

            conn.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBConnection.close(conn);
        }
        return false;
    }

    public boolean deleteSanPham(int perfumeId, int volumeSize) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            // 1. Lấy volume_id từ volumeSize
            String getVolumeIdSql = "SELECT id FROM volume WHERE size = ?";
            ps = conn.prepareStatement(getVolumeIdSql);
            ps.setInt(1, volumeSize);
            rs = ps.executeQuery();

            int volumeId = -1;
            if (rs.next()) {
                volumeId = rs.getInt("id");
            } else {
                conn.rollback();
                return false;
            }

            // 2. Xóa dòng cụ thể trong perfume_volume
            String deleteVolumeSql = "DELETE FROM perfume_volume WHERE perfume_id = ? AND volume_id = ?";
            ps = conn.prepareStatement(deleteVolumeSql);
            ps.setInt(1, perfumeId);
            ps.setInt(2, volumeId);
            ps.executeUpdate();

            // 3. Kiểm tra xem còn bản ghi nào trong perfume_volume không
            String checkSql = "SELECT COUNT(*) AS total FROM perfume_volume WHERE perfume_id = ?";
            ps = conn.prepareStatement(checkSql);
            ps.setInt(1, perfumeId);
            rs = ps.executeQuery();

            if (rs.next() && rs.getInt("total") == 0) {
                // Không còn dung tích nào → xóa ở perfume_notes và perfume

                // 3.1. Xóa perfume_notes
                String deleteNotes = "DELETE FROM perfume_notes WHERE perfume_id = ?";
                ps = conn.prepareStatement(deleteNotes);
                ps.setInt(1, perfumeId);
                ps.executeUpdate();

                // 3.2. Xóa perfume
                String deletePerfume = "DELETE FROM perfume WHERE id = ?";
                ps = conn.prepareStatement(deletePerfume);
                ps.setInt(1, perfumeId);
                ps.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBConnection.close(conn);
        }

        return false;
    }

    public int getVolumeIdBySize(int size) {
        String sql = "SELECT id FROM Volume WHERE size = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, size);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void updateSoLuongTon(int perfumeId, int volumeId, int quantity) {
        String sql = "UPDATE Perfume_Volume SET stock = stock + ? WHERE perfume_id = ? AND volume_id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, quantity);
            ps.setInt(2, perfumeId);
            ps.setInt(3, volumeId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateDungTichSanPham(int perfumeId, int oldVolumeId, int newVolumeId, double price) {
        try (Connection conn = DBConnection.getConnection()) {
            // 1. Nếu không thay đổi dung tích → chỉ cần cập nhật giá
            if (oldVolumeId == newVolumeId) {
                String updateSql = "UPDATE perfume_volume SET price = ? WHERE perfume_id = ? AND volume_id = ?";
                try (PreparedStatement ps = conn.prepareStatement(updateSql)) {
                    ps.setDouble(1, price);
                    ps.setInt(2, perfumeId);
                    ps.setInt(3, newVolumeId);
                    return ps.executeUpdate() > 0;
                }
            }

            // 2. Nếu có thay đổi dung tích → kiểm tra xem bản ghi cũ đã được dùng ở đâu chưa
            String checkSql = "SELECT COUNT(*) FROM importreceiptdetail WHERE perfume_id = ? AND volume_id = ?";
            try (PreparedStatement checkPs = conn.prepareStatement(checkSql)) {
                checkPs.setInt(1, perfumeId);
                checkPs.setInt(2, oldVolumeId);
                ResultSet rs = checkPs.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    // Đã phát sinh nhập hàng → không được sửa dung tích
                    return false;
                }
            }

            // 3. Nếu chưa phát sinh → xóa dòng cũ
            String deleteSql = "DELETE FROM perfume_volume WHERE perfume_id = ? AND volume_id = ?";
            try (PreparedStatement deletePs = conn.prepareStatement(deleteSql)) {
                deletePs.setInt(1, perfumeId);
                deletePs.setInt(2, oldVolumeId);
                deletePs.executeUpdate();
            }

            // 4. Thêm dòng mới với dung tích mới
            String insertSql = "INSERT INTO perfume_volume (perfume_id, volume_id, price, stock, cost) VALUES (?, ?, ?, 0, 0)";
            try (PreparedStatement insertPs = conn.prepareStatement(insertSql)) {
                insertPs.setInt(1, perfumeId);
                insertPs.setInt(2, newVolumeId);
                insertPs.setDouble(3, price);
                return insertPs.executeUpdate() > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Trong SanPhamDAO.java
    public boolean daSuDungSanPham(int perfumeId, int volumeId) {
        String sql = "SELECT COUNT(*) FROM importreceiptdetail WHERE perfume_id = ? AND volume_id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, perfumeId);
            ps.setInt(2, volumeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static final SanPhamDAO instance = new SanPhamDAO();

    public static SanPhamDAO getInstance() {
        return instance;
    }

}
