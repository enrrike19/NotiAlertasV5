package pe.empresab3.notialertas.datos.database;

import java.util.List;

import pe.empresab3.notialertas.datos.entity.NoticiaEntity;

/**
 * Created by Enrique on 17/11/2017.
 */

public interface NoticiaCache {

    List<NoticiaEntity> listar();

    void guardar(List<NoticiaEntity> noticiaEntityList);

    void limpiar();
}
