package model;

public class Silo extends Armazenamento{
	
	private double diametro;
	
	public Silo() {
		// TODO Auto-generated constructor stub
	}
		
	public Silo(double capMax, double quantArmazenada, Armazenamento tipo, double altura, double diametro) {
		super(capMax, quantArmazenada, tipo, null, altura);
		// TODO Auto-generated constructor stub
		this.diametro = diametro;
	}

	public Silo(double altura, double diametro) {
		super(0, 0, null, null, altura);
		this.diametro = diametro;
		setCapMax(capMax());
		setTipo(this);
	}
	

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	
	private double capMax() {
		double r = diametro/2;
		double volume = 3.14* (r*r)*getAltura();
	
		if(getGraoArmazenado()!=null) {
			double densidade = 1/getGraoArmazenado().getMassa();
			return volume*densidade;
		}else
			return volume*700;
		
		
	}
		
	public void addGrao(double quant, Grao grao) {
		
	}

	public void removerGrao(double quant) {
		
	}
}
