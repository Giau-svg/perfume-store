// File: GUI/ThongKeHeThong/ThongKeKhachHang.java
package GUI.ThongKeHeThong;

import BUS.ThongKeBUS;
import DTO.ThongKeDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Panel Thống kê Khách hàng
 */
public class ThongKeKhachHang extends javax.swing.JPanel {
    private final ThongKeBUS bus = new ThongKeBUS();
    private JDateChooser dcFrom, dcTo;
    private DefaultTableModel model;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ThongKeKhachHang() {
        initComponents();
        initCustom();
        setUpTable();
    }

    private void initCustom() {
        // Date choosers
        dcFrom = new JDateChooser(new Date());
        dcTo   = new JDateChooser(new Date());
        pnlStartDate.add(dcFrom);
        pnlStartEnd .add(dcTo);

        // Table model
        model = (DefaultTableModel) tblThongKeKhachHang.getModel();

        // Events
        txtTenKhachHang.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                loadData();
            }
        });
        dcFrom.getDateEditor().addPropertyChangeListener(evt -> loadData());
        dcTo  .getDateEditor().addPropertyChangeListener(evt -> loadData());
        btnXuatExcel.addActionListener(e -> exportToExcel(tblThongKeKhachHang, "ThongKeKhachHang"));

        // Initial load
        loadData();
    }

    private void loadData() {
    try {
        // 1) Xác định khoảng ngày
        Date d1 = dcFrom.getDate() != null ? dcFrom.getDate() : new Date();
        Date d2 = dcTo  .getDate() != null ? dcTo  .getDate() : new Date();
        String from = sdf.format(d1);
        String to   = sdf.format(d2);

        // 2) Lấy danh sách và lọc theo tên
        List<ThongKeDTO> list = bus.getKhachHang(from, to);
        String key = txtTenKhachHang.getText().trim().toLowerCase();
        List<ThongKeDTO> filtered = list.stream()
            .filter(dto -> dto.getName().toLowerCase().contains(key))
            .collect(Collectors.toList());

        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        // 3) Đổ vào bảng
        model.setRowCount(0);
        int stt = 1;
        for (ThongKeDTO dto : filtered) {
            model.addRow(new Object[]{
                stt++,
                dto.getId(),
                dto.getName(),
                dto.getQuantity(),
                decimalFormat.format(dto.getTotalAmount())
            });
        }

        // 4) Căn giữa toàn bộ dữ liệu trong bảng
        centerTableData(tblThongKeKhachHang);

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

/**
 * Căn giữa nội dung cho tất cả cột của một JTable
 */
private void centerTableData(javax.swing.JTable table) {
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel()
             .getColumn(i)
             .setCellRenderer(centerRenderer);
    }
}

    private void exportToExcel(JTable table, String sheetName) {
        // Gọi ExcelExporter.export(table, sheetName) khi đã có util
        JOptionPane.showMessageDialog(this, "Xuất Excel: " + sheetName);
    }

    private void setUpTable() {
        // Set ẩn hiển thị ô vuông khi bấm vào cell
        tblThongKeKhachHang.setFocusable(false);

        // Set không cho cell có thể chỉnh sửa
        tblThongKeKhachHang.setDefaultEditor(Object.class, null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        pnlLeft        = new javax.swing.JPanel();
        jLabel1        = new javax.swing.JLabel();
        txtTenKhachHang= new javax.swing.JTextField();
        pnlStartDate   = new javax.swing.JPanel();
        jLabel2        = new javax.swing.JLabel();
        pnlStartEnd    = new javax.swing.JPanel();
        jLabel3        = new javax.swing.JLabel();
        btnXuatExcel   = new javax.swing.JButton();
        pnlCenter      = new javax.swing.JPanel();
        jScrollPane2   = new javax.swing.JScrollPane();
        tblThongKeKhachHang = new javax.swing.JTable();

        setLayout(new BorderLayout());

        pnlLeft.setBackground(new java.awt.Color(255, 255, 255));
        pnlLeft.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlLeft.setPreferredSize(new java.awt.Dimension(285, 300));

        jLabel1.setText("Tên khách hàng :");
        pnlLeft.add(jLabel1);

        txtTenKhachHang.setPreferredSize(new java.awt.Dimension(200, 24));
        pnlLeft.add(txtTenKhachHang);

        jLabel2.setText("Từ ngày :");
        pnlLeft.add(jLabel2);
        pnlLeft.add(pnlStartDate);

        jLabel3.setText("Đến ngày :");
        pnlLeft.add(jLabel3);
        pnlLeft.add(pnlStartEnd);

        btnXuatExcel.setText("Xuất Excel");
        pnlLeft.add(btnXuatExcel);

        add(pnlLeft, BorderLayout.WEST);

        tblThongKeKhachHang.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"STT", "Mã khách hàng", "Tên khách hàng", "Số lượt phiếu", "Tổng tiền"}
        ));
        jScrollPane2.setViewportView(tblThongKeKhachHang);

        pnlCenter.setLayout(new BorderLayout());
        pnlCenter.add(jScrollPane2, BorderLayout.CENTER);
        add(pnlCenter, BorderLayout.CENTER);
    }

    // Variables declaration
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlCenter, pnlLeft, pnlStartDate, pnlStartEnd;
    private javax.swing.JTable tblThongKeKhachHang;
    private javax.swing.JTextField txtTenKhachHang;
    // End of variables declaration
}
