package pe.empresab3.notialertas.presentacion.view;

import pe.empresab3.notialertas.presentacion.model.NoticiaModel;

/**
 * Created by Enrique on 18/11/2017.
 */

public interface NoticiaDetalleView extends LoadingView {

    void guardarNoticia(NoticiaModel noticiaModel);

    void notificarNoticiaGuardada();
}
