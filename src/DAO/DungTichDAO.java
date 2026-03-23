/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.DBConnection;

/**
 *
 * @author hoang
 */
public class DungTichDAO {

    public static int getSizeByVolumeId(int volumeId) {
        int size = 0;
        String sql = "SELECT size FROM Volume WHERE id = ?";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, volumeId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                size = rs.getInt("size");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return size;
    }

    public static int getIdBySize(int size) {
        String sql = "SELECT id FROM volume WHERE size = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, size);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<Integer> getAllVolumeSizes() {
        ArrayList<Integer> list = new ArrayList<>();
        String sql = "SELECT size FROM Volume";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(rs.getInt("size"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public int getVolumeIdBySize(int size) {
        int id = -1;
        String sql = "SELECT id FROM volume WHERE size = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, size);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    private static final DungTichDAO instance = new DungTichDAO();

    public static DungTichDAO getInstance() {
        return instance;
    }
}
