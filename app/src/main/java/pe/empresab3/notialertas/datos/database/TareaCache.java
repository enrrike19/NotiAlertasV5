package pe.empresab3.notialertas.datos.database;

import java.util.List;

import pe.empresab3.notialertas.datos.entity.TareaEntity;

/**
 * Created by Enrique on 17/11/2017.
 */

public interface TareaCache {

    List<TareaEntity> listar();

    void guardar(List<TareaEntity> tareaEntityList);

    void limpiar();
}
