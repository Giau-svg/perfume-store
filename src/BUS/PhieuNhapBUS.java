/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.List;

public class PhieuNhapBUS {

    private PhieuNhapDAO phieuNhapDAO;
    private ChiTietPhieuNhapDAO chiTietPhieuNhapDAO;

    public PhieuNhapBUS() {
        phieuNhapDAO = new PhieuNhapDAO();
        chiTietPhieuNhapDAO = new ChiTietPhieuNhapDAO();
    }

    public ArrayList<PhieuNhapDTO> getAllPhieuNhap() {
        return phieuNhapDAO.getAllPhieuNhap();
    }

    public boolean deletePhieuNhap(int id) {
        return phieuNhapDAO.softDeletePhieuNhap(id);
    }

    public PhieuNhapDTO getPhieuNhap(int id) {
        return phieuNhapDAO.getPhieuNhapById(id);
    }
    // Hàm thêm mới phiếu nhập (có cả chi tiết)

    public boolean themPhieuNhap(int id, int supplierId, double totalCost, List<ChiTietPhieuNhapDTO> chiTietList) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        int newId = phieuNhapDAO.insertPhieuNhap(id, supplierId, now, totalCost);
        if (newId == -1) {
            return false;
        }

        for (ChiTietPhieuNhapDTO ct : chiTietList) {
            ct.setImportReceiptId(newId); // Gán id vừa tạo
        }

        boolean success = chiTietPhieuNhapDAO.insertChiTietPhieuNhap(chiTietList);
        return success;
    }

    
    public List<PhieuNhapDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<PhieuNhapDTO> getByNhaCungCap(int nccId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
