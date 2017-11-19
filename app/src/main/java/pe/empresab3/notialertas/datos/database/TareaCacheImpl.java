package pe.empresab3.notialertas.datos.database;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import pe.empresab3.notialertas.datos.entity.TareaEntity;
import pe.empresab3.notialertas.datos.repository.datasource.TareaDatasource;

/**
 * Created by Enrique on 17/11/2017.
 */

public class TareaCacheImpl implements TareaCache {


    @Override
    public List<TareaEntity> listar() {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<TareaEntity> query = realm.where(TareaEntity.class);
        RealmResults<TareaEntity> results = query.findAll();
//        realm.close();
        return results;

    }

    @Override
    public void guardar(final List<TareaEntity> tareaEntityList) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.copyToRealmOrUpdate(tareaEntityList);
            }
        });
        realm.close();
    }

    @Override
    public void limpiar() {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.deleteAll();
            }
        });
    }
}
