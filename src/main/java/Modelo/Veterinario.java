/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Zenith
 */
public class Veterinario extends Persona {

    private String cedula;

    public Veterinario() {

    }

    public Veterinario(String cedula, int id, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String email) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, telefono, email);
        this.cedula = cedula;
    }

    public Veterinario(String cedula, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String email) {
        super(nombre, apellidoPaterno, apellidoMaterno, telefono, email);
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
