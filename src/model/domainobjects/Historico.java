package model.domainobjects;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Historico implements Serializable, SistemaSGTE{
    private String codEstacion;
    private String codNave;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private String codDescargado; // Código del cargamento descargado (si es que lo hay).
    private String codCargado; // "" "" cargado "" ""
    private String razon;

    public Historico(String codEstacion, String codNave, LocalDateTime horaEntrada, LocalDateTime horaSalida, String codDescargado, String codCargado, String razon) {
        this.codEstacion = codEstacion;
        this.codNave = codNave;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.codDescargado = codDescargado;
        this.codCargado = codCargado;
        this.razon = razon;
    }

    public String toString(){
        return codEstacion + "\t" +
            codNave + "\t" +
            horaEntrada + "\t" +
            horaSalida + "\t" +
            codDescargado + "\t" +
            codCargado + "\t" +
            razon;
    }

    public String getCodEstacion() {
        return this.codEstacion;
    }

    public void setCodEstacion(String codEstacion) {
        this.codEstacion = codEstacion;
    }

    public String getCodNave() {
        return this.codNave;
    }

    public void setCodNave(String codNave) {
        this.codNave = codNave;
    }

    public LocalDateTime getHoraEntrada() {
        return this.horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return this.horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getCodDescargado() {
        return this.codDescargado;
    }

    public void setCodDescargado(String codDescargado) {
        this.codDescargado = codDescargado;
    }

    public String getCodCargado() {
        return this.codCargado;
    }

    public void setCodCargado(String codCargado) {
        this.codCargado = codCargado;
    }

    public String getRazon() {
        return this.razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
}
