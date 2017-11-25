package pe.empresab3.notialertas.presentacion.view;

import pe.empresab3.notialertas.presentacion.model.TareaModel;

/**
 * Created by Enrique on 18/11/2017.
 */

public interface TareaDetalleView extends LoadingView {

    void guardarTarea(TareaModel tareaModel);

    void notificarTareaGuardada();


}
