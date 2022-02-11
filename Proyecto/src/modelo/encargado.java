/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Karol
 */
public class encargado {
    private int idEncargado;
    private boolean revisarReserva;
    private boolean confirmarReserva;
    private int idReserva;

    public encargado() {
    }

    public encargado(int idEncargado, boolean revisarReserva, boolean confirmarReserva, int idReserva) {
        this.idEncargado = idEncargado;
        this.revisarReserva = revisarReserva;
        this.confirmarReserva = confirmarReserva;
        this.idReserva = idReserva;
    }
    
    

    public int getIdEncargado() {
        return idEncargado;
    }

    public boolean isRevisarReserva() {
        return revisarReserva;
    }

    public boolean isConfirmarReserva() {
        return confirmarReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdEncargado(int idEncargado) {
        this.idEncargado = idEncargado;
    }

    public void setRevisarReserva(boolean revisarReserva) {
        this.revisarReserva = revisarReserva;
    }

    public void setConfirmarReserva(boolean confirmarReserva) {
        this.confirmarReserva = confirmarReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    
     
    
    
}
