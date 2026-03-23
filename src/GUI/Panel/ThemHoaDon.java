/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.SanPhamBUS;
import DAO.ChiTietHoaDonDAO;
import DAO.DungTichDAO;
import DAO.HoaDonDAO;
import DAO.SanPhamDAO;
import DTO.ChiTietHoaDonDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import GUI.HDon.ChonKhachHang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import GUI.HoaDon;
import util.DBConnection;

/**
 *
 * @author Administrator
 */
public class ThemHoaDon extends javax.swing.JPanel {

    private ArrayList<SanPhamDTO> listNuocHoa = new ArrayList<>();
    private static int loggedInEmployeeId;
    private static String loggedInEmployeeName;
    private int selectedCustomerId = -1;
    private HoaDon hoaDonGUI;

    public ThemHoaDon(HoaDon hoaDonGUI) {
        initComponents();
        loadDanhSachSanPham();
        setUpTable();
        centerTableData(tblsoluongsanpham);
        centerTableData(tblthongtinspdathem);
        txtmahoadon.setText(taoMaHoaDonTuDong());
        txtmahoadon.setEditable(false);
        setNhanVienDangNhap();

        this.hoaDonGUI = hoaDonGUI;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerpanel = new javax.swing.JPanel();
        leftcontent = new javax.swing.JPanel();
        containernhap = new javax.swing.JPanel();
        txtsoluong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnxoasanpham = new javax.swing.JButton();
        btnthem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblsoluongsanpham = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblthongtinspdathem = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtmahoadon = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtnhanvienbanhang = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txttongtien = new javax.swing.JLabel();
        btnxuathoadon = new javax.swing.JButton();
        txtkhachhang = new javax.swing.JTextField();
        btnchonkhachhang = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        containerpanel.setBackground(new java.awt.Color(255, 255, 255));
        containerpanel.setLayout(new java.awt.BorderLayout());

        containernhap.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        containernhap.setPreferredSize(new java.awt.Dimension(447, 385));

        txtsoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsoluongActionPerformed(evt);
            }
        });

        jLabel3.setText("Số lượng");

        btnxoasanpham.setBackground(new java.awt.Color(255, 102, 153));
        btnxoasanpham.setForeground(new java.awt.Color(255, 255, 255));
        btnxoasanpham.setText("Xóa sản phẩm");
        btnxoasanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoasanphamActionPerformed(evt);
            }
        });

        btnthem.setBackground(new java.awt.Color(0, 153, 255));
        btnthem.setForeground(new java.awt.Color(255, 255, 255));
        btnthem.setText("Thêm sản phẩm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containernhapLayout = new javax.swing.GroupLayout(containernhap);
        containernhap.setLayout(containernhapLayout);
        containernhapLayout.setHorizontalGroup(
            containernhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containernhapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnxoasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(containernhapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containernhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containernhapLayout.setVerticalGroup(
            containernhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containernhapLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(containernhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnxoasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        tblsoluongsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên sản phẩm", "Dung tích", "Số lượng tồn"
            }
        ));
        tblsoluongsanpham.setFocusTraversalPolicyProvider(true);
        tblsoluongsanpham.setRequestFocusEnabled(false);
        tblsoluongsanpham.setRowHeight(40);
        jScrollPane3.setViewportView(tblsoluongsanpham);
        if (tblsoluongsanpham.getColumnModel().getColumnCount() > 0) {
            tblsoluongsanpham.getColumnModel().getColumn(0).setMaxWidth(75);
        }

        tblthongtinspdathem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Dung tích", "Giới tính", "Nồng độ", "Thương hiệu", "Giá bán", "Số lượng"
            }
        ));
        tblthongtinspdathem.setRowHeight(30);
        jScrollPane2.setViewportView(tblthongtinspdathem);

        javax.swing.GroupLayout leftcontentLayout = new javax.swing.GroupLayout(leftcontent);
        leftcontent.setLayout(leftcontentLayout);
        leftcontentLayout.setHorizontalGroup(
            leftcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftcontentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftcontentLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(containernhap, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE))
                .addContainerGap())
        );
        leftcontentLayout.setVerticalGroup(
            leftcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftcontentLayout.createSequentialGroup()
                .addGroup(leftcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(containernhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        containerpanel.add(leftcontent, java.awt.BorderLayout.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setText("Nhân viên bán hàng");

        jLabel17.setText("Khách hàng");

        jLabel18.setText("Mã hóa đơn");

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("TỔNG TIỀN:");

        txttongtien.setText("0đ");

        btnxuathoadon.setBackground(new java.awt.Color(0, 153, 51));
        btnxuathoadon.setForeground(new java.awt.Color(255, 255, 255));
        btnxuathoadon.setText("Xuất hóa đơn");
        btnxuathoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxuathoadonActionPerformed(evt);
            }
        });

        txtkhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkhachhangActionPerformed(evt);
            }
        });

        btnchonkhachhang.setText("...");
        btnchonkhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchonkhachhangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnchonkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(txtmahoadon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(txtnhanvienbanhang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txttongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnxuathoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtmahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtnhanvienbanhang, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnchonkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnxuathoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        containerpanel.add(jPanel1, java.awt.BorderLayout.EAST);

        add(containerpanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        int selectedRow = tblsoluongsanpham.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm.");
            return;
        }

        String soLuongStr = txtsoluong.getText().trim();
        if (soLuongStr.isEmpty() || !soLuongStr.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng hợp lệ.");
            return;
        }

        int soLuong = Integer.parseInt(soLuongStr);
        if (soLuong <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0.");
            return;
        }

        int maSP = Integer.parseInt(tblsoluongsanpham.getValueAt(selectedRow, 0).toString());
        int volumeSize = Integer.parseInt(tblsoluongsanpham.getValueAt(selectedRow, 2).toString());
        int soLuongTon = Integer.parseInt(tblsoluongsanpham.getValueAt(selectedRow, 3).toString());

        if (soLuong > soLuongTon) {
            JOptionPane.showMessageDialog(this, "Số lượng vượt quá tồn kho (" + soLuongTon + " sản phẩm còn lại).");
            return;
        }

        SanPhamDTO selectedPerfume = null;
        for (SanPhamDTO sp : listNuocHoa) {
            if (sp.getId() == maSP && sp.getVolumeSize() == volumeSize) {
                selectedPerfume = sp;
                break;
            }
        }

        if (selectedPerfume == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tblthongtinspdathem.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            int existingId = Integer.parseInt(model.getValueAt(i, 0).toString());
            int existingVolume = Integer.parseInt(model.getValueAt(i, 2).toString().replace("ml", "").trim());

            if (existingId == maSP && existingVolume == volumeSize) {
                JOptionPane.showMessageDialog(this, "Sản phẩm đã có trong hóa đơn.");
                return;
            }
        }

        model.addRow(new Object[]{
            selectedPerfume.getId(),
            selectedPerfume.getName(),
            selectedPerfume.getVolumeSize() + "ml",
            selectedPerfume.getSex(),
            selectedPerfume.getConcentration(),
            selectedPerfume.getBrandName(),
            selectedPerfume.getPrice(),
            soLuong
        });

        txtsoluong.setText("");
        tinhTongTien();
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnxoasanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoasanphamActionPerformed
        int selectedRow = tblthongtinspdathem.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc chắn muốn xóa sản phẩm này?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return; // Không xóa nếu người dùng chọn "Không"
        }

        DefaultTableModel model = (DefaultTableModel) tblthongtinspdathem.getModel();
        model.removeRow(selectedRow);

        // Cập nhật lại STT sau khi xóa
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0); // Cột 0 là STT
        }
    }//GEN-LAST:event_btnxoasanphamActionPerformed

    private void txtkhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkhachhangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkhachhangActionPerformed

    private void btnchonkhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchonkhachhangActionPerformed
        ChonKhachHang dialog = new ChonKhachHang(null, true); // null: không có cha cụ thể
        dialog.setVisible(true);

        // Sau khi dialog đóng lại, lấy thông tin
        if (dialog.getSelectedCustomerId() != -1) { // kiểm tra có chọn hay không
            int maKhachHang = dialog.getSelectedCustomerId();
            String tenKhachHang = dialog.getSelectedCustomerName();

            txtkhachhang.setText(maKhachHang + " - " + tenKhachHang); // set text
            selectedCustomerId = maKhachHang; // lưu lại mã khách hàng để sau này ghi vào hóa đơn
        }
    }//GEN-LAST:event_btnchonkhachhangActionPerformed

    private void btnxuathoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxuathoadonActionPerformed
        int invoiceId = Integer.parseInt(txtmahoadon.getText().trim());
        int customerId = selectedCustomerId;
        int employeeId = loggedInEmployeeId;
        String tongTienStr = txttongtien.getText().replace("đ", "").replace(" ", "").trim();
        double totalAmount = Double.parseDouble(tongTienStr);
        Timestamp issueDate = new Timestamp(System.currentTimeMillis());

        ArrayList<ChiTietHoaDonDTO> chiTietList = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tblthongtinspdathem.getModel();

        DungTichDAO volumeDAO = new DungTichDAO();

        for (int i = 0; i < model.getRowCount(); i++) {
            int perfumeId = Integer.parseInt(model.getValueAt(i, 0).toString());
            String perfumeName = model.getValueAt(i, 1).toString();
            int volumeSize = Integer.parseInt(model.getValueAt(i, 2).toString().replace("ml", "").trim());
            String sex = model.getValueAt(i, 3).toString();
            String concentration = model.getValueAt(i, 4).toString();
            String brand = model.getValueAt(i, 5).toString();
            double price = Double.parseDouble(model.getValueAt(i, 6).toString());
            int quantity = Integer.parseInt(model.getValueAt(i, 7).toString());

            int volumeId = volumeDAO.getVolumeIdBySize(volumeSize);

            ChiTietHoaDonDTO chiTiet = new ChiTietHoaDonDTO(invoiceId, perfumeId, perfumeName,
                    volumeSize + "ml", sex, concentration, brand, price, quantity);
            chiTiet.setVolumeId(volumeId);

            chiTietList.add(chiTiet);
        }

        HoaDonDAO hoaDonDAO = new HoaDonDAO();
        ChiTietHoaDonDAO chiTietDAO = new ChiTietHoaDonDAO();

        boolean insertedHoaDon = hoaDonDAO.insertInvoice(invoiceId, customerId, employeeId, totalAmount, issueDate);
        boolean insertedChiTiet = chiTietDAO.insertDetails(invoiceId, chiTietList);

        boolean updatedStock = true;
        for (ChiTietHoaDonDTO ct : chiTietList) {
            boolean ok = hoaDonDAO.capNhatTonKhoSauBanHang(ct.getPerfumeId(), ct.getVolumeId(), ct.getQuantity());
            if (!ok) {
                updatedStock = false;
                break;
            }
        }

        if (insertedHoaDon && insertedChiTiet && updatedStock) {
            JOptionPane.showMessageDialog(this, "Xuất hóa đơn thành công!");
            resetForm();
            loadDanhSachSanPham(); // Cập nhật lại danh sách sản phẩm
            hoaDonGUI.loadHoaDonToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Xuất hóa đơn thất bại!");
        }
    }//GEN-LAST:event_btnxuathoadonActionPerformed


    private void txtsoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsoluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsoluongActionPerformed

    private void resetForm() {
        txtmahoadon.setText(taoMaHoaDonTuDong()); // Sau khi xuất xong thì tự tạo mã hóa đơn mới
        txtkhachhang.setText("");
        selectedCustomerId = -1; // Reset mã khách đã chọn
        txttongtien.setText("0đ");

        DefaultTableModel model = (DefaultTableModel) tblthongtinspdathem.getModel();
        model.setRowCount(0); // Clear bảng sản phẩm đã thêm
    }

    private void setUpTable() {
        // Set ẩn hiển thị ô vuông khi bấm vào cell 
        tblsoluongsanpham.setFocusable(false);
        tblthongtinspdathem.setFocusable(false);

        // Set không cho cell có thể chỉnh sửa 
        tblsoluongsanpham.setDefaultEditor(Object.class, null);
        tblthongtinspdathem.setDefaultEditor(Object.class, null);
    }

    public void centerTableData(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void loadDanhSachSanPham() {
        SanPhamBUS bus = new SanPhamBUS();
        ArrayList<SanPhamDTO> danhSach = bus.getAllSanPhamTonKho();

        // GÁN danh sách này cho listNuocHoa để đảm bảo đồng bộ
        listNuocHoa = danhSach;

        DefaultTableModel model = (DefaultTableModel) tblsoluongsanpham.getModel(); // Bảng bên trái
        model.setRowCount(0);

        for (SanPhamDTO sp : danhSach) {
            model.addRow(new Object[]{
                sp.getId(),
                sp.getName(),
                sp.getVolumeSize(),
                sp.getStock()
            });
        }
    }

    private void tinhTongTien() {
        DefaultTableModel model = (DefaultTableModel) tblthongtinspdathem.getModel();
        double tongTien = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            double giaBan = (double) model.getValueAt(i, 6); // Cột giá bán
            int soLuong = (int) model.getValueAt(i, 7);      // Cột số lượng
            tongTien += giaBan * soLuong;
        }

        txttongtien.setText(String.format("%.0f đ", tongTien)); // Hiển thị tổng tiền
    }

    private String taoMaHoaDonTuDong() {
        int nextId = 1;

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT MAX(id) AS max_id FROM invoice"; // ⚡ đổi đúng bảng hóa đơn
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                nextId = maxId + 1;
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(nextId);
    }

    private void setNhanVienDangNhap() {
        String displayText = loggedInEmployeeId + " - " + loggedInEmployeeName;
        txtnhanvienbanhang.setText(displayText);
        txtnhanvienbanhang.setEditable(false);
    }

    public static void setLoggedInEmployee(int id, String name) {
        loggedInEmployeeId = id;
        loggedInEmployeeName = name;
    }

    private void formatCurrencyField(javax.swing.JTextField textField) {
        String text = textField.getText().replace(",", "").trim();
        if (text.isEmpty()) {
            return;
        }

        try {
            double value = Double.parseDouble(text);
            textField.setText(String.format("%,d", (long) value));
        } catch (NumberFormatException e) {
            // Nếu nhập ký tự không hợp lệ thì bỏ qua không định dạng
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnchonkhachhang;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoasanpham;
    private javax.swing.JButton btnxuathoadon;
    private javax.swing.JPanel containernhap;
    private javax.swing.JPanel containerpanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel leftcontent;
    private javax.swing.JTable tblsoluongsanpham;
    private javax.swing.JTable tblthongtinspdathem;
    public javax.swing.JTextField txtkhachhang;
    private javax.swing.JTextField txtmahoadon;
    private javax.swing.JTextField txtnhanvienbanhang;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JLabel txttongtien;
    // End of variables declaration//GEN-END:variables

}
