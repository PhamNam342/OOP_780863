package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.LimitedExceededException;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class ItemController {
	  @FXML
	    private Button btnAddToCart;

	    @FXML
	    private Button btnPlay;

	    @FXML
	    private Label lblTitle;

	    @FXML
	    private Label lblCost;

	    @FXML
	    void btnAddToCartClicked(ActionEvent event) throws LimitedExceededException {
	    	if (media != null && cart != null) {
	            cart.addMedia(media);
	            System.out.println(media.getTitle() + " added to cart.");
	        } else {
	            System.out.println("Error: media or cart is null.");
	        }
	    }

	    @FXML
	    void btnPlayClicked(ActionEvent event) throws PlayerException {
	    	Media selected = mediaListView.getSelectionModel().getSelectedItem();
	        if (selected instanceof Playable) {
	            ((Playable) selected).play();
	        } else {
	            showAlert("This media is not playable.");
	        }

	    }
	    private Media media;
	    private Cart cart;
	    public ItemController(Cart cart) {
	    	this.cart = cart;
	    }
	    public void setData(Media media) {
	    	this.media = media;
	    	lblTitle.setText(media.getTitle());
	    	lblCost.setText(media.getCost() +" $");
	    	if(media instanceof Playable) {
	    		btnPlay.setVisible(true);
	    	}
	    	else {
	    		btnPlay.setVisible(false);
	    		HBox.setMargin(btnAddToCart, new Insets(0,0,0,60));
	    	}

	    }
	    @FXML
	    private ListView<Media> mediaListView;


	    private void showAlert(String s) {
	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Thông báo");
	        alert.setHeaderText(null);
	        alert.setContentText(s);
	        alert.showAndWait();
	    }

}
