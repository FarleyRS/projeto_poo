package model;

public class Cliente {
	
	private int id;
	private String nome;
	private String cpf;
	private int compras;
	
	public Cliente() {
		
	}
	
	public Cliente(int id, String nome, String cpf, int compras) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.compras = compras;
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getCompras() {
		return compras;
	}

	public void setCompras(int compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {
		return "Cliente: " + nome;
	}

}
