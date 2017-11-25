package pe.empresab3.notialertas.dominio.negocio;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import pe.empresab3.notialertas.dominio.executor.PostExecutionThread;
import pe.empresab3.notialertas.dominio.executor.ThreadExecutor;
import pe.empresab3.notialertas.dominio.model.Tarea;
import pe.empresab3.notialertas.dominio.repository.TareaRepositorio;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by Administrador on 25/11/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class GuardarTareaTest {

    private GuardarTarea guardarTarea;

    @Mock
    private ThreadExecutor mockThreadExecutor;

    @Mock
    private PostExecutionThread mockPostExecutionThread;

    @Mock
    private TareaRepositorio mockTareaRepositorio;

    @Before
    public void setUp() throws Exception {
        guardarTarea = new GuardarTarea(mockThreadExecutor, mockPostExecutionThread, mockTareaRepositorio);
    }

    @Test
    public void tesGuardarTarea() throws Exception {
        Tarea tarea = null;
        tarea = new Tarea();

        tarea.setTitulo("Probar tarea 1");
        tarea.setDetalle("Detalle sobre esta tarea");
        tarea.setEstado("0");
        tarea.setFechEnvio("25/11/2017 12:15 PM");

        guardarTarea.setParams(tarea);
        guardarTarea.construirNegocio();

        verify(mockTareaRepositorio).crearTarea(tarea);
        verifyNoMoreInteractions(mockTareaRepositorio);

    }

}
