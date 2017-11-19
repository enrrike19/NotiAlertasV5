package pe.empresab3.notialertas.presentacion.presenter;

import android.util.Log;

import pe.empresab3.notialertas.datos.entity.mapper.NoticiaEntityDataMapper;
import pe.empresab3.notialertas.datos.repository.NoticiaDataRepositorio;
import pe.empresab3.notialertas.datos.repository.datasource.NoticiaDatasourceFactory;
import pe.empresab3.notialertas.dominio.executor.JobExecutor;
import pe.empresab3.notialertas.dominio.executor.UIThread;
import pe.empresab3.notialertas.dominio.model.Noticia;
import pe.empresab3.notialertas.dominio.negocio.GuardarNoticia;
import pe.empresab3.notialertas.dominio.negocio.NegocioBase;
import pe.empresab3.notialertas.dominio.repository.NoticiaRepositorio;
import pe.empresab3.notialertas.presentacion.model.NoticiaModel;
import pe.empresab3.notialertas.presentacion.model.mapper.NoticiaModelDataMapper;
import pe.empresab3.notialertas.presentacion.view.NoticiaDetalleView;

/**
 * Created by Enrique on 18/11/2017.
 */

public class NoticiaDetallePresenter extends BasePresenter<NoticiaDetalleView> {

    private static final String TAG = "NoticiaDetallePresenter";

    private final GuardarNoticia guardarNoticia;
    private final NoticiaModelDataMapper noticiaModelDataMapper;

    public NoticiaDetallePresenter(NoticiaDetalleView view) {
        super(view);

        this.noticiaModelDataMapper = new NoticiaModelDataMapper();

        NoticiaRepositorio noticiaRepositorio = new NoticiaDataRepositorio(
                new NoticiaDatasourceFactory(view.context()),
                new NoticiaEntityDataMapper()
        );

        this.guardarNoticia = new GuardarNoticia(
                new JobExecutor(),
                new UIThread(),
                noticiaRepositorio
        );
    }

    public void guardarNoticia(NoticiaModel noticiaModel) {
        view.mostrarLoading();

        this.guardarNoticia.setParams(noticiaModelDataMapper.transformar(noticiaModel));

        this.guardarNoticia.ejecutar(new NegocioBase.Callback<Noticia>() {
            @Override
            public void onSuccess(Noticia response) {
                view.ocultarLoading();
                view.notificarNoticiaGuardada();
            }

            @Override
            public void onError(Throwable t) {
                view.ocultarLoading();
                Log.e(TAG, "onError: ", t);
            }
        });
    }
}
