package pe.empresab3.notialertas.datos.repository.datasource;

import android.content.Context;

import pe.empresab3.notialertas.datos.database.TareaCache;
import pe.empresab3.notialertas.datos.database.TareaCacheImpl;
import pe.empresab3.notialertas.datos.network.RestApi;
import pe.empresab3.notialertas.datos.network.RestApiImpl;

/**
 * Created by Android on 18/11/2017.
 */

public class TareaDatasourceFactory {

    private final Context context;

    public TareaDatasourceFactory(Context context) {
        this.context = context;
    }

    public TareaDatasource crearNetworkDatasource() {
        RestApi restApi = new RestApiImpl(context);
        TareaCache tareaCache = new TareaCacheImpl();
        return new NetworkTareaDatasource(restApi, tareaCache);
    }

    public TareaDatasource crearDiskDatasource() {
        TareaCache tareaCache = new TareaCacheImpl();
        return new DiskTareaDatasource(tareaCache);
    }

    public TareaDatasource crear(boolean forzarRed) {
        return forzarRed ? crearNetworkDatasource() : crearDiskDatasource();
    }
}
