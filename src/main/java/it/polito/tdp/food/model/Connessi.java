package it.polito.tdp.food.model;

public class Connessi {

	private String tipoConnesso;
	private int peso;
	public Connessi(String tipoConnesso, int peso) {
		super();
		this.tipoConnesso = tipoConnesso;
		this.peso = peso;
	}
	public String getTipoConnesso() {
		return tipoConnesso;
	}
	public void setTipoConnesso(String tipoConnesso) {
		this.tipoConnesso = tipoConnesso;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "tipo di porzione : " + tipoConnesso + ", peso=" + peso;
	}
	
	
}
