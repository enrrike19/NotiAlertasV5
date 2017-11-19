package pe.empresab3.notialertas.presentacion.view.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pe.empresab3.notialertas.R;
import pe.empresab3.notialertas.presentacion.model.NoticiaModel;
import pe.empresab3.notialertas.presentacion.view.fragment.NoticiaDetalleFragment;
import pe.empresab3.notialertas.presentacion.view.fragment.NoticiasFragment;

public class MainActivity extends AppCompatActivity  implements NoticiasFragment.OnNoticiaClickListener {

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
    public void onNoticiaClick(NoticiaModel noticiaModel) {
        if (!isDualPane) {
            // Si es telefono
            Intent intent = new Intent(this, NoticiaDetalleActivity.class);
            intent.putExtra(NoticiaDetalleActivity.EXTRA_NOTICIA, noticiaModel);
            startActivity(intent);

        } else {
            // Si es tablet
            NoticiaDetalleFragment noticiaDetalleFragment =
                    (NoticiaDetalleFragment) getSupportFragmentManager()
                            .findFragmentById(R.id.frag_detalle);
            noticiaDetalleFragment.setNoticia(noticiaModel);
        }

    }

    @Override
    public void onAgregarNoticiaClick() {
        Intent intent = new Intent(this, NoticiaDetalleActivity.class);
        startActivity(intent);
    }
}