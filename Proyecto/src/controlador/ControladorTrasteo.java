/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Trasteo;
import modelo.TrasteoDAO;
import vista.FormTrasteo;

/**
 *
 * @author Karol
 */
public class ControladorTrasteo implements ActionListener{

    private FormTrasteo ftrasteo;
    private Trasteo trasteo1;
    private TrasteoDAO trasteod;
    
public ControladorTrasteo(FormTrasteo ftrasteo, Trasteo trasteo1, TrasteoDAO trasteod){
    this.ftrasteo = ftrasteo;
    this.trasteo1 = trasteo1;
    this.trasteod = trasteod;
    this.ftrasteo.jBActualizar.addActionListener(this);
    this.ftrasteo.jBConsultar.addActionListener(this);
    this.ftrasteo.jBEliminar.addActionListener(this);
    this.ftrasteo.jBGuardar.addActionListener(this);
    this.ftrasteo.jBNueva.addActionListener(this);
    this.ftrasteo.jBSalir.addActionListener(this);   
    
}

public boolean validar(){
    boolean ok=true;
    //
    if(ftrasteo.jTxApartamento.getText().isEmpty()){
       ftrasteo.jLAnuncio.setText("Debe ingresar el número de aptartamento");
       ok=false;
    }else if (ftrasteo.jTxApartamento.getText().length()<5){
        ftrasteo.jLAnuncio.setText("El apartamento debe tener mínimo 4 caracteres");
        ok=false;
    }else{
        ftrasteo.jLAnuncio.setText("");
    }
    //
    if(ftrasteo.jTxTipoMaterial.getText().isEmpty()){
        ftrasteo.jLAnuncio.setText("Debe ingresar el tipo de material");
        ok=false;
    }else{
        ftrasteo.jLAnuncio.setText("");
    }
    //
//    if(ftrasteo.jDCFecha)
      if(ftrasteo.jTxHora.getText().isEmpty()){
          ftrasteo.jLAnuncio.setText("Debe ingresar la hora");
          ok=false;
      }else{
          ftrasteo.jLAnuncio.setText("");
      }
    //
    if(ftrasteo.jTxNombre.getText().isEmpty()){
        ftrasteo.jLAnuncio.setText("Debe ingresar su nombre");
        ok=false;
    }else{
        ftrasteo.jLAnuncio.setText("");
    }
    if(ftrasteo.jTxCorreo.getText().isEmpty()){
        ftrasteo.jLAnuncio.setText("Debe ingresar el correo electrónico");
        ok=false;
    }else if (!ftrasteo.jTxCorreo.getText().contains("@") || !ftrasteo.jTxCorreo.getText().contains(".")){
        ftrasteo.jLAnuncio.setText("El texto ingresado no corresponde a un correo");
        ok=false;
    }else{
        ftrasteo.jLAnuncio.setText("");
    }
    return ok;
}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ftrasteo.jBGuardar){
            if (validar()){
            int apto = Integer.parseInt(ftrasteo.jTxApartamento.getText());
            String mate = ftrasteo.jTxTipoMaterial.getText();
            String fech = ftrasteo.jDCFecha.getDateFormatString();
            //Capturar dato fecha
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(fech,formatter);
            Date fechasql = java.sql.Date.valueOf(localDate);
            
            String hor = ftrasteo.jTxHora.getText();
            String nom = ftrasteo.jTxNombre.getText();
            String corr = ftrasteo.jTxCorreo.getText();
            trasteo1 = new Trasteo (apto, mate, fechasql, hor, nom, corr);
            if (trasteod.adicionar(trasteo1)){
                JOptionPane.showMessageDialog(ftrasteo, "Ingresado con éxito");
                limpiarControles();
            }else{
                JOptionPane.showMessageDialog(ftrasteo, "No se pudo ingresar datos");
                }
            }
        } 
        
        if(e.getSource()==ftrasteo.jBSalir){
            int respuesta = JOptionPane.showConfirmDialog(ftrasteo, "¿Esta seguro de salir?", "Fin Datos Persona", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(respuesta==JOptionPane.YES_OPTION){
                   ftrasteo.dispose();
            }
        }
        
        if(e.getSource()==ftrasteo.jBConsultar){
          String ident = JOptionPane.showInputDialog("Identificación: ");
            try {
                trasteo1 = trasteod.consultaDato(ident);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorTrasteo.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Trasteo no está inscrito en la BD");
            }
            
            //Enviando los datos del objeto a al vista
            ftrasteo.jTxApartamento.setText(String.valueOf(trasteo1.getNumeroApto()));
            ftrasteo.jTxTipoMaterial.setText(trasteo1.getTipoMaterial());
            ftrasteo.jDCFecha.setDate(trasteo1.getFecha());
            ftrasteo.jTxHora.setText(String.valueOf(trasteo1.getHora()));
            ftrasteo.jTxNombre.setText(trasteo1.getNombre());
            ftrasteo.jTxCorreo.setText(trasteo1.getCorreo());
        
            
        
        }
        if(e.getSource()==ftrasteo.jBActualizar){
          if(validar()){  
            int apto = Integer.parseInt(ftrasteo.jTxApartamento.getText());
            String mate = ftrasteo.jTxTipoMaterial.getText();
            String fech = ftrasteo.jDCFecha.getDateFormatString();
            //Capturar dato fecha
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(fech,formatter);
            Date fechasql = java.sql.Date.valueOf(localDate);
            String hor = ftrasteo.jTxHora.getText();
            String nom = ftrasteo.jTxNombre.getText();
            String corr = ftrasteo.jTxCorreo.getText();
            trasteo1 = new Trasteo(apto, mate, fechasql, hor, nom, corr);
            if(trasteod.actualizarDatos(trasteo1)){
               JOptionPane.showMessageDialog(ftrasteo, "Trasteo actualizado con éxito"); 
            }else{
                JOptionPane.showMessageDialog(ftrasteo, "Trasteo No se actualizó - verificar datos");  
            }
          }  
            
        }
        
        if(e.getSource()==ftrasteo.jBEliminar){
            String id = ftrasteo.jTxApartamento.getText();
            int respuesta = JOptionPane.showConfirmDialog(ftrasteo, "¿Esta seguro de eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(respuesta==JOptionPane.YES_OPTION){
                if(trasteod.eliminarTrasteo(id)){
                  JOptionPane.showMessageDialog(ftrasteo, "Trasteo eliminado con éxito");
                  limpiarControles();
                }else{
                  JOptionPane.showMessageDialog(ftrasteo, "Trasteo no se eliminó - verifique los datos");  
               }   
            }
        }
    }

public void limpiarControles(){
    java.util.Date date = new java.sql.Date(new java.util.Date().getTime());
    ftrasteo.jTxApartamento.setText("");
    ftrasteo.jTxTipoMaterial.setText("");
    ftrasteo.jDCFecha.setDate(date);
    ftrasteo.jTxHora.setText("");
    ftrasteo.jTxNombre.setText("");
    ftrasteo.jTxCorreo.setText("");
    }   
}