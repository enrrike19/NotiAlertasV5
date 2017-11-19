package pe.empresab3.notialertas.datos.repository.datasource;

import java.util.List;

import pe.empresab3.notialertas.datos.database.NoticiaCache;
import pe.empresab3.notialertas.datos.entity.NoticiaEntity;
import pe.empresab3.notialertas.datos.network.RestApi;

/**
 * Created by Android on 18/11/2017.
 */

public class NetworkNoticiaDatasource implements NoticiaDatasource {

    private final RestApi restApi;
    private final NoticiaCache noticiaCache;

    public NetworkNoticiaDatasource(RestApi restApi, NoticiaCache noticiaCache) {
        this.restApi = restApi;
        this.noticiaCache = noticiaCache;
    }

    @Override
    public List<NoticiaEntity> listarNoticias() throws Exception {
        List<NoticiaEntity> noticiaEntityList = restApi.listarNoticias();
        noticiaCache.guardar(noticiaEntityList);
        return noticiaEntityList;
    }

    @Override
    public NoticiaEntity crearNoticia(NoticiaEntity noticiaEntity) throws Exception {
        return restApi.guardarNoticia(noticiaEntity);
    }
}
