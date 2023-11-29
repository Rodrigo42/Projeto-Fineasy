package br.com.fineasy.model;



import java.util.ArrayList;
import java.util.List;
public class Categoria extends Entrada{
	
	//Atributos
	private int id;
	private ArrayList<String> categoriaE = new ArrayList<String>();
	private List<String> categoriaG = new ArrayList<String>();
	private int gastoDaCategoria;
	
	
	public Categoria() {
		super();
	}


	public Categoria(int id, ArrayList<String> categoriaE, ArrayList<String> categoriaG, int gastoDaCategoria) {
		super();
		this.id = id;
		this.categoriaE = categoriaE;
		this.categoriaG = categoriaG;
		this.gastoDaCategoria = gastoDaCategoria;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<String> getCategoriaE() {
		return categoriaE;
	}


	public void setCategoriaE(ArrayList<String> categoriaE) {
		
		this.categoriaE = categoriaE;
	}


	public List<String> getCategoriaG() {
		return categoriaG;
	}


	public void setCategoriaG(String categoria) {
		
		this.categoriaG.add(categoria);
	}


	public int getGastoDaCategoria() {
		return gastoDaCategoria;
	}


	public void setGastoDaCategoria(int gastoDaCategoria) {
		this.gastoDaCategoria = gastoDaCategoria;
	}

	
	//Cadastra uma nova categoria de entradas
	/*public void setCategoriaDeEntrada(String nomeDaCategoria) {
		this.nomeDaCategoria = nomeDaCategoria;
		for(int i=0; i < this.categoriaDeEntrada.size(); i++) {
			if(nomeDaCategoria == this.categoriaDeEntrada.get(i)){
				System.out.println("A categoria digitada já existe.");
			}
		}
		categoriaDeEntrada.add(nomeDaCategoria);
		
	}*/
	
	//Cadastra uma nova categoria de gasto
	/*public void setCategoriaDeGasto(String nomeDaCategoria) {
		this.nomeDaCategoria = nomeDaCategoria;
		for(int i=0; i < this.categoriaDeGasto.size(); i++) {
			if(nomeDaCategoria == this.categoriaDeGasto.get(i)){
				System.out.println("A categoria digitada já existe.");
			}
		}
		categoriaDeGasto.add(nomeDaCategoria);
		
	}*/
	
}
