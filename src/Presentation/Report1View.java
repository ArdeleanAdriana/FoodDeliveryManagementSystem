package Presentation;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Report1View extends JFrame {
	public JPanel contentPane;

	private JButton generate;
	

	private JLabel sh;
	private JLabel eh;

	private JTextField startHour;
	private JTextField endHour;
	
	public Report1View() {
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


	sh = new JLabel("Start hour:");
	sh.setBounds(70, 100, 70, 40);
	contentPane.add(sh);

	eh = new JLabel("End hour:");
	eh.setBounds(70, 150, 70, 40);
	contentPane.add(eh);

	startHour = new JTextField();
	startHour.setBounds(170, 113, 150, 20);
	contentPane.add(startHour);

	endHour = new JTextField();
	endHour.setBounds(170, 160, 150, 20);
	contentPane.add(endHour);

	}
	public JButton getR1() {
		return generate;
	}
	
	public int oraS() {
		return Integer.parseInt(startHour.getText());
	}
	public int oraE() {
		return Integer.parseInt(endHour.getText());
	}
	
}
