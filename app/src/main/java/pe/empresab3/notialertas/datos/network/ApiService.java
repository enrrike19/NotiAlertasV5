package pe.empresab3.notialertas.datos.network;

import java.util.List;

import pe.empresab3.notialertas.datos.entity.NoticiaEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Enrique on 17/11/2017.
 */

public interface ApiService {

    @GET("data/Noticia")
    Call<List<NoticiaEntity>> listarNoticias();

    @POST("data/Noticia")
    Call<NoticiaEntity> guardarNoticia(@Body NoticiaEntity noticiaEntity);
}
