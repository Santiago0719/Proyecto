/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import controlador.ControladorValidacion;
import modelo.Residente;
import modelo.ResidenteDAO;
import vista.FormValidacion;

/**
 *
 * @author Karol
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         FormValidacion fvalida = new FormValidacion();
         Residente resi = new Residente();
         ResidenteDAO resiDAO = new ResidenteDAO();
         ControladorValidacion contra = new ControladorValidacion(fvalida, resiDAO, resi);
         fvalida.setVisible(true);
    }
    
}
