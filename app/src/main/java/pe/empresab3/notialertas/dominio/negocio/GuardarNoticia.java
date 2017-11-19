package pe.empresab3.notialertas.dominio.negocio;

import pe.empresab3.notialertas.dominio.executor.PostExecutionThread;
import pe.empresab3.notialertas.dominio.executor.ThreadExecutor;
import pe.empresab3.notialertas.dominio.model.Noticia;
import pe.empresab3.notialertas.dominio.repository.NoticiaRepositorio;

/**
 * Created by Enrique on 18/11/2017.
 */

public class GuardarNoticia  extends NegocioBase<Noticia> {

    private final NoticiaRepositorio noticiaRepositorio;
    private Noticia noticia;

    public GuardarNoticia(ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread,
                          NoticiaRepositorio noticiaRepositorio) {
        super(threadExecutor, postExecutionThread);
        this.noticiaRepositorio = noticiaRepositorio;
    }

    @Override
    protected void construirNegocio() {
        try {
            Noticia noticia = this.noticiaRepositorio.crearNoticia(this.noticia);
            notificarUseCaseSatisfactorio(noticia);
        } catch (Exception e) {
            notificarUseCaseError(e);
        }
    }

    public void setParams(Noticia noticia) {
        this.noticia = noticia;
    }
}