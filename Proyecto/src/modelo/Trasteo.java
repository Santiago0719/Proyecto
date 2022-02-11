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
public class Trasteo {
    private int numeroApto;
    private String tipoMaterial;
    private Date fecha;
    private String  hora;
    private String nombre;
    private String correo;

    public Trasteo() {
    }

    public Trasteo(int numeroApto, String tipoMaterial, Date fecha, String hora, String nombre, String correo) {
        this.numeroApto = numeroApto;
        this.tipoMaterial = tipoMaterial;
        this.fecha = fecha;
        this.hora = hora;
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getNumeroApto() {
        return numeroApto;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNumeroApto(int numeroApto) {
        this.numeroApto = numeroApto;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
