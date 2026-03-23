package GUI.ThongKeHeThong;

import BUS.ThongKeBUS;
import DTO.ThongKeDTO;
import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;

public class ThongKeDoanhThu extends JPanel {
    private final ThongKeBUS bus = new ThongKeBUS();
    private JLabel lblCapital, lblRevenue, lblProfit;
    private JPanel pnlChart;
    private JTable tblDetail;

    public ThongKeDoanhThu() {
        initComponents();
        loadYearOverview();
        setUpTable();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10,10));

        // Summary panel
        JPanel pnlSum = new JPanel();
        lblCapital = createLabel(); lblRevenue = createLabel(); lblProfit = createLabel();
        pnlSum.add(lblCapital); pnlSum.add(lblRevenue); pnlSum.add(lblProfit);
        add(pnlSum, BorderLayout.NORTH);

        // Chart panel
        pnlChart = new JPanel(new BorderLayout());
        add(pnlChart, BorderLayout.CENTER);

        // Detail table
        tblDetail = new JTable(new DefaultTableModel(
            new Object[]{"Ngày","Vốn","Doanh thu","Lợi nhuận"}, 0
        ));
        add(new JScrollPane(tblDetail), BorderLayout.SOUTH);
    }

    private JLabel createLabel() {
        JLabel lbl = new JLabel("0", SwingConstants.CENTER);
        lbl.setPreferredSize(new java.awt.Dimension(200, 50));
        lbl.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        return lbl;
    }

    private void loadYearOverview() {
    // 1) Tính ngày từ đầu năm tới hôm nay
    LocalDate today = LocalDate.now();
    String from = today.withDayOfYear(1).toString();
    String to   = today.toString();

    // 2) Lấy dữ liệu thống kê
    List<ThongKeDTO> list = bus.getDoanhThu(from, to);
    double sumCap = list.stream().mapToDouble(ThongKeDTO::getCapital).sum();
    double sumRev = list.stream().mapToDouble(ThongKeDTO::getRevenue).sum();
    double sumPro = list.stream().mapToDouble(ThongKeDTO::getProfit).sum();

    // 3) Format tiền VND và set vào labels
    NumberFormat fmt = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
    lblCapital.setText("Vốn năm: "     + fmt.format(sumCap));
    lblRevenue.setText("Doanh thu năm: " + fmt.format(sumRev));
    lblProfit.setText("Lợi nhuận năm: " + fmt.format(sumPro));

    // Căn giữa text của các JLabel
    lblCapital.setHorizontalAlignment(SwingConstants.CENTER);
    lblRevenue.setHorizontalAlignment(SwingConstants.CENTER);
    lblProfit.setHorizontalAlignment(SwingConstants.CENTER);

    // 4) Vẽ biểu đồ cột doanh thu theo ngày
    DefaultCategoryDataset ds = new DefaultCategoryDataset();
    for (ThongKeDTO dto : list) {
        ds.addValue(dto.getRevenue(), "Doanh thu", dto.getDate());
    }
    ChartPanel cp = new ChartPanel(
        ChartFactory.createBarChart("Doanh thu theo ngày", "Ngày", "VND", ds)
    );
    pnlChart.removeAll();
    pnlChart.add(cp, BorderLayout.CENTER);
    pnlChart.revalidate();
    pnlChart.repaint();
    DecimalFormat decimalFormat = new DecimalFormat("#,##0");
    // 5) Đổ dữ liệu chi tiết vào JTable
    DefaultTableModel model = (DefaultTableModel) tblDetail.getModel();
    model.setRowCount(0);
    for (ThongKeDTO dto : list) {
        model.addRow(new Object[]{
            dto.getDate(),
                decimalFormat.format(dto.getCapital()),
            decimalFormat.format(dto.getRevenue()),
                decimalFormat.format(dto.getProfit())
        });
    }

    // 6) Căn giữa tất cả các cột trong table
    centerTableData(tblDetail);
}

    private void setUpTable() {
        // Set ẩn hiển thị ô vuông khi bấm vào cell
        tblDetail.setFocusable(false);

        // Set không cho cell có thể chỉnh sửa
        tblDetail.setDefaultEditor(Object.class, null);
    }

/**
 * Giúp căn giữa nội dung của mọi cột trong JTable.
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
}    