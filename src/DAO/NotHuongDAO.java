package DAO;

import DTO.NotHuongDTO;
import DTO.ThuongHieuDTO;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class NotHuongDAO {
    public ArrayList<NotHuongDTO> getAllNotHuongs() {
        ArrayList<NotHuongDTO> notHuongDTOArrayList = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM notes where is_deleted = 0";

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("note_name");

                NotHuongDTO notHuongDTO = new NotHuongDTO(id, name);
                notHuongDTOArrayList.add(notHuongDTO);
            }

            return notHuongDTOArrayList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean insertNotHuong(NotHuongDTO notHuongDTO) {
        Connection connection = DBConnection.getConnection();
        String sql = "insert into notes (note_name) values (?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, notHuongDTO.getName());

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

    public boolean isExistNotHuong(String name) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from notes where note_name = ? and is_deleted = 0";

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

    public boolean isExistNotHuongExcept(String name, int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from notes where note_name = ? and id <> ? and is_deleted = 0";

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

    public boolean updateNotHuong(NotHuongDTO notHuongDTO) {
        Connection connection = DBConnection.getConnection();
        String sql = "update notes set note_name = ? where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, notHuongDTO.getName());
            preparedStatement.setInt(2, notHuongDTO.getId());

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

    public boolean softDeleteNotHuong(int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "update notes set is_deleted = 1 where id = ?";

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
