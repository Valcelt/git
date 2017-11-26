package modeldao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexion.database;
import model.ejecutivo;
import model.natural;

/**
 * @author Aldo Francino
 * 
 */
public class clientedao {

	public class naturaldao {
		private static final String SQL_LISTAR=
				"SELECT * FROM vw_listar_cliente_naturales";
		
	private static final database cnn = database.saberEstado();
		
	    public ArrayList<natural> listar() {    
	        PreparedStatement ps;
	        ResultSet rs;
	        ArrayList<natural> naturales= new ArrayList<>();
	        try {
	            ps = cnn.getCnn().prepareStatement(SQL_LISTAR);
	            rs = ps.executeQuery();
	            while(rs.next()){
	            	natural n = new natural();
	            	n.setPerRut(rs.getString("RUT"));
	                n.setPerNombre(rs.getString("NOMBRE"));
	                n.setPerApePaterno(rs.getString("PATERNO"));
	                n.setPerApeMaterno(rs.getString("MATERNO"));
	                n.setPerFecNacimiento(rs.getString("NACIONALIDAD"));
	                n.setPerNacionalidad(rs.getString("NACIMIENTO"));
	                n.setCliCategoria(rs.getString("CATEGORIA"));
	           ejecutivo e = new ejecutivo ();  
	           		e.setPerRut(rs.getString("EJECUTIVO"));
	           		n.setEje(e);
	           		n.setNatPatrimonio(rs.getInt("PATRIMONIO"));
	           		naturales.add(n);
	            }
	        } catch (SQLException ex) {
	            System.out.println("ERROR AL LISTAR CLIENTE NATURAL "+ex.toString());
	        }
	        return naturales;
	    }

	}
}
