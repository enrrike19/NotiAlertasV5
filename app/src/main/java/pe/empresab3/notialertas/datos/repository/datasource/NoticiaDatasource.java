package pe.empresab3.notialertas.datos.repository.datasource;

import java.util.List;

import pe.empresab3.notialertas.datos.entity.NoticiaEntity;

/**
 * Created by Android on 18/11/2017.
 */

public interface NoticiaDatasource {

    List<NoticiaEntity> listarNoticias() throws Exception;

    NoticiaEntity crearNoticia(NoticiaEntity noticiaEntity) throws Exception;
}
