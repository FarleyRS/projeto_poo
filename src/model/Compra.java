package model;

public class Compra {
	
	private Cliente cliente;
	private Grao grao;
	private double total;
	private String data;
	
	public Compra(){
	
	}
	
	public Compra(Cliente cliente, Grao grao, double total, String data) {
		super();
		this.cliente = cliente;
		this.grao = grao;
		this.total = total;
		this.data = data;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Grao getGrao() {
		return grao;
	}
	
	public void setGrao(Grao grao) {
		this.grao = grao;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Compra [cliente=" + cliente + ", grao=" + grao + ", total=" + total + ", data=" + data + "]";
	}
	
}
