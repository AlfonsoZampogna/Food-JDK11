package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	
	private FoodDao dao;
	private Graph<String,DefaultWeightedEdge> grafo;
	
	//ricorsione
	private List<String> percorso;
	private int peso;
	private int pesoBest = Integer.MIN_VALUE;
	
	public Model() {
		this.dao = new FoodDao();
	}
	
	public void creaGrafo(int calorie) {
		this.grafo = new SimpleWeightedGraph<String,DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.grafo, this.dao.getTipiPorzione(calorie));
		
		for(Adiacenza a : this.dao.getArchi(calorie)) {
			Graphs.addEdgeWithVertices(this.grafo, a.getTipoPorzione1(), a.getTipoPorzione2(), a.getPeso());
		}
	}
	
	public int getNVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public Set<String> getVertici(){
		return this.grafo.vertexSet();
	}
	
	public int getNArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public List<Connessi> getConnessi(String tipoPorzione){
		List<Connessi> result = new ArrayList<Connessi>();
		List<String> adiacenti = Graphs.neighborListOf(this.grafo, tipoPorzione);
		if(adiacenti.isEmpty())
			return null;
		for(String s : adiacenti) {
			for(DefaultWeightedEdge e : this.grafo.edgeSet()) {
				if(e.equals(this.grafo.getEdge(tipoPorzione, s)))
					result.add(new Connessi(s,(int)this.grafo.getEdgeWeight(e)));
			}
		}
		return result;
	}
	
	public List<String> getPercorsoMigliore(int numeroPassi, String tipodiPartenza){
		this.percorso = new ArrayList<String>();
		List<String> parziale = new ArrayList<String>();
		parziale.add(tipodiPartenza);
		peso = 0;
		run(parziale,numeroPassi,peso);
		
		return this.percorso;
	}

	private void run(List<String> parziale, int numeroPassi, int peso2) {
		// caso di terminazione
		if(parziale.size()==numeroPassi) {
			if(peso2>=this.pesoBest) {
				this.pesoBest=peso2;
				this.percorso = new ArrayList<String>(parziale);
			}
			return;
		}
		//continua recursione
		List<String> adiacenti = Graphs.neighborListOf(this.grafo, parziale.get(parziale.size()-1));
		if(adiacenti.isEmpty())
			return;
		for(String s : adiacenti) {
			if(!parziale.contains(s)) {
				DefaultWeightedEdge e = this.grafo.getEdge(parziale.get(parziale.size()-1),s);
	    		int incremento = (int)this.grafo.getEdgeWeight(e);
		    	peso+=incremento;
			    parziale.add(s);
			    run(parziale,numeroPassi,peso);
			    parziale.remove(parziale.size()-1);
			    peso-=incremento;
			}
		}
	}

	public int getPesoBest() {
		return pesoBest;
	}
	
}
