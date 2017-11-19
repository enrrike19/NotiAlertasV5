package pe.empresab3.notialertas.presentacion.model.mapper;

import java.util.ArrayList;
import java.util.List;

import pe.empresab3.notialertas.dominio.model.Tarea;
import pe.empresab3.notialertas.presentacion.model.TareaModel;

/**
 * Created by Enrique on 18/11/2017.
 */

public class TareaModelDataMapper {

    public TareaModel transformar(Tarea tarea) {
        TareaModel tareaModel = new TareaModel();
        tareaModel.setTitulo(tarea.getTitulo());
        tareaModel.setDetalle(tarea.getDetalle());
        tareaModel.setEstado(tarea.getEstado());
        return tareaModel;
    }

    public Tarea transformar(TareaModel tarea) {
        Tarea tareaModel = new Tarea();
        tareaModel.setTitulo(tarea.getTitulo());
        tareaModel.setDetalle(tarea.getDetalle());
        tareaModel.setEstado(tarea.getEstado());
        return tareaModel;
    }

    public List<TareaModel> transformar(List<Tarea> tareaList) {
        List<TareaModel> tareaModelList = new ArrayList<>();
        for (Tarea tarea : tareaList) {
            TareaModel tareaModel = transformar(tarea);
            tareaModelList.add(tareaModel);
        }
        return tareaModelList;
    }
}
