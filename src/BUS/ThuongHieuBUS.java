package BUS;

import DAO.ThuongHieuDAO;
import DTO.ThuongHieuDTO;

import java.util.ArrayList;

public class ThuongHieuBUS {

    private ThuongHieuDAO thuongHieuDAO;

    public ThuongHieuBUS() {
        this.thuongHieuDAO = new ThuongHieuDAO();
    }

    public ArrayList<ThuongHieuDTO> getAllThuongHieus() {
        return thuongHieuDAO.getAllThuongHieus();
    }

    public int themThuongHieu(ThuongHieuDTO thuongHieuDTO) {
        // Return -1 if exist Brand name
        if (thuongHieuDAO.isExistThuongHieu(thuongHieuDTO.getName())) {
            return -1;
        }

        // Return 1 if insert successfully
        if (thuongHieuDAO.insertThuongHieu(thuongHieuDTO)) {
            return 1;
        }
        return 0;
    }

    public int suaThuongHieu(ThuongHieuDTO thuongHieuDTO) {
        // Return -1 if exist Brand name
        if (thuongHieuDAO.isExistThuongHieuExcept(thuongHieuDTO.getName(), thuongHieuDTO.getId())) {
            return -1;
        }

        // Return 1 if insert successfully
        if (thuongHieuDAO.updateThuongHieu(thuongHieuDTO)) {
            return 1;
        }
        return 0;
    }

    public boolean xoaThuongHieu(int id) {
        return thuongHieuDAO.softDeleteThuongHieu(id);
    }

    public ArrayList<String> getAllBrandNames() {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<ThuongHieuDTO> brands = thuongHieuDAO.getAllThuongHieus();
        for (ThuongHieuDTO brand : brands) {
            names.add(brand.getName());
        }
        return names;
    }

    public int getIdByName(String name) {
        for (ThuongHieuDTO th : thuongHieuDAO.getAllThuongHieus()) {
            if (th.getName().equals(name)) {
                return th.getId();
            }
        }
        return -1;
    }
    
    private static final ThuongHieuBUS instance = new ThuongHieuBUS();

    public static ThuongHieuBUS getInstance() {
        return instance;
    }

}
