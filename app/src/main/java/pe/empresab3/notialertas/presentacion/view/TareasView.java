package pe.empresab3.notialertas.presentacion.view;

import java.util.List;

import pe.empresab3.notialertas.presentacion.model.TareaModel;

/**
 * Created by Enrique on 18/11/2017.
 */

public interface TareasView  extends LoadingView {

    void mostrarTareas(List<TareaModel> tareaModels);

    void verDetalle(TareaModel tareaModel);

    void agregarTarea();
}
