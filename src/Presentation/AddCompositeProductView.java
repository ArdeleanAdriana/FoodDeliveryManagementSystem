package Presentation;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddCompositeProductView extends JFrame{
	public JPanel contentPane;

	private JButton addBaseProduct;
	
	private JTextField compositeProduct;
	private JTextField baseProduct;
	private JLabel compositeProductL;
	private JLabel baseProductL;
	
	private static JFrame content = new JFrame("AddCompositeProductView");

	public AddCompositeProductView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 250, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		compositeProduct = new JTextField();
		compositeProduct.setBounds(170, 50, 150, 20);
		contentPane.add(compositeProduct);
		
		baseProduct = new JTextField();
		baseProduct.setBounds(170, 80, 150, 20);
		contentPane.add(baseProduct);
		
		compositeProductL = new JLabel("Composite Product Name:");
		compositeProductL.setBounds(10, 50, 200, 20);
		contentPane.add(compositeProductL);
		
		baseProductL = new JLabel("Base Product name:");
		baseProductL.setBounds(10, 80, 200, 20);
		contentPane.add(baseProductL);
		
		addBaseProduct = new JButton("Add Base Product");
		addBaseProduct.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		addBaseProduct.setBounds(10, 300, 150, 30);
		contentPane.add(addBaseProduct);
		
	}
	 public String getBPTitle() {
	        return this.baseProduct.getText();
	 }
	 public String getCPtitle() {
	        return this.compositeProduct.getText();
	 }
	 
	 public JButton addBPBtn() {
			return addBaseProduct;
		}
	 
}
