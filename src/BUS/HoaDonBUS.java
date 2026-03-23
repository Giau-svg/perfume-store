package BUS;

import DAO.HoaDonDAO;
import DAO.ChiTietHoaDonDAO;
import DTO.HoaDonDTO;
import DTO.ChiTietHoaDonDTO;
import java.util.ArrayList;

public class HoaDonBUS {
    private HoaDonDAO hoaDonDAO;
    private ChiTietHoaDonDAO chiTietHoaDonDAO;

    public HoaDonBUS() {
        hoaDonDAO = new HoaDonDAO();
        chiTietHoaDonDAO = new ChiTietHoaDonDAO();
    }

    public ArrayList<HoaDonDTO> getAllHoaDon() {
        return (ArrayList<HoaDonDTO>) hoaDonDAO.getAllHoaDon();
    }

    public ArrayList<HoaDonDTO> searchHoaDon(String keyword) {
        return hoaDonDAO.searchWithNames(keyword);
    }
    public boolean deleteHoaDon(int id) {
        return hoaDonDAO.deleteInvoice(id);
    }
    
}
