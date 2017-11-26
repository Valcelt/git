/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeldao;

import conexion.database;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ejecutivo;
import model.juridico;
import model.natural;
import java.lang.Integer;

/**
 *
 * @author Aldo Francino
 * @version 10.0
 * 
 */
public class naturaldao{
    private static final String SQL_LISTAR=
            "SELECT * FROM vw_listar_cliente_naturales";
    private static final String SQL_INGRESAR=
            "CALL banco.sp_ingresar_natural(?,?,?,?,?,?)";
    private static final String SQL_ELIMINAR=
            "DELETE FROM banco.natural WHERE cliente_persona_perRut = ?;";
    private static final String SQL_EXISTE= 
            "SELECT * FROM banco.natural WHERE cliente_persona_perRut = ?";
    private static final String SQL_BUSCAR= 
            "SELECT * FROM banco.natural n, cliente c, persona p"
            + " WHERE p.perRut = c.persona_perRut"
            + " AND c.persona_perRut = n.cliente_persona_perRut"
            + " AND cliente_persona_perRut LIKE ?;";
    private static final String SQL_ACTUALIZAR=
            "UPDATE FROM Natural SET natPatrimonio = ?,  WHERE cliente_persona_perRut = ?";
    
    private static final database cnn=database.saberEstado();

    public ArrayList<natural> listar() {
    
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<natural> Naturales= new ArrayList<>();
        try {
            ps=cnn.getCnn().prepareStatement(SQL_LISTAR);
            rs=ps.executeQuery();
            while(rs.next()){
                		natural n = new natural();
                    	n.setPerRut(rs.getString("RUT"));
                    	n.setPerNombre(rs.getString("NOMBRE"));
                    	n.setPerApePaterno(rs.getString("PATERNO"));
                    	n.setPerApeMaterno(rs.getString("MATERNO"));
                    	n.setPerNacionalidad(rs.getString("NACIONALIDAD"));
                    	n.setPerFecNacimiento(rs.getString("NACIMIENTO"));
                    	n.setCliCategoria(rs.getString("CATEGORIA"));
                    	ejecutivo e = new ejecutivo();
                    	e.setPerRut(rs.getString("EJECUTIVO"));
                    	n.setNatPatrimonio(rs.getInt("PATRIMONIO"));
                    	Naturales.add(n);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar Clientes Naturales"+ex.toString());
        }
        return Naturales;
    }
    
    public boolean ingresar(natural n){
		CallableStatement cs;
		ResultSet rs;
		int bandera=0;
	        try {
	        	cs = cnn.getCnn().prepareCall(SQL_INGRESAR);
	        	cs.setString(1, n.getPerRut());
	            cs.setString(2, n.getPerNombre());
	            cs.setString(3, n.getPerApePaterno());
	            cs.setString(4, n.getPerApeMaterno());
	            cs.setString(5, n.getCliCategoria());
	            cs.setInt(6, n.getNatPatrimonio());
	            rs = cs.executeQuery();
	            while(rs.next()){
	            	bandera = rs.getInt("_resultado");
	            }
	            if(bandera > 0) {
	            	return true;
	            }
	        } catch (SQLException ex) {
	        	 System.out.println("Error al Ingresar Cliente Natural " + ex.toString());
	        }finally{
	            cnn.cerrarConexion();
	        }
		return false;
	}
    
    public boolean eliminar(natural x) {

        PreparedStatement ps;

        int bandera;

        try{

            ps = cnn.getCnn().prepareStatement(SQL_ELIMINAR);

            ps.setString(1, x.getPerRut());

            bandera = ps.executeUpdate();

            if(bandera > 0){

                return true;

            }

        }catch(SQLException ex){

            ex.printStackTrace();

        }finally{

            cnn.cerrarConexion();

        }

        return false;

    }
    public boolean existe(natural n) {

        PreparedStatement ps;
        ResultSet rs;
        natural n2 = new natural();

            try {
	            ps=cnn.getCnn().prepareStatement(SQL_EXISTE);
	            ps.setString(1, n.getPerRut());
	            rs=ps.executeQuery();
	            while(rs.next()){
	            	n2=new natural();
	            	n2.setPerRut(rs.getString("RUT"));
	            }
	            return(n.equals(n2));
            } catch (SQLException ex) {

                Logger.getLogger(naturaldao.class.getName()).log(Level.SEVERE, null, ex);

            }finally{

                cnn.cerrarConexion();

            }

        	return false;

    }
    
    public boolean actualizar(natural x) {

        PreparedStatement ps;

        int bandera;

        try {

            ps=cnn.getCnn().prepareStatement(SQL_ACTUALIZAR);

            ps.setInt(1,x.getNatPatrimonio());

            bandera=ps.executeUpdate();

            if(bandera>0){

                return true;

            }

        } catch (SQLException ex) {

            Logger.getLogger(naturaldao.class.getName()).log(Level.SEVERE, null, ex);

        }finally{

            cnn.cerrarConexion();

        }

        return false;

    }
    
    public natural buscar(natural n) {
        PreparedStatement ps;
        ResultSet rs;
        natural c=null;
            try {
            ps=cnn.getCnn().prepareStatement(SQL_BUSCAR);
            ps.setString(1, n.getPerRut()+"%");
            rs=ps.executeQuery();
            while(rs.next()){
            	n=new natural();
            	n.setPerNombre(rs.getString("RUT"));
            	n.setPerApePaterno(rs.getString("PATERNO"));
            	n.setPerApePaterno(rs.getString("MATERNO"));
            }
            } catch (SQLException ex) {
                Logger.getLogger(naturaldao.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                cnn.cerrarConexion();
            }
        return n;
    }

}