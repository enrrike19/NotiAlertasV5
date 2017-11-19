package pe.empresab3.notialertas.dominio.executor;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

/**
 * Created by Enrique on 17/11/2017.
 */

public class UIThread implements  PostExecutionThread {

    private Handler uiHandler = new Handler(Looper.getMainLooper());

    @Override
    public void execute(@NonNull Runnable command) {
        uiHandler.post(command);
    }
}
