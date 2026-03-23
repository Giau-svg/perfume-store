package DAO;

import DTO.ChiTietPhieuNhapDTO;
import java.sql.Connection;
import util.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChiTietPhieuNhapDAO {

    public List<ChiTietPhieuNhapDTO> getChiTietPhieuNhapByMaPhieu(int maPhieuNhap) {
        List<ChiTietPhieuNhapDTO> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();

        try {
            String sql = "SELECT ird.import_receipt_id, ird.perfume_id, ird.volume_id, ird.quantity, "
                    + "pv.cost AS cost, "
                    + "p.name AS perfume_name, p.sex, p.concentration, b.name AS brand, v.size AS volume_size "
                    + "FROM importreceiptdetail ird "
                    + "JOIN perfume p ON ird.perfume_id = p.id "
                    + "JOIN brand b ON p.brand_id = b.id "
                    + "JOIN perfume_volume pv ON ird.perfume_id = pv.perfume_id AND ird.volume_id = pv.volume_id "
                    + "JOIN volume v ON pv.volume_id = v.id "
                    + "WHERE ird.import_receipt_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maPhieuNhap);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ChiTietPhieuNhapDTO detail = new ChiTietPhieuNhapDTO(
                        rs.getInt("import_receipt_id"),
                        rs.getInt("perfume_id"),
                        rs.getInt("volume_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("cost"),
                        rs.getString("perfume_name"),
                        rs.getString("volume_size") + "ml",
                        rs.getString("sex"),
                        rs.getString("concentration"),
                        rs.getString("brand")
                );

                list.add(detail);
            }

            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean insertChiTietPhieuNhap(List<ChiTietPhieuNhapDTO> details) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO importreceiptdetail (import_receipt_id, perfume_id, volume_id, quantity) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            for (ChiTietPhieuNhapDTO detail : details) {
                ps.setInt(1, detail.getImportReceiptId());
                ps.setInt(2, detail.getPerfumeId());
                ps.setInt(3, detail.getVolumeId());
                ps.setInt(4, detail.getQuantity());

                ps.addBatch();
            }

            ps.executeBatch();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(conn);
        }

        return false;
    }
}
