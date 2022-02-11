/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.SalonDAO;
import modelo.SalonSocialBbq;
import vista.FormSalonSocialBqq;

/**
 *
 * @author Samsung
 */
public class ControladorSalon implements ActionListener {
    
    private FormSalonSocialBqq fsalon;
    private SalonSocialBbq salon1;
    private SalonDAO salond;

    public ControladorSalon(FormSalonSocialBqq fsalon, SalonSocialBbq salon1, SalonDAO salond) {
        this.fsalon = fsalon;
        this.salon1 = salon1;
        this.salond = salond;
        this.fsalon.jBActualizar.addActionListener(this);
        this.fsalon.jBConsultar.addActionListener(this);
        this.fsalon.jBEliminar.addActionListener(this);
        this.fsalon.jBGuardar.addActionListener(this);
        this.fsalon.jBNueva.addActionListener(this);
        this.fsalon.jBSalir.addActionListener(this);   
    }
    public boolean validar(){
    boolean ok=true;
    //
   // if(fsalon.jDCFecha.getDate().isEmpty()){
        
    //}
    //if(fsalon.jCBLugar.getSelectedItem().isEmpty()){
        
   // }
   if(fsalon.jTxDeposito.getText().isEmpty()){
       fsalon.jLAnuncio.setText("Debe ingresar la cantidad de deposito");
       ok=false;
   }else if (fsalon.jTxDeposito.getText().length()<11) {
       fsalon.jLAnuncio.setText("Debe tener mínimo 10 dígitos");
       ok=false;
   }else{
       fsalon.jLAnuncio.setText("");
   }
   //
    if(fsalon.jTxApartamento.getText().isEmpty()){
       fsalon.jLAnuncio.setText("Debe ingresar el número de aptartamento");
       ok=false;
    }else if (fsalon.jTxApartamento.getText().length()<5){
        fsalon.jLAnuncio.setText("El apartamento debe tener mínimo 4 caracteres");
        ok=false;
    }else{
        fsalon.jLAnuncio.setText("");
    }
    //
    if(fsalon.jTxNombre.getText().isEmpty()){
        fsalon.jLAnuncio.setText("Debe ingresar su nombre");
        ok=false;
    }else{
        fsalon.jLAnuncio.setText("");
    }
    if(fsalon.jTxCorreo.getText().isEmpty()){
        fsalon.jLAnuncio.setText("Debe ingresar el correo electrónico");
        ok=false;
    }else if (!fsalon.jTxCorreo.getText().contains("@") || !fsalon.jTxCorreo.getText().contains(".")){
        fsalon.jLAnuncio.setText("El texto ingresado no corresponde a un correo");
        ok=false;
    }else{
        fsalon.jLAnuncio.setText("");
    }
    return ok;
}

    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
