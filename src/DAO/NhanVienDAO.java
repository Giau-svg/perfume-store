package DAO;

import DTO.NhanVienDTO;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class NhanVienDAO {
    public ArrayList<NhanVienDTO> getAllNhanViens() {
        ArrayList<NhanVienDTO> nhanVienDTOArrayList = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM employee inner join rolegroup on employee.rolegroup_id = rolegroup.id WHERE is_deleted = 0;";

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int roleGroupId = resultSet.getInt("employee.rolegroup_id");
                String name = resultSet.getString("employee.name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String roleGroupName = resultSet.getString("rolegroup.name");
                boolean status = resultSet.getBoolean("status");

                NhanVienDTO nhanVienDTO = new NhanVienDTO(id, roleGroupId, name, username, password, roleGroupName, status);
                nhanVienDTOArrayList.add(nhanVienDTO);
            }

            return nhanVienDTOArrayList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return null;
    }
    // Kiểm tra thông tin đăng nhập
    public NhanVienDTO checkLogin(String username, String password) {
        String sql = "SELECT employee.*, rolegroup.name AS roleGroupName " +
                     "FROM employee " +
                     "INNER JOIN rolegroup ON employee.rolegroup_id = rolegroup.id " +
                     "WHERE employee.username = ? AND employee.password = ? " +
                     "AND employee.status = 1 AND employee.is_deleted = 0";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    int roleGroupId = rs.getInt("rolegroup_id");
                    String name = rs.getString("name");
                    String roleGroupName = rs.getString("roleGroupName");
                    boolean status = rs.getBoolean("status");

                    return new NhanVienDTO(id, roleGroupId, name, username, password, roleGroupName, status);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean insertNhanVien(NhanVienDTO nhanVienDTO) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO employee (rolegroup_id, name, username, password, status) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nhanVienDTO.getRoleGroupId());
            preparedStatement.setString(2, nhanVienDTO.getName());
            preparedStatement.setString(3, nhanVienDTO.getUsername());
            preparedStatement.setString(4, nhanVienDTO.getPassword());
            preparedStatement.setBoolean(5, nhanVienDTO.isStatus());

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return false;
    }

    public boolean isExistNhanVienUsername(String username) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from employee where employee.username = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return false;
    }

    public boolean isExistNhanVienUsernameExcept(String username, int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from employee where employee.username = ? and id <> ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return false;
    }

    public NhanVienDTO getNhanVienById(int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from employee where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int rolegroup_id = resultSet.getInt("rolegroup_id");
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                boolean status = resultSet.getBoolean("status");

                NhanVienDTO nhanVienDTO = new NhanVienDTO(id, rolegroup_id, name, username, password, null, status);
                return nhanVienDTO;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return null;
    }

    public boolean updateNhanVien(NhanVienDTO nhanVienDTO) {
        Connection connection = DBConnection.getConnection();
        String sql = "update employee set rolegroup_id = ?, name = ?, username = ?, password = ?, status = ? where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nhanVienDTO.getRoleGroupId());
            preparedStatement.setString(2, nhanVienDTO.getName());
            preparedStatement.setString(3, nhanVienDTO.getUsername());
            preparedStatement.setString(4, nhanVienDTO.getPassword());
            preparedStatement.setBoolean(5, nhanVienDTO.isStatus());
            preparedStatement.setInt(6, nhanVienDTO.getId());

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return false;
    }

    public boolean softDeleteNhanVien(int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "update employee set is_deleted = 1 where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return false;
    }
}
