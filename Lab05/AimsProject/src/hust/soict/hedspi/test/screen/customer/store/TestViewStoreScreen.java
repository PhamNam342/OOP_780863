package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class TestViewStoreScreen extends Application {
	private static Store store;
	private static Cart cart;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewstoreController = new ViewStoreController(store,cart);
		fxmlLoader.setController(viewstoreController);
		Parent root = fxmlLoader.load();

		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		store = new Store();
		try {
			cart = new Cart();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f));
        store.addMedia(new Book("Harry Potter", "Fantasy", 29.5f));
        store.addMedia(new DigitalVideoDisc("Harry Potter and the Philosopher's Stone", "Fantasy", "Chris Columbus", 100, 3.0f));
        store.addMedia(new DigitalVideoDisc("Harry Potter and the Chamber of Secrets", "Fantasy", "Chris Columbus", 200, 3.5f));
        store.addMedia(new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban", "Fantasy", "Alfonso Cuarón", 142, 5.0f));
        launch(args);
	}
}
