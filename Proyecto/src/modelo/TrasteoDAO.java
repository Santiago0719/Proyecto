/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karol
 */
public class TrasteoDAO {
    // Atributos de la conexión
    Conexion cn = new Conexion(); 
    Connection con; // Verificar la instriccion sql y ejecutarla
    PreparedStatement ps; // Objeto donde se carga 
    ResultSet  rs; // Objeto que guarda el resultado de la consulta 
    Trasteo trasteo = new Trasteo();
    
    public boolean adicionar (Trasteo trasteo){
        String sql = "insert into trasteo (numeroApto, tipoMaterial, fecha, "
                +" hora, nombre, correo) values ('" + trasteo.getNumeroApto()+
                "', '"+ trasteo.getTipoMaterial()+"','"+ trasteo.getNombre()+
                "', '"+ trasteo.getCorreo()+"')";
        
        // Conectarse a BD
    con = cn.getConnection();
    
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TrasteoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            return false;
        }
        return true;
               
    }
    
    public boolean actualizarDatos(Trasteo trasteo){
        String sql = "update trasteo set nombre='"+trasteo.getCorreo()+"',correo='"+
                trasteo.getTipoMaterial()+"',tipoMaterial='"+trasteo.getFecha()+
                "',fecha='"+trasteo.getHora()+"',hora='"+trasteo.getNombre()+
                "',nombre='"+trasteo.getNumeroApto()+"' where numeroApto='"+
                trasteo.getNumeroApto()+"'";
        //Conectarse a BD
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TrasteoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            return false;
        }
        return true;
    }
    
    public boolean eliminarTrasteo(String idNumApto){
        String sql = "Delete from trasteo where numeroApto='"+idNumApto+"'";
        //Conectarse a BD
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TrasteoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            return false;
        }
        return true;
    }
    
    public Trasteo consultaDato(String idNumApto) throws SQLException{
       String sql = "Select * from trasteo where numeroApto='"+idNumApto+"'";
       con = cn.getConnection(); //Establece la conexion
       ps = con.prepareStatement(sql); //Se prepara el codigo sql
       rs = ps.executeQuery();
       while(rs.next()){
          trasteo.setNumeroApto(rs.getInt("numeroApto"));
          trasteo.setTipoMaterial(rs.getString("tipoMaterial"));
          trasteo.setFecha(rs.getDate("fecha"));
          trasteo.setHora(rs.getString("hora"));
          trasteo.setNombre(rs.getString("nombre"));
          trasteo.setCorreo(rs.getString("correo"));
       }
       return trasteo;
    }
}
