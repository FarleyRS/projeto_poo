package model;

public class Grao {
	
	private int id;
	private String nome, tipo;
	private boolean impureza;
	private double massa, nivel_impureza;
	private String data_coleta;
	
	
	public Grao() {
		// TODO Auto-generated constructor stub
	}
			
	public Grao(String nome, String tipo, boolean impureza, double massa, double nivel_impureza,
			String data_coleta) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.impureza = impureza;
		this.massa = massa;
		this.nivel_impureza = nivel_impureza;
		this.data_coleta = data_coleta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isImpureza() {
		return impureza;
	}

	public void setImpureza(boolean impureza) {
		this.impureza = impureza;
	}

	public double getNivel_impureza() {
		return nivel_impureza;
	}


	public void setNivel_impureza(double nivel_impureza) {
		this.nivel_impureza = nivel_impureza;
	}


	public double getMassa() {
		return massa;
	}

	public void setMassa(double massa) {
		this.massa = massa;
	}

	public String getData_coleta() {
		return data_coleta;
	}

	public void setData_coleta(String data_coleta) {
		this.data_coleta = data_coleta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
