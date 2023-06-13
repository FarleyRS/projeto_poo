package model;

public class Galpao extends Armazenamento{
	
	private double largura, comprimento;
	
	public Galpao() {
		// TODO Auto-generated constructor stub
	}
	
	public Galpao(double altura, double largura, double comprimento) {
		super(0, 0, null, null, altura);
		this.largura = largura;
		this.comprimento = comprimento;
	}

	public Galpao(double capMax, double quantArmazenada, Armazenamento tipo, Grao graoArmazenado, double altura,
			double largura, double comprimento) {
		super(capMax, quantArmazenada, tipo, graoArmazenado, altura);
		this.largura = largura;
		this.comprimento = comprimento;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	
	public double capMax() {
		
		double volume = getAltura()*getComprimento()*getLargura();

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
