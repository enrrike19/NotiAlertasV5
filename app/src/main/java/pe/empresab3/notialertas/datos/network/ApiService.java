package pe.empresab3.notialertas.datos.network;

import java.util.List;

import pe.empresab3.notialertas.datos.entity.TareaEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Enrique on 17/11/2017.
 */

public interface ApiService {

    @GET("data/Tarea")
    Call<List<TareaEntity>> listarTareas();

    @POST("data/Tarea")
    Call<TareaEntity> guardarTarea(@Body TareaEntity tareaEntity);
}
