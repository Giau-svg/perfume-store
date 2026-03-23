package DAO;

import DTO.KhachHangDTO;
import DTO.ThuongHieuDTO;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class ThuongHieuDAO {
    public ArrayList<ThuongHieuDTO> getAllThuongHieus() {
        ArrayList<ThuongHieuDTO> thuongHieuDTOArrayList = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM brand where is_deleted = 0";

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                ThuongHieuDTO thuongHieuDTO = new ThuongHieuDTO(id, name);
                thuongHieuDTOArrayList.add(thuongHieuDTO);
            }

            return thuongHieuDTOArrayList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return null;
    }

    public boolean insertThuongHieu(ThuongHieuDTO thuongHieuDTO) {
        Connection connection = DBConnection.getConnection();
        String sql = "insert into brand (name) values (?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, thuongHieuDTO.getName());

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

    public boolean isExistThuongHieu(String name) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from brand where name = ?";

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

    public boolean isExistThuongHieuExcept(String name, int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from brand where name = ? and id <> ?";

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

    public boolean updateThuongHieu(ThuongHieuDTO thuongHieuDTO) {
        Connection connection = DBConnection.getConnection();
        String sql = "update brand set name = ? where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, thuongHieuDTO.getName());
            preparedStatement.setInt(2, thuongHieuDTO.getId());

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

    public boolean softDeleteThuongHieu(int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "update brand set is_deleted = 1 where id = ?";

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
