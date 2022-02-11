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
public class SalonSocialBbq {
    private String lugar;
    private int deposito;
    private int numeroApto;
    private String nombre;
    private String correo;

    public SalonSocialBbq() {
    }

    public SalonSocialBbq(String lugar, int deposito, int numeroApto, String nombre, String correo) {
        this.lugar = lugar;
        this.deposito = deposito;
        this.numeroApto = numeroApto;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getLugar() {
        return lugar;
    }

    public int getDeposito() {
        return deposito;
    }

    public int getNumeroApto() {
        return numeroApto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setDeposito(int deposito) {
        this.deposito = deposito;
    }

    public void setNumeroApto(int numeroApto) {
        this.numeroApto = numeroApto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
}
