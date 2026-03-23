/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

 package GUI;

 import GUI.ThongKeHeThong.ThongKeDoanhThu;
 import GUI.ThongKeHeThong.ThongKeKhachHang;
 import GUI.ThongKeHeThong.ThongKeNhaCungCap;
 
 /**
  * Panel chứa các tab thống kê chính: Doanh thu, Khách hàng, Nhà cung cấp
  */
 public class ThongKe extends javax.swing.JPanel {
     private ThongKeDoanhThu doanhThuTab;
     private ThongKeKhachHang khachHangTab;
     private ThongKeNhaCungCap nhaCungCapTab;
 
     /** Creates new form ThongKe */
     public ThongKe() {
         initComponents();
         initTabs();
         addTabs();
     }
 
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
     private void initComponents() {
         tabPaneThongKe = new javax.swing.JTabbedPane();
         setLayout(new java.awt.BorderLayout());
         add(tabPaneThongKe, java.awt.BorderLayout.CENTER);
     }// </editor-fold>                        
 
     /** Khởi tạo các panel con */
     private void initTabs() {
         doanhThuTab   = new ThongKeDoanhThu();
         khachHangTab  = new ThongKeKhachHang();
         nhaCungCapTab = new ThongKeNhaCungCap();
     }
 
     /** Thêm các tab vào JTabbedPane */
     private void addTabs() {
         tabPaneThongKe.addTab("Doanh thu", doanhThuTab);
         tabPaneThongKe.addTab("Khách hàng", khachHangTab);
         tabPaneThongKe.addTab("Nhà cung cấp", nhaCungCapTab);
     }
 
     // Variables declaration - do not modify                     
     private javax.swing.JTabbedPane tabPaneThongKe;
     // End of variables declaration                   
 }
 