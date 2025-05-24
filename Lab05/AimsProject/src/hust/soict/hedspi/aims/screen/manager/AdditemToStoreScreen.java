package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.store.Store;

public abstract class AdditemToStoreScreen extends JFrame{
	Store store;
	JPanel centerP;
	JButton btn;
	ArrayList<JTextField> tfs = new ArrayList<>();
	public AdditemToStoreScreen(Store store) {
		this.store = store;
		setSize(1024, 768);
		setLayout(new BorderLayout());
		add(createMenuBar(), BorderLayout.NORTH);
		JPanel btnP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btn = new JButton("Add");
		btnP.add(btn);
		btnP.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		add(btnP, BorderLayout.SOUTH);
		centerP = createCenter();
        add(centerP, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);

	}
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenuItem viewStoreMenu = new JMenuItem("View Store");
		menu.add(viewStoreMenu);
		viewStoreMenu.addActionListener(new btnMenuListener());

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;

	}
	JPanel createSubPanel(String text) {
        JPanel subPanel = new JPanel(new FlowLayout());
        JTextField tf = new JTextField(50);
        tf.setName(text);
        tfs.add(tf);
        JLabel lbTextField = new JLabel(text);

        subPanel.add(lbTextField);
        subPanel.add(tf);
        subPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        return subPanel;
    }
	JPanel createCenter() {
		JPanel centerP = new JPanel(new GridLayout(7,1,4,4));
		JPanel idP = createSubPanel("ID");
		JPanel titleP = createSubPanel("Title");
		JPanel categoryP = createSubPanel("Category");
        JPanel costP = createSubPanel("Cost");

        centerP.add(idP);
        centerP.add(titleP);
        centerP.add(categoryP);
        centerP.add(costP);

        return centerP;
	}
	private class btnMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new StoreManagerScreen(store);
            dispose();
        }
    }
}
