package pe.empresab3.notialertas.dominio.negocio;

import java.util.List;

import pe.empresab3.notialertas.dominio.executor.PostExecutionThread;
import pe.empresab3.notialertas.dominio.executor.ThreadExecutor;
import pe.empresab3.notialertas.dominio.model.Tarea;
import pe.empresab3.notialertas.dominio.repository.TareaRepositorio;

/**
 * Created by Enrique on 18/11/2017.
 */

public class ListarTareas extends NegocioBase<List<Tarea>> {

    private final TareaRepositorio tareaRepositorio;
    private boolean forzarRed;

    public ListarTareas(ThreadExecutor threadExecutor,
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
            List<Tarea> tareaList = this.tareaRepositorio.listarTareas(forzarRed);
            notificarUseCaseSatisfactorio(tareaList);
        } catch (Exception e) {
            notificarUseCaseError(e);
        }
    }
}
