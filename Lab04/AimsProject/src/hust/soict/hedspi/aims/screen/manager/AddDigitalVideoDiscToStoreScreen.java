package hust.soict.hedspi.aims.screen.manager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.media.*;

public class AddDigitalVideoDiscToStoreScreen extends AdditemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);

        JPanel directorP = super.createSubPanel("Director");
        JPanel lengthP = super.createSubPanel("Length");

        super.centerP.add(directorP);
        super.centerP.add(lengthP);

        btn.addActionListener(new btnListener());
        super.setTitle("Add DVD");
        super.setVisible(true); 
    }

    private class btnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = null, category = null, director = null;
            int id = 0;
            float cost = 0f;
            int length = 0;
            try {
                for (JTextField tf : tfs) {
                    switch (tf.getName()) {
                    	case "ID":
                    		id = Integer.parseInt(tf.getText());
                            break;
                        case "Title":
                            title = tf.getText();
                            break;
                        case "Cost":
                            cost = Float.parseFloat(tf.getText());
                            break;
                        case "Category":
                            category = tf.getText();
                            break;
                        case "Director":
                            director = tf.getText();
                            break;
                        case "Length":
                            length = Integer.parseInt(tf.getText());
                            break;
                    }
                }

                DigitalVideoDisc dvd = new DigitalVideoDisc(id,title, category, director, length, cost);
                store.addMedia(dvd);       
                JOptionPane.showMessageDialog(null, "DVD has been added successfully!");
                new StoreManagerScreen(store);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid number format for cost or length", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error adding DVD: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void main(String [] args) {
    	Store store = new Store();
    	AddDigitalVideoDiscToStoreScreen add = new AddDigitalVideoDiscToStoreScreen(store);
    }
}