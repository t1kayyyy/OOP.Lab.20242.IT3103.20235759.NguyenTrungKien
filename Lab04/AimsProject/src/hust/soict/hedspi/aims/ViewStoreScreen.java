package hust.soict.hedspi.aims;
import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class ViewStoreScreen extends JFrame {
    public ViewStoreScreen(Store store) {
        setTitle("Cửa hàng hiện tại");
        setSize(400, 300);
        setLayout(new BorderLayout());

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Media m : store.getItems()) {
            model.addElement(m.getTitle() + " - " + m.getCost() + " đ");
        }

        JList<String> mediaList = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(mediaList);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
