package pe.empresab3.notialertas.presentacion.view.fragment;


import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import pe.empresab3.notialertas.R;
import pe.empresab3.notialertas.presentacion.model.TareaModel;
import pe.empresab3.notialertas.presentacion.notification.NotificacionActivity;
import pe.empresab3.notialertas.presentacion.notification.NotificacionAlerta;
import pe.empresab3.notialertas.presentacion.presenter.TareaDetallePresenter;
import pe.empresab3.notialertas.presentacion.utils.Utils;
import pe.empresab3.notialertas.presentacion.view.TareaDetalleView;


public class TareaDetalleFragment extends Fragment
        implements TareaDetalleView, View.OnClickListener {

    private static final String ARG_TAREA = "fragment.TareaDetalleFragment.ARG_TAREA";
    private static final String TAG = "TareaDetalleFragment";

    private EditText edtTitulo;
    private EditText edtDetalle;
    private ProgressBar progressBar;
    private EditText edtFecha;

    private TareaModel tareaModel;

    private TareaDetallePresenter tareaDetallePresenter;

    //------ Notificacion ------//
    private TextView txtMensaje;
    private Button btnValidar;
    //------ Notificacion ------//

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
        progressBar = view.findViewById(R.id.progress);
        edtFecha = view.findViewById(R.id.edt_fecha);

        //------ Notificacion ------//
        btnValidar = view.findViewById(R.id.btn_validar);
        txtMensaje = view.findViewById(R.id.txt_Mensaje);
        btnValidar.setOnClickListener(this);
        //------ Notificacion ------//

        edtFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarCalendario();
            }
        });

        Button btnGuardar = view.findViewById(R.id.btn_guardar);
        btnGuardar.setOnClickListener(this);

        initUI();

        tareaDetallePresenter = new TareaDetallePresenter(this);
    }

    private void initUI() {
        if (tareaModel != null) {
            edtTitulo.setText(tareaModel.getTitulo());
            edtDetalle.setText(tareaModel.getDetalle());
            edtFecha.setText(tareaModel.getFechEnvio());

            Log.d(TAG, "initUI: tareaModel_detalle:" + tareaModel.getDetalle());
            Log.d(TAG, "initUI: tareaModel_id:" + tareaModel.getId());

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
        switch (v.getId()) {
            case R.id.btn_guardar:
                if (tareaModel == null) {
                    tareaModel = new TareaModel();
                }
                tareaModel.setTitulo(edtTitulo.getText().toString());
                tareaModel.setDetalle(edtDetalle.getText().toString());
                tareaModel.setFechEnvio(edtFecha.getText().toString());
                guardarTarea(tareaModel);
                break;
            case R.id.btn_validar:
                validarFecha();
                break;
        }
    }

    private void mostrarCalendario() {
        Utils utils = new Utils();

        utils.showTimePickerDialog(getContext(), edtFecha);

        utils.showDateDialog(getContext(), edtFecha, false, 0);
    }

    //------ Notificacion ------//
    private void validarFecha() {

        NotificacionAlerta notificacionAlerta = new NotificacionAlerta();

        notificacionAlerta.validarFecha(edtFecha.getText().toString(), edtFecha.getText().toString(), tareaModel.getTitulo().toString(), tareaModel.getDetalle().toString(), getContext());
    }
    //------ Notificacion ------//
}
