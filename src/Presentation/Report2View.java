package Presentation;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Report2View extends JFrame {
	public JPanel contentPane;

	private JButton generate;

	private JLabel nrL;

	private JTextField nr;

	public Report2View() {
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

		nrL = new JLabel("Products ordered more than x times:  x =");
		nrL.setBounds(30, 100, 300, 40);
		contentPane.add(nrL);

		nr = new JTextField();
		nr.setBounds(30, 150, 300, 20);
		contentPane.add(nr);

	}

	public JButton getR2() {
		return generate;
	}

	public int getNr() {
		return Integer.parseInt(nr.getText());
	}

}
