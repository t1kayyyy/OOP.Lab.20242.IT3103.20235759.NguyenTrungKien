package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewStoreController {

    private Cart cart = new Cart(); // Dùng 1 cart dùng chung

    @FXML
    private void handleViewCartAction(ActionEvent event) {
        try {
            final String CART_FXML_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(CART_FXML_PATH));
            Parent cartRoot = loader.load();

            CartController cartController = loader.getController();
            cartController.setCart(this.cart); // Truyền Cart vào Controller

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(new Scene(cartRoot));
            currentStage.setTitle("Cart");
            currentStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
