/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Karol
 */
public class Reserva {
    private int idReserva;
    private String nombre;
    private int numeroApto;
    private Date horaReserva;
    private Date fechaReserva;

    public Reserva() {
    }

    public Reserva(int idReserva, String nombre, int numeroApto, Date horaReserva, Date fechaReserva) {
        this.idReserva = idReserva;
        this.nombre = nombre;
        this.numeroApto = numeroApto;
        this.horaReserva = horaReserva;
        this.fechaReserva = fechaReserva;
    }
    
    

    public int getIdReserva() {
        return idReserva;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroApto() {
        return numeroApto;
    }

    public Date getHoraReserva() {
        return horaReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroApto(int numeroApto) {
        this.numeroApto = numeroApto;
    }

    public void setHoraReserva(Date horaReserva) {
        this.horaReserva = horaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    
    
}
