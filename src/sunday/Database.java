package sunday;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	private Connection con;
	private Statement statement;
	private String db = "jdbc:sqlite:strikke.db";
	
	public Database() {
		sjekker(); // sjekker om databasen eksisterer eller ikke.
		
		
	}
	
	public boolean sjekker() {
		boolean eksisterer = true;
		try {
			this.con = DriverManager.getConnection("jdbc:sqlite:strikke.db");
			this.statement = con.createStatement();
			String sqlTabellen = "CREATE TABLE IF NOT EXISTS utstyr("
								+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
								+ "Leverandor VARCHAR(50), "
								+ "Farge VARCHAR(50), "
								+ "Navn VARCHAR(100), "
								+ "Plassering VARCHAR(50));";
			
			int antallEndret = statement.executeUpdate(sqlTabellen);
			if (antallEndret > 0) {
				// databasen eksisterer ikke
				eksisterer = false;
			} else {
				// databasen eksiterer allerede
			}
			
			con.close();
		} catch ( SQLException e ) {
			System.err.print("! Feil med database laging, eller sjekking" + e);
		}
		return eksisterer;
	}
	
	public void lagNy(String s) {
		try {
			this.con = DriverManager.getConnection(db);
			this.statement = con.createStatement();
			statement.executeUpdate(s);
			con.close();
		} catch (SQLException e) {
			System.err.print(e);
		}		
	}
	
	/* Global utstyrliste holdes i Database klassen */
	
	public Utstyr[] hentLageret() {
		Utstyr[] tempTabell = new Utstyr[0];
		try  {
			this.con = DriverManager.getConnection(db);
			this.statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM utstyr");
			int aktiv = 0;
			while (rs.next()) {
				tempTabell = addUtstyrsArray(tempTabell);
				tempTabell[aktiv++] = new Utstyr(rs.getInt("id"), rs.getString("Leverandor"), rs.getString("Farge"), rs.getString("Navn"), rs.getString("Plassering")  );
				}
			con.close();
		} catch ( SQLException e ) {
			System.err.print("SQL ERROR: " + e);
		}
		return tempTabell;
		
	}
	
	private Utstyr[] addUtstyrsArray(Utstyr[] tab) {
		Utstyr[] newer = new Utstyr[tab.length +1];
		int pos = 0;
		for (Utstyr u : tab) {
			newer[pos++] = u;
		}
		return newer;
	}
	
	public void fjern(String id) {
		try {
			this.con = DriverManager.getConnection(db);
			this.statement = con.createStatement();
			statement.executeUpdate(id);
			con.close();
		} catch (SQLException e) {
			System.err.print(e);
		}		
	}
	

}
