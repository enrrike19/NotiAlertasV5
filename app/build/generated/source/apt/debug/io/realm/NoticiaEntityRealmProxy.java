package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.ProxyUtils;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class NoticiaEntityRealmProxy extends pe.empresab3.notialertas.datos.entity.NoticiaEntity
    implements RealmObjectProxy, NoticiaEntityRealmProxyInterface {

    static final class NoticiaEntityColumnInfo extends ColumnInfo {
        long idIndex;
        long tituloIndex;
        long detalleIndex;
        long estadoIndex;

        NoticiaEntityColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("NoticiaEntity");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.tituloIndex = addColumnDetails("titulo", objectSchemaInfo);
            this.detalleIndex = addColumnDetails("detalle", objectSchemaInfo);
            this.estadoIndex = addColumnDetails("estado", objectSchemaInfo);
        }

        NoticiaEntityColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new NoticiaEntityColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final NoticiaEntityColumnInfo src = (NoticiaEntityColumnInfo) rawSrc;
            final NoticiaEntityColumnInfo dst = (NoticiaEntityColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.tituloIndex = src.tituloIndex;
            dst.detalleIndex = src.detalleIndex;
            dst.estadoIndex = src.estadoIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(4);
        fieldNames.add("id");
        fieldNames.add("titulo");
        fieldNames.add("detalle");
        fieldNames.add("estado");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private NoticiaEntityColumnInfo columnInfo;
    private ProxyState<pe.empresab3.notialertas.datos.entity.NoticiaEntity> proxyState;

    NoticiaEntityRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (NoticiaEntityColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<pe.empresab3.notialertas.datos.entity.NoticiaEntity>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$titulo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tituloIndex);
    }

    @Override
    public void realmSet$titulo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tituloIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.tituloIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tituloIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tituloIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$detalle() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.detalleIndex);
    }

    @Override
    public void realmSet$detalle(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.detalleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.detalleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.detalleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.detalleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$estado() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.estadoIndex);
    }

    @Override
    public void realmSet$estado(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.estadoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.estadoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.estadoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.estadoIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("NoticiaEntity", 4, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("titulo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("detalle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("estado", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static NoticiaEntityColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new NoticiaEntityColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "NoticiaEntity";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static pe.empresab3.notialertas.datos.entity.NoticiaEntity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        pe.empresab3.notialertas.datos.entity.NoticiaEntity obj = null;
        if (update) {
            Table table = realm.getTable(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class);
            NoticiaEntityColumnInfo columnInfo = (NoticiaEntityColumnInfo) realm.getSchema().getColumnInfo(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class), false, Collections.<String> emptyList());
                    obj = new io.realm.NoticiaEntityRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.NoticiaEntityRealmProxy) realm.createObjectInternal(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.NoticiaEntityRealmProxy) realm.createObjectInternal(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final NoticiaEntityRealmProxyInterface objProxy = (NoticiaEntityRealmProxyInterface) obj;
        if (json.has("titulo")) {
            if (json.isNull("titulo")) {
                objProxy.realmSet$titulo(null);
            } else {
                objProxy.realmSet$titulo((String) json.getString("titulo"));
            }
        }
        if (json.has("detalle")) {
            if (json.isNull("detalle")) {
                objProxy.realmSet$detalle(null);
            } else {
                objProxy.realmSet$detalle((String) json.getString("detalle"));
            }
        }
        if (json.has("estado")) {
            if (json.isNull("estado")) {
                objProxy.realmSet$estado(null);
            } else {
                objProxy.realmSet$estado((String) json.getString("estado"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static pe.empresab3.notialertas.datos.entity.NoticiaEntity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final pe.empresab3.notialertas.datos.entity.NoticiaEntity obj = new pe.empresab3.notialertas.datos.entity.NoticiaEntity();
        final NoticiaEntityRealmProxyInterface objProxy = (NoticiaEntityRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("titulo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$titulo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$titulo(null);
                }
            } else if (name.equals("detalle")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$detalle((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$detalle(null);
                }
            } else if (name.equals("estado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$estado((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$estado(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static pe.empresab3.notialertas.datos.entity.NoticiaEntity copyOrUpdate(Realm realm, pe.empresab3.notialertas.datos.entity.NoticiaEntity object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (pe.empresab3.notialertas.datos.entity.NoticiaEntity) cachedRealmObject;
        }

        pe.empresab3.notialertas.datos.entity.NoticiaEntity realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class);
            NoticiaEntityColumnInfo columnInfo = (NoticiaEntityColumnInfo) realm.getSchema().getColumnInfo(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((NoticiaEntityRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.NoticiaEntityRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static pe.empresab3.notialertas.datos.entity.NoticiaEntity copy(Realm realm, pe.empresab3.notialertas.datos.entity.NoticiaEntity newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (pe.empresab3.notialertas.datos.entity.NoticiaEntity) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        pe.empresab3.notialertas.datos.entity.NoticiaEntity realmObject = realm.createObjectInternal(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class, ((NoticiaEntityRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        NoticiaEntityRealmProxyInterface realmObjectSource = (NoticiaEntityRealmProxyInterface) newObject;
        NoticiaEntityRealmProxyInterface realmObjectCopy = (NoticiaEntityRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$titulo(realmObjectSource.realmGet$titulo());
        realmObjectCopy.realmSet$detalle(realmObjectSource.realmGet$detalle());
        realmObjectCopy.realmSet$estado(realmObjectSource.realmGet$estado());
        return realmObject;
    }

    public static long insert(Realm realm, pe.empresab3.notialertas.datos.entity.NoticiaEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class);
        long tableNativePtr = table.getNativePtr();
        NoticiaEntityColumnInfo columnInfo = (NoticiaEntityColumnInfo) realm.getSchema().getColumnInfo(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((NoticiaEntityRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$titulo = ((NoticiaEntityRealmProxyInterface) object).realmGet$titulo();
        if (realmGet$titulo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tituloIndex, rowIndex, realmGet$titulo, false);
        }
        String realmGet$detalle = ((NoticiaEntityRealmProxyInterface) object).realmGet$detalle();
        if (realmGet$detalle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.detalleIndex, rowIndex, realmGet$detalle, false);
        }
        String realmGet$estado = ((NoticiaEntityRealmProxyInterface) object).realmGet$estado();
        if (realmGet$estado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.estadoIndex, rowIndex, realmGet$estado, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class);
        long tableNativePtr = table.getNativePtr();
        NoticiaEntityColumnInfo columnInfo = (NoticiaEntityColumnInfo) realm.getSchema().getColumnInfo(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class);
        long pkColumnIndex = columnInfo.idIndex;
        pe.empresab3.notialertas.datos.entity.NoticiaEntity object = null;
        while (objects.hasNext()) {
            object = (pe.empresab3.notialertas.datos.entity.NoticiaEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((NoticiaEntityRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$titulo = ((NoticiaEntityRealmProxyInterface) object).realmGet$titulo();
            if (realmGet$titulo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tituloIndex, rowIndex, realmGet$titulo, false);
            }
            String realmGet$detalle = ((NoticiaEntityRealmProxyInterface) object).realmGet$detalle();
            if (realmGet$detalle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.detalleIndex, rowIndex, realmGet$detalle, false);
            }
            String realmGet$estado = ((NoticiaEntityRealmProxyInterface) object).realmGet$estado();
            if (realmGet$estado != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.estadoIndex, rowIndex, realmGet$estado, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, pe.empresab3.notialertas.datos.entity.NoticiaEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class);
        long tableNativePtr = table.getNativePtr();
        NoticiaEntityColumnInfo columnInfo = (NoticiaEntityColumnInfo) realm.getSchema().getColumnInfo(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((NoticiaEntityRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$titulo = ((NoticiaEntityRealmProxyInterface) object).realmGet$titulo();
        if (realmGet$titulo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tituloIndex, rowIndex, realmGet$titulo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tituloIndex, rowIndex, false);
        }
        String realmGet$detalle = ((NoticiaEntityRealmProxyInterface) object).realmGet$detalle();
        if (realmGet$detalle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.detalleIndex, rowIndex, realmGet$detalle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.detalleIndex, rowIndex, false);
        }
        String realmGet$estado = ((NoticiaEntityRealmProxyInterface) object).realmGet$estado();
        if (realmGet$estado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.estadoIndex, rowIndex, realmGet$estado, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.estadoIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class);
        long tableNativePtr = table.getNativePtr();
        NoticiaEntityColumnInfo columnInfo = (NoticiaEntityColumnInfo) realm.getSchema().getColumnInfo(pe.empresab3.notialertas.datos.entity.NoticiaEntity.class);
        long pkColumnIndex = columnInfo.idIndex;
        pe.empresab3.notialertas.datos.entity.NoticiaEntity object = null;
        while (objects.hasNext()) {
            object = (pe.empresab3.notialertas.datos.entity.NoticiaEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((NoticiaEntityRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$titulo = ((NoticiaEntityRealmProxyInterface) object).realmGet$titulo();
            if (realmGet$titulo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tituloIndex, rowIndex, realmGet$titulo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tituloIndex, rowIndex, false);
            }
            String realmGet$detalle = ((NoticiaEntityRealmProxyInterface) object).realmGet$detalle();
            if (realmGet$detalle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.detalleIndex, rowIndex, realmGet$detalle, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.detalleIndex, rowIndex, false);
            }
            String realmGet$estado = ((NoticiaEntityRealmProxyInterface) object).realmGet$estado();
            if (realmGet$estado != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.estadoIndex, rowIndex, realmGet$estado, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.estadoIndex, rowIndex, false);
            }
        }
    }

    public static pe.empresab3.notialertas.datos.entity.NoticiaEntity createDetachedCopy(pe.empresab3.notialertas.datos.entity.NoticiaEntity realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        pe.empresab3.notialertas.datos.entity.NoticiaEntity unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new pe.empresab3.notialertas.datos.entity.NoticiaEntity();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (pe.empresab3.notialertas.datos.entity.NoticiaEntity) cachedObject.object;
            }
            unmanagedObject = (pe.empresab3.notialertas.datos.entity.NoticiaEntity) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        NoticiaEntityRealmProxyInterface unmanagedCopy = (NoticiaEntityRealmProxyInterface) unmanagedObject;
        NoticiaEntityRealmProxyInterface realmSource = (NoticiaEntityRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$titulo(realmSource.realmGet$titulo());
        unmanagedCopy.realmSet$detalle(realmSource.realmGet$detalle());
        unmanagedCopy.realmSet$estado(realmSource.realmGet$estado());

        return unmanagedObject;
    }

    static pe.empresab3.notialertas.datos.entity.NoticiaEntity update(Realm realm, pe.empresab3.notialertas.datos.entity.NoticiaEntity realmObject, pe.empresab3.notialertas.datos.entity.NoticiaEntity newObject, Map<RealmModel, RealmObjectProxy> cache) {
        NoticiaEntityRealmProxyInterface realmObjectTarget = (NoticiaEntityRealmProxyInterface) realmObject;
        NoticiaEntityRealmProxyInterface realmObjectSource = (NoticiaEntityRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$titulo(realmObjectSource.realmGet$titulo());
        realmObjectTarget.realmSet$detalle(realmObjectSource.realmGet$detalle());
        realmObjectTarget.realmSet$estado(realmObjectSource.realmGet$estado());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("NoticiaEntity = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{titulo:");
        stringBuilder.append(realmGet$titulo() != null ? realmGet$titulo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{detalle:");
        stringBuilder.append(realmGet$detalle() != null ? realmGet$detalle() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{estado:");
        stringBuilder.append(realmGet$estado() != null ? realmGet$estado() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoticiaEntityRealmProxy aNoticiaEntity = (NoticiaEntityRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aNoticiaEntity.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aNoticiaEntity.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aNoticiaEntity.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
