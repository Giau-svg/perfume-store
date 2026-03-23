package BUS;

import DAO.NhanVienDAO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;

import java.util.ArrayList;

public class NhanVienBUS {
    private NhanVienDAO nhanVienDAO;

    public NhanVienBUS() {
        this.nhanVienDAO = new NhanVienDAO();
    }

    public ArrayList<NhanVienDTO> getAllNhanViens() {
        return nhanVienDAO.getAllNhanViens();
    }

    public int addNhanVien(NhanVienDTO nhanVienDTO) {
        // Return -1 if exist KH Phone number
        if (nhanVienDAO.isExistNhanVienUsername(nhanVienDTO.getUsername())) {
            return -1;
        }

        // Return 1 if insert successfully
        if (nhanVienDAO.insertNhanVien(nhanVienDTO)) {
            return 1;
        }
        return 0;
    }

    public NhanVienDTO getNhanVien(int id) {
        return nhanVienDAO.getNhanVienById(id);
    }

    public int suaNhanVien(NhanVienDTO nhanVienDTO) {
        // Return -1 if exist KH Phone number
        if (nhanVienDAO.isExistNhanVienUsernameExcept(nhanVienDTO.getUsername(), nhanVienDTO.getId())) {
            return -1;
        }

        // Return 1 if insert successfully
        if (nhanVienDAO.updateNhanVien(nhanVienDTO)) {
            return 1;
        }
        return 0;
    }

    public boolean xoaNhanVien(int id) {
        return nhanVienDAO.softDeleteNhanVien(id);
    }
    public NhanVienDTO login(String username, String password) {
    return nhanVienDAO.checkLogin(username, password);
}

}
