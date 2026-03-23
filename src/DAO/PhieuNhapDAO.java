/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhieuNhapDTO;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoang
 */
public class PhieuNhapDAO {

    public ArrayList<PhieuNhapDTO> getAllPhieuNhap() {
        ArrayList<PhieuNhapDTO> phieuNhaps = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT importreceipt.id, supplier.name AS supplier_name, import_date, total_cost "
                + "FROM importreceipt "
                + "JOIN supplier ON importreceipt.supplier_id = supplier.id "
                + "WHERE importreceipt.is_deleted = 0";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String supplierName = resultSet.getString("supplier_name");
                Timestamp importDate = resultSet.getTimestamp("import_date");
                double totalCost = resultSet.getDouble("total_cost");
                PhieuNhapDTO phieuNhapDTO = new PhieuNhapDTO(id, supplierName, importDate, totalCost);
                phieuNhaps.add(phieuNhapDTO);
            }
            return phieuNhaps;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }
        return null;
    }

    public PhieuNhapDTO getPhieuNhapById(int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from importreceipt where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String supplierId = resultSet.getString("supplier_id");
                Timestamp importDate = resultSet.getTimestamp("import_date");
                double totalCost = resultSet.getDouble("total_cost");

                PhieuNhapDTO phieuNhapDTO = new PhieuNhapDTO(id, supplierId, importDate, totalCost);
                return phieuNhapDTO;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return null;
    }

    public boolean softDeletePhieuNhap(int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE importreceipt SET is_deleted = 1 WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int rowAffected = preparedStatement.executeUpdate();
            return rowAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return false;
    }

    public int insertPhieuNhap(int id, int supplierId, Timestamp importDate, double totalCost) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO importreceipt (id, supplier_id, import_date, total_cost) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);             // <-- Dùng mã bạn truyền vào
            ps.setInt(2, supplierId);
            ps.setTimestamp(3, importDate);
            ps.setDouble(4, totalCost);

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0 ? id : -1; // Trả về chính id bạn cung cấp

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(conn);
        }
        return -1;
    }

    public List<PhieuNhapDTO> getByNhaCungCap(int nccId) {
        List<PhieuNhapDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM importreceipt WHERE supplier_id = ?";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, nccId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Tạo và add vào list
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<PhieuNhapDTO> searchBySupplierName(String keyword) {
        List<PhieuNhapDTO> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT importreceipt.id, supplier.name AS supplier_name, import_date, total_cost "
                + "FROM importreceipt "
                + "JOIN supplier ON importreceipt.supplier_id = supplier.id "
                + "WHERE importreceipt.is_deleted = 0 AND supplier.name LIKE ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String supplierName = rs.getString("supplier_name");
                Timestamp importDate = rs.getTimestamp("import_date");
                double totalCost = rs.getDouble("total_cost");

                PhieuNhapDTO dto = new PhieuNhapDTO(id, supplierName, importDate, totalCost);
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return list;
    }

}
