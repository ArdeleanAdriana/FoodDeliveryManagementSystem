package Presentation;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Report3View extends JFrame {
	public JPanel contentPane;

	private JButton generate;

	private JLabel nrTL;
	private JLabel amountL;

	private JTextField nrT;
	private JTextField amount;

	public Report3View() {
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

		amountL = new JLabel("Amount:");
		amountL.setBounds(30, 150, 100, 40);
		contentPane.add(amountL);

		nrT = new JTextField();
		nrT.setBounds(170, 113, 150, 20);
		contentPane.add(nrT);

		amount = new JTextField();
		amount.setBounds(170, 160, 150, 20);
		contentPane.add(amount);

	}

	public JButton getR3() {
		return generate;
	}

	public int getNumberOfTimes() {
		return Integer.parseInt(nrT.getText());
	}

	public double getAmount() {
		return Double.parseDouble(amount.getText());
	}

}
