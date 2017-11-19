package pe.empresab3.notialertas.dominio.negocio;

import pe.empresab3.notialertas.dominio.executor.PostExecutionThread;
import pe.empresab3.notialertas.dominio.executor.ThreadExecutor;
import pe.empresab3.notialertas.dominio.model.Tarea;
import pe.empresab3.notialertas.dominio.repository.TareaRepositorio;

/**
 * Created by Enrique on 18/11/2017.
 */

public class GuardarTarea  extends NegocioBase<Tarea> {

    private final TareaRepositorio tareaRepositorio;
    private Tarea tarea;

    public GuardarTarea(ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread,
                          TareaRepositorio tareaRepositorio) {
        super(threadExecutor, postExecutionThread);
        this.tareaRepositorio = tareaRepositorio;
    }

    @Override
    protected void construirNegocio() {
        try {
            Tarea tarea = this.tareaRepositorio.crearTarea(this.tarea);
            notificarUseCaseSatisfactorio(tarea);
        } catch (Exception e) {
            notificarUseCaseError(e);
        }
    }

    public void setParams(Tarea tarea) {
        this.tarea = tarea;
    }
}