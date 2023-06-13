package projeto_final;

import dao.GraoDao;
import dao.SiloDao;
import model.Grao;
import model.Silo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grao g = new Grao("Milho", "Amarelo", true, 0.0034, 0.2, "08/12/2023");

		GraoDao gd = new GraoDao();

		gd.delete(1);
	}

}
