package pe.empresab3.notialertas.presentacion.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import pe.empresab3.notialertas.R;
import pe.empresab3.notialertas.presentacion.model.NoticiaModel;
import pe.empresab3.notialertas.presentacion.presenter.NoticiaDetallePresenter;
import pe.empresab3.notialertas.presentacion.view.NoticiaDetalleView;


public class NoticiaDetalleFragment  extends Fragment
        implements NoticiaDetalleView, View.OnClickListener {

    private static final String ARG_NOTICIA = "fragment.NoticiaDetalleFragment.ARG_NOTICIA";

    private EditText edtTitulo;
    private EditText edtUrl;
    private EditText edtDetalle;
    private ProgressBar progressBar;

    private NoticiaModel noticiaModel;

    private NoticiaDetallePresenter noticiaDetallePresenter;

    public static NoticiaDetalleFragment newInstance(NoticiaModel noticiaModel) {
        NoticiaDetalleFragment f = new NoticiaDetalleFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTICIA, noticiaModel);
        f.setArguments(args);
        return f;
    }


    public NoticiaDetalleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            noticiaModel = getArguments().getParcelable(ARG_NOTICIA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_noticia_detalle, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtTitulo = view.findViewById(R.id.edt_titulo);
        edtDetalle = view.findViewById(R.id.edt_detalle);
        //edtUrl = view.findViewById(R.id.edt_url);
        progressBar = view.findViewById(R.id.progress);

        Button btnGuardar = view.findViewById(R.id.btn_guardar);
        btnGuardar.setOnClickListener(this);

        initUI();

        noticiaDetallePresenter = new NoticiaDetallePresenter(this);
    }

    private void initUI() {
        if (noticiaModel != null) {
            edtTitulo.setText(noticiaModel.getTitulo());
            //edtUrl.setText(noticiaModel.getUrl());
            edtDetalle.setText(noticiaModel.getDetalle());
        }
    }

    public void setNoticia(NoticiaModel noticiaModel) {
        this.noticiaModel = noticiaModel;

        initUI();
    }

    @Override
    public void mostrarLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void ocultarLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public Context context() {
        return getContext();
    }

    @Override
    public void guardarNoticia(NoticiaModel noticiaModel) {
        noticiaDetallePresenter.guardarNoticia(noticiaModel);
    }

    @Override
    public void notificarNoticiaGuardada() {
        getActivity().finish();
    }

    @Override
    public void onClick(View v) {
        if (noticiaModel == null) {
            noticiaModel = new NoticiaModel();
        }
        noticiaModel.setTitulo(edtTitulo.getText().toString());
        noticiaModel.setDetalle(edtDetalle.getText().toString());
        //noticiaModel.setUrl(edtUrl.getText().toString());
        guardarNoticia(noticiaModel);
    }
}
