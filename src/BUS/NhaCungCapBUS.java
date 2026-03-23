package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;

import java.util.ArrayList;

public class NhaCungCapBUS {
    private NhaCungCapDAO nhaCungCapDAO;

    public NhaCungCapBUS() {
        this.nhaCungCapDAO = new NhaCungCapDAO();
    }

    public ArrayList<NhaCungCapDTO> getAllNhaCungCaps() {
        return nhaCungCapDAO.getAllNCCs();
    }

    public int addNCC(NhaCungCapDTO nhaCungCapDTO) {
        // Return -1 if exist NCC Phone number
        if (nhaCungCapDAO.isExistNCCPhoneNumber(nhaCungCapDTO.getPhone())) {
            return -1;
        }

        // Return -2 if exists KH Email
        if (nhaCungCapDAO.isExistNCCEmail(nhaCungCapDTO.getEmail())) {
            return -2;
        }

        // Return 1 if insert successfully
        if (nhaCungCapDAO.insertNhaCungCap(nhaCungCapDTO)) {
            return 1;
        }
        return 0;
    }

    public NhaCungCapDTO getNCC(int id) {
        return nhaCungCapDAO.getNCCById(id);
    }

    public int updateNCC(NhaCungCapDTO nhaCungCapDTO) {
        // Return -1 if exist KH Phone number
        if (nhaCungCapDAO.isExistNCCPhoneNumberExcept(nhaCungCapDTO.getPhone(), nhaCungCapDTO.getId())) {
            return -1;
        }

        // Return -2 if exists KH Email
        if (nhaCungCapDAO.isExistNCCEmailExcept(nhaCungCapDTO.getEmail(), nhaCungCapDTO.getId())) {
            return -2;
        }

        // Return 1 if insert successfully
        if (nhaCungCapDAO.updateNCC(nhaCungCapDTO)) {
            return 1;
        }
        return 0;
    }

    public boolean xoaNhaCungCap(int id) {
        return nhaCungCapDAO.softDeleteNhaCungCap(id);
    }
}
