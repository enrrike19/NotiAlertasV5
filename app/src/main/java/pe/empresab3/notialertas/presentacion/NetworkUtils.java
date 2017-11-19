package pe.empresab3.notialertas.presentacion;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Enrique on 18/11/2017.
 */

public class NetworkUtils {

    public static boolean hayInternet(Context context) {
        boolean hayInternet;
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        hayInternet = (networkInfo != null && networkInfo.isConnectedOrConnecting());
        return hayInternet;
    }
}
