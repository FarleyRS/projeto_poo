package controller;


import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.DashboardView;
import view.GerenciaPanel;
import view.VendaPanel;
import view.galpao.GerenciaGalpaoView;
import controller.CompraController;

public class DashboardController {
	
	private GerenciaPanel gp;
	private VendaPanel vp;
	private DashboardView dv;
	public DashboardController() {
		
	}

	public DashboardController(DashboardView dv) {
		// TODO Auto-generated constructor stub
		gp = new GerenciaPanel();
		vp = new VendaPanel();
		this.dv = dv;
		
		dv.getPanel().add("gerenciamento", gp);
		dv.getPanel().add("venda", vp);
		initControllerDashboard();
	}
	
	public void initControllerDashboard() {
		dv.getBtnGerenciar().addActionListener(e -> abrePanelGerenciamento());
		dv.getBtnVender().addActionListener(e -> abrePanelVenda());
		
		gp.getBtnGerenciarGalpao().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				abreGerenciamento();
			}
		});
	}
	
	public void abrePanelGerenciamento() {
		CardLayout cl = (CardLayout) (dv.getPanel().getLayout());
		cl.show(dv.getPanel(), "gerenciamento");
	}
	
	public void abrePanelVenda(){
		CardLayout cl = (CardLayout) (dv.getPanel().getLayout());
		cl.show(dv.getPanel(), "venda");
		new CompraController(vp);
	}

	public void abreGerenciamento() {
		GalpaoController d = new GalpaoController(new GerenciaGalpaoView());
	}
	
	
	
}
