package DAO;

import DTO.ChiTietHoaDonDTO;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonDAO {

    public List<ChiTietHoaDonDTO> getChiTietHoaDonByMaHoaDon(int invoiceId) {
        List<ChiTietHoaDonDTO> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = """
                SELECT 
                    idt.invoice_id,
                    pf.id AS perfume_id,
                    pf.name AS perfume_name,
                    pf.sex,
                    pf.concentration,
                    br.name AS brand_name,
                    v.size AS volume_size,
                    pv.price,
                    idt.quantity
                FROM invoicedetail idt
                JOIN perfume pf ON idt.perfume_id = pf.id
                JOIN perfume_volume pv ON pf.id = pv.perfume_id
                JOIN volume v ON pv.volume_id = v.id
                JOIN brand br ON pf.brand_id = br.id
                WHERE idt.invoice_id = ?
            """;

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, invoiceId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ChiTietHoaDonDTO detail = new ChiTietHoaDonDTO(
                        rs.getInt("invoice_id"),
                        rs.getInt("perfume_id"),
                        rs.getString("perfume_name"),
                        rs.getString("volume_size") + "ml",
                        rs.getString("sex"),
                        rs.getString("concentration"),
                        rs.getString("brand_name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
                list.add(detail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public boolean insertDetails(int invoiceId, List<ChiTietHoaDonDTO> list) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO invoicedetail (invoice_id, perfume_id, volume_id, quantity) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            for (ChiTietHoaDonDTO detail : list) {
                ps.setInt(1, invoiceId);
                ps.setInt(2, detail.getPerfumeId());
                ps.setInt(3, detail.getVolumeId());
                ps.setInt(4, detail.getQuantity());
                ps.addBatch();
            }

            ps.executeBatch();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
