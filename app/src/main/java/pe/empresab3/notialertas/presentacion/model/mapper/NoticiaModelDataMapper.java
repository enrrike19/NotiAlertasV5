package pe.empresab3.notialertas.presentacion.model.mapper;

import java.util.ArrayList;
import java.util.List;

import pe.empresab3.notialertas.dominio.model.Noticia;
import pe.empresab3.notialertas.presentacion.model.NoticiaModel;

/**
 * Created by Enrique on 18/11/2017.
 */

public class NoticiaModelDataMapper {

    public NoticiaModel transformar(Noticia noticia) {
        NoticiaModel noticiaModel = new NoticiaModel();
        noticiaModel.setTitulo(noticia.getTitulo());
        noticiaModel.setDetalle(noticia.getDetalle());
        noticiaModel.setEstado(noticia.getEstado());
        return noticiaModel;
    }

    public Noticia transformar(NoticiaModel noticia) {
        Noticia noticiaModel = new Noticia();
        noticiaModel.setTitulo(noticia.getTitulo());
        noticiaModel.setDetalle(noticia.getDetalle());
        noticiaModel.setEstado(noticia.getEstado());
        return noticiaModel;
    }

    public List<NoticiaModel> transformar(List<Noticia> noticiaList) {
        List<NoticiaModel> noticiaModelList = new ArrayList<>();
        for (Noticia noticia : noticiaList) {
            NoticiaModel noticiaModel = transformar(noticia);
            noticiaModelList.add(noticiaModel);
        }
        return noticiaModelList;
    }
}
