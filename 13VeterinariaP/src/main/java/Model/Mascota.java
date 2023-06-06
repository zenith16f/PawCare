/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author alumno
 */
public class Mascota extends BDObject {
    // Data table

    private String nombre;
    private String sexo;
    private Timestamp nacimiento;
    private String pelaje;
    private String senasParticulares;

    // FK ID's
    private int idPropietario;
    private int idRaza;
    private int idEspecie;

    // Especie catalog
    private String tipoEspecie;

    // Raza catalog
    private String tipoRaza;

    public Mascota() {

    }

    public Mascota(String nombre, String sexo, Timestamp nacimiento, String pelaje, String senasParticulares, int idPropietario, int idRaza, int idEspecie) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.pelaje = pelaje;
        this.senasParticulares = senasParticulares;
        this.idPropietario = idPropietario;
        this.idRaza = idRaza;
        this.idEspecie = idEspecie;
    }

    public Mascota(int id, String nombre, String sexo, Timestamp nacimiento, String pelaje, String senasParticulares, int idPropietario, int idRaza, int idEspecie) {
        super(id);
        this.nombre = nombre;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.pelaje = pelaje;
        this.senasParticulares = senasParticulares;
        this.idPropietario = idPropietario;
        this.idRaza = idRaza;
        this.idEspecie = idEspecie;
    }

    public Mascota(int id, String nombre, String sexo, Timestamp nacimiento, String pelaje, String senasParticulares, int idPropietario, int idRaza, int idEspecie, String tipoEspecie, String tipoRaza) {
        super(id);
        this.nombre = nombre;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.pelaje = pelaje;
        this.senasParticulares = senasParticulares;
        this.idPropietario = idPropietario;
        this.idRaza = idRaza;
        this.idEspecie = idEspecie;
        this.tipoEspecie = tipoEspecie;
        this.tipoRaza = tipoRaza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Timestamp getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Timestamp nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getPelaje() {
        return pelaje;
    }

    public void setPelaje(String pelaje) {
        this.pelaje = pelaje;
    }

    public String getSenasParticulares() {
        return senasParticulares;
    }

    public void setSenasParticulares(String senasParticulaes) {
        this.senasParticulares = senasParticulaes;
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

    public int getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getTipoEspecie() {
        return tipoEspecie;
    }

    public void setTipoEspecie(String tipoEspecie) {
        this.tipoEspecie = tipoEspecie;
    }

    public String getTipoRaza() {
        return tipoRaza;
    }

    public void setTipoRaza(String tipoRaza) {
        this.tipoRaza = tipoRaza;
    }

}
