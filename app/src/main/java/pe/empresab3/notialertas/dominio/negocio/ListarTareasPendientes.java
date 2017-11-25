package pe.empresab3.notialertas.dominio.negocio;

import java.util.ArrayList;
import java.util.List;

import pe.empresab3.notialertas.dominio.executor.PostExecutionThread;
import pe.empresab3.notialertas.dominio.executor.ThreadExecutor;
import pe.empresab3.notialertas.dominio.model.Tarea;
import pe.empresab3.notialertas.dominio.repository.TareaRepositorio;

/**
 * Created by Enrique on 24/11/2017.
 */

public class ListarTareasPendientes extends NegocioBase<List<Tarea>> {

    private final TareaRepositorio tareaRepositorio;
    private boolean forzarRed;

    public ListarTareasPendientes(ThreadExecutor threadExecutor,
                        PostExecutionThread postExecutionThread,
                        TareaRepositorio tareaRepositorio) {
        super(threadExecutor, postExecutionThread);
        this.tareaRepositorio = tareaRepositorio;
    }

    public void setParam(boolean forzarRed) {
        this.forzarRed = forzarRed;
    }

    @Override
    protected void construirNegocio() {
        try {
            List<Tarea> tareaAll = this.tareaRepositorio.listarTareas(forzarRed);
            List<Tarea> tareasPendientes = new ArrayList<>();
            for (Tarea tarea: tareaAll  ) {
                //Solo tareas pendientes
                if(tarea.getStatusEnvio()==0) {
                    tareasPendientes.add(tarea);
                }
            }

            notificarUseCaseSatisfactorio(tareasPendientes);
        } catch (Exception e) {
            notificarUseCaseError(e);
        }
    }
}
