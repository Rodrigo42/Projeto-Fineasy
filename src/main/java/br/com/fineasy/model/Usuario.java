package br.com.fineasy.model;

import java.util.Date;

public class Usuario extends Categoria{
	//Atributos

	private int id;
	private String nome;
	private Date dataDeNascimento = new Date();
	private String telefone;
	private String email;
	private String senha;

	//Construtores
	public Usuario() {
		super();
	}


	public Usuario(int id, String nome, Date dataDeNascimento, String telefone, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}
	
	





	public Usuario(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}


	//Getters e Settes
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	//Cadastra uma conta
	
}




