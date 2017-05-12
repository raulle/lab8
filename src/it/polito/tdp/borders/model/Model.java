package it.polito.tdp.borders.model;

import java.util.List;
import java.util.Set;

import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {

	UndirectedGraph<Country,DefaultEdge> grafo;
	
	private void creaGrafo(int anno) {
		
		this.grafo = new SimpleGraph<Country,DefaultEdge>(DefaultEdge.class);
		
		BordersDAO dao = new BordersDAO() ;
		
		Graphs.addAllVertices(grafo, dao.getPaesiAnno(anno)) ;
	
		for(Border b : dao.getConfiniAnno(anno))
			grafo.addEdge(b.getPaese1(),b.getPaese2()) ;
		
	}
	
	public int getNumeroPaesiConfinanti(int anno, Country c){
		if(grafo==null)
			this.creaGrafo(anno);
		return grafo.degreeOf(c);
	}
	
	public Set<Country> getPaesi(int anno){
		if(grafo==null)
			this.creaGrafo(anno);
		return grafo.vertexSet();
	}
	
	

}
