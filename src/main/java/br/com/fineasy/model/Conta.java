package br.com.fineasy.model;


public class Conta{

	//Atributos
	private int id;
	private String nomeDaConta;
	private double saldo;
	protected double gasto;
	private double entrada;
	/*protected ArrayList<String> categoriaDeGasto = new ArrayList<String>();
	protected ArrayList<String> categoriaDeEntrada = new ArrayList<String>();*/

	public Conta() {
		super();
	}

	public Conta(int id, String nomeDaConta, int saldo) {

		this.id = id;
		this.nomeDaConta = nomeDaConta;
		this.saldo = saldo;

	}

	public Conta(double saldo2, double nr_total_entrada, double nr_total_saida) {
		// TODO Auto-generated constructor stub
		this.saldo = saldo2;
		this.entrada = nr_total_entrada;
		this.gasto = nr_total_saida;
	}

	//Getters e Settes
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeDaConta() {
		return nomeDaConta;
	}

	public void setNomeDaConta(String nomeDaConta) {
		this.nomeDaConta = nomeDaConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public void setGasto(double gasto) {
		this.gasto = gasto;
	}

	public void setEntrada(double valor) {
		this.entrada = valor;
	}

	public double getGasto() {
		return gasto;
	}

	public double getEntrada() {
		return entrada;
	}









}
