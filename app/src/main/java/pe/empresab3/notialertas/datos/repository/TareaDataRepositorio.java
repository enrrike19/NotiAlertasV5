package pe.empresab3.notialertas.datos.repository;

import java.util.List;

import pe.empresab3.notialertas.datos.entity.TareaEntity;
import pe.empresab3.notialertas.datos.entity.mapper.TareaEntityDataMapper;
import pe.empresab3.notialertas.datos.repository.datasource.TareaDatasource;
import pe.empresab3.notialertas.datos.repository.datasource.TareaDatasourceFactory;
import pe.empresab3.notialertas.dominio.model.Tarea;
import pe.empresab3.notialertas.dominio.repository.TareaRepositorio;

/**
 * Created by Enrique on 18/11/2017.
 */

public class TareaDataRepositorio implements TareaRepositorio {

    private final TareaDatasourceFactory tareaDatasourceFactory;
    private final TareaEntityDataMapper tareaEntityDataMapper;

    public TareaDataRepositorio(TareaDatasourceFactory tareaDatasourceFactory,
                                  TareaEntityDataMapper tareaEntityDataMapper) {
        this.tareaDatasourceFactory = tareaDatasourceFactory;
        this.tareaEntityDataMapper = tareaEntityDataMapper;
    }

    @Override
    public List<Tarea> listarTareas(boolean forzarRed) throws Exception {
        final TareaDatasource tareaDatasource = tareaDatasourceFactory
                .crear(forzarRed);
        List<TareaEntity> tareaEntityList = tareaDatasource.listarTareas();
        return tareaEntityDataMapper.transformar(tareaEntityList);
    }

    @Override
    public Tarea crearTarea(Tarea tarea) throws Exception {
        final TareaDatasource tareaDatasource = tareaDatasourceFactory
                .crearNetworkDatasource();
        TareaEntity tareaEntity = tareaDatasource.crearTarea(
                tareaEntityDataMapper.transformar(tarea));
        return tareaEntityDataMapper.transformar(tareaEntity);
    }

    @Override
    public Tarea modificarTarea(Tarea tarea) throws Exception {
        final TareaDatasource tareaDatasource = tareaDatasourceFactory
                .crearNetworkDatasource();
        TareaEntity tareaEntity = tareaDatasource.modificarTarea(
                tareaEntityDataMapper.transformar(tarea));
        return tareaEntityDataMapper.transformar(tareaEntity);
    }
}
