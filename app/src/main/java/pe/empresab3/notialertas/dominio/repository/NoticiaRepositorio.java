package pe.empresab3.notialertas.dominio.repository;

import java.util.List;

import pe.empresab3.notialertas.dominio.model.Noticia;

/**
 * Created by Enrique on 17/11/2017.
 */

public interface NoticiaRepositorio {

    List<Noticia> listarNoticias(boolean forzarRed) throws Exception;

    Noticia crearNoticia(Noticia noticia) throws Exception;

    Noticia actualizarNoticia(Noticia noticia) throws Exception;


}
