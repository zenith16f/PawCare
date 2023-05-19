/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Blob;
import java.sql.Timestamp;

/**
 *
 * @author Zenith
 */
public class Mascota extends BDObject {

    private int idPropietario;
    private int idRaza;
    private Timestamp nacimiento;
    private String nombre;
    private Blob imagen;
    private int tamano;
    private int peso;
    private String sexo;

    public Mascota() {

    }

    public Mascota(int idPropietario, int idRaza, Timestamp nacimiento, String nombre, Blob imagen, int tamano, int peso, String sexo) {
        super();
        this.idPropietario = idPropietario;
        this.idRaza = idRaza;
        this.nacimiento = nacimiento;
        this.nombre = nombre;
        this.imagen = imagen;
        this.tamano = tamano;
        this.peso = peso;
        this.sexo = sexo;
    }

    public Mascota(int id, int idPropietario, int idRaza, Timestamp nacimiento, String nombre, Blob imagen, int tamano, int peso, String sexo) {
        super(id);
        this.idPropietario = idPropietario;
        this.idRaza = idRaza;
        this.nacimiento = nacimiento;
        this.nombre = nombre;
        this.imagen = imagen;
        this.tamano = tamano;
        this.peso = peso;
        this.sexo = sexo;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }

    public Timestamp getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Timestamp nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
