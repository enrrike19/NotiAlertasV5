package pe.empresab3.notialertas.presentacion.view.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pe.empresab3.notialertas.R;
import pe.empresab3.notialertas.presentacion.model.TareaModel;
import pe.empresab3.notialertas.presentacion.view.fragment.TareaDetalleFragment;
import pe.empresab3.notialertas.presentacion.view.fragment.TareasFragment;

public class MainActivity extends AppCompatActivity  implements TareasFragment.OnTareaClickListener {

    private boolean isDualPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment noticiaDetalleFragment = getSupportFragmentManager()
                .findFragmentById(R.id.frag_detalle);



        isDualPane = noticiaDetalleFragment != null;
    }

    @Override
    public void onTareaClick(TareaModel tareaModel) {
        if (!isDualPane) {
            // Si es telefono
            Intent intent = new Intent(this, TareaDetalleActivity.class);
            intent.putExtra(TareaDetalleActivity.EXTRA_TAREA, tareaModel);
            startActivity(intent);

        } else {
            // Si es tablet
            TareaDetalleFragment tareaDetalleFragment =
                    (TareaDetalleFragment) getSupportFragmentManager()
                            .findFragmentById(R.id.frag_detalle);
            tareaDetalleFragment.setTarea(tareaModel);
        }

    }

    @Override
    public void onAgregarTareaClick() {
        Intent intent = new Intent(this, TareaDetalleActivity.class);
        startActivity(intent);
    }
}