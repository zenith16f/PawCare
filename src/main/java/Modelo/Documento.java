/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Zenith
 */
public class Documento extends BDObject{
    
    private int idMascota;
    private String nombre;
    private String descripcion;
    private Byte[] archivo;
    
    public Documento(){
        
    }

    public Documento(int idMascota, String nombre, String descripcion, Byte[] archivo) {
        super();
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo = archivo;
    }

    public Documento(int idMascota, String nombre, String descripcion, Byte[] archivo, int id) {
        super(id);
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo = archivo;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(Byte[] archivo) {
        this.archivo = archivo;
    }
    
    

}
