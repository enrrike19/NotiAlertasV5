package pe.empresab3.notialertas.datos.repository.datasource;

import java.util.List;
import pe.empresab3.notialertas.datos.database.NoticiaCache;
import pe.empresab3.notialertas.datos.entity.NoticiaEntity;

/**
 * Created by Android on 18/11/2017.
 */

public class DiskNoticiaDatasource implements NoticiaDatasource {

    private final NoticiaCache noticiaCache;

    public DiskNoticiaDatasource(NoticiaCache noticiaCache) {
        this.noticiaCache = noticiaCache;
    }

    @Override
    public List<NoticiaEntity> listarNoticias() throws Exception {
        return noticiaCache.listar();
    }

    @Override
    public NoticiaEntity crearNoticia(NoticiaEntity noticiaEntity) throws Exception {
        throw new UnsupportedOperationException("Operacion no valida");
    }
}
