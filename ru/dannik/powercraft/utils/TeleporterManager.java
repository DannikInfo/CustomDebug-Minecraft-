package ru.dannik.powercraft.utils;

import java.sql.Connection;
import java.sql.DriverManager;
public class TeleporterManager {
	public void start(String worldName) {
		Connection c = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:teleporter_"+worldName+".db");
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    }
	    System.out.println("Opened database successfully");
	}
	public void createDB(){
		
	}
}
