package Presentation;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Report4View extends JFrame {
	public JPanel contentPane;

	private JButton generate;
	

	private JLabel nrTL;
	private JLabel dayL;

	private JTextField nrT;
	private JTextField day;
	
	public Report4View() {
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(400, 250, 400, 400);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	generate = new JButton("Generate");
	generate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	generate.setBounds(130, 300, 90, 30);
	contentPane.add(generate);


	nrTL = new JLabel("Number of times:");
	nrTL.setBounds(30, 100, 100, 40);
	contentPane.add(nrTL);

	dayL = new JLabel("Day:");
	dayL.setBounds(30, 150, 100, 40);
	contentPane.add(dayL);

	nrT = new JTextField();
	nrT.setBounds(170, 113, 150, 20);
	contentPane.add(nrT);

	day = new JTextField();
	day.setBounds(170, 160, 150, 20);
	contentPane.add(day);

	}
	public JButton getR4() {
		return generate;
	}
	
	public int getNumberOfTimes() {
		return Integer.parseInt(nrT.getText());
	}
	public int getDay() {
		return Integer.parseInt(day.getText());
	}
	
}
