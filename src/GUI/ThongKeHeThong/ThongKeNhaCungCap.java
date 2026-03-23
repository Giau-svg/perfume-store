// File: GUI/ThongKeHeThong/ThongKeNhaCungCap.java
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
 * Panel Thống kê Nhà cung cấp
 */
public class ThongKeNhaCungCap extends javax.swing.JPanel {
    private final ThongKeBUS bus = new ThongKeBUS();
    private JDateChooser dcFrom, dcTo;
    private DefaultTableModel model;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ThongKeNhaCungCap() {
        initComponents();
        initCustom();
        setUpTable();
    }

    private void initCustom() {
        dcFrom = new JDateChooser(new Date());
        dcTo   = new JDateChooser(new Date());
        PnldateStart.add(dcFrom);
        PnldateEnd  .add(dcTo);

        model = (DefaultTableModel) tblThongKeNcc.getModel();

        txtnhacungcap.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                loadData();
            }
        });
        dcFrom.getDateEditor().addPropertyChangeListener(evt -> loadData());
        dcTo  .getDateEditor().addPropertyChangeListener(evt -> loadData());
        btnXuatExcel.addActionListener(e -> exportToExcel(tblThongKeNcc, "ThongKeNhaCungCap"));

        loadData();
    }

    /**
 * Tải dữ liệu thống kê Nhà cung cấp, đổ vào bảng và căn giữa các cột
 */
private void loadData() {
    try {
        // 1) Xác định khoảng ngày
        Date d1 = dcFrom.getDate() != null ? dcFrom.getDate() : new Date();
        Date d2 = dcTo  .getDate() != null ? dcTo  .getDate() : new Date();
        String from = sdf.format(d1);
        String to   = sdf.format(d2);

        // 2) Lấy danh sách và lọc theo tên
        List<ThongKeDTO> list = bus.getNhaCungCap(from, to);
        String key = txtnhacungcap.getText().trim().toLowerCase();
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
        centerTableData(tblThongKeNcc);

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
        // TODO: gọi ExcelExporter.export(table, sheetName)
        JOptionPane.showMessageDialog(this, "Xuất Excel: " + sheetName);
    }

    private void setUpTable() {
        // Set ẩn hiển thị ô vuông khi bấm vào cell
        tblThongKeNcc.setFocusable(false);

        // Set không cho cell có thể chỉnh sửa
        tblThongKeNcc.setDefaultEditor(Object.class, null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        PanelCenter   = new javax.swing.JPanel();
        jPanel1       = new javax.swing.JPanel();
        jLabel1       = new javax.swing.JLabel();
        txtnhacungcap = new javax.swing.JTextField();
        jLabel2       = new javax.swing.JLabel();
        PnldateStart  = new javax.swing.JPanel();
        jLabel3       = new javax.swing.JLabel();
        PnldateEnd    = new javax.swing.JPanel();
        btnXuatExcel  = new javax.swing.JButton();
        jScrollPane1  = new javax.swing.JScrollPane();
        tblThongKeNcc = new javax.swing.JTable();

        setLayout(new BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255,255,255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(285,500));

        jLabel1.setText("Tìm kiếm nhà cung cấp");
        jPanel1.add(jLabel1);

        txtnhacungcap.setPreferredSize(new java.awt.Dimension(200,24));
        jPanel1.add(txtnhacungcap);

        jLabel2.setText("Từ ngày");
        jPanel1.add(jLabel2);
        PnldateStart.setLayout(new javax.swing.BoxLayout(PnldateStart, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(PnldateStart);

        jLabel3.setText("Đến ngày");
        jPanel1.add(jLabel3);
        PnldateEnd.setLayout(new javax.swing.BoxLayout(PnldateEnd, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(PnldateEnd);

        btnXuatExcel.setText("Xuất Excel");
        jPanel1.add(btnXuatExcel);

        PanelCenter.setLayout(new BorderLayout());
        PanelCenter.add(jPanel1, BorderLayout.WEST);

        tblThongKeNcc.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"STT","Mã nhà cung cấp","Tên nhà cung cấp","Số lượng nhập","Tổng tiền"}
        ));
        jScrollPane1.setViewportView(tblThongKeNcc);
        PanelCenter.add(jScrollPane1, BorderLayout.CENTER);

        add(PanelCenter, BorderLayout.CENTER);
    }

    // Variables declaration
    private javax.swing.JPanel PanelCenter, PnldateEnd, PnldateStart, jPanel1;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThongKeNcc;
    private javax.swing.JTextField txtnhacungcap;
    // End of variables declaration
}
