package it.polito.tdp.borders.model;

import java.util.List;

import it.polito.tdp.borders.db.BordersDAO;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		//System.out.println("Creo il grafo relativo al 2000");
		//model.creaGrafo(2000);
		
		BordersDAO dao = new BordersDAO() ;

		
		List<Country> l=  dao.getPaesiAnno(1920);
		for(Country c : l){
			System.out.println("Numero confini di "+c.getNomeAbb()+": "+model.getNumeroPaesiConfinanti(1920, c));
		}
		
	//	List<Country> countries = model.getPaesi();
		//System.out.format("Trovate %d nazioni\n", countries.size());

//		System.out.format("Numero componenti connesse: %d\n", model.getNumberOfConnectedComponents());
		
//		Map<Country, Integer> stats = model.getCountryCounts();
//		for (Country country : stats.keySet())
//			System.out.format("%s %d\n", country, stats.get(country));		
		
	}

}
