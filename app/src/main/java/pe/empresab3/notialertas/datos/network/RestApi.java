package pe.empresab3.notialertas.datos.network;

import java.util.List;

import pe.empresab3.notialertas.datos.entity.NoticiaEntity;

/**
 * Created by Android on 18/11/2017.
 */

public interface RestApi {

    List<NoticiaEntity> listarNoticias() throws Exception;

    NoticiaEntity guardarNoticia(NoticiaEntity noticiaEntity) throws Exception;
}
