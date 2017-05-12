package it.polito.tdp.borders.model;

public class Country {
	
	private int codice;
	private String nomeInt;
	private String nomeAbb;
	
	public Country(int codice, String nomeAbb, String nomeInt) {
		super();
		this.codice = codice;
		this.nomeInt = nomeInt;
		this.nomeAbb = nomeAbb;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNomeInt() {
		return nomeInt;
	}

	public void setNomeInt(String nomeInt) {
		this.nomeInt = nomeInt;
	}

	public String getNomeAbb() {
		return nomeAbb;
	}

	public void setNomeAbb(String nomeAbb) {
		this.nomeAbb = nomeAbb;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codice;
		result = prime * result + ((nomeAbb == null) ? 0 : nomeAbb.hashCode());
		result = prime * result + ((nomeInt == null) ? 0 : nomeInt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (codice != other.codice)
			return false;
		if (nomeAbb == null) {
			if (other.nomeAbb != null)
				return false;
		} else if (!nomeAbb.equals(other.nomeAbb))
			return false;
		if (nomeInt == null) {
			if (other.nomeInt != null)
				return false;
		} else if (!nomeInt.equals(other.nomeInt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nomeAbb;
	}
	
	

}
