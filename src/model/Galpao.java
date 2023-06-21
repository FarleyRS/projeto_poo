package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.GalpaoDao;
import dao.GraoDao;
import factory.ConnectionFactory;

public class Galpao extends Armazenamento {

	private double largura, comprimento;
	private GalpaoDao galpaoDao = new GalpaoDao();
	private GraoDao graoDao = new GraoDao();
	private int id;

	public Galpao() {
		// TODO Auto-generated constructor stub
	}

	public Galpao(double altura, double largura, double comprimento) {
		super(0, 0, null, null, altura);
		this.largura = largura;
		this.comprimento = comprimento;
		setCapMax(capMax());
	}

	public Galpao(double capMax, double quantArmazenada, Armazenamento tipo, Grao graoArmazenado, double altura,
			double largura, double comprimento) {
		super(capMax, quantArmazenada, tipo, graoArmazenado, altura);
		this.largura = largura;
		this.comprimento = comprimento;
		setCapMax(capMax());
	}

	public Galpao(int id, double capMax, double quantArmazenada, Armazenamento tipo, Grao graoArmazenado, double altura,
			double largura, double comprimento) {
		super(capMax, quantArmazenada, tipo, graoArmazenado, altura);
		this.largura = largura;
		this.comprimento = comprimento;
		this.id = id;
		setCapMax(capMax());
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

		double volume = getAltura() * getComprimento() * getLargura();

		if (getGraoArmazenado() != null) {
			double densidade = 1 / getGraoArmazenado().getMassa();
			return volume * densidade;
		} else
			return volume * 700;

	}

	public void addGrao(double quant, int idGalpao, Grao grao) {
		this.setCapArmazenada(quant);
		graoDao.create(grao);
		try {
			Connection con = ConnectionFactory.createConnectionToMySQL();
			PreparedStatement pts = con.prepareStatement("SELECT id FROM grao ORDER BY id ASC; ");
			ResultSet rs = pts.executeQuery();

			int id = 0;
			while (rs.next()) {
				id = rs.getInt("id");
			}

			galpaoDao.update(this, idGalpao, id);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void removerGrao(double quant) {

	}

	public int getId() {
		return id;
	}
}
