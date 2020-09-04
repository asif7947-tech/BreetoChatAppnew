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
public class com_zamba_testchat_models_LogCallRealmProxy extends com.zamba.testchat.models.LogCall
    implements RealmObjectProxy, com_zamba_testchat_models_LogCallRealmProxyInterface {

    static final class LogCallColumnInfo extends ColumnInfo {
        long timeUpdatedColKey;
        long timeDurationSecondsColKey;
        long statusColKey;
        long myIdColKey;
        long userIdColKey;
        long userNameColKey;
        long userImageColKey;
        long userStatusColKey;
        long isVideoColKey;

        LogCallColumnInfo(OsSchemaInfo schemaInfo) {
            super(9);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("LogCall");
            this.timeUpdatedColKey = addColumnDetails("timeUpdated", "timeUpdated", objectSchemaInfo);
            this.timeDurationSecondsColKey = addColumnDetails("timeDurationSeconds", "timeDurationSeconds", objectSchemaInfo);
            this.statusColKey = addColumnDetails("status", "status", objectSchemaInfo);
            this.myIdColKey = addColumnDetails("myId", "myId", objectSchemaInfo);
            this.userIdColKey = addColumnDetails("userId", "userId", objectSchemaInfo);
            this.userNameColKey = addColumnDetails("userName", "userName", objectSchemaInfo);
            this.userImageColKey = addColumnDetails("userImage", "userImage", objectSchemaInfo);
            this.userStatusColKey = addColumnDetails("userStatus", "userStatus", objectSchemaInfo);
            this.isVideoColKey = addColumnDetails("isVideo", "isVideo", objectSchemaInfo);
        }

        LogCallColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new LogCallColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final LogCallColumnInfo src = (LogCallColumnInfo) rawSrc;
            final LogCallColumnInfo dst = (LogCallColumnInfo) rawDst;
            dst.timeUpdatedColKey = src.timeUpdatedColKey;
            dst.timeDurationSecondsColKey = src.timeDurationSecondsColKey;
            dst.statusColKey = src.statusColKey;
            dst.myIdColKey = src.myIdColKey;
            dst.userIdColKey = src.userIdColKey;
            dst.userNameColKey = src.userNameColKey;
            dst.userImageColKey = src.userImageColKey;
            dst.userStatusColKey = src.userStatusColKey;
            dst.isVideoColKey = src.isVideoColKey;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private LogCallColumnInfo columnInfo;
    private ProxyState<com.zamba.testchat.models.LogCall> proxyState;

    com_zamba_testchat_models_LogCallRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (LogCallColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.zamba.testchat.models.LogCall>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$timeUpdated() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.timeUpdatedColKey);
    }

    @Override
    public void realmSet$timeUpdated(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.timeUpdatedColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.timeUpdatedColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$timeDurationSeconds() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.timeDurationSecondsColKey);
    }

    @Override
    public void realmSet$timeDurationSeconds(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.timeDurationSecondsColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.timeDurationSecondsColKey, value);
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
    public String realmGet$myId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.myIdColKey);
    }

    @Override
    public void realmSet$myId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.myIdColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.myIdColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.myIdColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.myIdColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$userId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.userIdColKey);
    }

    @Override
    public void realmSet$userId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.userIdColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.userIdColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.userIdColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.userIdColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$userName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.userNameColKey);
    }

    @Override
    public void realmSet$userName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.userNameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.userNameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.userNameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.userNameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$userImage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.userImageColKey);
    }

    @Override
    public void realmSet$userImage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.userImageColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.userImageColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.userImageColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.userImageColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$userStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.userStatusColKey);
    }

    @Override
    public void realmSet$userStatus(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.userStatusColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.userStatusColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.userStatusColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.userStatusColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isVideo() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isVideoColKey);
    }

    @Override
    public void realmSet$isVideo(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isVideoColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isVideoColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("LogCall", 9, 0);
        builder.addPersistedProperty("timeUpdated", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("timeDurationSeconds", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("myId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("userId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("userName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("userImage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("userStatus", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("isVideo", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static LogCallColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new LogCallColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "LogCall";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "LogCall";
    }

    @SuppressWarnings("cast")
    public static com.zamba.testchat.models.LogCall createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.zamba.testchat.models.LogCall obj = realm.createObjectInternal(com.zamba.testchat.models.LogCall.class, true, excludeFields);

        final com_zamba_testchat_models_LogCallRealmProxyInterface objProxy = (com_zamba_testchat_models_LogCallRealmProxyInterface) obj;
        if (json.has("timeUpdated")) {
            if (json.isNull("timeUpdated")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'timeUpdated' to null.");
            } else {
                objProxy.realmSet$timeUpdated((long) json.getLong("timeUpdated"));
            }
        }
        if (json.has("timeDurationSeconds")) {
            if (json.isNull("timeDurationSeconds")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'timeDurationSeconds' to null.");
            } else {
                objProxy.realmSet$timeDurationSeconds((int) json.getInt("timeDurationSeconds"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                objProxy.realmSet$status(null);
            } else {
                objProxy.realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("myId")) {
            if (json.isNull("myId")) {
                objProxy.realmSet$myId(null);
            } else {
                objProxy.realmSet$myId((String) json.getString("myId"));
            }
        }
        if (json.has("userId")) {
            if (json.isNull("userId")) {
                objProxy.realmSet$userId(null);
            } else {
                objProxy.realmSet$userId((String) json.getString("userId"));
            }
        }
        if (json.has("userName")) {
            if (json.isNull("userName")) {
                objProxy.realmSet$userName(null);
            } else {
                objProxy.realmSet$userName((String) json.getString("userName"));
            }
        }
        if (json.has("userImage")) {
            if (json.isNull("userImage")) {
                objProxy.realmSet$userImage(null);
            } else {
                objProxy.realmSet$userImage((String) json.getString("userImage"));
            }
        }
        if (json.has("userStatus")) {
            if (json.isNull("userStatus")) {
                objProxy.realmSet$userStatus(null);
            } else {
                objProxy.realmSet$userStatus((String) json.getString("userStatus"));
            }
        }
        if (json.has("isVideo")) {
            if (json.isNull("isVideo")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isVideo' to null.");
            } else {
                objProxy.realmSet$isVideo((boolean) json.getBoolean("isVideo"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.zamba.testchat.models.LogCall createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.zamba.testchat.models.LogCall obj = new com.zamba.testchat.models.LogCall();
        final com_zamba_testchat_models_LogCallRealmProxyInterface objProxy = (com_zamba_testchat_models_LogCallRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("timeUpdated")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$timeUpdated((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'timeUpdated' to null.");
                }
            } else if (name.equals("timeDurationSeconds")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$timeDurationSeconds((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'timeDurationSeconds' to null.");
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$status(null);
                }
            } else if (name.equals("myId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$myId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$myId(null);
                }
            } else if (name.equals("userId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userId(null);
                }
            } else if (name.equals("userName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userName(null);
                }
            } else if (name.equals("userImage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userImage((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userImage(null);
                }
            } else if (name.equals("userStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userStatus((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userStatus(null);
                }
            } else if (name.equals("isVideo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isVideo((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isVideo' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_zamba_testchat_models_LogCallRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.zamba.testchat.models.LogCall.class), false, Collections.<String>emptyList());
        io.realm.com_zamba_testchat_models_LogCallRealmProxy obj = new io.realm.com_zamba_testchat_models_LogCallRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.zamba.testchat.models.LogCall copyOrUpdate(Realm realm, LogCallColumnInfo columnInfo, com.zamba.testchat.models.LogCall object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.zamba.testchat.models.LogCall) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.zamba.testchat.models.LogCall copy(Realm realm, LogCallColumnInfo columnInfo, com.zamba.testchat.models.LogCall newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.zamba.testchat.models.LogCall) cachedRealmObject;
        }

        com_zamba_testchat_models_LogCallRealmProxyInterface realmObjectSource = (com_zamba_testchat_models_LogCallRealmProxyInterface) newObject;

        Table table = realm.getTable(com.zamba.testchat.models.LogCall.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.timeUpdatedColKey, realmObjectSource.realmGet$timeUpdated());
        builder.addInteger(columnInfo.timeDurationSecondsColKey, realmObjectSource.realmGet$timeDurationSeconds());
        builder.addString(columnInfo.statusColKey, realmObjectSource.realmGet$status());
        builder.addString(columnInfo.myIdColKey, realmObjectSource.realmGet$myId());
        builder.addString(columnInfo.userIdColKey, realmObjectSource.realmGet$userId());
        builder.addString(columnInfo.userNameColKey, realmObjectSource.realmGet$userName());
        builder.addString(columnInfo.userImageColKey, realmObjectSource.realmGet$userImage());
        builder.addString(columnInfo.userStatusColKey, realmObjectSource.realmGet$userStatus());
        builder.addBoolean(columnInfo.isVideoColKey, realmObjectSource.realmGet$isVideo());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_zamba_testchat_models_LogCallRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.zamba.testchat.models.LogCall object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.zamba.testchat.models.LogCall.class);
        long tableNativePtr = table.getNativePtr();
        LogCallColumnInfo columnInfo = (LogCallColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.LogCall.class);
        long colKey = OsObject.createRow(table);
        cache.put(object, colKey);
        Table.nativeSetLong(tableNativePtr, columnInfo.timeUpdatedColKey, colKey, ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$timeUpdated(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.timeDurationSecondsColKey, colKey, ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$timeDurationSeconds(), false);
        String realmGet$status = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, colKey, realmGet$status, false);
        }
        String realmGet$myId = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$myId();
        if (realmGet$myId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.myIdColKey, colKey, realmGet$myId, false);
        }
        String realmGet$userId = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userId();
        if (realmGet$userId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userIdColKey, colKey, realmGet$userId, false);
        }
        String realmGet$userName = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userName();
        if (realmGet$userName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userNameColKey, colKey, realmGet$userName, false);
        }
        String realmGet$userImage = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userImage();
        if (realmGet$userImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userImageColKey, colKey, realmGet$userImage, false);
        }
        String realmGet$userStatus = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userStatus();
        if (realmGet$userStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userStatusColKey, colKey, realmGet$userStatus, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isVideoColKey, colKey, ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$isVideo(), false);
        return colKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.zamba.testchat.models.LogCall.class);
        long tableNativePtr = table.getNativePtr();
        LogCallColumnInfo columnInfo = (LogCallColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.LogCall.class);
        com.zamba.testchat.models.LogCall object = null;
        while (objects.hasNext()) {
            object = (com.zamba.testchat.models.LogCall) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long colKey = OsObject.createRow(table);
            cache.put(object, colKey);
            Table.nativeSetLong(tableNativePtr, columnInfo.timeUpdatedColKey, colKey, ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$timeUpdated(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.timeDurationSecondsColKey, colKey, ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$timeDurationSeconds(), false);
            String realmGet$status = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, colKey, realmGet$status, false);
            }
            String realmGet$myId = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$myId();
            if (realmGet$myId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.myIdColKey, colKey, realmGet$myId, false);
            }
            String realmGet$userId = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userId();
            if (realmGet$userId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userIdColKey, colKey, realmGet$userId, false);
            }
            String realmGet$userName = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userName();
            if (realmGet$userName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userNameColKey, colKey, realmGet$userName, false);
            }
            String realmGet$userImage = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userImage();
            if (realmGet$userImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userImageColKey, colKey, realmGet$userImage, false);
            }
            String realmGet$userStatus = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userStatus();
            if (realmGet$userStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userStatusColKey, colKey, realmGet$userStatus, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isVideoColKey, colKey, ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$isVideo(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.zamba.testchat.models.LogCall object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.zamba.testchat.models.LogCall.class);
        long tableNativePtr = table.getNativePtr();
        LogCallColumnInfo columnInfo = (LogCallColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.LogCall.class);
        long colKey = OsObject.createRow(table);
        cache.put(object, colKey);
        Table.nativeSetLong(tableNativePtr, columnInfo.timeUpdatedColKey, colKey, ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$timeUpdated(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.timeDurationSecondsColKey, colKey, ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$timeDurationSeconds(), false);
        String realmGet$status = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, colKey, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusColKey, colKey, false);
        }
        String realmGet$myId = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$myId();
        if (realmGet$myId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.myIdColKey, colKey, realmGet$myId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.myIdColKey, colKey, false);
        }
        String realmGet$userId = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userId();
        if (realmGet$userId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userIdColKey, colKey, realmGet$userId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userIdColKey, colKey, false);
        }
        String realmGet$userName = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userName();
        if (realmGet$userName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userNameColKey, colKey, realmGet$userName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userNameColKey, colKey, false);
        }
        String realmGet$userImage = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userImage();
        if (realmGet$userImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userImageColKey, colKey, realmGet$userImage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userImageColKey, colKey, false);
        }
        String realmGet$userStatus = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userStatus();
        if (realmGet$userStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userStatusColKey, colKey, realmGet$userStatus, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userStatusColKey, colKey, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isVideoColKey, colKey, ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$isVideo(), false);
        return colKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.zamba.testchat.models.LogCall.class);
        long tableNativePtr = table.getNativePtr();
        LogCallColumnInfo columnInfo = (LogCallColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.LogCall.class);
        com.zamba.testchat.models.LogCall object = null;
        while (objects.hasNext()) {
            object = (com.zamba.testchat.models.LogCall) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long colKey = OsObject.createRow(table);
            cache.put(object, colKey);
            Table.nativeSetLong(tableNativePtr, columnInfo.timeUpdatedColKey, colKey, ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$timeUpdated(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.timeDurationSecondsColKey, colKey, ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$timeDurationSeconds(), false);
            String realmGet$status = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, colKey, realmGet$status, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.statusColKey, colKey, false);
            }
            String realmGet$myId = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$myId();
            if (realmGet$myId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.myIdColKey, colKey, realmGet$myId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.myIdColKey, colKey, false);
            }
            String realmGet$userId = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userId();
            if (realmGet$userId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userIdColKey, colKey, realmGet$userId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.userIdColKey, colKey, false);
            }
            String realmGet$userName = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userName();
            if (realmGet$userName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userNameColKey, colKey, realmGet$userName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.userNameColKey, colKey, false);
            }
            String realmGet$userImage = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userImage();
            if (realmGet$userImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userImageColKey, colKey, realmGet$userImage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.userImageColKey, colKey, false);
            }
            String realmGet$userStatus = ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$userStatus();
            if (realmGet$userStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userStatusColKey, colKey, realmGet$userStatus, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.userStatusColKey, colKey, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isVideoColKey, colKey, ((com_zamba_testchat_models_LogCallRealmProxyInterface) object).realmGet$isVideo(), false);
        }
    }

    public static com.zamba.testchat.models.LogCall createDetachedCopy(com.zamba.testchat.models.LogCall realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.zamba.testchat.models.LogCall unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.zamba.testchat.models.LogCall();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.zamba.testchat.models.LogCall) cachedObject.object;
            }
            unmanagedObject = (com.zamba.testchat.models.LogCall) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_zamba_testchat_models_LogCallRealmProxyInterface unmanagedCopy = (com_zamba_testchat_models_LogCallRealmProxyInterface) unmanagedObject;
        com_zamba_testchat_models_LogCallRealmProxyInterface realmSource = (com_zamba_testchat_models_LogCallRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$timeUpdated(realmSource.realmGet$timeUpdated());
        unmanagedCopy.realmSet$timeDurationSeconds(realmSource.realmGet$timeDurationSeconds());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$myId(realmSource.realmGet$myId());
        unmanagedCopy.realmSet$userId(realmSource.realmGet$userId());
        unmanagedCopy.realmSet$userName(realmSource.realmGet$userName());
        unmanagedCopy.realmSet$userImage(realmSource.realmGet$userImage());
        unmanagedCopy.realmSet$userStatus(realmSource.realmGet$userStatus());
        unmanagedCopy.realmSet$isVideo(realmSource.realmGet$isVideo());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("LogCall = proxy[");
        stringBuilder.append("{timeUpdated:");
        stringBuilder.append(realmGet$timeUpdated());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{timeDurationSeconds:");
        stringBuilder.append(realmGet$timeDurationSeconds());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{myId:");
        stringBuilder.append(realmGet$myId() != null ? realmGet$myId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userId:");
        stringBuilder.append(realmGet$userId() != null ? realmGet$userId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userName:");
        stringBuilder.append(realmGet$userName() != null ? realmGet$userName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userImage:");
        stringBuilder.append(realmGet$userImage() != null ? realmGet$userImage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userStatus:");
        stringBuilder.append(realmGet$userStatus() != null ? realmGet$userStatus() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isVideo:");
        stringBuilder.append(realmGet$isVideo());
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
        com_zamba_testchat_models_LogCallRealmProxy aLogCall = (com_zamba_testchat_models_LogCallRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aLogCall.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aLogCall.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aLogCall.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
