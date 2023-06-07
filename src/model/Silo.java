package model;

public class Silo extends Armazenamento{
	
	private double diametro;
	
	public Silo() {
		// TODO Auto-generated constructor stub
	}
	
	public Silo(Armazenamento tipo, double altura, double diametro) {
		super(0, 0, tipo, null, altura);
		this.diametro = diametro;
		setCapMax(capMax());
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
		
		return volume*getGraoArmazenado().getDensidade();
	}
		
	public void addGrao(double quant, Grao grao) {
		
	}

	public void removerGrao(double quant) {
		
	}
}
