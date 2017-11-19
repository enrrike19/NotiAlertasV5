package pe.empresab3.notialertas.datos.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import pe.empresab3.notialertas.datos.entity.NoticiaEntity;
import pe.empresab3.notialertas.dominio.model.Noticia;

/**
 * Created by Enrique on 17/11/2017.
 */

public class NoticiaEntityDataMapper {

    public Noticia transformar(NoticiaEntity noticiaEntity) {
        Noticia noticia = new Noticia();
        noticia.setTitulo(noticiaEntity.getTitulo());
        noticia.setDetalle(noticiaEntity.getDetalle());
        noticia.setEstado(noticiaEntity.getEstado());
        return noticia;
    }

    public NoticiaEntity transformar(Noticia noticiaEntity) {
        NoticiaEntity noticia = new NoticiaEntity();
        noticia.setTitulo(noticiaEntity.getTitulo());
        noticia.setDetalle(noticiaEntity.getDetalle());
        noticia.setEstado(noticiaEntity.getEstado());
        return noticia;
    }

    public List<Noticia> transformar(List<NoticiaEntity> noticiaEntityList) {
        List<Noticia> noticiaModelList = new ArrayList<>();
        for (NoticiaEntity noticiaEntity : noticiaEntityList) {
            Noticia noticia = transformar(noticiaEntity);
            noticiaModelList.add(noticia);
        }
        return noticiaModelList;
    }
}
