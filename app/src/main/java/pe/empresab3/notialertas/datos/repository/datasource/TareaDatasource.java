package pe.empresab3.notialertas.datos.repository.datasource;

import java.util.List;

import pe.empresab3.notialertas.datos.entity.TareaEntity;

/**
 * Created by Android on 18/11/2017.
 */

public interface TareaDatasource {

    List<TareaEntity> listarTareas() throws Exception;

    TareaEntity crearTarea(TareaEntity tareaEntity) throws Exception;

    TareaEntity modificarTarea(TareaEntity tareaEntity) throws Exception;
}
