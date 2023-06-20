package view.galpao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;

public class AddGraoGalpaoPanel extends JPanel {
	private JTextField tfNomeGrao;
	private JTextField tfTipoGrao;
	private JTextField tfImpureza;
	private JTextField tfDatacoleta;
	private JTextField tfMassa;
	private JTextField tfGalpao;
	JCheckBox ckbxImpureza = new JCheckBox("Impureza");

	JList listGalpao = new JList();
	
	JButton btnAddGrao = new JButton("Adicionar");

	/**
	 * Create the panel.
	 */
	public AddGraoGalpaoPanel() {
		setBackground(new Color(192, 192, 192));
		
		JLabel lbNomeGrao = new JLabel("Nome:");
		lbNomeGrao.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfNomeGrao = new JTextField();
		tfNomeGrao.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfTipoGrao = new JTextField();
		tfTipoGrao.setColumns(10);
		
		
		ckbxImpureza.setFont(new Font("Tahoma", Font.BOLD, 12));
		ckbxImpureza.setBackground(new Color(192, 192, 192));
		
		JLabel lblNewLabel = new JLabel("Grão");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Nivel de impureza:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfImpureza = new JTextField();
		tfImpureza.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data de Coleta:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfDatacoleta = new JTextField();
		tfDatacoleta.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Massa:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfMassa = new JTextField();
		tfMassa.setColumns(10);
		
		
		tfGalpao = new JTextField();
		tfGalpao.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Galpao");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfMassa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(tfGalpao, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(39)
									.addComponent(btnAddGrao)))
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addComponent(listGalpao, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfDatacoleta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(tfTipoGrao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbNomeGrao)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfNomeGrao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(ckbxImpureza)
							.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfImpureza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbNomeGrao)
						.addComponent(tfNomeGrao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(tfTipoGrao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ckbxImpureza)
						.addComponent(lblNewLabel_1)
						.addComponent(tfImpureza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(tfDatacoleta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(listGalpao, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(tfMassa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfGalpao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
							.addComponent(btnAddGrao)
							.addGap(20))))
		);
		setLayout(groupLayout);

	}
}
