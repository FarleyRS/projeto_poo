package model;


public abstract class Armazenamento {
	private double capMax;
	private double quantArmazenada;
	private Armazenamento tipo;
	private Grao graoArmazenado;
	
	private double altura;
	
	
	public Armazenamento() {
		// TODO Auto-generated constructor stub
	}
	

	public Armazenamento(double capMax, double quantArmazenada, Armazenamento tipo, Grao graoArmazenado, double altura) {
		super();
		this.capMax = capMax;
		this.quantArmazenada = quantArmazenada;
		this.tipo = tipo;
		this.graoArmazenado = graoArmazenado;
		this.altura = altura;
	}


	public double getCapMax() {
		return capMax;
	}


	public void setCapMax(double capMax) {
		this.capMax = capMax;
	}


	public double getCapArmazenada() {
		return quantArmazenada;
	}


	public void setCapArmazenada(double capArmazenada) {
		this.quantArmazenada = capArmazenada;
	}


	public Armazenamento getTipo() {
		return tipo;
	}


	public void setTipo(Armazenamento tipo) {
		this.tipo = tipo;
	}


	public Grao getGraoArmazenado() {
		return graoArmazenado;
	}


	public void setGraoArmazenado(Grao graoArmazenado) {
		this.graoArmazenado = graoArmazenado;
	}


	public double getAltura() {
		return altura;
	}


	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	
}
