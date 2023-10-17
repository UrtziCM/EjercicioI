package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Persona;

public class GestorDBPersona {
    private ConexionDB conexion;

    public ObservableList<Persona> cargarPersonas()  {
    	
    	ObservableList<Persona> personas = FXCollections.observableArrayList();
        try {
            conexion = new ConexionDB();        	
        	String consulta = "SELECT * FROM Persona";
        	PreparedStatement pstmt = conexion.getConexion().prepareStatement(consulta);      
        	ResultSet rs = pstmt.executeQuery();   
				
			 while (rs.next()) {
		            int idPersona = rs.getInt("id");
		            String nombre = rs.getString("nombre");
		            String apellidos = rs.getString("apellidos");
		            int edad = rs.getInt("edad");
	                Persona p = new Persona(nombre,apellidos,edad);
	                System.out.println(p.toString());
	                personas.add(p);        
        }             
		rs.close();       
        conexion.closeConexion();
        
	    } catch (SQLException e) {	    	
	    	e.printStackTrace();
	    }    
        return personas;    
    }
}