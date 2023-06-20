package view.galpao;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GerenciaGalpaoView {

	private JFrame frmGerenciaGalpo;
	private JButton btnNewGalpao = new JButton("Novo");

	private JButton btnAddGraos = new JButton("Adicionar Grãos");

	private JButton btnExcluir = new JButton("Excluir Galpao");

	private JButton btnRemoverGros = new JButton("Remover Grãos");

	private JButton btnAtualizaGalpao = new JButton("Atualizar");

	private JPanel ContainerPanel = new JPanel();
	
	private AddGalpaoPanel g = new AddGalpaoPanel(); 
	private AddGraoGalpaoPanel gg = new AddGraoGalpaoPanel();

	public GerenciaGalpaoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGerenciaGalpo = new JFrame();
		frmGerenciaGalpo.getContentPane().setBackground(new Color(128, 128, 128));

		GroupLayout groupLayout = new GroupLayout(frmGerenciaGalpo.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAddGraos, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
						.addComponent(btnNewGalpao, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
						.addComponent(btnAtualizaGalpao, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
						.addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE).addComponent(
								btnRemoverGros, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
				.addGap(18).addComponent(ContainerPanel, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup()
						.addComponent(btnNewGalpao, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addComponent(btnAddGraos, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnRemoverGros, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnAtualizaGalpao, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(ContainerPanel, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
				.addContainerGap()));
		ContainerPanel.setLayout(new CardLayout(0, 0));
		frmGerenciaGalpo.getContentPane().setLayout(groupLayout);
		frmGerenciaGalpo.setTitle("Gerenciamento de Galpão");
		frmGerenciaGalpo.setResizable(false);
		frmGerenciaGalpo.setVisible(true);
		frmGerenciaGalpo.setBounds(100, 100, 585, 390);
	}

	public JFrame getFrmGerenciaGalpo() {
		return frmGerenciaGalpo;
	}

	public void setFrmGerenciaGalpo(JFrame frmGerenciaGalpo) {
		this.frmGerenciaGalpo = frmGerenciaGalpo;
	}

	public JButton getBtnNewGalpao() {
		return btnNewGalpao;
	}

	public void setBtnNewGalpao(JButton btnNewGalpao) {
		this.btnNewGalpao = btnNewGalpao;
	}

	public JButton getBtnAddGraos() {
		return btnAddGraos;
	}

	public void setBtnAddGraos(JButton btnAddGraos) {
		this.btnAddGraos = btnAddGraos;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	public void setBtnExcluir(JButton btnExcluir) {
		this.btnExcluir = btnExcluir;
	}

	public JButton getBtnRemoverGros() {
		return btnRemoverGros;
	}

	public void setBtnRemoverGros(JButton btnRemoverGros) {
		this.btnRemoverGros = btnRemoverGros;
	}

	public JButton getBtnAtualizaGalpao() {
		return btnAtualizaGalpao;
	}

	public void setBtnAtualizaGalpao(JButton btnAtualizaGalpao) {
		this.btnAtualizaGalpao = btnAtualizaGalpao;
	}

	public JPanel getContainerPanel() {
		return ContainerPanel;
	}

	public void setContainerPanel(JPanel containerPanel) {
		ContainerPanel = containerPanel;
	}
	
}
