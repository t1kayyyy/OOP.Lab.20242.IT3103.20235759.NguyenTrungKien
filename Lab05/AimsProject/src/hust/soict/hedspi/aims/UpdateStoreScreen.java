package hust.soict.hedspi.aims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

public class UpdateStoreScreen extends JFrame {
    public UpdateStoreScreen(Store store) {
        setTitle("Cập nhật cửa hàng - Thêm sản phẩm");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 5, 5));

        JComboBox<String> typeCombo = new JComboBox<>(new String[]{"Book", "CD", "DVD"});
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField costField = new JTextField();

        JButton addBtn = new JButton("Thêm");

        add(new JLabel("Loại:"));
        add(typeCombo);
        add(new JLabel("Tiêu đề:"));
        add(titleField);
        add(new JLabel("Thể loại:"));
        add(categoryField);
        add(new JLabel("Giá:"));
        add(costField);
        add(new JLabel());
        add(addBtn);

        addBtn.addActionListener(e -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());
            String type = (String) typeCombo.getSelectedItem();

            if (type.equals("Book")) {
                store.addMedia(new Book(title, category, (int) cost, new ArrayList<>()));
            } else if (type.equals("CD")) {
                store.addMedia(new CompactDisc(title, category, cost));
            } else if (type.equals("DVD")) {
                store.addMedia(new DigitalVideoDisc(title, category, "Unknown", 0, cost));
            }

            JOptionPane.showMessageDialog(this, "Đã thêm " + type + " thành công!");
            titleField.setText("");
            categoryField.setText("");
            costField.setText("");
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
