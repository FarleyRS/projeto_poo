package controller;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import dao.GalpaoDao;
import model.Galpao;
import view.galpao.AddGalpaoPanel;
import view.galpao.AddGraoGalpaoPanel;
import view.galpao.GerenciaGalpaoView;

public class GalpaoController {

	GalpaoDao gd = new GalpaoDao();

	GerenciaGalpaoView g;
	AddGalpaoPanel ag;
	AddGraoGalpaoPanel agg;

	public GalpaoController(GerenciaGalpaoView g) {
		// TODO Auto-generated constructor stub
		this.g = g;
		this.ag = new AddGalpaoPanel();
		this.agg = new AddGraoGalpaoPanel();
		
		g.getContainerPanel().add("add",ag);
		g.getContainerPanel().add("addGrao",agg);
		
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
	
	public void  initControleGalpao() {
		g.getBtnNewGalpao().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				CardLayout cl = (CardLayout) (g.getContainerPanel().getLayout());
				cl.show(g.getContainerPanel(), "add");;
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
			}
		});
	}

}
