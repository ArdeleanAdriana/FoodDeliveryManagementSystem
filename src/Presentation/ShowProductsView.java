package Presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ShowProductsView {
	JFrame tabelP;
	JScrollPane t;
	public JTable tabel;

	public ShowProductsView() {
		tabelP = new JFrame("Produse");
		t = new JScrollPane(tabel);
		tabel = new JTable();
		tabelP.add(t);
		tabelP.setBounds(400, 250, 600, 400);
	}

	public JTable getTable() {
		return this.tabel;
	}
}
