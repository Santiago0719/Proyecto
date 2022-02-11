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
public class Cartera {
    private int idCartera;
    private int idReserva;
    private int saldo;
    private String aviso;

    public Cartera() {
    }

    public Cartera(int idCartera, int idReserva, int saldo, String aviso) {
        this.idCartera = idCartera;
        this.idReserva = idReserva;
        this.saldo = saldo;
        this.aviso = aviso;
    }

    public int getIdCartera() {
        return idCartera;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public int getSaldo() {
        return saldo;
    }

    public String getAviso() {
        return aviso;
    }

    public void setIdCartera(int idCartera) {
        this.idCartera = idCartera;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setAviso(String aviso) {
        this.aviso = aviso;
    }

    
}
