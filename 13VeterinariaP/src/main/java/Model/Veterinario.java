/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 */
public class Veterinario {

    private int cedula = -1;
    private String especialidad;
    private String nombre;
    private String correo;
    private String telefono;
    private String contraseña;

    public Veterinario() {

    }

    public Veterinario(int cedula, String especialidad, String nombre, String correo, String telefono, String contraseña) {
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }

    public Veterinario(String especialidad, String nombre, String correo, String telefono) {
        this.especialidad = especialidad;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }
     public Veterinario( String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}