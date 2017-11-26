package modeldao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import conexion.database;
import model.juridico;


public class juridicodao {

	
			private static final String SQL_INGRESAR_PERSONA=
		            "INSERT INTO persona(perRut, perNombre, perApePaterno, perApeMaterno, perNacionalidad, perFecNacimiento) "
		            + "VALUES (?, ?, ?, ?, ?, ?)";
			private static final String SQL_INGRESAR_CLIENTE=
		            "INSERT INTO cliente(persona_perRut, cliCategoria) "
		            + "VALUES (?, ?)";
			private static final String SQL_INGRESAR_JURIDICO=
		            "INSERT INTO juridico(cliente_persona_perRut, jurRazSocial) "
		            + "VALUES (?, ?)";
			
			private static final database cnn=database.saberEstado();
			
			public boolean ingresar(juridico x) {
		        PreparedStatement ps;
		        int bandera;
		        try {
		            ps=cnn.getCnn().prepareStatement(SQL_INGRESAR_PERSONA);
		            ps.setString(1, x.getPerRut());
		            ps.setString(2, x.getPerNombre());
		            ps.setString(3, x.getPerApePaterno());
		            ps.setString(4, x.getPerApeMaterno());
		            ps.setString(5, x.getPerNacionalidad());
		            ps.setString(6, x.getPerFecNacimiento());
		            
		            ps=cnn.getCnn().prepareStatement(SQL_INGRESAR_CLIENTE);
		            ps.setString(1, x.getPerRut());
		            ps.setString(2, x.getCliCategoria());
		            
		            ps=cnn.getCnn().prepareStatement(SQL_INGRESAR_JURIDICO);
		            ps.setString(1, x.getPerRut());
		            ps.setString(2, x.getJurRazSocial());
		            bandera=ps.executeUpdate();
		            if(bandera > 0){
		                return true;
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }finally{
		            cnn.cerrarConexion();
		        }
		        return false;
		    }	
		
	}