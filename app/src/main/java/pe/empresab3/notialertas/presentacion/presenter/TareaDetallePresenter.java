package pe.empresab3.notialertas.presentacion.presenter;

import android.util.Log;

import pe.empresab3.notialertas.datos.entity.mapper.TareaEntityDataMapper;
import pe.empresab3.notialertas.datos.repository.TareaDataRepositorio;
import pe.empresab3.notialertas.datos.repository.datasource.TareaDatasourceFactory;
import pe.empresab3.notialertas.dominio.executor.JobExecutor;
import pe.empresab3.notialertas.dominio.executor.UIThread;
import pe.empresab3.notialertas.dominio.model.Tarea;
import pe.empresab3.notialertas.dominio.negocio.GuardarTarea;
import pe.empresab3.notialertas.dominio.negocio.NegocioBase;
import pe.empresab3.notialertas.dominio.repository.TareaRepositorio;
import pe.empresab3.notialertas.presentacion.model.TareaModel;
import pe.empresab3.notialertas.presentacion.model.mapper.TareaModelDataMapper;
import pe.empresab3.notialertas.presentacion.view.TareaDetalleView;

/**
 * Created by Enrique on 18/11/2017.
 */

public class TareaDetallePresenter extends BasePresenter<TareaDetalleView> {

    private static final String TAG = "TareaDetallePresenter";

    private final GuardarTarea guardarTarea;
    private final TareaModelDataMapper tareaModelDataMapper;

    public TareaDetallePresenter(TareaDetalleView view) {
        super(view);

        this.tareaModelDataMapper = new TareaModelDataMapper();

        TareaRepositorio tareaRepositorio = new TareaDataRepositorio(
                new TareaDatasourceFactory(view.context()),
                new TareaEntityDataMapper()
        );

        this.guardarTarea = new GuardarTarea(
                new JobExecutor(),
                new UIThread(),
                tareaRepositorio
        );
    }

    public void guardarTarea(TareaModel tareaModel) {
        view.mostrarLoading();

        this.guardarTarea.setParams(tareaModelDataMapper.transformar(tareaModel));

        this.guardarTarea.ejecutar(new NegocioBase.Callback<Tarea>() {
            @Override
            public void onSuccess(Tarea response) {
                view.ocultarLoading();
                view.notificarTareaGuardada();
            }

            @Override
            public void onError(Throwable t) {
                view.ocultarLoading();
                Log.e(TAG, "onError: ", t);
            }
        });
    }
}
