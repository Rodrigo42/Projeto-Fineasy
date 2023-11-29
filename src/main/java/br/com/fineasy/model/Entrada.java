package br.com.fineasy.model;

public class Entrada /* extends Gasto */ {

	// Atributos
	private int id;
	private double valorDeEntrada;
	private String catEntrada;

	public Entrada() {
		super();
	}

	public Entrada(double valor, String categoria) {
		// TODO Auto-generated constructor stub

		this.valorDeEntrada = valor;
		this.catEntrada = categoria;

	}

	public Entrada(int id, double valorDeEntrada, String catEntrada) {
		super();
		this.id = id;
		this.valorDeEntrada = valorDeEntrada;
		this.catEntrada = catEntrada;
	}

	// Getters e Settes

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSaldoDeEntrada() {
		return valorDeEntrada;
	}

	public void setSaldoDeEntrada(double valor) {
		this.valorDeEntrada = valor;
	}

	public String getCategoriaEntrada() {
		return catEntrada;
	}

	public void setCategoriaDeEntrada(String categoriaDeEntrada) {
		this.catEntrada = categoriaDeEntrada;
	}

}
