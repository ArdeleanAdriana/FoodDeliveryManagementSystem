package Presentation;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddProductView extends JFrame {
	public JPanel contentPane;

	private JButton add;
	private JButton addCompositeProduct;
	private JTextField title;
	private JTextField rating;
	private JTextField calories;
	private JTextField protein;
	private JTextField fat;
	private JTextField sodium;
	private JTextField price;
	private JLabel titleL;
	private JLabel ratingL;
	private JLabel caloriesL;
	private JLabel proteinL;
	private JLabel fatL;
	private JLabel sodiumL;
	private JLabel priceL;
	

	private static JFrame content = new JFrame("ClientView");

	public AddProductView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 250, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		title = new JTextField();
		title.setBounds(100, 50, 200, 20);
		contentPane.add(title);
		
		rating = new JTextField();
		rating.setBounds(100, 80, 200, 20);
		contentPane.add(rating);
		
		calories = new JTextField();
		calories.setBounds(100, 110, 200, 20);
		contentPane.add(calories);
		
		protein = new JTextField();
		protein.setBounds(100, 140, 200, 20);
		contentPane.add(protein);
		
		fat = new JTextField();
		fat.setBounds(100, 170, 200, 20);
		contentPane.add(fat);
		
		sodium = new JTextField();
		sodium.setBounds(100, 200, 200, 20);
		contentPane.add(sodium);
		
		price = new JTextField();
		price.setBounds(100, 230, 200, 20);
		contentPane.add(price);
		
		titleL = new JLabel("Title:");
		titleL.setBounds(30, 50, 70, 20);
		contentPane.add(titleL);
		
		ratingL = new JLabel("Rating:");
		ratingL.setBounds(30, 80, 70, 20);
		contentPane.add(ratingL);
		
		caloriesL = new JLabel("Calories:");
		caloriesL.setBounds(30, 110, 70, 20);
		contentPane.add(caloriesL);
		
		proteinL = new JLabel("Protein:");
		proteinL.setBounds(30, 140, 70, 20);
		contentPane.add(proteinL);
		
		fatL = new JLabel("Fat:");
		fatL.setBounds(30, 170, 70, 20);
		contentPane.add(fatL);
		
		sodiumL = new JLabel("Sodium:");
		sodiumL.setBounds(30, 200, 70, 20);
		contentPane.add(sodiumL);
		
		priceL = new JLabel("Price:");
		priceL.setBounds(30, 230, 70, 20);
		contentPane.add(priceL);
		
		add = new JButton("Add");
		add.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		add.setBounds(50, 300, 90, 30);
		contentPane.add(add);
		
		addCompositeProduct= new JButton("Add Composite Product");
		addCompositeProduct.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		addCompositeProduct.setBounds(150, 300, 200, 30);
		contentPane.add(addCompositeProduct);
	}
	
	 public String getTitleInput() {
	        return this.title.getText();
	 }
	 public String getRatingInput() {
	        return this.rating.getText();
	 }
	 public String getCaloriesInput() {
	        return this.calories.getText();
	 }
	 public String getPriceInput() {
	        return this.price.getText();
	 }
	 public String getFatInput() {
	        return this.fat.getText();
	 }
	 public String getSodiumInput() {
	        return this.sodium.getText();
	 }
	 public String getProteinInput() {
	        return this.protein.getText();
	 }
	 
	 public JButton addBtn() {
			return add;
		}
	 public JButton addCompositeBtn() {
			return addCompositeProduct;
		}
}
