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
import pe.empresab3.notialertas.presentacion.model.TareaModel;
import pe.empresab3.notialertas.presentacion.presenter.TareaDetallePresenter;
import pe.empresab3.notialertas.presentacion.view.TareaDetalleView;


public class TareaDetalleFragment  extends Fragment
        implements TareaDetalleView, View.OnClickListener {

    private static final String ARG_TAREA = "fragment.TareaDetalleFragment.ARG_TAREA";

    private EditText edtTitulo;
    private EditText edtUrl;
    private EditText edtDetalle;
    private ProgressBar progressBar;

    private TareaModel tareaModel;

    private TareaDetallePresenter tareaDetallePresenter;

    public static TareaDetalleFragment newInstance(TareaModel tareaModel) {
        TareaDetalleFragment f = new TareaDetalleFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_TAREA, tareaModel);
        f.setArguments(args);
        return f;
    }


    public TareaDetalleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            tareaModel = getArguments().getParcelable(ARG_TAREA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tarea_detalle, container, false);
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

        tareaDetallePresenter = new TareaDetallePresenter(this);
    }

    private void initUI() {
        if (tareaModel != null) {
            edtTitulo.setText(tareaModel.getTitulo());
            //edtUrl.setText(noticiaModel.getUrl());
            edtDetalle.setText(tareaModel.getDetalle());
        }
    }

    public void setTarea(TareaModel tareaModel) {
        this.tareaModel = tareaModel;
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
    public void guardarTarea(TareaModel tareaModel) {
        tareaDetallePresenter.guardarTarea(tareaModel);
    }

    @Override
    public void notificarTareaGuardada() {

        getActivity().finish();

    }

    @Override
    public void onClick(View v) {
        if (tareaModel == null) {
            tareaModel = new TareaModel();
        }
        tareaModel.setTitulo(edtTitulo.getText().toString());
        tareaModel.setDetalle(edtDetalle.getText().toString());
        guardarTarea(tareaModel);
    }
}
