package BUS;

import DAO.NhomQuyenDAO;
import DTO.NhomQuyenDTO;

import java.util.ArrayList;
import java.util.Set;

public class NhomQuyenBUS {
    private NhomQuyenDAO nhomQuyenDAO;

    public NhomQuyenBUS() {
        this.nhomQuyenDAO = new NhomQuyenDAO();
    }

    public ArrayList<NhomQuyenDTO> getAllNhomQuyens() {
        return  nhomQuyenDAO.getAllNhomQuyens();
    }
    public ArrayList<Object[]> getAllNhomQuyenThongTin() {
    return nhomQuyenDAO.getAllNhomQuyenThongTin();
}

    public boolean delete(int Id) {
    return nhomQuyenDAO.deleteNhomQuyen(Id);
    }
    public Set<Integer> getRoleIdsByGroup(int groupId) {
    return nhomQuyenDAO.getRoleIdsByGroup(groupId);
}
}    
    