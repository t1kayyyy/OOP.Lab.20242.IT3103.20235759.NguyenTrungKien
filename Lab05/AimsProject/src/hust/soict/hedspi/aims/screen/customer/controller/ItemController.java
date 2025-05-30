package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ItemController {

    private Media currentMedia;

    @FXML
    private Label titleLabel;

    @FXML
    private Label categoryLabel;

    @FXML
    private ImageView mediaImage;

    @FXML
    private Button playButton;

    @FXML
    private Button addToCartButton;

    public void setMedia(Media media) {
        this.currentMedia = media;

        // Hiển thị thông tin media lên giao diện
        titleLabel.setText(media.getTitle());
        categoryLabel.setText(media.getCategory() + " $");

        // Hiển thị/Ẩn nút Play dựa vào loại media
        if (media instanceof Playable) {
            playButton.setVisible(true);
        } else {
            playButton.setVisible(false);
            // Nếu không phải Playable, dời nút Add to Cart sang phải cho cân đối
            HBox.setMargin(addToCartButton, new Insets(0, 0, 0, 60));
        }

        // TODO: Xử lý hình ảnh media nếu cần (tạm để mediaImage trống)
    }

    @FXML
    private void handlePlay() {
        if (currentMedia instanceof Playable playableMedia) {
            playableMedia.play();
        }
    }

    @FXML
    private void handleAddToCart() {
        // TODO: Gọi logic thêm vào cart
        System.out.println("Add to Cart: " + currentMedia.getTitle());
    }
}
