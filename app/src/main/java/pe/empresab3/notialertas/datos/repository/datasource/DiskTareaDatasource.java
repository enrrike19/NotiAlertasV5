package pe.empresab3.notialertas.datos.repository.datasource;

import java.util.List;
import pe.empresab3.notialertas.datos.database.TareaCache;
import pe.empresab3.notialertas.datos.entity.TareaEntity;

/**
 * Created by Android on 18/11/2017.
 */

public class DiskTareaDatasource implements TareaDatasource {

    private final TareaCache tareaCache;

    public DiskTareaDatasource(TareaCache tareaCache) {
        this.tareaCache = tareaCache;
    }

    @Override
    public List<TareaEntity> listarTareas() throws Exception {
        return tareaCache.listar();
    }

    @Override
    public TareaEntity crearTarea(TareaEntity tareaEntity) throws Exception {
        throw new UnsupportedOperationException("Operacion no valida");
    }

    @Override
    public TareaEntity modificarTarea(TareaEntity tareaEntity) throws Exception {
        throw new UnsupportedOperationException("Operacion no valida");
    }
}
