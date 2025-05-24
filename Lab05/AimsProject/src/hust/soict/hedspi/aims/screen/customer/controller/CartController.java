package hust.soict.hedspi.aims.screen.customer.controller;
import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	 @FXML
	    private Label costLabel;
	 @FXML
	    private ToggleGroup filterCategory;
	 @FXML
	    private RadioButton radioBtnFilterId;
		
		@FXML
	    private RadioButton radioBtnFilterTitle;
	    @FXML
	    private TableView<Media> tblMedia;
	    @FXML
	    private TextField searchField;
	 @FXML
	    private Button btnPlay;

	    @FXML
	    private Button btnRemove;

	    @FXML
	    private TableColumn<Media, String> colMediaCategory;

	    @FXML
	    private TableColumn<Media, Float> colMediaCost;

	    @FXML
	    private TableColumn<Media, Integer> colMediaId;

	    @FXML
	    private TableColumn<Media, String> colMediaTitle;
	    private TableView<Media> tableView;
	private Cart cart;
	private Store store;
	public CartController(Cart cart, Store store) {
		this.cart = cart;
		this.store= store;
	}
	   @FXML
	    public void initialize() {
	        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
	        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
	        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
	        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
	        if (cart.getItemOrdered() != null) {
	            tblMedia.setItems(cart.getItemOrdered());
	            updateTotalCost();
	        }
	        btnPlay.setVisible(false);
	        btnRemove.setVisible(false);

	        tblMedia.getSelectionModel().selectedItemProperty().addListener(
	                new ChangeListener<Media>() {
	                    @Override
	                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
	                        updateButtonBar(newValue);
	                    }
	                }
	        );
	        searchField.textProperty().addListener(new ChangeListener<String>() {
	        	@Override
	        	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	        		showFilteredMedia(newValue);
	        	}
	        });
		}
	   public void updateTotalCost() {
		   float total = 0;
	        for (Media media : cart.getItemOrdered()) {
	            total += media.getCost();
	        }
	        costLabel.setText(String.format("%.2f $", total));

	   }
	   public void updateButtonBar(Media newValue) {
		   	if(newValue == null) {
			   btnPlay.setVisible(false);
			   btnRemove.setVisible(false);
		   }
		   	else {
		   		btnRemove.setVisible(true);
		   		if(newValue instanceof Media) {
		   			btnPlay.setVisible(true);
		   		}
		   		else {
		   			btnPlay.setVisible(false);
		   		}
		   	}
	   }
	   @FXML
	   void btnRemovePressed() {
		   Media media = tblMedia.getSelectionModel().getSelectedItem();
		   cart.removeMedia(media);
		   updateTotalCost();
	   }
	   @FXML
	   void btnPlayPressed() throws PlayerException {
		   Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
		   if(selectedMedia instanceof Playable) {
			   ((Playable) selectedMedia).play();
		   }
	   }
	   @FXML
	    void btnViewStorePressed(ActionEvent event) {
	        try {
	            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
	            fxmlLoader.setController(new ViewStoreController(this.store, this.cart));  // truyền lại store và cart
	            Parent root = fxmlLoader.load();

	            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	            stage.setScene(new Scene(root));
	            stage.setTitle("Store");
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	   @FXML
	    private ListView<Media> mediaListView;
	   @FXML
	    private void handlePlaceOrder() {
	        cart.emptyCart();
	        mediaListView.getItems().clear();
	        updateTotalCost();
	        showAlert("Order placed successfully!");
	    }

	   @FXML
	    private void handleRemoveMedia() {
	        Media selected = tableView.getSelectionModel().getSelectedItem();
	        if (selected != null) {
	            cart.removeMedia(selected);
	        }

	    }

	    private void showAlert(String s) {
	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Thông báo");
	        alert.setHeaderText(null);
	        alert.setContentText(s);
	        alert.showAndWait();
	    }
	    void showFilteredMedia(String keyword) {
	        if (keyword == null || keyword.isEmpty()) {
	            tblMedia.setItems(cart.getItemOrdered());
	            updateTotalCost();
	            return;
	        }

	        ObservableList<Media> filteredList = FXCollections.observableArrayList();
	        for (Media media : cart.getItemOrdered()) {
	            boolean match = false;
	            if (radioBtnFilterId.isSelected()) {
	                match = String.valueOf(media.getId()).contains(keyword);
	            } else if (radioBtnFilterTitle.isSelected()) {
	                match = media.getTitle().toLowerCase().contains(keyword.toLowerCase());
	            }

	            if (match) {
	                filteredList.add(media);
	            }
	        }

	        tblMedia.setItems(filteredList);
	        updateTotalCost();
	    }

	   }
