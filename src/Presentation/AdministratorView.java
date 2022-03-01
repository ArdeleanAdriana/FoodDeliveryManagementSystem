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

public class AdministratorView extends JFrame{
	public JPanel contentPane;

	private JButton importProducts;
	private JButton addProducts;
	private JButton deleteProducts;
	//private JButton editProducts;
	private JButton showProducts;
	private JButton report1;
	private JButton report2;
	private JButton report3;
	private JButton report4;
	
	private static JFrame content = new JFrame("AdministratorView");

	public AdministratorView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 250, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		importProducts = new JButton("Import Products");
		importProducts.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		importProducts.setBounds(100, 50, 200, 20);
		contentPane.add(importProducts);
		
		addProducts = new JButton("Add Products");
		addProducts.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		addProducts.setBounds(100, 80, 200, 20);
		contentPane.add(addProducts);
		
		deleteProducts = new JButton("Delete&Edit Products");
		deleteProducts.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		deleteProducts.setBounds(100, 110, 200, 20);
		contentPane.add(deleteProducts);
		
		
		showProducts = new JButton("Show Products");
		showProducts.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		showProducts.setBounds(100, 140, 200, 20);
		contentPane.add(showProducts);
		
		report1 = new JButton("Report 1");
		report1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		report1.setBounds(100, 170, 200, 20);
		contentPane.add(report1);
		
		report2 = new JButton("Report 2");
		report2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		report2.setBounds(100, 200, 200, 20);
		contentPane.add(report2);

		report3 = new JButton("Report 3");
		report3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		report3.setBounds(100, 230, 200, 20);
		contentPane.add(report3);
		
		report4 = new JButton("Report 4");
		report4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		report4.setBounds(100, 260, 200, 20);
		contentPane.add(report4);
		
		

		
	}
	public JButton getImportProducts() {
		return importProducts;
	}
	public JButton getAddProducts() {
		return addProducts;
	}
	
	public JButton getDeleteProducts() {
		return deleteProducts;
	}
	public JButton getShowProducts() {
		return showProducts;
	}
	public JButton getReport1() {
		return report1;
	}
	public JButton getReport2() {
		return report2;
	}
	public JButton getReport3() {
		return report3;
	}
	public JButton getReport4() {
		return report4;
	}

}
