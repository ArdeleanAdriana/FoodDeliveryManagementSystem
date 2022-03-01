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

public class View extends JFrame {
	public JPanel contentPane;

	private JButton login;
	private JButton register;

	private JLabel username;
	private JLabel password;

	private JTextField userT;
	private JTextField passT;

	private JPasswordField pass;

	private JComboBox usersB;

	String[] users = { "Client", "Employee", "Administrator" };

	private static JFrame content = new JFrame("View");

	public View() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 250, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		login = new JButton("Login");
		login.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		login.setBounds(100, 300, 90, 30);
		contentPane.add(login);

		register = new JButton("Register");
		register.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		register.setBounds(200, 300, 90, 30);
		contentPane.add(register);

		username = new JLabel("Username:");
		username.setBounds(70, 100, 70, 40);
		contentPane.add(username);

		password = new JLabel("Password:");
		password.setBounds(70, 150, 70, 40);
		contentPane.add(password);

		userT = new JTextField();
		userT.setBounds(170, 113, 150, 20);
		contentPane.add(userT);

		pass = new JPasswordField();
		pass.setBounds(170, 160, 150, 20);
		contentPane.add(pass);

		usersB = new JComboBox(users);
		usersB.setBounds(120, 220, 150, 30);
		contentPane.add(usersB);
	}

	public JButton getLogin() {
		return login;
	}

	public JButton getRegister() {
		return register;
	}
	
	 public String getUsername() {
	        return this.userT.getText();
	 }
	 public String getPassword() {
		 String pasText = new String(pass.getPassword());
	        return pasText;
	 }
	 
	 public int role() {
		 if( usersB.getSelectedItem().toString()=="Client") {
			 return 0;
		 }
		 if( usersB.getSelectedItem().toString()=="Employee") {
			 return 1;
		 }
		 if( usersB.getSelectedItem().toString()=="Administrator") {
			 return 2;
		 }
		 return 0;
	 }
	 

}
