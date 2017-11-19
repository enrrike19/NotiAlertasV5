package pe.empresab3.notialertas.datos.repository;

import java.util.List;

import pe.empresab3.notialertas.datos.entity.NoticiaEntity;
import pe.empresab3.notialertas.datos.entity.mapper.NoticiaEntityDataMapper;
import pe.empresab3.notialertas.datos.repository.datasource.NoticiaDatasource;
import pe.empresab3.notialertas.datos.repository.datasource.NoticiaDatasourceFactory;
import pe.empresab3.notialertas.dominio.model.Noticia;
import pe.empresab3.notialertas.dominio.repository.NoticiaRepositorio;

/**
 * Created by Enrique on 18/11/2017.
 */

public class NoticiaDataRepositorio implements NoticiaRepositorio {

    private final NoticiaDatasourceFactory noticiaDatasourceFactory;
    private final NoticiaEntityDataMapper noticiaEntityDataMapper;

    public NoticiaDataRepositorio(NoticiaDatasourceFactory noticiaDatasourceFactory,
                                  NoticiaEntityDataMapper noticiaEntityDataMapper) {
        this.noticiaDatasourceFactory = noticiaDatasourceFactory;
        this.noticiaEntityDataMapper = noticiaEntityDataMapper;
    }

    @Override
    public List<Noticia> listarNoticias(boolean forzarRed) throws Exception {
        final NoticiaDatasource noticiaDatasource = noticiaDatasourceFactory
                .crear(forzarRed);
        List<NoticiaEntity> noticiaEntityList = noticiaDatasource.listarNoticias();
        return noticiaEntityDataMapper.transformar(noticiaEntityList);
    }

    @Override
    public Noticia crearNoticia(Noticia noticia) throws Exception {
        final NoticiaDatasource noticiaDatasource = noticiaDatasourceFactory
                .crearNetworkDatasource();
        NoticiaEntity noticiaEntity = noticiaDatasource.crearNoticia(
                noticiaEntityDataMapper.transformar(noticia));
        return noticiaEntityDataMapper.transformar(noticiaEntity);
    }

    @Override
    public Noticia actualizarNoticia(Noticia noticia) throws Exception {
        return null;
    }
}
