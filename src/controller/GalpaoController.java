package controller;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
import javax.swing.table.DefaultTableModel;

public class GalpaoController {

	GalpaoDao gd = new GalpaoDao();

	GerenciaGalpaoView g;
	AddGalpaoPanel ag;
	AddGraoGalpaoPanel agg;
	int idGalpao = 0;
	Galpao galpao;

	public GalpaoController(GerenciaGalpaoView g) {
		// TODO Auto-generated constructor stub
		this.g = g;
		this.ag = new AddGalpaoPanel();
		this.agg = new AddGraoGalpaoPanel();

		g.getContainerPanel().add("add", ag);
		g.getContainerPanel().add("addGrao", agg);

		initControleGalpao();

	}

	public void addGalpao(double altura, double largura, double comprimento) {
		Galpao g = new Galpao(altura, largura, comprimento);
		if (gd.create(g)) {
			JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Falha!");
		}

	}

	public void initControleGalpao() {
		g.getBtnNewGalpao().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				CardLayout cl = (CardLayout) (g.getContainerPanel().getLayout());
				cl.show(g.getContainerPanel(), "add");
				
			}
		});

		ag.getBtnNewGalpao().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				double altura = Double.parseDouble(ag.getTfAltura().getText());
				double largura = Double.parseDouble(ag.getTfLargura().getText());
				double comprimento = Double.parseDouble(ag.getTfComprimento().getText());

				addGalpao(altura, largura, comprimento);

				ag.getTfAltura().setText("");
				ag.getTfComprimento().setText("");
				ag.getTfLargura().setText("");
			}
		});

		g.getBtnAddGraos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				CardLayout cl = (CardLayout) (g.getContainerPanel().getLayout());
				g.getContainerPanel().add("addGrao", agg);
				cl.show(g.getContainerPanel(), "addGrao");
				preencheListaGalpaos();
				
			}
		});
		agg.getListGalpao().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					Galpao selectedGalpao = (Galpao) agg.getListGalpao().getSelectedValue();
					if (selectedGalpao != null) {
						agg.getTfGalpao().setText(String.valueOf(selectedGalpao.getId()));
						galpao = selectedGalpao;
						
					}
				}
			}

		});
		agg.getBtnAddGrao().addActionListener(e -> criarGrao(galpao));
	}

	public void preencheListaGalpaos() {
		GalpaoDao galpaoDao = new GalpaoDao();
		List<Galpao> galpoes = galpaoDao.readAll();

		DefaultListModel<Galpao> model = new DefaultListModel<>();
		for (Galpao galpao : galpoes) {
			model.addElement(galpao);
		}

		agg.getListGalpao().setModel(model);
	}

	public void criarGrao(Galpao galpao) {
	    String nome = agg.getTfNomeGrao().getText();
	    String tipo = agg.getTfTipoGrao().getText();
	    boolean impureza = agg.getCkbxImpureza().isSelected();
	    double nivelImpureza = Double.parseDouble(agg.getTfImpureza().getText());
	    String dataColeta = agg.getTfDatacoleta().getText();
	    double massa = Double.parseDouble(agg.getTfMassa().getText());

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
	        GalpaoDao galpaoDao = new GalpaoDao();
	        galpaoDao.update(galpao, idGalpao, id);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
