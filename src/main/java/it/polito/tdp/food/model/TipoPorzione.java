package it.polito.tdp.food.model;

import java.util.List;
import java.util.Objects;

public class TipoPorzione {

	private String nome;
	private List<Portion> portions;
	public TipoPorzione(String nome, List<Portion> portions) {
		super();
		this.nome = nome;
		this.portions = portions;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Portion> getPortions() {
		return portions;
	}
	public void setPortions(List<Portion> portions) {
		this.portions = portions;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoPorzione other = (TipoPorzione) obj;
		return Objects.equals(nome, other.nome);
	}
	@Override
	public String toString() {
		return "TipoPorzione [nome=" + nome + "]";
	}
	
	
	
}
