package modeldao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexion.database;
import model.cuenta;
import model.ejecutivo;

public class ejecutivodao {
	private static final String SQL_LISTAR=
            "SELECT * FROM listarejecutivos";
	private static final String SQL_INGRESAR = 
			"call banco.sp_ingresar_ejecutivo(?, ?, ?, ?,?);";
	
    private static final database cnn=database.saberEstado();
	
    public ArrayList<ejecutivo> listar() {    
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<ejecutivo> ejecutivos= new ArrayList<>();
        try {
            ps = cnn.getCnn().prepareStatement(SQL_LISTAR);
            rs = ps.executeQuery();
            while(rs.next()){
                ejecutivos.add(
                        new ejecutivo(rs.getString("RUT"),
                        		rs.getString("NOMBRE"),
                        		rs.getString("PATERNO"),
                        		rs.getString("MATERNO"),
                        		rs.getString("NACIONALIDAD"),
                        		rs.getString("NACIMIENTO"),
                                rs.getString("FECHA_CONTRATO")));
            }
            } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR EJECUTIVO "+ex.toString());
        }
        return ejecutivos;
    }
    public boolean ingresar(ejecutivo e){
		CallableStatement cs;
		ResultSet rs;
		int bandera=0;
	        try {
	        	cs = cnn.getCnn().prepareCall(SQL_INGRESAR);
	        	cs.setString(1, e.getPerRut());
	            cs.setString(2, e.getPerNombre());
	            cs.setString(3, e.getPerApePaterno());
	            cs.setString(4,e.getPerApeMaterno());
	            cs.setString(5, e.getEjeFecContrato());
	            rs = cs.executeQuery();
	            while(rs.next()){
	            	bandera = rs.getInt("_resultado");
	            }
	            if(bandera > 0) {
	            	return true;
	            }
	        } catch (SQLException ex) {
	        	 System.out.println("Error al Ingresar Cuenta " + ex.toString());
	        }finally{
	            cnn.cerrarConexion();
	        }
		return false;
	}
	
}
