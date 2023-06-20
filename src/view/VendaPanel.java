package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class VendaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public VendaPanel() {
		setBackground(new Color(192, 192, 192));
		
		JLabel lblNewLabel = new JLabel("Tela de Venda");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(300)
					.addComponent(lblNewLabel)
					.addContainerGap(301, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(151)
					.addComponent(lblNewLabel)
					.addContainerGap(151, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	public JPanel getVendaPanel() {
		return this;
	}

}
