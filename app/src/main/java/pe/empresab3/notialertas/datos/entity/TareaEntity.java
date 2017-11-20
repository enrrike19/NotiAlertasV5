package pe.empresab3.notialertas.datos.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Enrique on 17/11/2017.
 */

public class TareaEntity extends RealmObject {

    @PrimaryKey
    @SerializedName("objectId")
    private String id;

    @SerializedName("titulo")
    private String titulo;

    @SerializedName("detalle")
    private String detalle;

    @SerializedName("estado")
    private String estado;

    @SerializedName("fechaHoraAlerta")
    private Date fechEnvio;

    @SerializedName("StatusSend")
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
