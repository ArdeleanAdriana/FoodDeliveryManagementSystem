package Presentation;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class OrderView extends JFrame{
	public JPanel contentPane;

	private JButton orderBtn;
	private JButton addPBtn;
	private JTextField p;
	private JLabel pL;
	private JTextField pret;
	private JLabel pretL;
	
	public OrderView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 250, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		orderBtn = new JButton("Place Order");
		orderBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		orderBtn.setBounds(50, 300, 130, 30);
		contentPane.add(orderBtn);

		addPBtn = new JButton("Add product");
		addPBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		addPBtn.setBounds(200, 300, 130, 30);
		contentPane.add(addPBtn);
		
		pL = new JLabel("Produs:");
		pL.setBounds(100, 20, 70, 20);
		contentPane.add(pL); 
		
		p = new JTextField();
		p.setBounds(100, 50, 200, 20);
		contentPane.add(p);
		
		pretL = new JLabel("Pret total:");
		pretL.setBounds(100, 80, 70, 20);
		contentPane.add(pretL); 
		
		pret = new JTextField();
		pret.setBounds(100, 110, 200, 20);
		contentPane.add(pret);
		
	}
	
	 public String getInput() {
	        return this.p.getText();
	 }
	 public JButton getOrderBtn() {
			return orderBtn;
		}

	 public JButton getAddPBtn() {
			return addPBtn;
		}
	 public void setPret(float price) {
		 pret.setText(String.valueOf(price));
	 }
}
