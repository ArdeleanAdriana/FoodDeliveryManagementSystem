package Presentation;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;



public class EmployeeView extends JFrame implements Observer{
	public JPanel contentPane;
	public JTextPane pane;
 
	public EmployeeView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 250, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		pane= new JTextPane();
		pane.setBounds(20, 20, 300, 300);
		contentPane.add(pane);
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		String str=new String("");
		str=pane.getText()+(String)arg;
		pane.setText(str);
	
		
		
	};
	
}
	