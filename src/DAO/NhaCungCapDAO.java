/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHangDTO;
import DTO.NhaCungCapDTO;
import DTO.NhaCungCapDTO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import util.DBConnection;

/**
 * @author hoang
 */
public class NhaCungCapDAO {

    public static List<NhaCungCapDTO> getAll() {
        List<NhaCungCapDTO> list = new ArrayList<>();
        String sql = "SELECT id, name, phone, email FROM supplier";
        Connection connection = DBConnection.getConnection();
        try (
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                NhaCungCapDTO s = new NhaCungCapDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email")
                );
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return list;
    }

    public ArrayList<NhaCungCapDTO> getAllNCCs() {
        ArrayList<NhaCungCapDTO> nccs = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM supplier WHERE is_deleted = 0";

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO(id, name, phone, email);
                nccs.add(nhaCungCapDTO);
            }

            return nccs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return null;
    }

    public boolean insertNhaCungCap(NhaCungCapDTO nhaCungCapDTO) {
        Connection connection = DBConnection.getConnection();
        String sql = "insert into supplier (name, phone, email) values (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nhaCungCapDTO.getName());
            preparedStatement.setString(2, nhaCungCapDTO.getPhone());
            preparedStatement.setString(3, nhaCungCapDTO.getEmail());

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

    public boolean isExistNCCPhoneNumber(String phoneNumber) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from supplier where phone = ?";

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

    public boolean isExistNCCEmail(String email) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from supplier where email = ?";

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

    public NhaCungCapDTO getNCCById(int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from supplier where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO(id, name, phone, email);
                return nhaCungCapDTO;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(connection);
        }

        return null;
    }

    public boolean isExistNCCEmailExcept(String email, int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from supplier where email = ? and id <> ?";

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

    public boolean isExistNCCPhoneNumberExcept(String phoneNumber, int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from supplier where phone = ? and id <> ?";

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

    public boolean updateNCC(NhaCungCapDTO nhaCungCapDTO) {
        Connection connection = DBConnection.getConnection();
        String sql = "update supplier set name = ?, phone = ?, email = ? where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nhaCungCapDTO.getName());
            preparedStatement.setString(2, nhaCungCapDTO.getPhone());
            preparedStatement.setString(3, nhaCungCapDTO.getEmail());
            preparedStatement.setInt(4, nhaCungCapDTO.getId());

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

    public boolean softDeleteNhaCungCap(int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "update supplier set is_deleted = 1 where id = ?";

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
