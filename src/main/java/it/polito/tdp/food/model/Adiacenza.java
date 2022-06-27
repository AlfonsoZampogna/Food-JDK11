package it.polito.tdp.food.model;

public class Adiacenza {

	private String tipoPorzione1;
	private String tipoPorzione2;
	private int peso;
	public Adiacenza(String tipoPorzione1, String tipoPorzione2, int peso) {
		super();
		this.tipoPorzione1 = tipoPorzione1;
		this.tipoPorzione2 = tipoPorzione2;
		this.peso = peso;
	}
	public String getTipoPorzione1() {
		return tipoPorzione1;
	}
	public void setTipoPorzione1(String tipoPorzione1) {
		this.tipoPorzione1 = tipoPorzione1;
	}
	public String getTipoPorzione2() {
		return tipoPorzione2;
	}
	public void setTipoPorzione2(String tipoPorzione2) {
		this.tipoPorzione2 = tipoPorzione2;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Adiacenza [tipoPorzione1=" + tipoPorzione1 + ", tipoPorzione2=" + tipoPorzione2 + ", peso=" + peso
				+ "]";
	}
	
	
}
