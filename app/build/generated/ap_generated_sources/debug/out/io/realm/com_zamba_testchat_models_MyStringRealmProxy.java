package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_zamba_testchat_models_MyStringRealmProxy extends com.zamba.testchat.models.MyString
    implements RealmObjectProxy, com_zamba_testchat_models_MyStringRealmProxyInterface {

    static final class MyStringColumnInfo extends ColumnInfo {
        long stringColKey;

        MyStringColumnInfo(OsSchemaInfo schemaInfo) {
            super(1);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("MyString");
            this.stringColKey = addColumnDetails("string", "string", objectSchemaInfo);
        }

        MyStringColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MyStringColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MyStringColumnInfo src = (MyStringColumnInfo) rawSrc;
            final MyStringColumnInfo dst = (MyStringColumnInfo) rawDst;
            dst.stringColKey = src.stringColKey;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private MyStringColumnInfo columnInfo;
    private ProxyState<com.zamba.testchat.models.MyString> proxyState;

    com_zamba_testchat_models_MyStringRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MyStringColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.zamba.testchat.models.MyString>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$string() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.stringColKey);
    }

    @Override
    public void realmSet$string(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.stringColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.stringColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.stringColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.stringColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("MyString", 1, 0);
        builder.addPersistedProperty("string", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MyStringColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new MyStringColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "MyString";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "MyString";
    }

    @SuppressWarnings("cast")
    public static com.zamba.testchat.models.MyString createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.zamba.testchat.models.MyString obj = realm.createObjectInternal(com.zamba.testchat.models.MyString.class, true, excludeFields);

        final com_zamba_testchat_models_MyStringRealmProxyInterface objProxy = (com_zamba_testchat_models_MyStringRealmProxyInterface) obj;
        if (json.has("string")) {
            if (json.isNull("string")) {
                objProxy.realmSet$string(null);
            } else {
                objProxy.realmSet$string((String) json.getString("string"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.zamba.testchat.models.MyString createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.zamba.testchat.models.MyString obj = new com.zamba.testchat.models.MyString();
        final com_zamba_testchat_models_MyStringRealmProxyInterface objProxy = (com_zamba_testchat_models_MyStringRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("string")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$string((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$string(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_zamba_testchat_models_MyStringRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.zamba.testchat.models.MyString.class), false, Collections.<String>emptyList());
        io.realm.com_zamba_testchat_models_MyStringRealmProxy obj = new io.realm.com_zamba_testchat_models_MyStringRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.zamba.testchat.models.MyString copyOrUpdate(Realm realm, MyStringColumnInfo columnInfo, com.zamba.testchat.models.MyString object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
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
            return (com.zamba.testchat.models.MyString) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.zamba.testchat.models.MyString copy(Realm realm, MyStringColumnInfo columnInfo, com.zamba.testchat.models.MyString newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.zamba.testchat.models.MyString) cachedRealmObject;
        }

        com_zamba_testchat_models_MyStringRealmProxyInterface realmObjectSource = (com_zamba_testchat_models_MyStringRealmProxyInterface) newObject;

        Table table = realm.getTable(com.zamba.testchat.models.MyString.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.stringColKey, realmObjectSource.realmGet$string());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_zamba_testchat_models_MyStringRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.zamba.testchat.models.MyString object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.zamba.testchat.models.MyString.class);
        long tableNativePtr = table.getNativePtr();
        MyStringColumnInfo columnInfo = (MyStringColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.MyString.class);
        long colKey = OsObject.createRow(table);
        cache.put(object, colKey);
        String realmGet$string = ((com_zamba_testchat_models_MyStringRealmProxyInterface) object).realmGet$string();
        if (realmGet$string != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stringColKey, colKey, realmGet$string, false);
        }
        return colKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.zamba.testchat.models.MyString.class);
        long tableNativePtr = table.getNativePtr();
        MyStringColumnInfo columnInfo = (MyStringColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.MyString.class);
        com.zamba.testchat.models.MyString object = null;
        while (objects.hasNext()) {
            object = (com.zamba.testchat.models.MyString) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long colKey = OsObject.createRow(table);
            cache.put(object, colKey);
            String realmGet$string = ((com_zamba_testchat_models_MyStringRealmProxyInterface) object).realmGet$string();
            if (realmGet$string != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.stringColKey, colKey, realmGet$string, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.zamba.testchat.models.MyString object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.zamba.testchat.models.MyString.class);
        long tableNativePtr = table.getNativePtr();
        MyStringColumnInfo columnInfo = (MyStringColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.MyString.class);
        long colKey = OsObject.createRow(table);
        cache.put(object, colKey);
        String realmGet$string = ((com_zamba_testchat_models_MyStringRealmProxyInterface) object).realmGet$string();
        if (realmGet$string != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stringColKey, colKey, realmGet$string, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.stringColKey, colKey, false);
        }
        return colKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.zamba.testchat.models.MyString.class);
        long tableNativePtr = table.getNativePtr();
        MyStringColumnInfo columnInfo = (MyStringColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.MyString.class);
        com.zamba.testchat.models.MyString object = null;
        while (objects.hasNext()) {
            object = (com.zamba.testchat.models.MyString) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long colKey = OsObject.createRow(table);
            cache.put(object, colKey);
            String realmGet$string = ((com_zamba_testchat_models_MyStringRealmProxyInterface) object).realmGet$string();
            if (realmGet$string != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.stringColKey, colKey, realmGet$string, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.stringColKey, colKey, false);
            }
        }
    }

    public static com.zamba.testchat.models.MyString createDetachedCopy(com.zamba.testchat.models.MyString realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.zamba.testchat.models.MyString unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.zamba.testchat.models.MyString();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.zamba.testchat.models.MyString) cachedObject.object;
            }
            unmanagedObject = (com.zamba.testchat.models.MyString) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_zamba_testchat_models_MyStringRealmProxyInterface unmanagedCopy = (com_zamba_testchat_models_MyStringRealmProxyInterface) unmanagedObject;
        com_zamba_testchat_models_MyStringRealmProxyInterface realmSource = (com_zamba_testchat_models_MyStringRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$string(realmSource.realmGet$string());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MyString = proxy[");
        stringBuilder.append("{string:");
        stringBuilder.append(realmGet$string() != null ? realmGet$string() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

}
