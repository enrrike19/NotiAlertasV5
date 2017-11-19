package pe.empresab3.notialertas.datos.database;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import pe.empresab3.notialertas.datos.entity.NoticiaEntity;

/**
 * Created by Enrique on 17/11/2017.
 */

public class NoticiaCacheImpl implements NoticiaCache {


    @Override
    public List<NoticiaEntity> listar() {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<NoticiaEntity> query = realm.where(NoticiaEntity.class);
        RealmResults<NoticiaEntity> results = query.findAll();
//        realm.close();
        return results;

    }

    @Override
    public void guardar(final List<NoticiaEntity> noticiaEntityList) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.copyToRealmOrUpdate(noticiaEntityList);
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
