/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Timestamp;

/**
 *
 * @author Zenith
 */
public class Cita extends BDObject {

    private int idMascota;
    private int idVeterinario;
    private String descripcion;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    
    public Cita (){
        
    }

    public Cita(int idMascota, int idVeterinario, String descripcion, Timestamp fechaCreacion, Timestamp fechaModificacion) {
        super();
        this.idMascota = idMascota;
        this.idVeterinario = idVeterinario;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Cita(int idMascota, int idVeterinario, String descripcion, Timestamp fechaCreacion, Timestamp fechaModificacion, int id) {
        super(id);
        this.idMascota = idMascota;
        this.idVeterinario = idVeterinario;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

}
