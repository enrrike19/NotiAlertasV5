package pe.empresab3.notialertas.presentacion;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.EventLogTags;
import android.util.Log;

/**
 * Created by Enrique on 18/11/2017.
 */

public class NetworkUtils {


    private static final String TAG = "VALIDAR_CONEXION";
    public static boolean hayInternet(Context context) {
        boolean hayInternet;
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        hayInternet = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        Log.d(TAG, "hayInternet: " + hayInternet);
        return hayInternet;
    }
}
