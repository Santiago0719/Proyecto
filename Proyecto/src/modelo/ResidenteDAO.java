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

/**
 *
 * @author Karol
 */
public class ResidenteDAO {
    // Atributos de la conexión
    Conexion cn = new Conexion(); 
    Connection con; // Verificar la instriccion sql y ejecutarla
    PreparedStatement ps; // Objeto donde se carga 
    ResultSet  rs; // Objeto que guarda el resultado de la consulta 
    Residente resi = new Residente();
    
    public boolean validarResidente(int apartamento)throws ClassNotFoundException{
        boolean ok= false;
        Conexion conex = new Conexion();
        String sql = "Select * from residente";
        try{
            con = cn.getConnection();
            PreparedStatement ps = conex.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           while (rs.next()){
            if (rs.getInt("numeroApto")== apartamento){
                ok= true;    
            }
           }
        }catch(SQLException ex){
            System.out.println(ex);
        }        
        return ok;
    }
}
