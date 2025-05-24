package hust.soict.hedspi.aims.screen.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AdditemToStoreScreen{
	public AddBookToStoreScreen (Store store) {
		super(store);
		JPanel authors = super.createSubPanel("Authors");
		super.centerP.add(authors);
		btn.addActionListener(new btnAddListener());
		super.setTitle("Add Book");
		super.setVisible(true);
	}
	private class btnAddListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 String title = null, category = null, authors_text = null;
	            int id = 0;
	            float cost = 0;

	            try {
	                for (JTextField tf : tfs) {
	                    switch (tf.getName()) {
	                    	case "ID":
	                    	id = Integer.parseInt(tf.getText());
	                        break;
	                        case "Title":
	                            title = tf.getText();
	                            break;
	                        case "Category":
	                            category = tf.getText();
	                            break;
	                        case "Cost":
	                            cost = Float.parseFloat(tf.getText());
	                            break;
	                        case "Authors":
	                            authors_text = tf.getText();
	                            break;
	                    }
	                }

	            Book book = new Book(id, title , category, cost);
	            if(authors_text != null) {
	            	String[] authorslist = authors_text.split(",");
	            	for(String author : authorslist) {
	            		book.addAuthor(author.trim());
	            	}
	            }
	            store.addMedia(book);
	            JOptionPane.showMessageDialog(null, "Book has been added!");
	            new StoreManagerScreen(store);
	            dispose();
		}catch(NumberFormatException en) {
			JOptionPane.showMessageDialog(null,"Invalid number format","ERROR",JOptionPane.ERROR_MESSAGE);
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!" +ex.getMessage());
		}
	}
	}
}
