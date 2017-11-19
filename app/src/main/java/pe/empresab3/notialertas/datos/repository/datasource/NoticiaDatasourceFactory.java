package pe.empresab3.notialertas.datos.repository.datasource;

import android.content.Context;

import pe.empresab3.notialertas.datos.database.NoticiaCache;
import pe.empresab3.notialertas.datos.database.NoticiaCacheImpl;
import pe.empresab3.notialertas.datos.network.RestApi;
import pe.empresab3.notialertas.datos.network.RestApiImpl;

/**
 * Created by Android on 18/11/2017.
 */

public class NoticiaDatasourceFactory {

    private final Context context;

    public NoticiaDatasourceFactory(Context context) {
        this.context = context;
    }

    public NoticiaDatasource crearNetworkDatasource() {
        RestApi restApi = new RestApiImpl(context);
        NoticiaCache noticiaCache = new NoticiaCacheImpl();
        return new NetworkNoticiaDatasource(restApi, noticiaCache);
    }

    public NoticiaDatasource crearDiskDatasource() {
        NoticiaCache noticiaCache = new NoticiaCacheImpl();
        return new DiskNoticiaDatasource(noticiaCache);
    }

    public NoticiaDatasource crear(boolean forzarRed) {
        return forzarRed ? crearNetworkDatasource() : crearDiskDatasource();
    }
}
