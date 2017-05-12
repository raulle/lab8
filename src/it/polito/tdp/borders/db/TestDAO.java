package it.polito.tdp.borders.db;


public class TestDAO {

	public static void main(String[] args) {

		BordersDAO dao = new BordersDAO();

		System.out.println("Lista di tutte le nazioni:"+dao.getPaesiAnno(1920));
		System.out.println("Lista di tutti i confini:"+dao.getConfiniAnno(1920));

	}
}
