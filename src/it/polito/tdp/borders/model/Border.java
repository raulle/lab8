package it.polito.tdp.borders.model;

public class Border {
	
	private Country paese1;
	private Country paese2;
	
	public Border(Country paese1, Country paese2) {
		super();
		this.paese1 = paese1;
		this.paese2 = paese2;
	}
	
	public Country getPaese1() {
		return paese1;
	}
	
	public void setPaese1(Country paese1) {
		this.paese1 = paese1;
	}
	
	public Country getPaese2() {
		return paese2;
	}
	
	public void setPaese2(Country paese2) {
		this.paese2 = paese2;
	}
	
	@Override
	public String toString() {
		return paese1.getNomeAbb()+" - "+paese2.getNomeAbb();
	}
	
		

}
