package DAO;

import DTO.KhachHangDTO;
import DTO.KhuyenMaiDTO;
import DTO.NhanVienDTO;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class KhuyenMaiDAO {
    public ArrayList<KhuyenMaiDTO> getAllKhuyenMais() {
        ArrayList<KhuyenMaiDTO> khuyenMaiDTOArrayList = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM promotion where is_deleted = 0";

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double discountPercent = resultSet.getDouble("discount_percent");
                Timestamp startDate = resultSet.getTimestamp("start_date");
                Timestamp endDate = resultSet.getTimestamp("end_date");

                KhuyenMaiDTO khuyenMaiDTO = new KhuyenMaiDTO(id, name, discountPercent, startDate, endDate);
                khuyenMaiDTOArrayList.add(khuyenMaiDTO);
            }

            return khuyenMaiDTOArrayList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addKhuyenMai(KhuyenMaiDTO khuyenMaiDTO) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO promotion (name, discount_percent, start_date, end_date) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, khuyenMaiDTO.getName());
            preparedStatement.setDouble(2, khuyenMaiDTO.getDiscountPercent());
            preparedStatement.setTimestamp(3, khuyenMaiDTO.getStartDate());
            preparedStatement.setTimestamp(4, khuyenMaiDTO.getEndDate());

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

    public boolean isExistTenKhuyenMai(String name) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from promotion where name = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

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

    public boolean isExistTenKhuyenMaiExcept(String name, int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from promotion where name = ? and id <> ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
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

    public KhuyenMaiDTO getKhuyenMaiById(int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from promotion where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                double discountPercent = resultSet.getDouble("discount_percent");
                Timestamp startDate = resultSet.getTimestamp("start_date");
                Timestamp endDate = resultSet.getTimestamp("end_date");

                KhuyenMaiDTO khuyenMaiDTO = new KhuyenMaiDTO(id, name, discountPercent, startDate, endDate);
                return khuyenMaiDTO;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return null;
    }

    public boolean updateKhuyenMai(KhuyenMaiDTO khuyenMaiDTO) {
        Connection connection = DBConnection.getConnection();
        String sql = "update promotion set name = ?, discount_percent = ?, start_date = ?, end_date = ? where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, khuyenMaiDTO.getName());
            preparedStatement.setDouble(2, khuyenMaiDTO.getDiscountPercent());
            preparedStatement.setTimestamp(3, khuyenMaiDTO.getStartDate());
            preparedStatement.setTimestamp(4, khuyenMaiDTO.getEndDate());
            preparedStatement.setInt(5, khuyenMaiDTO.getId());

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

    public boolean deleteKhuyenMai(int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "update promotion set is_deleted = 1 where id = ?";

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
