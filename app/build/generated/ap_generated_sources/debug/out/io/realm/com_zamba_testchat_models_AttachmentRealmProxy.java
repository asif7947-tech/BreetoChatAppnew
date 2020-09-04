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
public class com_zamba_testchat_models_AttachmentRealmProxy extends com.zamba.testchat.models.Attachment
    implements RealmObjectProxy, com_zamba_testchat_models_AttachmentRealmProxyInterface {

    static final class AttachmentColumnInfo extends ColumnInfo {
        long nameColKey;
        long dataColKey;
        long urlColKey;
        long bytesCountColKey;

        AttachmentColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Attachment");
            this.nameColKey = addColumnDetails("name", "name", objectSchemaInfo);
            this.dataColKey = addColumnDetails("data", "data", objectSchemaInfo);
            this.urlColKey = addColumnDetails("url", "url", objectSchemaInfo);
            this.bytesCountColKey = addColumnDetails("bytesCount", "bytesCount", objectSchemaInfo);
        }

        AttachmentColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new AttachmentColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final AttachmentColumnInfo src = (AttachmentColumnInfo) rawSrc;
            final AttachmentColumnInfo dst = (AttachmentColumnInfo) rawDst;
            dst.nameColKey = src.nameColKey;
            dst.dataColKey = src.dataColKey;
            dst.urlColKey = src.urlColKey;
            dst.bytesCountColKey = src.bytesCountColKey;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private AttachmentColumnInfo columnInfo;
    private ProxyState<com.zamba.testchat.models.Attachment> proxyState;

    com_zamba_testchat_models_AttachmentRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (AttachmentColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.zamba.testchat.models.Attachment>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
    public String realmGet$data() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.dataColKey);
    }

    @Override
    public void realmSet$data(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.dataColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.dataColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dataColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.dataColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$url() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.urlColKey);
    }

    @Override
    public void realmSet$url(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.urlColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.urlColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.urlColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.urlColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$bytesCount() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.bytesCountColKey);
    }

    @Override
    public void realmSet$bytesCount(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.bytesCountColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.bytesCountColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Attachment", 4, 0);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("data", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("url", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("bytesCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static AttachmentColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new AttachmentColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Attachment";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Attachment";
    }

    @SuppressWarnings("cast")
    public static com.zamba.testchat.models.Attachment createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.zamba.testchat.models.Attachment obj = realm.createObjectInternal(com.zamba.testchat.models.Attachment.class, true, excludeFields);

        final com_zamba_testchat_models_AttachmentRealmProxyInterface objProxy = (com_zamba_testchat_models_AttachmentRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("data")) {
            if (json.isNull("data")) {
                objProxy.realmSet$data(null);
            } else {
                objProxy.realmSet$data((String) json.getString("data"));
            }
        }
        if (json.has("url")) {
            if (json.isNull("url")) {
                objProxy.realmSet$url(null);
            } else {
                objProxy.realmSet$url((String) json.getString("url"));
            }
        }
        if (json.has("bytesCount")) {
            if (json.isNull("bytesCount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'bytesCount' to null.");
            } else {
                objProxy.realmSet$bytesCount((long) json.getLong("bytesCount"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.zamba.testchat.models.Attachment createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.zamba.testchat.models.Attachment obj = new com.zamba.testchat.models.Attachment();
        final com_zamba_testchat_models_AttachmentRealmProxyInterface objProxy = (com_zamba_testchat_models_AttachmentRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("data")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$data((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$data(null);
                }
            } else if (name.equals("url")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$url((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$url(null);
                }
            } else if (name.equals("bytesCount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$bytesCount((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'bytesCount' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_zamba_testchat_models_AttachmentRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.zamba.testchat.models.Attachment.class), false, Collections.<String>emptyList());
        io.realm.com_zamba_testchat_models_AttachmentRealmProxy obj = new io.realm.com_zamba_testchat_models_AttachmentRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.zamba.testchat.models.Attachment copyOrUpdate(Realm realm, AttachmentColumnInfo columnInfo, com.zamba.testchat.models.Attachment object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.zamba.testchat.models.Attachment) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.zamba.testchat.models.Attachment copy(Realm realm, AttachmentColumnInfo columnInfo, com.zamba.testchat.models.Attachment newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.zamba.testchat.models.Attachment) cachedRealmObject;
        }

        com_zamba_testchat_models_AttachmentRealmProxyInterface realmObjectSource = (com_zamba_testchat_models_AttachmentRealmProxyInterface) newObject;

        Table table = realm.getTable(com.zamba.testchat.models.Attachment.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.nameColKey, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.dataColKey, realmObjectSource.realmGet$data());
        builder.addString(columnInfo.urlColKey, realmObjectSource.realmGet$url());
        builder.addInteger(columnInfo.bytesCountColKey, realmObjectSource.realmGet$bytesCount());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_zamba_testchat_models_AttachmentRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.zamba.testchat.models.Attachment object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.zamba.testchat.models.Attachment.class);
        long tableNativePtr = table.getNativePtr();
        AttachmentColumnInfo columnInfo = (AttachmentColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Attachment.class);
        long colKey = OsObject.createRow(table);
        cache.put(object, colKey);
        String realmGet$name = ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, colKey, realmGet$name, false);
        }
        String realmGet$data = ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$data();
        if (realmGet$data != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dataColKey, colKey, realmGet$data, false);
        }
        String realmGet$url = ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlColKey, colKey, realmGet$url, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.bytesCountColKey, colKey, ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$bytesCount(), false);
        return colKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.zamba.testchat.models.Attachment.class);
        long tableNativePtr = table.getNativePtr();
        AttachmentColumnInfo columnInfo = (AttachmentColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Attachment.class);
        com.zamba.testchat.models.Attachment object = null;
        while (objects.hasNext()) {
            object = (com.zamba.testchat.models.Attachment) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long colKey = OsObject.createRow(table);
            cache.put(object, colKey);
            String realmGet$name = ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, colKey, realmGet$name, false);
            }
            String realmGet$data = ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$data();
            if (realmGet$data != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.dataColKey, colKey, realmGet$data, false);
            }
            String realmGet$url = ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$url();
            if (realmGet$url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlColKey, colKey, realmGet$url, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.bytesCountColKey, colKey, ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$bytesCount(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.zamba.testchat.models.Attachment object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.zamba.testchat.models.Attachment.class);
        long tableNativePtr = table.getNativePtr();
        AttachmentColumnInfo columnInfo = (AttachmentColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Attachment.class);
        long colKey = OsObject.createRow(table);
        cache.put(object, colKey);
        String realmGet$name = ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, colKey, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, colKey, false);
        }
        String realmGet$data = ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$data();
        if (realmGet$data != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dataColKey, colKey, realmGet$data, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dataColKey, colKey, false);
        }
        String realmGet$url = ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlColKey, colKey, realmGet$url, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.urlColKey, colKey, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.bytesCountColKey, colKey, ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$bytesCount(), false);
        return colKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.zamba.testchat.models.Attachment.class);
        long tableNativePtr = table.getNativePtr();
        AttachmentColumnInfo columnInfo = (AttachmentColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Attachment.class);
        com.zamba.testchat.models.Attachment object = null;
        while (objects.hasNext()) {
            object = (com.zamba.testchat.models.Attachment) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long colKey = OsObject.createRow(table);
            cache.put(object, colKey);
            String realmGet$name = ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, colKey, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, colKey, false);
            }
            String realmGet$data = ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$data();
            if (realmGet$data != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.dataColKey, colKey, realmGet$data, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.dataColKey, colKey, false);
            }
            String realmGet$url = ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$url();
            if (realmGet$url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlColKey, colKey, realmGet$url, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.urlColKey, colKey, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.bytesCountColKey, colKey, ((com_zamba_testchat_models_AttachmentRealmProxyInterface) object).realmGet$bytesCount(), false);
        }
    }

    public static com.zamba.testchat.models.Attachment createDetachedCopy(com.zamba.testchat.models.Attachment realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.zamba.testchat.models.Attachment unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.zamba.testchat.models.Attachment();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.zamba.testchat.models.Attachment) cachedObject.object;
            }
            unmanagedObject = (com.zamba.testchat.models.Attachment) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_zamba_testchat_models_AttachmentRealmProxyInterface unmanagedCopy = (com_zamba_testchat_models_AttachmentRealmProxyInterface) unmanagedObject;
        com_zamba_testchat_models_AttachmentRealmProxyInterface realmSource = (com_zamba_testchat_models_AttachmentRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$data(realmSource.realmGet$data());
        unmanagedCopy.realmSet$url(realmSource.realmGet$url());
        unmanagedCopy.realmSet$bytesCount(realmSource.realmGet$bytesCount());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Attachment = proxy[");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{data:");
        stringBuilder.append(realmGet$data() != null ? realmGet$data() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{url:");
        stringBuilder.append(realmGet$url() != null ? realmGet$url() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bytesCount:");
        stringBuilder.append(realmGet$bytesCount());
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
        long colKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (colKey ^ (colKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_zamba_testchat_models_AttachmentRealmProxy aAttachment = (com_zamba_testchat_models_AttachmentRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aAttachment.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aAttachment.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aAttachment.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
