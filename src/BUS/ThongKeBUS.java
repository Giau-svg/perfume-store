package BUS;

import DAO.ThongKeDAO;
import DTO.ThongKeDTO;
import java.util.List;

public class ThongKeBUS {
    private final ThongKeDAO dao = new ThongKeDAO();

    /** Doanh thu từ–đến */
    public List<ThongKeDTO> getDoanhThu(String from, String to) {
        return dao.thongKeDoanhThu(from, to);
    }

    /** Khách hàng từ–đến */
    public List<ThongKeDTO> getKhachHang(String from, String to) {
        return dao.thongKeKhachHang(from, to);
    }

    /** Nhà cung cấp từ–đến */
    public List<ThongKeDTO> getNhaCungCap(String from, String to) {
        return dao.thongKeNhaCungCap(from, to);
    }
}
