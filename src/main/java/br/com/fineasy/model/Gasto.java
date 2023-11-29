package br.com.fineasy.model;

import br.com.fineasy.model.Conta;

public class Gasto extends Conta {

	//Atributos
	private int id;
	private double saldoDeGasto;
	private String catEntrada;


	public Gasto() {
		super();
	}

	public Gasto(double saldoDeGasto, String categoriaDeGasto) {
		super();
		this.saldoDeGasto = saldoDeGasto;
		this.catEntrada = categoriaDeGasto;
	}

	public Gasto(int id2, double saldoDeGasto2, String categoriaDeGasto2) {
		
		super();
		this.id = id2;
		this.saldoDeGasto = saldoDeGasto2;
		this.catEntrada = categoriaDeGasto2;
	}

	/*
	Verifica se a conta chegou no negativo.
	*/
	public void setGasto(double valor) {
			this.saldoDeGasto -= valor;
			gasto -= valor;
			System.out.println("Gasto de " + valor + "registrado.");
			if(getSaldo() < 0) {
				System.out.println("Seu saldo está negativo.");
			}
	}




	public void setCategoriaDeGasto(String categoriaDeGasto) {
		this.catEntrada = categoriaDeGasto;
	}

	//Getters e Settes
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public double getSaldoDeGasto() {
		return saldoDeGasto;
	}

	public String getCategoriaDeGasto() {
		return catEntrada;
	}



}
