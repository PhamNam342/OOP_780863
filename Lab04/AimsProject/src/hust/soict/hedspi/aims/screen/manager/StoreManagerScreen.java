package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame{
	private Store store;
	
	JPanel createNorth(){
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener((ActionEvent e) -> {
            new StoreManagerScreen(store);
            dispose(); // đóng cửa sổ hiện tại (không bắt buộc)
        });
		menu.add(viewStore);
		JMenu smUpdateStore = new JMenu("Update Store!");
		JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener((ActionEvent e) -> {
            new AddBookToStoreScreen(store);
        });
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener((ActionEvent e) -> {
            new AddCompactDiscToStoreScreen(store);
        });
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener((ActionEvent e) -> {
            new AddDigitalVideoDiscToStoreScreen(store);
        });
        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);
		JMenuBar MenuBar = new JMenuBar();
		MenuBar.setLayout(new FlowLayout(FlowLayout.LEFT) );
		MenuBar.add(menu);
		return MenuBar;
		
	}
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		 ArrayList<Media> mediaInStore = store.getItemsInStore();
		 for(int i=0 ;i< mediaInStore.size();i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		 }
		 return center;
		 
	}
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	private void PlayMedia(Playable media) {
		JDialog playDialog = new JDialog(this, "Playing Media", true);
		playDialog.setLayout(new BorderLayout());
		String title = new String();
		if(media instanceof Media) {
			title = ((Media) media).getTitle();
		}
		else {
			title = "Unknown";
		}
		int length = 0;
		if(media instanceof DigitalVideoDisc) {
			length = ((DigitalVideoDisc) media).getLength();
		}
		else if(media instanceof CompactDisc) {
			length =((CompactDisc) media).getLength();
		}
		
		playDialog.add(new JLabel("Playing : "+ title +"[ Length "+ length +" minutes]"));
		JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(e -> playDialog.dispose());
		playDialog.add(stopButton, BorderLayout.SOUTH);
		playDialog.setSize(400, 100);
		playDialog.setLocationRelativeTo(null);
		playDialog.setVisible(true);
	}
	private void showErrorMessage() {
		JOptionPane.showMessageDialog(this,"Book can be played","Error!", JOptionPane.ERROR_MESSAGE);
	}
	public static void main(String[] args) {
		 Store store = new Store();
	        //Example
	        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
	        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
	        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f));
	        store.addMedia(new Book("Harry Potter", "Fantasy", 29.5f));
	        store.addMedia(new DigitalVideoDisc("Harry Potter and the Philosopher's Stone", "Fantasy", "Chris Columbus", 100, 3.0f));
	        store.addMedia(new DigitalVideoDisc("Harry Potter and the Chamber of Secrets", "Fantasy", "Chris Columbus", 200, 3.5f));
	        store.addMedia(new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban", "Fantasy", "Alfonso Cuarón", 142, 5.0f));
	        new StoreManagerScreen(store);
	}
}