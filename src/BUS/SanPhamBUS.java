package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

public class SanPhamBUS {

    private final SanPhamDAO dao;

    public SanPhamBUS() {
        this.dao = new SanPhamDAO();
    }

    // Lấy danh sách tất cả sản phẩm (hiển thị bảng chính)
    public List<SanPhamDTO> getAllPerfumeViews() {
        return dao.getAllPerfumeViews();
    }

    // Lấy chi tiết 1 sản phẩm theo perfumeId và volumeSize
    public Map<String, Object> getChiTietSanPham(int perfumeId, int volumeSize) {
        return dao.getChiTietSanPham(perfumeId, volumeSize);
    }

    private static final SanPhamBUS instance = new SanPhamBUS();

    public static SanPhamBUS getInstance() {
        return instance;
    }

    public boolean saveFullSanPham(SanPhamDTO dto) {
        return dao.insertSanPham(dto) != -1;
    }

    public boolean updateSanPham(SanPhamDTO dto) {
        return dao.updateSanPham(dto);
    }

    public boolean deleteSanPham(int perfumeId, int volumeSize) {
        return dao.deleteSanPham(perfumeId, volumeSize);
    }

    public ArrayList<SanPhamDTO> getAllSanPhamTonKho() {
        return new ArrayList<>(dao.getAllPerfumeViews());
    }

    public int getVolumeIdBySize(int volumeSize) {
        return dao.getVolumeIdBySize(volumeSize);
    }

    public void congDonSoLuongTon(int perfumeId, int volumeId, int quantity) {
        dao.updateSoLuongTon(perfumeId, volumeId, quantity);
    }

    public boolean updateSanPhamVaVolume(SanPhamDTO dto, int oldVolumeId) {
        boolean updatedPerfume = SanPhamDAO.getInstance().updateSanPham(dto);
        boolean updatedVolume = SanPhamDAO.getInstance()
                .updateDungTichSanPham(dto.getId(), oldVolumeId, dto.getVolumeId(), dto.getPrice());

        return updatedPerfume && updatedVolume;
    }

}
