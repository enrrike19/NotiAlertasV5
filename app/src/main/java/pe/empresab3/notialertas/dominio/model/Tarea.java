package pe.empresab3.notialertas.dominio.model;

/**
 * Created by Enrique on 17/11/2017.
 */

public class Tarea {

    private String titulo;
    private String detalle;
    private String estado;

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
}
