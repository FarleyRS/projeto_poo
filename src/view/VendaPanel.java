package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.DateFormatter;

import dao.GraoDao;
import model.Cliente;
import model.Grao;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import javax.swing.table.DefaultTableModel;

public class VendaPanel extends JPanel {

	private JTable tableGrao;
	private JTextField tfQuantidadeGrao;
	private JTextField tfValor;
	private JList listCliente = new JList();
	private JButton btnNovoCliente = new JButton("Cadastrar Novo Cliente");
	private JButton btnEfetuarComprar = new JButton("Efetuar Compra");
	private JFormattedTextField ftfData;
	/**
	 * Create the panel.
	 */
	public VendaPanel() {
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Grão");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		// Cria os cabeçalhos das colunas
        String[] columnNames = {"Item", "Value"};

        // Cria o modelo de dados para o JTable
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Adiciona os dados ao modelo de dados
        GraoDao gd = new GraoDao();
        
        List<Grao> graos = gd.readAll();
        for (Grao grao : graos) {
            Object[] row = {grao.getId(),grao.getNome()};
            model.addRow(row);
        }
		
		tableGrao = new JTable(model);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		
		tfQuantidadeGrao = new JTextField();
		tfQuantidadeGrao.setColumns(10);
			
		tfValor = new JTextField();
		tfValor.setEditable(false);
		tfValor.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Valor:");
		
		JLabel lblNewLabel_4 = new JLabel("Data:");
		
		DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
		DateFormatter formatter = new DateFormatter(format);

		// Cria o JFormattedTextField e define o formato
		ftfData = new JFormattedTextField();
		ftfData.setEditable(false);
		ftfData.setValue(new Date());
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNovoCliente, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(listCliente, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(tableGrao, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnEfetuarComprar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ftfData)
						.addComponent(tfValor)
						.addComponent(tfQuantidadeGrao))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(tfQuantidadeGrao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(ftfData, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(21, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(listCliente, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tableGrao, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNovoCliente)
						.addComponent(btnEfetuarComprar))
					.addGap(61))
		);
		setLayout(groupLayout);

	}

	public JTable getTableGrao() {
		return tableGrao;
	}

	public void setTableGrao(JTable tableGrao) {
		this.tableGrao = tableGrao;
	}

	public JTextField getTfQuantidadeGrao() {
		return tfQuantidadeGrao;
	}

	public void setTfQuantidadeGrao(JTextField tfQuantidadeGrao) {
		this.tfQuantidadeGrao = tfQuantidadeGrao;
	}

	public JTextField getTfValor() {
		return tfValor;
	}

	public void setTfValor(JTextField tfValor) {
		this.tfValor = tfValor;
	}

	public JList getListCliente() {
		return listCliente;
	}

	public void setListCliente(JList listCliente) {
		this.listCliente = listCliente;
	}

	public JButton getBtnNovoCliente() {
		return btnNovoCliente;
	}

	public void setBtnNovoCliente(JButton btnNovoCliente) {
		this.btnNovoCliente = btnNovoCliente;
	}

	public JButton getBtnEfetuarComprar() {
		return btnEfetuarComprar;
	}

	public void setBtnEfetuarComprar(JButton btnEfetuarComprar) {
		this.btnEfetuarComprar = btnEfetuarComprar;
	}

	public JFormattedTextField getFtfData() {
		return ftfData;
	}

	public void setFtfData(JFormattedTextField ftfData) {
		this.ftfData = ftfData;
	}
	
	
}
