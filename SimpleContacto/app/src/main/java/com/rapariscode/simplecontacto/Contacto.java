package com.rapariscode.simplecontacto;

/**
 * Created by root on 15/05/16.
 */
public class Contacto {

    private String nombre;

    private String telefono;
    private String email;
    private String descripcion;

    private int dia;
    private int mes;
    private int año;

    public Contacto () {
        nombre = "";
        telefono="";
        email="";
        descripcion="";
        dia = 0;
        mes = 0;
        año = 0;
    }

    public Contacto(String nombre) {
        this.nombre = nombre;
    }

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        String fecha = dia + "/" + mes + "/" + año;
        return fecha;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
