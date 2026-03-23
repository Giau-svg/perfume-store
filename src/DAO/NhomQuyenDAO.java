package DAO;

import DTO.NhomQuyenDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import util.DBConnection;

public class NhomQuyenDAO {

    // ✅ 1. Lấy danh sách nhóm quyền đơn giản
    public ArrayList<NhomQuyenDTO> getAllNhomQuyens() {
        ArrayList<NhomQuyenDTO> list = new ArrayList<>();

        String sql = "SELECT * FROM rolegroup";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                list.add(new NhomQuyenDTO(id, name));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ✅ 2. Lấy thông tin nhóm quyền (JOIN 3 bảng)
    public ArrayList<Object[]> getAllNhomQuyenThongTin() {
        ArrayList<Object[]> result = new ArrayList<>();

        String sql = """
                    SELECT 
                        rg.id AS group_id,
                        rg.name AS group_name,
                        GROUP_CONCAT(DISTINCT r.name SEPARATOR ', ') AS roles,
                        GROUP_CONCAT(DISTINCT e.name SEPARATOR ', ') AS employees
                    FROM rolegroup rg
                    LEFT JOIN role_rolegroup rr ON rg.id = rr.rolegroup_id AND rr.status = 1
                    LEFT JOIN role r ON rr.role_id = r.id
                    LEFT JOIN employee e ON rg.id = e.rolegroup_id
                    GROUP BY rg.id, rg.name
                    ORDER BY rg.id
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("group_id");
                String name = rs.getString("group_name");
                String roles = rs.getString("roles");
                String employees = rs.getString("employees");

                result.add(new Object[]{id, name, roles, employees});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // ✅ 3. Xóa nhóm quyền (gồm cả dữ liệu liên quan)
    public boolean deleteNhomQuyen(int id) {
        // Kiểm tra xem còn nhân viên nào đang thuộc nhóm quyền này không
        String checkSql = "SELECT COUNT(*) FROM employee WHERE rolegroup_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

            checkStmt.setInt(1, id);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                // Có nhân viên → không xóa
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        // Tiếp tục xóa nếu không có nhân viên
        String deleteRoles = "DELETE FROM role_rolegroup WHERE rolegroup_id = ?";
        String deleteGroup = "DELETE FROM rolegroup WHERE id = ?";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt1 = conn.prepareStatement(deleteRoles)) {
                stmt1.setInt(1, id);
                stmt1.executeUpdate();
            }

            try (PreparedStatement stmt2 = conn.prepareStatement(deleteGroup)) {
                stmt2.setInt(1, id);
                stmt2.executeUpdate();
            }

            conn.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Set<Integer> getRoleIdsByGroup(int groupId) {
        Set<Integer> roleIds = new HashSet<>();

        String sql = "SELECT role_id FROM role_rolegroup WHERE rolegroup_id = ? AND status = 1";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, groupId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                roleIds.add(rs.getInt("role_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return roleIds;
    }

}
