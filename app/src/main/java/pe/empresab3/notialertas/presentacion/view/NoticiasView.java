package pe.empresab3.notialertas.presentacion.view;

import java.util.List;

import pe.empresab3.notialertas.presentacion.model.NoticiaModel;

/**
 * Created by Enrique on 18/11/2017.
 */

public interface NoticiasView  extends LoadingView {

    void mostrarNoticias(List<NoticiaModel> noticiaModels);

    void verDetalle(NoticiaModel noticiaModel);

    void agregarNoticia();
}
