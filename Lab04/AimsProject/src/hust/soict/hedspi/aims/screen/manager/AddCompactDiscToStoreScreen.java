package hust.soict.hedspi.aims.screen.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AdditemToStoreScreen{
	public AddCompactDiscToStoreScreen(Store store) {
		super(store);
		
		JPanel director = super.createSubPanel("Director");
		JPanel artist = super.createSubPanel("Artist");
		JPanel length = super.createSubPanel("Length");
		super.centerP.add(director);
		super.centerP.add(artist);
		super.centerP.add(length);
		btn.addActionListener(new btnAddListener());
		super.setTitle("Add CompactDisc");
		super.setVisible(true);
	}
	private class btnAddListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String title = null, category = null, artist = null, director = null; // khoi tao
			int id = 0;
			float cost = 0f;
			int length =0;
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
                        case "Director":
                            director = tf.getText();
                            break;
                        case "Artist":
                            artist = tf.getText();
                            break;
                        case "Length":
                            length = Integer.parseInt(tf.getText());
                            break;
                        case "Cost":
                            cost = Float.parseFloat(tf.getText());
                            break;
                    }
                }

                CompactDisc cd = new CompactDisc(id,title, category, cost, artist, length, director);
                store.addMedia(cd);
                JOptionPane.showMessageDialog(null, "Compact Disc has been added successfully!");
                new StoreManagerScreen(store);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error adding Compact Disc: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }			
	}
	public static void main(String [] args) {
		Store store = new Store();
		AddCompactDiscToStoreScreen add = new AddCompactDiscToStoreScreen(store);
	}
	}
