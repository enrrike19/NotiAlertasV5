package pe.empresab3.notialertas.dominio.model;

import java.util.Date;

/**
 * Created by Enrique on 17/11/2017.
 */

public class Tarea {

    private String id;
    private String titulo;
    private String detalle;
    private String estado;
    private String fechEnvio;
    private Integer statusEnvio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getFechEnvio() {
        return fechEnvio;
    }

    public void setFechEnvio(String fechEnvio) {
        this.fechEnvio = fechEnvio;
    }

    public Integer getStatusEnvio() {
        return statusEnvio;
    }

    public void setStatusEnvio(Integer statusEnvio) {
        this.statusEnvio = statusEnvio;
    }
}
