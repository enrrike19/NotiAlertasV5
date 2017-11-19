package pe.empresab3.notialertas.presentacion.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import pe.empresab3.notialertas.R;
import pe.empresab3.notialertas.presentacion.model.TareaModel;
import pe.empresab3.notialertas.presentacion.view.fragment.TareaDetalleFragment;

public class TareaDetalleActivity extends AppCompatActivity {

    public static final String EXTRA_TAREA = "activity.TareaDetalle.EXTRA_TAREA";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TareaModel tareaModel = getIntent().getParcelableExtra(EXTRA_TAREA);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(android.R.id.content, TareaDetalleFragment.newInstance(tareaModel));
        ft.commit();
    }

}
