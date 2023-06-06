/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Zenith
 */
public class Cita extends BDObject {

    // Date table
    private String nota;
    private int talla;
    private Timestamp fechaCita;
    private String diagnostico;
    private int temperatura;

    // FK ID's
    private int idTipoCita;
    private int idVacuna;
    private int idVeterinario;
    private int idMascota;
    private int idExpediente;

    // Information of the "Expediente"
    private int idEstado;
    private String tipoEstado;

    // Type of Date information
    private String descripcionTipo;

    // Vacuna information
    private String vacuna;
    private String dosis;
    private int idTipoVacuna;
    private Timestamp fechaAplicacion;
    private Timestamp fechaVencimiento;
    private String descripcionVacuna;

    // Tratamiento information
    private String Tratamiento;

    // Pet name
    private String nombreMascota;
    
    // Vet name
   private String nombreVeterinario;

    public Cita() {

    }

    public Cita(String nota, int talla, Timestamp fechaCita, String diagnostico, int temperatura, String Tratamiento, int idTipoCita, int idTratamiento, int idVacuna, int idVeterinario, int idMascota, int idExpediente) {
        this.nota = nota;
        this.talla = talla;
        this.fechaCita = fechaCita;
        this.diagnostico = diagnostico;
        this.temperatura = temperatura;
        this.Tratamiento = Tratamiento;
        this.idTipoCita = idTipoCita;
        this.idVacuna = idVacuna;
        this.idVeterinario = idVeterinario;
        this.idMascota = idMascota;
        this.idExpediente = idExpediente;
    }

    public Cita(int id, String nota, int talla, Timestamp fechaCita, String diagnostico, int temperatura, int idTipoCita, String Tratamiento, int idVacuna, int idVeterinario, int idMascota, int idExpediente) {
        super(id);
        this.nota = nota;
        this.talla = talla;
        this.fechaCita = fechaCita;
        this.diagnostico = diagnostico;
        this.temperatura = temperatura;
        this.idTipoCita = idTipoCita;
        this.Tratamiento = Tratamiento;
        this.idVacuna = idVacuna;
        this.idVeterinario = idVeterinario;
        this.idMascota = idMascota;
        this.idExpediente = idExpediente;
    }

    private LocalDate parseFechaCita(String fechaCitaString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaCita = LocalDate.parse(fechaCitaString, formatter);
        return fechaCita;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public Timestamp getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Timestamp fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getIdTipoCita() {
        return idTipoCita;
    }

    public void setIdTipoCita(int idTipoCita) {
        this.idTipoCita = idTipoCita;
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public int getIdTipoVacuna() {
        return idTipoVacuna;
    }

    public void setIdTipoVacuna(int idTipoVacuna) {
        this.idTipoVacuna = idTipoVacuna;
    }

    public Timestamp getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Timestamp fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public Timestamp getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Timestamp fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getDescripcionVacuna() {
        return descripcionVacuna;
    }

    public void setDescripcionVacuna(String descripcionVacuna) {
        this.descripcionVacuna = descripcionVacuna;
    }

    public String getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(String Tratamiento) {
        this.Tratamiento = Tratamiento;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getNombreVeterinario() {
        return nombreVeterinario;
    }

    public void setNombreVeterinario(String nombreVeterinario) {
        this.nombreVeterinario = nombreVeterinario;
    }

}
