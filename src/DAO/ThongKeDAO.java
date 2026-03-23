package DAO;

import DTO.ThongKeDTO;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDAO {
    private final Connection conn;

    public ThongKeDAO() {
        this.conn = DBConnection.getConnection();
    }

    /** 1) Thống kê doanh thu (capital, revenue, profit) theo ngày */
    public List<ThongKeDTO> thongKeDoanhThu(String fromDate, String toDate) {
        String sql = """
            SELECT 
              DATE(inv.issue_date) AS date,
              SUM(det.quantity * pv.cost)     AS capital,
              SUM(inv.total)                  AS revenue,
              SUM(inv.total) - SUM(det.quantity * pv.cost) AS profit
            FROM invoice inv
            JOIN invoicedetail det 
              ON inv.id = det.invoice_id
            JOIN perfume_volume pv 
              ON det.perfume_id = pv.perfume_id 
             AND det.volume_id  = pv.volume_id
            WHERE inv.issue_date BETWEEN ? AND ?
            GROUP BY date
            ORDER BY date
            """;

        List<ThongKeDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongKeDTO(
                  rs.getString("date"),
                  rs.getDouble("capital"),
                  rs.getDouble("revenue"),
                  rs.getDouble("profit")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    /** 2) Thống kê khách hàng: số hoá đơn và tổng tiền mua */
    public List<ThongKeDTO> thongKeKhachHang(String fromDate, String toDate) {
        String sql = """
            SELECT
              c.id           AS id,
              c.name         AS name,
              COUNT(inv.id)  AS quantity,
              SUM(inv.total) AS totalAmount
            FROM customer c
            JOIN invoice inv ON c.id = inv.customer_id
            WHERE inv.issue_date BETWEEN ? AND ?
            GROUP BY c.id, c.name
            ORDER BY totalAmount DESC
            """;

        List<ThongKeDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongKeDTO(
                  rs.getInt("id"),
                  rs.getString("name"),
                  rs.getInt("quantity"),
                  rs.getDouble("totalAmount")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    /** 3) Thống kê nhà cung cấp: số phiếu nhập và tổng tiền nhập */
    public List<ThongKeDTO> thongKeNhaCungCap(String fromDate, String toDate) {
        String sql = """
            SELECT
              s.id              AS id,
              s.name            AS name,
              COUNT(ir.id)      AS quantity,
              SUM(ir.total_cost) AS totalAmount
            FROM supplier s
            JOIN importreceipt ir ON s.id = ir.supplier_id
            WHERE ir.import_date BETWEEN ? AND ?
            GROUP BY s.id, s.name
            ORDER BY totalAmount DESC
            """;

        List<ThongKeDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongKeDTO(
                  rs.getInt("id"),
                  rs.getString("name"),
                  rs.getInt("quantity"),
                  rs.getDouble("totalAmount")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
