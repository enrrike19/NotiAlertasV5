package pe.empresab3.notialertas.dominio.negocio;

import java.util.List;

import pe.empresab3.notialertas.dominio.executor.PostExecutionThread;
import pe.empresab3.notialertas.dominio.executor.ThreadExecutor;
import pe.empresab3.notialertas.dominio.model.Noticia;
import pe.empresab3.notialertas.dominio.repository.NoticiaRepositorio;

/**
 * Created by Enrique on 18/11/2017.
 */

public class ListarNoticias extends NegocioBase<List<Noticia>> {

    private final NoticiaRepositorio noticiaRepositorio;
    private boolean forzarRed;

    public ListarNoticias(ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread,
                          NoticiaRepositorio noticiaRepositorio) {
        super(threadExecutor, postExecutionThread);
        this.noticiaRepositorio = noticiaRepositorio;
    }

    public void setParam(boolean forzarRed) {
        this.forzarRed = forzarRed;
    }

    @Override
    protected void construirNegocio() {
        try {
            List<Noticia> noticiaList = this.noticiaRepositorio.listarNoticias(forzarRed);
            notificarUseCaseSatisfactorio(noticiaList);
        } catch (Exception e) {
            notificarUseCaseError(e);
        }
//        List<Noticia> noticiaList = new ArrayList<>();
//        for (int i=0; i < 10; i++) {
//            Noticia noticia = new Noticia();
//            noticia.setTitulo("Noticia " + i);
//            noticiaList.add(noticia);
//        }
//        notificarUseCaseSatisfactorio(noticiaList);
    }
}
