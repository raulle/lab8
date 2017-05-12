package it.polito.tdp.borders.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import it.polito.tdp.borders.model.Border;
import it.polito.tdp.borders.model.Country;


public class BordersDAO {

	public List<Country> loadAllCountries() {

		String sql = "SELECT ccode,StateAbb,StateNme " + "FROM country " + "ORDER BY StateAbb ";

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			List<Country> paesi = new ArrayList<Country>();

			while (rs.next()) {
				paesi.add(new Country(rs.getInt("ccode"),rs.getString("stateAbb"), rs.getString("stateNme")));
			}

			conn.close();
			return paesi;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Error -- loadAllCountries");
			throw new RuntimeException("Database Error");
		}
	}
	
	public List<Country> getPaesiAnno(int anno) {

		String sql = "SELECT DISTINCT country.CCode, country.StateNme, country.StateAbb " +
					"FROM country,contiguity "+
					"WHERE country.CCode=contiguity.state1no "+
					"AND contiguity.year<=? "+
					"AND contiguity.conttype=1 ";

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, anno);
			ResultSet rs = st.executeQuery();
			List<Country> paesi = new ArrayList<Country>();

			while (rs.next()) {
				paesi.add(new Country(rs.getInt("ccode"),rs.getString("stateAbb"), rs.getString("stateNme")));
			}

			conn.close();
			return paesi;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Error -- getPaesiAnno");
			throw new RuntimeException("Database Error");
		}
	}
	

	public List<Border> getConfiniAnno(int anno) {

		try {

			Connection conn = DBConnect.getInstance().getConnection();
			String sql = "SELECT c1.CCode as CCode1, c1.StateAbb as StateAbb1, c1.StateNme as StateNme1, " +
				"c2.CCode as CCode2, c2.StateAbb as StateAbb2, c2.StateNme as StateNme2 " +
				"FROM contiguity, country c1, country c2 " +
				"WHERE contiguity.state1no = c1.CCode " +
				"AND contiguity.state2no = c2.CCode " +
				"AND contiguity.conttype=1 AND contiguity.year<=?";
			PreparedStatement st;
			st = conn.prepareStatement(sql);
			st.setInt(1, anno);
			ResultSet rs = st.executeQuery();

			List<Border> confini = new ArrayList<Border>();

			while (rs.next()){
				Country c1= new Country(rs.getInt("ccode1"),rs.getString("stateAbb1"), rs.getString("stateNme1"));
				Country c2= new Country(rs.getInt("ccode2"),rs.getString("stateAbb2"), rs.getString("stateNme2"));
				confini.add(new Border(c1,c2));
			}
			return confini;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}
	}
}
