package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;

import java.util.ArrayList;

public class KhachHangBUS {
    private KhachHangDAO khachHangDAO;

    public KhachHangBUS() {
        khachHangDAO = new KhachHangDAO();
    }

    public ArrayList<KhachHangDTO> getAllKhachHangs() {
        return khachHangDAO.getAllKhachHangs();
    }

    public int addKhachHang(KhachHangDTO khachHangDTO) {
        // Return -1 if exist KH Phone number
        if (khachHangDAO.isExistKhachHangPhoneNumber(khachHangDTO.getPhone())) {
            return -1;
        }

        // Return -2 if exists KH Email
        if (khachHangDAO.isExistKhachHangEmail(khachHangDTO.getEmail())) {
            return -2;
        }

        // Return 1 if insert successfully
        if (khachHangDAO.insertKhachHang(khachHangDTO)) {
            return 1;
        }
        return 0;
    }

    public KhachHangDTO getKhachHang(int id) {
        return khachHangDAO.getKhachHangById(id);
    }

    public int updateKhachHang(KhachHangDTO khachHangDTO) {
        // Return -1 if exist KH Phone number
        if (khachHangDAO.isExistKhachHangPhoneNumberExcept(khachHangDTO.getPhone(), khachHangDTO.getId())) {
            return -1;
        }

        // Return -2 if exists KH Email
        if (khachHangDAO.isExistKhachHangEmailExcept(khachHangDTO.getEmail(), khachHangDTO.getId())) {
            return -2;
        }

        // Return 1 if insert successfully
        if (khachHangDAO.updateKhachHang(khachHangDTO)) {
            return 1;
        }
        return 0;
    }

    public boolean xoaKhachHang(int id) {
        return khachHangDAO.softDeleteKhachHang(id);
    }
}
