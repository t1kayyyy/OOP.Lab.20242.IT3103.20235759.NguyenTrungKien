package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {

    private static Store currentStore;
    private static Stage appStage;

    @Override
    public void start(Stage stage) throws Exception {
        appStage = stage;
        loadStoreScreen();
    }

    private void loadStoreScreen() {
        try {
            final String STORE_FXML_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(STORE_FXML_PATH));
            Parent storeRoot = loader.load(); // Chỉ load, không setController
            appStage.setTitle("Store");
            appStage.setScene(new Scene(storeRoot));
            appStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        currentStore = new Store();
        launch(args);
    }
}
