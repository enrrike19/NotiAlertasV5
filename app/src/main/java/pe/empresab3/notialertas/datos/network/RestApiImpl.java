package pe.empresab3.notialertas.datos.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import pe.empresab3.notialertas.datos.entity.TareaEntity;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android on 18/11/2017.
 */

public class RestApiImpl implements RestApi {

    private final ApiService apiService;
    private final Context context;

    public RestApiImpl(Context context) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.backendless.com/C4659C0A-18B0-6B50-FF2E-6DFDB203B200/4316FC36-DB62-4BB9-FF51-8155F955B900/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        this.apiService = retrofit.create(ApiService.class);
        this.context = context;
    }

    @Override
    public List<TareaEntity> listarTareas() throws Exception {
        if (hayInternet()) {
            Call<List<TareaEntity>> call = apiService.listarTareas();
            Response<List<TareaEntity>> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }

    @Override
    public TareaEntity guardarTarea(TareaEntity tareaEntity) throws Exception {
        if (hayInternet()) {
            Call<TareaEntity> call = apiService.guardarTarea(tareaEntity);
            Response<TareaEntity> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }

    @Override
    public TareaEntity actualizarTarea(TareaEntity tareaEntity) throws Exception {
        if (hayInternet()) {
            Call<TareaEntity> call = apiService.guardarTarea(tareaEntity);
            Response<TareaEntity> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }

    public boolean hayInternet() {
        boolean hayInternet;
        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        hayInternet = (networkInfo != null && networkInfo.isConnectedOrConnecting());
        return hayInternet;
    }
}
