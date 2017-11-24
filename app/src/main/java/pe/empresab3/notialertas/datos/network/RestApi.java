package pe.empresab3.notialertas.datos.network;

import java.util.List;

import pe.empresab3.notialertas.datos.entity.TareaEntity;

/**
 * Created by Android on 18/11/2017.
 */

public interface RestApi {

    List<TareaEntity> listarTareas() throws Exception;

    TareaEntity guardarTarea(TareaEntity tareaEntity) throws Exception;

    TareaEntity modificarTarea(TareaEntity tareaEntity) throws Exception;
}
