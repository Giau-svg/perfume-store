package BUS;

import DAO.NotHuongDAO;
import DTO.NotHuongDTO;
import DTO.NotHuongDTO;

import java.util.ArrayList;

public class NotHuongBUS {
    private NotHuongDAO notHuongDAO;

    public NotHuongBUS() {
        this.notHuongDAO = new NotHuongDAO();
    }

    public ArrayList<NotHuongDTO> getAllNotHuongs() {
        return notHuongDAO.getAllNotHuongs();
    }

    public int themNotHuong(NotHuongDTO notHuongDTO) {
        // Return -1 if exist Brand name
        if (notHuongDAO.isExistNotHuong(notHuongDTO.getName())) {
            return -1;
        }

        // Return 1 if insert successfully
        if (notHuongDAO.insertNotHuong(notHuongDTO)) {
            return 1;
        }
        return 0;
    }

    public int suaNotHuong(NotHuongDTO notHuongDTO) {
        // Return -1 if exist Brand name
        if (notHuongDAO.isExistNotHuongExcept(notHuongDTO.getName(), notHuongDTO.getId())) {
            return -1;
        }

        // Return 1 if insert successfully
        if (notHuongDAO.updateNotHuong(notHuongDTO)) {
            return 1;
        }
        return 0;
    }

    public boolean xoaNotHuong(int id) {
        return notHuongDAO.softDeleteNotHuong(id);
    }
}
