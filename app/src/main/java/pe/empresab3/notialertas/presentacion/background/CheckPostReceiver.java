package pe.empresab3.notialertas.presentacion.background;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.NotificationManagerCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import pe.empresab3.notialertas.datos.entity.TareaEntity;
import pe.empresab3.notialertas.datos.network.RestApi;
import pe.empresab3.notialertas.datos.network.RestApiImpl;
import pe.empresab3.notialertas.presentacion.notification.NotificacionAlerta;
import pe.empresab3.notialertas.presentacion.presenter.TareasPresenter;

/**
 * Created by Harold on 25/11/2017.
 */

public class CheckPostReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        new MyNotificationTask(context).execute();
    }
}

class MyNotificationTask extends AsyncTask<String, Void, String> {

    RestApi restApi;
    private TareasPresenter tareasPresenter;
    private Context privatecontext;


    public MyNotificationTask(Context context) {
        restApi = new RestApiImpl(context);
        privatecontext = context;
    }

    @Override
    protected String doInBackground(String... params) {
        String exito = "0";
        String fechaProgramada;
        String horaProgramada;
        Calendar myCalendar;
        String formatoFecha = "dd/MM/yyyy";
        SimpleDateFormat sdfFecha;
        String formatoHora = "hh:mm a";
        SimpleDateFormat sdfHora;
        String fechaActual;
        String horaActual;
        myCalendar = Calendar.getInstance();
        sdfFecha = new SimpleDateFormat(formatoFecha, Locale.US);
        sdfHora = new SimpleDateFormat(formatoHora, Locale.US);
        fechaActual = sdfFecha.format(myCalendar.getTime()).toString();
        horaActual = sdfHora.format(myCalendar.getTime()).toString();
        NotificacionAlerta notificacionAlerta = new NotificacionAlerta();

        try {
            List<TareaEntity> listTareasPendientes = restApi.listarTareas();
            for(TareaEntity tarea : listTareasPendientes) {
                if (tarea.getStatusEnvio() == 0) {
                    fechaProgramada = tarea.getFechEnvio().substring(0, 10);
                    horaProgramada = tarea.getFechEnvio().substring(11);
                    if (fechaProgramada.equals(fechaActual) && horaProgramada.equals(horaActual)) {
                        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(privatecontext);
                        notificationManager.notify(1, notificacionAlerta.TareaProgramada(privatecontext,tarea.getTitulo(),tarea.getDetalle()));

                        //actualizar el status a enviado
                        tarea.setStatusEnvio(1);
                        restApi.modificarTarea(tarea);
                    }
                }
            }
            return exito;
        } catch (Exception e) {
            e.printStackTrace();
            exito = "1";
            return exito;
        }


    }

}

