package pe.empresab3.notialertas.datos.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import pe.empresab3.notialertas.datos.entity.TareaEntity;
import pe.empresab3.notialertas.dominio.model.Tarea;

/**
 * Created by Enrique on 17/11/2017.
 */

public class TareaEntityDataMapper {

    public Tarea transformar(TareaEntity tareaEntity) {
        Tarea tarea = new Tarea();
        tarea.setId(tareaEntity.getId());
        tarea.setTitulo(tareaEntity.getTitulo());
        tarea.setDetalle(tareaEntity.getDetalle());
        tarea.setEstado(tareaEntity.getEstado());
        tarea.setFechEnvio(tareaEntity.getFechEnvio());
        return tarea;
    }

    public TareaEntity transformar(Tarea tareaEntity) {
        TareaEntity tarea = new TareaEntity();
        tarea.setId(tareaEntity.getId());
        tarea.setTitulo(tareaEntity.getTitulo());
        tarea.setDetalle(tareaEntity.getDetalle());
        tarea.setEstado(tareaEntity.getEstado());
        tarea.setFechEnvio(tareaEntity.getFechEnvio());
        return tarea;
    }

    public List<Tarea> transformar(List<TareaEntity> tareaEntityList) {
        List<Tarea> tareaModelList = new ArrayList<>();
        for (TareaEntity tareaEntity : tareaEntityList) {
            Tarea tarea = transformar(tareaEntity);
            tareaModelList.add(tarea);
        }
        return tareaModelList;
    }
}
