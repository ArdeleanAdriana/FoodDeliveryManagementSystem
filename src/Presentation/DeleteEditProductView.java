package Presentation;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DeleteEditProductView extends JFrame{
	public JPanel contentPane;

	private JButton deleteProduct;
	private JButton editProduct;
	
	private JTextField titleDelete;
	
	private JTextField title;
	private JTextField rating;
	private JTextField calories;
	private JTextField protein;
	private JTextField fat;
	private JTextField sodium;
	private JTextField price;
	//private JTextField titleEdit;
	private JLabel delete;
	
	private JLabel titleL;
	private JLabel ratingL;
	private JLabel caloriesL;
	private JLabel proteinL;
	private JLabel fatL;
	private JLabel sodiumL;
	private JLabel priceL;
	private JLabel edit;
	
	private static JFrame content = new JFrame("AddCompositeProductView");

	public DeleteEditProductView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 250, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titleDelete = new JTextField();
		titleDelete.setBounds(170, 20, 150, 20);
		contentPane.add(titleDelete);
		
		rating = new JTextField();
		rating.setBounds(170, 110, 150, 20);
        contentPane.add(rating);
        
        calories = new JTextField();
        calories.setBounds(170, 140, 150, 20);
        contentPane.add(calories);
        
        protein = new JTextField();
        protein.setBounds(170, 170, 150, 20);
        contentPane.add(protein);
        
        fat = new JTextField();
        fat.setBounds(170, 200, 150, 20);
        contentPane.add(fat);
        
        sodium = new JTextField();
        sodium.setBounds(170, 230, 150, 20);
        contentPane.add(sodium);
        
        price = new JTextField();
        price.setBounds(170, 260, 150, 20);
        contentPane.add(price);
        
        title = new JTextField();
		title.setBounds(170, 80, 150, 20);
        contentPane.add(title);
		
		delete = new JLabel("Delete:");
		delete.setBounds(10, 20, 200, 20);
		contentPane.add(delete);
		
		edit = new JLabel("Edit:");
		edit.setBounds(10, 50, 200, 20);
		contentPane.add(edit);
		
		titleL = new JLabel("Title:");
		titleL.setBounds(10, 80, 200, 20);
		contentPane.add(titleL);
		
		ratingL = new JLabel("Rating:");
		ratingL.setBounds(10, 110, 200, 20);
		contentPane.add(ratingL);
		
		
		caloriesL = new JLabel("Calories:");
		caloriesL.setBounds(10, 140, 200, 20);
		contentPane.add(caloriesL);
		
		proteinL = new JLabel("Protein:");
		proteinL.setBounds(10, 170, 200, 20);
		contentPane.add(proteinL);
		
		fatL = new JLabel("Fat:");
		fatL.setBounds(10, 200, 200, 20);
		contentPane.add(fatL);
		
		
		sodiumL = new JLabel("Sodium:");
		sodiumL.setBounds(10, 230, 200, 20);
		contentPane.add(sodiumL);
		
		
		priceL = new JLabel("Price:");
		priceL.setBounds(10, 260, 200, 20);
		contentPane.add(priceL);
		
		
		deleteProduct = new JButton("Delete Product");
		deleteProduct.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		deleteProduct.setBounds(10, 300, 150, 30);
		contentPane.add(deleteProduct);
		
		editProduct = new JButton("Edit Product");
		editProduct.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		editProduct.setBounds(200, 300, 150, 30);
		contentPane.add(editProduct);
		
	}
	 public String getDeletedTitle() {
	        return this.titleDelete.getText();
	 }
	 //public String getCPtitle() {
	   //     return this.compositeProduct.getText();
	 //}
	 
	 public JButton deleteBtn() {
			return deleteProduct;
		}
	 public JButton editBtn() {
			return editProduct;
		}
	 public String getEditedTitle() {
	        return this.title.getText();
	 }
	 public String getEditedRating() {
	        return this.rating.getText();
	 }
	 public String getEditedCalories() {
	        return this.calories.getText();
	 }
	 public String getEditedProtein() {
	        return this.protein.getText();
	 }
	 public String getEditedFat() {
	        return this.fat.getText();
	 }
	 public String getEditedSodium() {
	        return this.sodium.getText();
	 }
	 public String getEditedPrice() {
	        return this.price.getText();
	 }

}
