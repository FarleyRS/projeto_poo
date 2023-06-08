package projeto_final;

import dao.GraoDao;
import factory.ConnectionFactory;
import model.Grao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grao g = new Grao("Feijao","carioca",false, 0.3, 0,"02/02/2022");
		
		GraoDao g2 = new GraoDao();
		
		g2.creat(g);
	}

}
