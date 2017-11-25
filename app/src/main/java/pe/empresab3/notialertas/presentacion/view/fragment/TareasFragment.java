package pe.empresab3.notialertas.presentacion.view.fragment;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import pe.empresab3.notialertas.R;
import pe.empresab3.notialertas.presentacion.background.CheckPostReceiver;
import pe.empresab3.notialertas.presentacion.model.TareaModel;
import pe.empresab3.notialertas.presentacion.presenter.TareasPresenter;
import pe.empresab3.notialertas.presentacion.view.TareasView;


public class TareasFragment extends Fragment
        implements TareasView, AdapterView.OnItemClickListener {

    private ProgressBar progressBar;
    private ListView listView;
    private FloatingActionButton fabAgregar;

    private ArrayAdapter<TareaModel> adapter;
    private List<TareaModel> tareaModelList = new ArrayList<>();

    private TareasPresenter tareasPresenter;

    private OnTareaClickListener onTareaClickListener;

    private int index = 0;

    private static final String TAG = "TareasFragment";

    private static int num = 0;

    public TareasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onTareaClickListener = (OnTareaClickListener) context;
        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " debe implementar OnTareaClickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tareas, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        progressBar = view.findViewById(R.id.progress);
        listView = view.findViewById(R.id.list_noticias);
        fabAgregar = view.findViewById(R.id.fab_agregar);

        listView.setOnItemClickListener(this);

        fabAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarTarea();
            }
        });

        if (savedInstanceState != null) {
            index = savedInstanceState.getInt("index", 0);
        }

        adapter = new ArrayAdapter<TareaModel>(
                getContext(),
                android.R.layout.simple_list_item_activated_1,
                tareaModelList);
        listView.setAdapter(adapter);

        tareasPresenter = new TareasPresenter(this);
    }


    @Override
    public void onStart() {
        super.onStart();
        tareasPresenter.cargarNoticias();
        //TODO, Se adicionó para saber cuantas tareas pendientes existen.
        Log.d(TAG, "onStart: cargarTareasPendientes");
        tareasPresenter.cargarTareasPendientes();

        if(num == 0){
            AlarmManager manager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
            Intent alarmIntent = new Intent(getContext(), CheckPostReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, alarmIntent, 0);
            long interval = (long) 0.005;

            manager.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), interval, pendingIntent);
            num = 1;
        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", index);
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
    public void mostrarTareas(List<TareaModel> tareaModels) {
        adapter.clear();
        adapter.addAll(tareaModels);


        if (getResources().getBoolean(R.bool.dual_pane)) {
            listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

            listView.setItemChecked(index, true);

            verDetalle(tareaModelList.get(index));
        }

    }

    @Override
    public void verDetalle(TareaModel tareaModel) {

        onTareaClickListener.onTareaClick(tareaModel);
    }

    @Override
    public void agregarTarea() {
        onTareaClickListener.onAgregarTareaClick();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        index = position;
        listView.setItemChecked(position, true);

        verDetalle(tareaModelList.get(position));
    }

    public interface OnTareaClickListener {
        void onTareaClick(TareaModel tareaModel);

        void onAgregarTareaClick();
    }
}