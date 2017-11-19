package pe.empresab3.notialertas.presentacion.presenter;

import pe.empresab3.notialertas.presentacion.view.BaseView;

/**
 * Created by Enrique on 18/11/2017.
 */

public class BasePresenter <V extends BaseView> {

    protected V view;

    public BasePresenter(V view) {
        this.view = view;
    }
}

