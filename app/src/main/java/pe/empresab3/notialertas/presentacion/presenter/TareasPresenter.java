package pe.empresab3.notialertas.presentacion.presenter;

import android.util.Log;

import java.util.List;

import pe.empresab3.notialertas.datos.entity.mapper.TareaEntityDataMapper;
import pe.empresab3.notialertas.datos.repository.TareaDataRepositorio;
import pe.empresab3.notialertas.datos.repository.datasource.TareaDatasourceFactory;
import pe.empresab3.notialertas.dominio.executor.JobExecutor;
import pe.empresab3.notialertas.dominio.executor.UIThread;
import pe.empresab3.notialertas.dominio.model.Tarea;
import pe.empresab3.notialertas.dominio.negocio.ListarTareas;
import pe.empresab3.notialertas.dominio.negocio.NegocioBase;
import pe.empresab3.notialertas.dominio.repository.TareaRepositorio;
import pe.empresab3.notialertas.presentacion.NetworkUtils;
import pe.empresab3.notialertas.presentacion.model.mapper.TareaModelDataMapper;
import pe.empresab3.notialertas.presentacion.view.TareasView;

/**
 * Created by Enrique on 18/11/2017.
 */

public class TareasPresenter extends BasePresenter<TareasView> {

    private static final String TAG = "TareasPresenter";

    private final ListarTareas listartareas;
    private final TareaModelDataMapper tareaModelDataMapper;

    public TareasPresenter(TareasView view) {
        super(view);

        this.tareaModelDataMapper = new TareaModelDataMapper();

        TareaRepositorio tareaRepositorio = new TareaDataRepositorio(
                new TareaDatasourceFactory(view.context()),
                new TareaEntityDataMapper()
        );

        this.listartareas = new ListarTareas(
                new JobExecutor(),
                new UIThread(),
                tareaRepositorio
        );
    }

    public void cargarNoticias() {
        view.mostrarLoading();

        this.listartareas.setParam(NetworkUtils.hayInternet(view.context()));
        this.listartareas.ejecutar(new NegocioBase.Callback<List<Tarea>>() {
            @Override
            public void onSuccess(List<Tarea> response) {
                view.ocultarLoading();
                view.mostrarTareas(tareaModelDataMapper.transformar(response));
            }

            @Override
            public void onError(Throwable t) {
                Log.e(TAG, "onError: ", t);
                view.ocultarLoading();
            }
        });
    }
}
