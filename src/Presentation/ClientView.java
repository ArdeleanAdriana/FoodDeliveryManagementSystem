package Presentation;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientView extends JFrame{
	
	public JPanel contentPane;

	private JButton show;
	private JButton order;
	private JButton search;

	private static JFrame content = new JFrame("ClientView");

	public ClientView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 250, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		show = new JButton("Show Products");
		show.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		show.setBounds(100, 50, 200, 20);
		contentPane.add(show);
		
		search = new JButton("Search Products");
		search.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		search.setBounds(100, 100, 200, 20);
		contentPane.add(search);
		
		order = new JButton("Place Order");
		order.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		order.setBounds(100, 150, 200, 20);
		contentPane.add(order);
		
	}
	
	public JButton getShowProductsClient() {
		return show;
	}
	
	public JButton getSearchProducts() {
		return search;
	}
	
	public JButton getOrder() {
		return order;
	}

}
