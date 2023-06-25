package view;

import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import model.Cliente;


public class VendaPanel extends JPanel {

	private JTable tableGrao;
	private JTextField tfQuantidadeGrao;
	private JTextField tfValor;
	private JList<Cliente> listCliente;
	private JButton btnNovoCliente;
	private JButton btnEfetuarCompra;
	private JFormattedTextField ftfData;

	public VendaPanel() {
		listCliente = new JList<>();
	    JLabel lblNewLabel = new JLabel("Cliente");
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));

	    JLabel lblNewLabel_1 = new JLabel("Grão");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));

	    tableGrao = new JTable();
	    JScrollPane scrollPane = new JScrollPane(tableGrao);

	    JLabel lblNewLabel_2 = new JLabel("Quantidade:");
	    tfQuantidadeGrao = new JTextField();
	    tfQuantidadeGrao.setColumns(10);

	    tfValor = new JTextField();
	    tfValor.setEditable(false);
	    tfValor.setColumns(10);

	    JLabel lblNewLabel_3 = new JLabel("Valor:");

	    JLabel lblNewLabel_4 = new JLabel("Data:");

	    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    ftfData = new JFormattedTextField(format);
	    ftfData.setEditable(false);
	    ftfData.setValue(new Date());

	    btnNovoCliente = new JButton("Cadastrar Novo Cliente");
	    btnEfetuarCompra = new JButton("Efetuar Compra");

	    GroupLayout groupLayout = new GroupLayout(this);
	    groupLayout.setHorizontalGroup(
	        groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(groupLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(groupLayout.createSequentialGroup()
	                        .addComponent(lblNewLabel)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(listCliente, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
	                    .addComponent(btnNovoCliente))
	                .addGap(18)
	                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addComponent(lblNewLabel_1)
	                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
	                .addGap(18)
	                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addComponent(lblNewLabel_2)
	                    .addComponent(lblNewLabel_4)
	                    .addComponent(lblNewLabel_3))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addComponent(ftfData, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(tfValor, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(tfQuantidadeGrao, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(btnEfetuarCompra))
	                .addContainerGap(59, Short.MAX_VALUE))
	    );
	    groupLayout.setVerticalGroup(
	        groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(groupLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(lblNewLabel)
	                    .addComponent(lblNewLabel_1)
	                    .addComponent(lblNewLabel_2)
	                    .addComponent(tfQuantidadeGrao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(groupLayout.createSequentialGroup()
	                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                            .addComponent(listCliente, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
	                            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(btnNovoCliente)
	                            .addComponent(btnEfetuarCompra)))
	                    .addGroup(groupLayout.createSequentialGroup()
	                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                            .addComponent(lblNewLabel_4)
	                            .addComponent(ftfData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGap(18)
	                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                            .addComponent(lblNewLabel_3)
	                            .addComponent(tfValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
	                .addContainerGap(30, Short.MAX_VALUE))
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

	public JList<Cliente> getListCliente() {
	    return listCliente;
	}

	public void setListCliente(JList<Cliente> listCliente) {
	    this.listCliente = listCliente;
	}

	public JButton getBtnNovoCliente() {
	    return btnNovoCliente;
	}

	public void setBtnNovoCliente(JButton btnNovoCliente) {
	    this.btnNovoCliente = btnNovoCliente;
	}

	public JButton getBtnEfetuarCompra() {
	    return btnEfetuarCompra;
	}

	public void setBtnEfetuarCompra(JButton btnEfetuarCompra) {
	    this.btnEfetuarCompra = btnEfetuarCompra;
	}

	public JFormattedTextField getFtfData() {
	    return ftfData;
	}

	public void setFtfData(JFormattedTextField ftfData) {
	    this.ftfData = ftfData;
	}
}