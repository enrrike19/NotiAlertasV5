package pe.empresab3.notialertas.datos.repository.datasource;

import java.util.List;

import pe.empresab3.notialertas.datos.database.TareaCache;
import pe.empresab3.notialertas.datos.entity.TareaEntity;
import pe.empresab3.notialertas.datos.network.RestApi;

/**
 * Created by Android on 18/11/2017.
 */

public class NetworkTareaDatasource implements TareaDatasource {

    private final RestApi restApi;
    private final TareaCache tareaCache;

    public NetworkTareaDatasource(RestApi restApi, TareaCache tareaCache) {
        this.restApi = restApi;
        this.tareaCache = tareaCache;
    }

    @Override
    public List<TareaEntity> listarTareas() throws Exception {
        List<TareaEntity> tareaEntityList = restApi.listarTareas();
        tareaCache.guardar(tareaEntityList);
        return tareaEntityList;
    }

    @Override
    public TareaEntity crearTarea(TareaEntity tareaEntity) throws Exception {
        return restApi.guardarTarea(tareaEntity);
    }
}
