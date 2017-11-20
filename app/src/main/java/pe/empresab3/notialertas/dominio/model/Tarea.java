package pe.empresab3.notialertas.dominio.model;

import java.util.Date;

/**
 * Created by Enrique on 17/11/2017.
 */

public class Tarea {

    private String titulo;
    private String detalle;
    private String estado;
    private Date fechEnvio;
    private Integer statusEnvio;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechEnvio() {
        return fechEnvio;
    }

    public void setFechEnvio(Date fechEnvio) {
        this.fechEnvio = fechEnvio;
    }

    public Integer getStatusEnvio() {
        return statusEnvio;
    }

    public void setStatusEnvio(Integer statusEnvio) {
        this.statusEnvio = statusEnvio;
    }
}
