package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {

    private Cart cart;

    public CartController() {
        // Constructor mặc định
    }

    public void setCart(Cart cart) {
        this.cart = cart;
        tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));
    }

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        btnPlay.setDisable(true);
        btnRemove.setDisable(true);

        tblMedia.getSelectionModel().selectedItemProperty().addListener((obs, oldMedia, selectedMedia) -> {
            updateButtonState(selectedMedia);
        });
    }

    private void updateButtonState(Media selectedMedia) {
        boolean hasSelection = selectedMedia != null;
        btnRemove.setDisable(!hasSelection);
        btnPlay.setDisable(!(hasSelection && selectedMedia instanceof Playable));
    }

    @FXML
    private void handlePlayAction() {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia instanceof Playable playableMedia) {
            playableMedia.play();
        }
    }

    @FXML
    private void handleRemoveAction() {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            tblMedia.getItems().remove(selectedMedia);
        }
    }

    @FXML
    private void handleViewStoreAction(javafx.event.ActionEvent event) {
        try {
            final String STORE_FXML_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(STORE_FXML_PATH));
            Parent storeRoot = loader.load();

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(new Scene(storeRoot));
            currentStage.setTitle("Store");
            currentStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
