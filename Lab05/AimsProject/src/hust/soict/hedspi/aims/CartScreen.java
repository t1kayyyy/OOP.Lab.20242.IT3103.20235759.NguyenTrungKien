package hust.soict.hedspi.aims;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import java.util.Collections;

public class CartScreen extends JFrame {
    private Cart cart;
    private DefaultListModel<Media> mediaModel;
    private JList<Media> mediaList;

    public CartScreen(Cart cart) {
        this.cart = cart;
        setTitle("Giỏ hàng");
        setSize(500, 350);
        setLayout(new BorderLayout());

        // Danh sách hiển thị media
        mediaModel = new DefaultListModel<>();
        for (Media m : cart.getItemsOrdered()) {
            mediaModel.addElement(m);
        }

        mediaList = new JList<>(mediaModel);
        mediaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(mediaList);

        add(scrollPane, BorderLayout.CENTER);

        // Panel nút điều khiển
        JPanel buttonPanel = new JPanel();
        JButton removeBtn = new JButton("Xóa");
        JButton sortCostBtn = new JButton("Sắp xếp: Cost -> Title");
        JButton sortTitleBtn = new JButton("Sắp xếp: Title -> Cost");
        JButton playBtn = new JButton("Phát");
        JButton orderBtn = new JButton("Đặt hàng");

        buttonPanel.add(removeBtn);
        buttonPanel.add(sortCostBtn);
        buttonPanel.add(sortTitleBtn);
        buttonPanel.add(playBtn);
        buttonPanel.add(orderBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        // Sự kiện nút
        removeBtn.addActionListener(e -> {
            Media selected = mediaList.getSelectedValue();
            if (selected != null) {
                cart.removeMedia(selected);
                mediaModel.removeElement(selected);
            }
        });

        sortCostBtn.addActionListener(e -> {
            cart.getItemsOrdered().sort(new MediaComparatorByCostTitle());
            refreshList();
        });

        sortTitleBtn.addActionListener(e -> {
            cart.getItemsOrdered().sort(new MediaComparatorByTitleCost());
            refreshList();
        });

        playBtn.addActionListener(e -> {
            Media selected = mediaList.getSelectedValue();
            if (selected instanceof Playable) {
                JOptionPane.showMessageDialog(this, "Đang phát: " + selected.getTitle(), "Phát Media", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Không thể phát: " + selected.getTitle(), "Lỗi", JOptionPane.WARNING_MESSAGE);
            }
        });

        orderBtn.addActionListener(e -> {
            cart.getItemsOrdered().clear();
            mediaModel.clear();
            JOptionPane.showMessageDialog(this, "Đã đặt hàng thành công!");
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void refreshList() {
        mediaModel.clear();
        for (Media m : cart.getItemsOrdered()) {
            mediaModel.addElement(m);
        }
    }
    
}
