/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Residente;
import modelo.ResidenteDAO;
import vista.FormMenu;
import vista.FormValidacion;

/**
 *
 * @author Karol
 */
public class ControladorValidacion implements ActionListener{
    FormValidacion fvalidacion;
    ResidenteDAO residented;
    Residente resi;

    public ControladorValidacion(FormValidacion fvalidacion, ResidenteDAO residented, Residente resi) {
        this.fvalidacion = fvalidacion;
        this.residented = residented;
        this.resi = resi;
        fvalidacion.setLocationRelativeTo(null);
        fvalidacion.jBtIngresar.addActionListener(this);
        fvalidacion.jBtSalir.addActionListener(this);
        //fvalidacion.jBtIngresar.setEnabled(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==fvalidacion.jBtIngresar){ 
       int resi = parseInt(fvalidacion.jTxApartamento.getText());
       
          try {
              // int resiPrueba=637;
              
              if (residented.validarResidente(resi)){
                  FormMenu fmenu = new FormMenu();
                  fmenu.setVisible(true);
                  
              } else {
                  JOptionPane.showMessageDialog(fvalidacion,"Número de apartamento inválido");
              }
              //try {
              //   if (residented.validarResidente(resi)){
              //     FormMenu fmenu = new FormMenu();
              //   fmenu.setVisible(true);
              //}else{
              //  JOptionPane.showMessageDialog(fvalidacion,"Número de apartamento inválido");
              //}
              //} catch (ClassNotFoundException ex) {
              //  Logger.getLogger(ControladorValidacion.class.getName()).log(Level.SEVERE, null, ex);
              // }
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(ControladorValidacion.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
     
      if(e.getSource()==fvalidacion.jBtSalir){
            int respuesta = JOptionPane.showConfirmDialog(fvalidacion, "¿Está seguro de salir?", "Fin", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(respuesta==JOptionPane.YES_OPTION){
                   System.exit(0);
            }
        }
    }    
}