package controller;


import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.DashboardView;
import view.GerenciaPanel;
import view.VendaPanel;

public class DashboardController {
	
	
	DashboardView dv;
	

	JButton btnGeren, btnVenda;

	public DashboardController(DashboardView dv ) {
		// TODO Auto-generated constructor stub
		this.dv = dv;
		
		GerenciaPanel g = new GerenciaPanel();
		VendaPanel v = new VendaPanel();
		
		dv.getBtnGerenciar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				CardLayout cl = (CardLayout) (dv.getPanel().getLayout());
				dv.getPanel().add(g,"gerencia");
				
				cl.show(dv.getPanel(), "gerencia");
			}
		});
		

		dv.getBtnVender().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				CardLayout cl = (CardLayout) (dv.getPanel().getLayout());
				dv.getPanel().add(v,"venda");
				
				cl.show(dv.getPanel(), "venda");
			}
		});
	}

	
	
	public void initControllerDashboard() {
		
	}
	
	
}
