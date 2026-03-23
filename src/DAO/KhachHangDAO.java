package DAO;

import DTO.KhachHangDTO;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class KhachHangDAO {

    public ArrayList<KhachHangDTO> getAllKhachHangs() {
        ArrayList<KhachHangDTO> khachHangs = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM customer WHERE is_deleted = 0";

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                KhachHangDTO khachHangDTO = new KhachHangDTO(id, name, phone, email);
                khachHangs.add(khachHangDTO);
            }

            return khachHangs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return null;
    }

    public boolean insertKhachHang(KhachHangDTO khachHangDTO) {
        Connection connection = DBConnection.getConnection();
        String sql = "insert into customer (name, phone, email) values (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, khachHangDTO.getName());
            preparedStatement.setString(2, khachHangDTO.getPhone());
            preparedStatement.setString(3, khachHangDTO.getEmail());

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

    public boolean isExistKhachHangPhoneNumber(String phoneNumber) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from customer where phone = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phoneNumber);

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

    public boolean isExistKhachHangPhoneNumberExcept(String phoneNumber, int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from customer where phone = ? and id <> ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phoneNumber);
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

    public boolean isExistKhachHangEmail(String email) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from customer where email = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);

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

    public boolean isExistKhachHangEmailExcept(String email, int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from customer where email = ? and id <> ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
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

    public KhachHangDTO getKhachHangById(int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from customer where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                KhachHangDTO khachHangDTO = new KhachHangDTO(id, name, phone, email);
                return khachHangDTO;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return null;
    }

    public boolean updateKhachHang(KhachHangDTO khachHangDTO) {
        Connection connection = DBConnection.getConnection();
        String sql = "update customer set name = ?, phone = ?, email = ? where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, khachHangDTO.getName());
            preparedStatement.setString(2, khachHangDTO.getPhone());
            preparedStatement.setString(3, khachHangDTO.getEmail());
            preparedStatement.setInt(4, khachHangDTO.getId());

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

    public boolean softDeleteKhachHang(int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "update customer set is_deleted = 1 where id = ?";

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
