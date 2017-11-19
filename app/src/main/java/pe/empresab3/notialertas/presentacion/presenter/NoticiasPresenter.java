package pe.empresab3.notialertas.presentacion.presenter;

import android.util.Log;

import java.util.List;

import pe.empresab3.notialertas.datos.entity.mapper.NoticiaEntityDataMapper;
import pe.empresab3.notialertas.datos.repository.NoticiaDataRepositorio;
import pe.empresab3.notialertas.datos.repository.datasource.NoticiaDatasourceFactory;
import pe.empresab3.notialertas.dominio.executor.JobExecutor;
import pe.empresab3.notialertas.dominio.executor.UIThread;
import pe.empresab3.notialertas.dominio.model.Noticia;
import pe.empresab3.notialertas.dominio.negocio.ListarNoticias;
import pe.empresab3.notialertas.dominio.negocio.NegocioBase;
import pe.empresab3.notialertas.dominio.repository.NoticiaRepositorio;
import pe.empresab3.notialertas.presentacion.model.mapper.NoticiaModelDataMapper;
import pe.empresab3.notialertas.presentacion.NetworkUtils;
import pe.empresab3.notialertas.presentacion.view.NoticiasView;

/**
 * Created by Enrique on 18/11/2017.
 */

public class NoticiasPresenter extends BasePresenter<NoticiasView> {

    private static final String TAG = "NoticiasPresenter";

    private final ListarNoticias listarNoticias;
    private final NoticiaModelDataMapper noticiaModelDataMapper;

    public NoticiasPresenter(NoticiasView view) {
        super(view);

        this.noticiaModelDataMapper = new NoticiaModelDataMapper();

        NoticiaRepositorio noticiaRepositorio = new NoticiaDataRepositorio(
                new NoticiaDatasourceFactory(view.context()),
                new NoticiaEntityDataMapper()
        );

        this.listarNoticias = new ListarNoticias(
                new JobExecutor(),
                new UIThread(),
                noticiaRepositorio
        );
    }

    public void cargarNoticias() {
        view.mostrarLoading();

        this.listarNoticias.setParam(NetworkUtils.hayInternet(view.context()));
        this.listarNoticias.ejecutar(new NegocioBase.Callback<List<Noticia>>() {
            @Override
            public void onSuccess(List<Noticia> response) {
                view.ocultarLoading();
                view.mostrarNoticias(noticiaModelDataMapper.transformar(response));
            }

            @Override
            public void onError(Throwable t) {
                Log.e(TAG, "onError: ", t);
                view.ocultarLoading();
            }
        });
    }
}
