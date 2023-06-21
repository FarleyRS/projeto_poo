package controller;

import dao.GalpaoDao;
import dao.GraoDao;
import model.Grao;
import view.DashboardView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new DashboardController(new DashboardView());
		
	}

}
