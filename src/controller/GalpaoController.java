package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.GalpaoDao;
import dao.GraoDao;
import factory.ConnectionFactory;
import model.Galpao;
import model.Grao;
import view.galpao.AddGalpaoPanel;
import view.galpao.AddGraoGalpaoPanel;
import view.galpao.GerenciaGalpaoView;

public class GalpaoController {

	private GalpaoDao galpaoDao;
	private GerenciaGalpaoView gerenciaGalpaoView;
	private AddGalpaoPanel addGalpaoPanel;
	private AddGraoGalpaoPanel addGraoGalpaoPanel;
	private Galpao selectedGalpao;

	public GalpaoController(GerenciaGalpaoView gerenciaGalpaoView) {
		this.galpaoDao = new GalpaoDao();
		this.gerenciaGalpaoView = gerenciaGalpaoView;
		this.addGalpaoPanel = new AddGalpaoPanel();
		this.addGraoGalpaoPanel = new AddGraoGalpaoPanel();

		gerenciaGalpaoView.getContainerPanel().add("add", addGalpaoPanel);
		gerenciaGalpaoView.getContainerPanel().add("addGrao", addGraoGalpaoPanel);

		initControleGalpao();
	}

	public void addGalpao(double altura, double largura, double comprimento) {
		Galpao galpao = new Galpao(altura, largura, comprimento);
		if (galpaoDao.create(galpao)) {
			JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Falha!");
		}
	}

	public void initControleGalpao() {
		gerenciaGalpaoView.getBtnNewGalpao().addActionListener((ActionEvent e) -> {
			CardLayout cardLayout = (CardLayout) (gerenciaGalpaoView.getContainerPanel().getLayout());
			cardLayout.show(gerenciaGalpaoView.getContainerPanel(), "add");
		});

		addGalpaoPanel.getBtnNewGalpao().addActionListener((ActionEvent e) -> {
			double altura = Double.parseDouble(addGalpaoPanel.getTfAltura().getText());
			double largura = Double.parseDouble(addGalpaoPanel.getTfLargura().getText());
			double comprimento = Double.parseDouble(addGalpaoPanel.getTfComprimento().getText());

			addGalpao(altura, largura, comprimento);

			addGalpaoPanel.getTfAltura().setText("");
			addGalpaoPanel.getTfComprimento().setText("");
			addGalpaoPanel.getTfLargura().setText("");
		});

		gerenciaGalpaoView.getBtnAddGraos().addActionListener((ActionEvent e) -> {
			CardLayout cardLayout = (CardLayout) (gerenciaGalpaoView.getContainerPanel().getLayout());
			gerenciaGalpaoView.getContainerPanel().add("addGrao", addGraoGalpaoPanel);
			cardLayout.show(gerenciaGalpaoView.getContainerPanel(), "addGrao");
			preencheListaGalpaos();
		});

		addGraoGalpaoPanel.getListGalpao().addListSelectionListener((ListSelectionEvent e) -> {
			if (!e.getValueIsAdjusting()) {
				selectedGalpao = addGraoGalpaoPanel.getListGalpao().getSelectedValue();
				if (selectedGalpao != null) {
					addGraoGalpaoPanel.getTfGalpao().setText(String.valueOf(selectedGalpao.getId()));
				}
			}
		});

		addGraoGalpaoPanel.getBtnAddGrao().addActionListener((ActionEvent e) -> {
			criarGrao(selectedGalpao);
		});
	}

	public void preencheListaGalpaos() {
		List<Galpao> galpoes = galpaoDao.readAll();

		DefaultListModel<Galpao> model = new DefaultListModel<>();
		for (Galpao galpao : galpoes) {
			model.addElement(galpao);
		}

		addGraoGalpaoPanel.getListGalpao().setModel(model);
	}

	public void criarGrao(Galpao galpao) {
		String nome = addGraoGalpaoPanel.getTfNomeGrao().getText();
		String tipo = addGraoGalpaoPanel.getTfTipoGrao().getText();
		boolean impureza = addGraoGalpaoPanel.getCkbxImpureza().isSelected();
		double nivelImpureza = Double.parseDouble(addGraoGalpaoPanel.getTfImpureza().getText());
		String dataColeta = addGraoGalpaoPanel.getTfDatacoleta().getText();
		double massa = Double.parseDouble(addGraoGalpaoPanel.getTfMassa().getText());

		Grao grao = new Grao(nome, tipo, impureza, massa, nivelImpureza, dataColeta);
		GraoDao graoDao = new GraoDao();
		graoDao.create(grao);

		try (Connection con = ConnectionFactory.createConnectionToMySQL()) {
			PreparedStatement pts = con.prepareStatement("SELECT id FROM grao ORDER BY id DESC LIMIT 1;");
			ResultSet rs = pts.executeQuery();

			int id = 0;
			if (rs.next()) {
				id = rs.getInt("id");
			}
			galpao.setGraoArmazenado(grao);
			galpao.setCapArmazenada(Double.parseDouble(addGraoGalpaoPanel.getTfQuantidade().getText()));
			galpaoDao.update(galpao, galpao.getId(), id);

			addGraoGalpaoPanel.getTfNomeGrao().setText("");
			addGraoGalpaoPanel.getTfTipoGrao().setText("");
			addGraoGalpaoPanel.getCkbxImpureza().setSelected(false);
			addGraoGalpaoPanel.getTfImpureza().setText("");
			addGraoGalpaoPanel.getTfDatacoleta().setText("");
			addGraoGalpaoPanel.getTfMassa().setText("");
			addGraoGalpaoPanel.getTfGalpao().setText("");

			JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
