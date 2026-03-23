package util;

import javax.swing.*;

public class DialogUtil {
    public static void showPanelInDialog(JPanel panel, String title, JFrame parent) {
        JDialog dialog = new JDialog(parent, title, true); // true = modal
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.getContentPane().add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
    }
}
