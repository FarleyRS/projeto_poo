package controller;

import view.DashboardView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DashboardController d = new DashboardController(new DashboardView());
		
		d.initControllerDashboard();
	}

}
