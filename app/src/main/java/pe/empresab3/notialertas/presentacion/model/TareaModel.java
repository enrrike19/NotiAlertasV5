package pe.empresab3.notialertas.presentacion.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Enrique on 18/11/2017.
 */

public class TareaModel implements Parcelable {

    private String titulo;
    private String estado;
    private String detalle;
    private Date fechEnvio;


    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {  this.titulo = titulo;}

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


    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titulo);
        dest.writeString(this.detalle);
        dest.writeString(this.estado);
    }

    public TareaModel() {
    }

    protected TareaModel(Parcel in) {
        this.titulo = in.readString();
        this.estado = in.readString();
        this.detalle = in.readString();
    }

    public static final Creator<TareaModel> CREATOR = new Creator<TareaModel>() {
        @Override
        public TareaModel createFromParcel(Parcel source) {
            return new TareaModel(source);
        }

        @Override
        public TareaModel[] newArray(int size) {
            return new TareaModel[size];
        }
    };
}