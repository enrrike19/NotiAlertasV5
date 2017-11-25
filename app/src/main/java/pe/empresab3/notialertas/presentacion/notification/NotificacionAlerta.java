package pe.empresab3.notialertas.presentacion.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import pe.empresab3.notialertas.R;

/**
 * Created by Administrador on 25/11/2017.
 */

public class NotificacionAlerta {

    public void validarFecha (String fecha, String hora, String titulo, String detalle, Context context) {

        Calendar myCalendar;

        String formatoFecha = "dd/MM/yyyy";
        SimpleDateFormat sdfFecha;
        String formatoHora = "hh:mm a";
        SimpleDateFormat sdfHora;

        String fechaActual;
        String horaActual;

        String fechaProgramada;
        String horaProgramada;

        myCalendar = Calendar.getInstance();
        sdfFecha = new SimpleDateFormat(formatoFecha, Locale.US);
        sdfHora = new SimpleDateFormat(formatoHora, Locale.US);

        fechaActual = sdfFecha.format(myCalendar.getTime()).toString();
        horaActual = sdfHora.format(myCalendar.getTime()).toString();

        fechaProgramada = fecha.substring(0,10);
        horaProgramada = hora.substring(11);

        if (fechaProgramada.equals(fechaActual) && horaProgramada.equals(horaActual)) {
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
            notificationManager.notify(1, TareaProgramada(context,titulo,detalle));
            //txtMensaje.setText("Inicio de Tarea");
        } else {
            //txtMensaje.setText("Tarea no programada");
        }

    }

    private Notification TareaProgramada(Context context, String titulo, String detalle) {
        Intent intent = new Intent(context, NotificacionActivity.class);

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(context);
        taskStackBuilder.addParentStack(NotificacionActivity.class);
        taskStackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                context, "basic")
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(Notification.PRIORITY_HIGH)
                .setColor(Color.parseColor("#71b32a"))
                .setContentTitle(titulo)
                .setContentText(detalle)
                .setSmallIcon(R.drawable.ic_alerta)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        return builder.build();
    }

}
