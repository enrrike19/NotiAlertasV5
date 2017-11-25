package pe.empresab3.notialertas.dominio.negocio;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import pe.empresab3.notialertas.dominio.executor.PostExecutionThread;
import pe.empresab3.notialertas.dominio.executor.ThreadExecutor;
import pe.empresab3.notialertas.dominio.repository.TareaRepositorio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by Enrique on 24/11/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ListarTareasTest {
    private ListarTareas listarTareas;

    @Mock
    private ThreadExecutor mockThreadExecutor;

    @Mock
    private PostExecutionThread mockPostExecutionThread;

    @Mock
    private TareaRepositorio mockTareaRepositorio;

    @Before
    public void setUp() throws Exception {
        listarTareas = new ListarTareas(
                mockThreadExecutor, mockPostExecutionThread, mockTareaRepositorio);
    }

    @Test
    public void testListasTareasNegocio() throws Exception {
        listarTareas.setParam(true);
        listarTareas.construirNegocio();

        verify(mockTareaRepositorio).listarTareas(true);
        verifyNoMoreInteractions(mockTareaRepositorio);
    }
}