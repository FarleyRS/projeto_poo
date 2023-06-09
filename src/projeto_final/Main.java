package projeto_final;

import dao.SiloDao;
import model.Silo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SiloDao sd = new SiloDao();
		
		
		sd.delete(1);
	}

}
