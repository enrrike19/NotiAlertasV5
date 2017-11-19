package pe.empresab3.notialertas.presentacion.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import pe.empresab3.notialertas.R;
import pe.empresab3.notialertas.presentacion.model.NoticiaModel;
import pe.empresab3.notialertas.presentacion.presenter.NoticiasPresenter;
import pe.empresab3.notialertas.presentacion.view.NoticiasView;


public class NoticiasFragment extends Fragment
        implements NoticiasView, AdapterView.OnItemClickListener {

    private ProgressBar progressBar;
    private ListView listView;
    private FloatingActionButton fabAgregar;

    private ArrayAdapter<NoticiaModel> adapter;
    private List<NoticiaModel> noticiaModelList = new ArrayList<>();

    private NoticiasPresenter noticiasPresenter;

    private OnNoticiaClickListener onNoticiaClickListener;

    private int index = 0;

    public NoticiasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onNoticiaClickListener = (OnNoticiaClickListener) context;
        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " debe implementar OnNoticiaClickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_noticias, container, false);
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
                agregarNoticia();
            }
        });

        if (savedInstanceState != null) {
            index = savedInstanceState.getInt("index", 0);
        }

        adapter = new ArrayAdapter<NoticiaModel>(
                getContext(),
                android.R.layout.simple_list_item_activated_1,
                noticiaModelList);
        listView.setAdapter(adapter);

        noticiasPresenter = new NoticiasPresenter(this);
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        noticiasPresenter.cargarNoticias();
//    }


    @Override
    public void onStart() {
        super.onStart();
        noticiasPresenter.cargarNoticias();
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
    public void mostrarNoticias(List<NoticiaModel> noticiaModels) {
        adapter.clear();
        adapter.addAll(noticiaModels);

//        listView.post(new Runnable() {
//            @Override
//            public void run() {
//                Fragment noticiaDetalleFragment = getActivity().getSupportFragmentManager()
//                        .findFragmentById(R.id.frag_detalle);
//                if (noticiaDetalleFragment != null) {
//                    listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
//
//                    listView.setItemChecked(index, true);
//
//                    verDetalle(noticiaModelList.get(index));
//                }
//            }
//        });

        if (getResources().getBoolean(R.bool.dual_pane)) {
            listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

            listView.setItemChecked(index, true);

            verDetalle(noticiaModelList.get(index));
        }

    }

    @Override
    public void verDetalle(NoticiaModel noticiaModel) {
        onNoticiaClickListener.onNoticiaClick(noticiaModel);
    }

    @Override
    public void agregarNoticia() {
        onNoticiaClickListener.onAgregarNoticiaClick();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        index = position;
        listView.setItemChecked(position, true);

        verDetalle(noticiaModelList.get(position));
    }

    public interface OnNoticiaClickListener {
        void onNoticiaClick(NoticiaModel noticiaModel);

        void onAgregarNoticiaClick();
    }
}