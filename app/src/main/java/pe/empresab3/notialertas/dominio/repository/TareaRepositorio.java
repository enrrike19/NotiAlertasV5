package pe.empresab3.notialertas.dominio.repository;

import java.util.List;

import pe.empresab3.notialertas.dominio.model.Tarea;


/**
 * Created by Enrique on 17/11/2017.
 */

public interface TareaRepositorio {

    List<Tarea> listarTareas(boolean forzarRed) throws Exception;

    Tarea crearTarea(Tarea tarea) throws Exception;

    Tarea modificarTarea(Tarea tarea) throws Exception;


}
