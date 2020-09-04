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
public class com_zamba_testchat_models_UserRealmProxy extends com.zamba.testchat.models.User
    implements RealmObjectProxy, com_zamba_testchat_models_UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo {
        long nameInPhoneColKey;
        long idColKey;
        long nameColKey;
        long statusColKey;
        long imageColKey;
        long user_nameColKey;

        UserColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("User");
            this.nameInPhoneColKey = addColumnDetails("nameInPhone", "nameInPhone", objectSchemaInfo);
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.nameColKey = addColumnDetails("name", "name", objectSchemaInfo);
            this.statusColKey = addColumnDetails("status", "status", objectSchemaInfo);
            this.imageColKey = addColumnDetails("image", "image", objectSchemaInfo);
            this.user_nameColKey = addColumnDetails("user_name", "user_name", objectSchemaInfo);
        }

        UserColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserColumnInfo src = (UserColumnInfo) rawSrc;
            final UserColumnInfo dst = (UserColumnInfo) rawDst;
            dst.nameInPhoneColKey = src.nameInPhoneColKey;
            dst.idColKey = src.idColKey;
            dst.nameColKey = src.nameColKey;
            dst.statusColKey = src.statusColKey;
            dst.imageColKey = src.imageColKey;
            dst.user_nameColKey = src.user_nameColKey;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserColumnInfo columnInfo;
    private ProxyState<com.zamba.testchat.models.User> proxyState;

    com_zamba_testchat_models_UserRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.zamba.testchat.models.User>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nameInPhone() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameInPhoneColKey);
    }

    @Override
    public void realmSet$nameInPhone(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameInPhoneColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameInPhoneColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameInPhoneColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameInPhoneColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idColKey);
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
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameColKey);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusColKey);
    }

    @Override
    public void realmSet$status(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$image() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.imageColKey);
    }

    @Override
    public void realmSet$image(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.imageColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.imageColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.imageColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.imageColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$user_name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.user_nameColKey);
    }

    @Override
    public void realmSet$user_name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.user_nameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.user_nameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.user_nameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.user_nameColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("User", 6, 0);
        builder.addPersistedProperty("nameInPhone", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("image", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("user_name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "User";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "User";
    }

    @SuppressWarnings("cast")
    public static com.zamba.testchat.models.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.zamba.testchat.models.User obj = null;
        if (update) {
            Table table = realm.getTable(com.zamba.testchat.models.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.User.class);
            long pkColumnKey = columnInfo.idColKey;
            long colKey = Table.NO_MATCH;
            if (json.isNull("id")) {
                colKey = table.findFirstNull(pkColumnKey);
            } else {
                colKey = table.findFirstString(pkColumnKey, json.getString("id"));
            }
            if (colKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(colKey), realm.getSchema().getColumnInfo(com.zamba.testchat.models.User.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_zamba_testchat_models_UserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_zamba_testchat_models_UserRealmProxy) realm.createObjectInternal(com.zamba.testchat.models.User.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_zamba_testchat_models_UserRealmProxy) realm.createObjectInternal(com.zamba.testchat.models.User.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_zamba_testchat_models_UserRealmProxyInterface objProxy = (com_zamba_testchat_models_UserRealmProxyInterface) obj;
        if (json.has("nameInPhone")) {
            if (json.isNull("nameInPhone")) {
                objProxy.realmSet$nameInPhone(null);
            } else {
                objProxy.realmSet$nameInPhone((String) json.getString("nameInPhone"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                objProxy.realmSet$status(null);
            } else {
                objProxy.realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("image")) {
            if (json.isNull("image")) {
                objProxy.realmSet$image(null);
            } else {
                objProxy.realmSet$image((String) json.getString("image"));
            }
        }
        if (json.has("user_name")) {
            if (json.isNull("user_name")) {
                objProxy.realmSet$user_name(null);
            } else {
                objProxy.realmSet$user_name((String) json.getString("user_name"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.zamba.testchat.models.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.zamba.testchat.models.User obj = new com.zamba.testchat.models.User();
        final com_zamba_testchat_models_UserRealmProxyInterface objProxy = (com_zamba_testchat_models_UserRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("nameInPhone")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nameInPhone((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nameInPhone(null);
                }
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$status(null);
                }
            } else if (name.equals("image")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$image((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$image(null);
                }
            } else if (name.equals("user_name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$user_name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$user_name(null);
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

    private static com_zamba_testchat_models_UserRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.zamba.testchat.models.User.class), false, Collections.<String>emptyList());
        io.realm.com_zamba_testchat_models_UserRealmProxy obj = new io.realm.com_zamba_testchat_models_UserRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.zamba.testchat.models.User copyOrUpdate(Realm realm, UserColumnInfo columnInfo, com.zamba.testchat.models.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.zamba.testchat.models.User) cachedRealmObject;
        }

        com.zamba.testchat.models.User realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.zamba.testchat.models.User.class);
            long pkColumnKey = columnInfo.idColKey;
            String value = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$id();
            long colKey = Table.NO_MATCH;
            if (value == null) {
                colKey = table.findFirstNull(pkColumnKey);
            } else {
                colKey = table.findFirstString(pkColumnKey, value);
            }
            if (colKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(colKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_zamba_testchat_models_UserRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.zamba.testchat.models.User copy(Realm realm, UserColumnInfo columnInfo, com.zamba.testchat.models.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.zamba.testchat.models.User) cachedRealmObject;
        }

        com_zamba_testchat_models_UserRealmProxyInterface realmObjectSource = (com_zamba_testchat_models_UserRealmProxyInterface) newObject;

        Table table = realm.getTable(com.zamba.testchat.models.User.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.nameInPhoneColKey, realmObjectSource.realmGet$nameInPhone());
        builder.addString(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nameColKey, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.statusColKey, realmObjectSource.realmGet$status());
        builder.addString(columnInfo.imageColKey, realmObjectSource.realmGet$image());
        builder.addString(columnInfo.user_nameColKey, realmObjectSource.realmGet$user_name());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_zamba_testchat_models_UserRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.zamba.testchat.models.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.zamba.testchat.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.User.class);
        long pkColumnKey = columnInfo.idColKey;
        String primaryKeyValue = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$id();
        long colKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            colKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            colKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
        }
        if (colKey == Table.NO_MATCH) {
            colKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, colKey);
        String realmGet$nameInPhone = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$nameInPhone();
        if (realmGet$nameInPhone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameInPhoneColKey, colKey, realmGet$nameInPhone, false);
        }
        String realmGet$name = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, colKey, realmGet$name, false);
        }
        String realmGet$status = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, colKey, realmGet$status, false);
        }
        String realmGet$image = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageColKey, colKey, realmGet$image, false);
        }
        String realmGet$user_name = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$user_name();
        if (realmGet$user_name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.user_nameColKey, colKey, realmGet$user_name, false);
        }
        return colKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.zamba.testchat.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.User.class);
        long pkColumnKey = columnInfo.idColKey;
        com.zamba.testchat.models.User object = null;
        while (objects.hasNext()) {
            object = (com.zamba.testchat.models.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$id();
            long colKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                colKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                colKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
            }
            if (colKey == Table.NO_MATCH) {
                colKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, colKey);
            String realmGet$nameInPhone = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$nameInPhone();
            if (realmGet$nameInPhone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameInPhoneColKey, colKey, realmGet$nameInPhone, false);
            }
            String realmGet$name = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, colKey, realmGet$name, false);
            }
            String realmGet$status = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, colKey, realmGet$status, false);
            }
            String realmGet$image = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$image();
            if (realmGet$image != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.imageColKey, colKey, realmGet$image, false);
            }
            String realmGet$user_name = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$user_name();
            if (realmGet$user_name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.user_nameColKey, colKey, realmGet$user_name, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.zamba.testchat.models.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.zamba.testchat.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.User.class);
        long pkColumnKey = columnInfo.idColKey;
        String primaryKeyValue = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$id();
        long colKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            colKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            colKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
        }
        if (colKey == Table.NO_MATCH) {
            colKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        }
        cache.put(object, colKey);
        String realmGet$nameInPhone = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$nameInPhone();
        if (realmGet$nameInPhone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameInPhoneColKey, colKey, realmGet$nameInPhone, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameInPhoneColKey, colKey, false);
        }
        String realmGet$name = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, colKey, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, colKey, false);
        }
        String realmGet$status = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, colKey, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusColKey, colKey, false);
        }
        String realmGet$image = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageColKey, colKey, realmGet$image, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.imageColKey, colKey, false);
        }
        String realmGet$user_name = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$user_name();
        if (realmGet$user_name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.user_nameColKey, colKey, realmGet$user_name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.user_nameColKey, colKey, false);
        }
        return colKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.zamba.testchat.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.User.class);
        long pkColumnKey = columnInfo.idColKey;
        com.zamba.testchat.models.User object = null;
        while (objects.hasNext()) {
            object = (com.zamba.testchat.models.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$id();
            long colKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                colKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                colKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
            }
            if (colKey == Table.NO_MATCH) {
                colKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            }
            cache.put(object, colKey);
            String realmGet$nameInPhone = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$nameInPhone();
            if (realmGet$nameInPhone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameInPhoneColKey, colKey, realmGet$nameInPhone, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameInPhoneColKey, colKey, false);
            }
            String realmGet$name = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, colKey, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, colKey, false);
            }
            String realmGet$status = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, colKey, realmGet$status, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.statusColKey, colKey, false);
            }
            String realmGet$image = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$image();
            if (realmGet$image != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.imageColKey, colKey, realmGet$image, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.imageColKey, colKey, false);
            }
            String realmGet$user_name = ((com_zamba_testchat_models_UserRealmProxyInterface) object).realmGet$user_name();
            if (realmGet$user_name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.user_nameColKey, colKey, realmGet$user_name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.user_nameColKey, colKey, false);
            }
        }
    }

    public static com.zamba.testchat.models.User createDetachedCopy(com.zamba.testchat.models.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.zamba.testchat.models.User unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.zamba.testchat.models.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.zamba.testchat.models.User) cachedObject.object;
            }
            unmanagedObject = (com.zamba.testchat.models.User) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_zamba_testchat_models_UserRealmProxyInterface unmanagedCopy = (com_zamba_testchat_models_UserRealmProxyInterface) unmanagedObject;
        com_zamba_testchat_models_UserRealmProxyInterface realmSource = (com_zamba_testchat_models_UserRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$nameInPhone(realmSource.realmGet$nameInPhone());
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$image(realmSource.realmGet$image());
        unmanagedCopy.realmSet$user_name(realmSource.realmGet$user_name());

        return unmanagedObject;
    }

    static com.zamba.testchat.models.User update(Realm realm, UserColumnInfo columnInfo, com.zamba.testchat.models.User realmObject, com.zamba.testchat.models.User newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_zamba_testchat_models_UserRealmProxyInterface realmObjectTarget = (com_zamba_testchat_models_UserRealmProxyInterface) realmObject;
        com_zamba_testchat_models_UserRealmProxyInterface realmObjectSource = (com_zamba_testchat_models_UserRealmProxyInterface) newObject;
        Table table = realm.getTable(com.zamba.testchat.models.User.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.nameInPhoneColKey, realmObjectSource.realmGet$nameInPhone());
        builder.addString(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nameColKey, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.statusColKey, realmObjectSource.realmGet$status());
        builder.addString(columnInfo.imageColKey, realmObjectSource.realmGet$image());
        builder.addString(columnInfo.user_nameColKey, realmObjectSource.realmGet$user_name());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("User = proxy[");
        stringBuilder.append("{nameInPhone:");
        stringBuilder.append(realmGet$nameInPhone() != null ? realmGet$nameInPhone() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{image:");
        stringBuilder.append(realmGet$image() != null ? realmGet$image() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{user_name:");
        stringBuilder.append(realmGet$user_name() != null ? realmGet$user_name() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

}
