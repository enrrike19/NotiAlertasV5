package pe.empresab3.notialertas.dominio.negocio;

import pe.empresab3.notialertas.dominio.executor.PostExecutionThread;
import pe.empresab3.notialertas.dominio.executor.ThreadExecutor;

/**
 * Created by Enrique on 18/11/2017.
 */

public abstract class NegocioBase<T> {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private Callback<T> callback;


    protected NegocioBase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    protected void notificarUseCaseSatisfactorio(final T response) {
        postExecutionThread.execute(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onSuccess(response);
                }
            }
        });
    }

    protected void notificarUseCaseError(final Throwable t) {
        postExecutionThread.execute(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onError(t);
                }
            }
        });
    }

    public void ejecutar(final Callback<T> callback) {
        this.callback = callback;
        threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                construirNegocio();
            }
        });
    }

    protected abstract void construirNegocio();

    public interface Callback<T> {
        void onSuccess(T response);

        void onError(Throwable t);
    }
}

