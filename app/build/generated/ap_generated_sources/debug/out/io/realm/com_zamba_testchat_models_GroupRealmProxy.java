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
public class com_zamba_testchat_models_GroupRealmProxy extends com.zamba.testchat.models.Group
    implements RealmObjectProxy, com_zamba_testchat_models_GroupRealmProxyInterface {

    static final class GroupColumnInfo extends ColumnInfo {
        long idColKey;
        long nameColKey;
        long statusColKey;
        long imageColKey;
        long userIdsColKey;

        GroupColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Group");
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.nameColKey = addColumnDetails("name", "name", objectSchemaInfo);
            this.statusColKey = addColumnDetails("status", "status", objectSchemaInfo);
            this.imageColKey = addColumnDetails("image", "image", objectSchemaInfo);
            this.userIdsColKey = addColumnDetails("userIds", "userIds", objectSchemaInfo);
        }

        GroupColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new GroupColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final GroupColumnInfo src = (GroupColumnInfo) rawSrc;
            final GroupColumnInfo dst = (GroupColumnInfo) rawDst;
            dst.idColKey = src.idColKey;
            dst.nameColKey = src.nameColKey;
            dst.statusColKey = src.statusColKey;
            dst.imageColKey = src.imageColKey;
            dst.userIdsColKey = src.userIdsColKey;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private GroupColumnInfo columnInfo;
    private ProxyState<com.zamba.testchat.models.Group> proxyState;
    private RealmList<com.zamba.testchat.models.MyString> userIdsRealmList;

    com_zamba_testchat_models_GroupRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (GroupColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.zamba.testchat.models.Group>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
    public RealmList<com.zamba.testchat.models.MyString> realmGet$userIds() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (userIdsRealmList != null) {
            return userIdsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.userIdsColKey);
            userIdsRealmList = new RealmList<com.zamba.testchat.models.MyString>(com.zamba.testchat.models.MyString.class, osList, proxyState.getRealm$realm());
            return userIdsRealmList;
        }
    }

    @Override
    public void realmSet$userIds(RealmList<com.zamba.testchat.models.MyString> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("userIds")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.zamba.testchat.models.MyString> original = value;
                value = new RealmList<com.zamba.testchat.models.MyString>();
                for (com.zamba.testchat.models.MyString item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.userIdsColKey);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.zamba.testchat.models.MyString linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.zamba.testchat.models.MyString linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Group", 5, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("image", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("userIds", RealmFieldType.LIST, "MyString");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static GroupColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new GroupColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Group";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Group";
    }

    @SuppressWarnings("cast")
    public static com.zamba.testchat.models.Group createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.zamba.testchat.models.Group obj = null;
        if (update) {
            Table table = realm.getTable(com.zamba.testchat.models.Group.class);
            GroupColumnInfo columnInfo = (GroupColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Group.class);
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
                    objectContext.set(realm, table.getUncheckedRow(colKey), realm.getSchema().getColumnInfo(com.zamba.testchat.models.Group.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_zamba_testchat_models_GroupRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("userIds")) {
                excludeFields.add("userIds");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_zamba_testchat_models_GroupRealmProxy) realm.createObjectInternal(com.zamba.testchat.models.Group.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_zamba_testchat_models_GroupRealmProxy) realm.createObjectInternal(com.zamba.testchat.models.Group.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_zamba_testchat_models_GroupRealmProxyInterface objProxy = (com_zamba_testchat_models_GroupRealmProxyInterface) obj;
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
        if (json.has("userIds")) {
            if (json.isNull("userIds")) {
                objProxy.realmSet$userIds(null);
            } else {
                objProxy.realmGet$userIds().clear();
                JSONArray array = json.getJSONArray("userIds");
                for (int i = 0; i < array.length(); i++) {
                    com.zamba.testchat.models.MyString item = com_zamba_testchat_models_MyStringRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$userIds().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.zamba.testchat.models.Group createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.zamba.testchat.models.Group obj = new com.zamba.testchat.models.Group();
        final com_zamba_testchat_models_GroupRealmProxyInterface objProxy = (com_zamba_testchat_models_GroupRealmProxyInterface) obj;
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
            } else if (name.equals("userIds")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$userIds(null);
                } else {
                    objProxy.realmSet$userIds(new RealmList<com.zamba.testchat.models.MyString>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.zamba.testchat.models.MyString item = com_zamba_testchat_models_MyStringRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$userIds().add(item);
                    }
                    reader.endArray();
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

    private static com_zamba_testchat_models_GroupRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.zamba.testchat.models.Group.class), false, Collections.<String>emptyList());
        io.realm.com_zamba_testchat_models_GroupRealmProxy obj = new io.realm.com_zamba_testchat_models_GroupRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.zamba.testchat.models.Group copyOrUpdate(Realm realm, GroupColumnInfo columnInfo, com.zamba.testchat.models.Group object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.zamba.testchat.models.Group) cachedRealmObject;
        }

        com.zamba.testchat.models.Group realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.zamba.testchat.models.Group.class);
            long pkColumnKey = columnInfo.idColKey;
            String value = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$id();
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
                    realmObject = new io.realm.com_zamba_testchat_models_GroupRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.zamba.testchat.models.Group copy(Realm realm, GroupColumnInfo columnInfo, com.zamba.testchat.models.Group newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.zamba.testchat.models.Group) cachedRealmObject;
        }

        com_zamba_testchat_models_GroupRealmProxyInterface realmObjectSource = (com_zamba_testchat_models_GroupRealmProxyInterface) newObject;

        Table table = realm.getTable(com.zamba.testchat.models.Group.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nameColKey, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.statusColKey, realmObjectSource.realmGet$status());
        builder.addString(columnInfo.imageColKey, realmObjectSource.realmGet$image());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_zamba_testchat_models_GroupRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        RealmList<com.zamba.testchat.models.MyString> userIdsList = realmObjectSource.realmGet$userIds();
        if (userIdsList != null) {
            RealmList<com.zamba.testchat.models.MyString> userIdsRealmList = realmObjectCopy.realmGet$userIds();
            userIdsRealmList.clear();
            for (int i = 0; i < userIdsList.size(); i++) {
                com.zamba.testchat.models.MyString userIdsItem = userIdsList.get(i);
                com.zamba.testchat.models.MyString cacheuserIds = (com.zamba.testchat.models.MyString) cache.get(userIdsItem);
                if (cacheuserIds != null) {
                    userIdsRealmList.add(cacheuserIds);
                } else {
                    userIdsRealmList.add(com_zamba_testchat_models_MyStringRealmProxy.copyOrUpdate(realm, (com_zamba_testchat_models_MyStringRealmProxy.MyStringColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.MyString.class), userIdsItem, update, cache, flags));
                }
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.zamba.testchat.models.Group object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.zamba.testchat.models.Group.class);
        long tableNativePtr = table.getNativePtr();
        GroupColumnInfo columnInfo = (GroupColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Group.class);
        long pkColumnKey = columnInfo.idColKey;
        String primaryKeyValue = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$id();
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
        String realmGet$name = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, colKey, realmGet$name, false);
        }
        String realmGet$status = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, colKey, realmGet$status, false);
        }
        String realmGet$image = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageColKey, colKey, realmGet$image, false);
        }

        RealmList<com.zamba.testchat.models.MyString> userIdsList = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$userIds();
        if (userIdsList != null) {
            OsList userIdsOsList = new OsList(table.getUncheckedRow(colKey), columnInfo.userIdsColKey);
            for (com.zamba.testchat.models.MyString userIdsItem : userIdsList) {
                Long cacheItemIndexuserIds = cache.get(userIdsItem);
                if (cacheItemIndexuserIds == null) {
                    cacheItemIndexuserIds = com_zamba_testchat_models_MyStringRealmProxy.insert(realm, userIdsItem, cache);
                }
                userIdsOsList.addRow(cacheItemIndexuserIds);
            }
        }
        return colKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.zamba.testchat.models.Group.class);
        long tableNativePtr = table.getNativePtr();
        GroupColumnInfo columnInfo = (GroupColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Group.class);
        long pkColumnKey = columnInfo.idColKey;
        com.zamba.testchat.models.Group object = null;
        while (objects.hasNext()) {
            object = (com.zamba.testchat.models.Group) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$id();
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
            String realmGet$name = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, colKey, realmGet$name, false);
            }
            String realmGet$status = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, colKey, realmGet$status, false);
            }
            String realmGet$image = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$image();
            if (realmGet$image != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.imageColKey, colKey, realmGet$image, false);
            }

            RealmList<com.zamba.testchat.models.MyString> userIdsList = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$userIds();
            if (userIdsList != null) {
                OsList userIdsOsList = new OsList(table.getUncheckedRow(colKey), columnInfo.userIdsColKey);
                for (com.zamba.testchat.models.MyString userIdsItem : userIdsList) {
                    Long cacheItemIndexuserIds = cache.get(userIdsItem);
                    if (cacheItemIndexuserIds == null) {
                        cacheItemIndexuserIds = com_zamba_testchat_models_MyStringRealmProxy.insert(realm, userIdsItem, cache);
                    }
                    userIdsOsList.addRow(cacheItemIndexuserIds);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.zamba.testchat.models.Group object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.zamba.testchat.models.Group.class);
        long tableNativePtr = table.getNativePtr();
        GroupColumnInfo columnInfo = (GroupColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Group.class);
        long pkColumnKey = columnInfo.idColKey;
        String primaryKeyValue = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$id();
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
        String realmGet$name = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, colKey, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, colKey, false);
        }
        String realmGet$status = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, colKey, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusColKey, colKey, false);
        }
        String realmGet$image = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageColKey, colKey, realmGet$image, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.imageColKey, colKey, false);
        }

        OsList userIdsOsList = new OsList(table.getUncheckedRow(colKey), columnInfo.userIdsColKey);
        RealmList<com.zamba.testchat.models.MyString> userIdsList = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$userIds();
        if (userIdsList != null && userIdsList.size() == userIdsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = userIdsList.size();
            for (int i = 0; i < objects; i++) {
                com.zamba.testchat.models.MyString userIdsItem = userIdsList.get(i);
                Long cacheItemIndexuserIds = cache.get(userIdsItem);
                if (cacheItemIndexuserIds == null) {
                    cacheItemIndexuserIds = com_zamba_testchat_models_MyStringRealmProxy.insertOrUpdate(realm, userIdsItem, cache);
                }
                userIdsOsList.setRow(i, cacheItemIndexuserIds);
            }
        } else {
            userIdsOsList.removeAll();
            if (userIdsList != null) {
                for (com.zamba.testchat.models.MyString userIdsItem : userIdsList) {
                    Long cacheItemIndexuserIds = cache.get(userIdsItem);
                    if (cacheItemIndexuserIds == null) {
                        cacheItemIndexuserIds = com_zamba_testchat_models_MyStringRealmProxy.insertOrUpdate(realm, userIdsItem, cache);
                    }
                    userIdsOsList.addRow(cacheItemIndexuserIds);
                }
            }
        }

        return colKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.zamba.testchat.models.Group.class);
        long tableNativePtr = table.getNativePtr();
        GroupColumnInfo columnInfo = (GroupColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Group.class);
        long pkColumnKey = columnInfo.idColKey;
        com.zamba.testchat.models.Group object = null;
        while (objects.hasNext()) {
            object = (com.zamba.testchat.models.Group) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$id();
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
            String realmGet$name = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, colKey, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, colKey, false);
            }
            String realmGet$status = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, colKey, realmGet$status, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.statusColKey, colKey, false);
            }
            String realmGet$image = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$image();
            if (realmGet$image != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.imageColKey, colKey, realmGet$image, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.imageColKey, colKey, false);
            }

            OsList userIdsOsList = new OsList(table.getUncheckedRow(colKey), columnInfo.userIdsColKey);
            RealmList<com.zamba.testchat.models.MyString> userIdsList = ((com_zamba_testchat_models_GroupRealmProxyInterface) object).realmGet$userIds();
            if (userIdsList != null && userIdsList.size() == userIdsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = userIdsList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.zamba.testchat.models.MyString userIdsItem = userIdsList.get(i);
                    Long cacheItemIndexuserIds = cache.get(userIdsItem);
                    if (cacheItemIndexuserIds == null) {
                        cacheItemIndexuserIds = com_zamba_testchat_models_MyStringRealmProxy.insertOrUpdate(realm, userIdsItem, cache);
                    }
                    userIdsOsList.setRow(i, cacheItemIndexuserIds);
                }
            } else {
                userIdsOsList.removeAll();
                if (userIdsList != null) {
                    for (com.zamba.testchat.models.MyString userIdsItem : userIdsList) {
                        Long cacheItemIndexuserIds = cache.get(userIdsItem);
                        if (cacheItemIndexuserIds == null) {
                            cacheItemIndexuserIds = com_zamba_testchat_models_MyStringRealmProxy.insertOrUpdate(realm, userIdsItem, cache);
                        }
                        userIdsOsList.addRow(cacheItemIndexuserIds);
                    }
                }
            }

        }
    }

    public static com.zamba.testchat.models.Group createDetachedCopy(com.zamba.testchat.models.Group realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.zamba.testchat.models.Group unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.zamba.testchat.models.Group();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.zamba.testchat.models.Group) cachedObject.object;
            }
            unmanagedObject = (com.zamba.testchat.models.Group) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_zamba_testchat_models_GroupRealmProxyInterface unmanagedCopy = (com_zamba_testchat_models_GroupRealmProxyInterface) unmanagedObject;
        com_zamba_testchat_models_GroupRealmProxyInterface realmSource = (com_zamba_testchat_models_GroupRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$image(realmSource.realmGet$image());

        // Deep copy of userIds
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$userIds(null);
        } else {
            RealmList<com.zamba.testchat.models.MyString> manageduserIdsList = realmSource.realmGet$userIds();
            RealmList<com.zamba.testchat.models.MyString> unmanageduserIdsList = new RealmList<com.zamba.testchat.models.MyString>();
            unmanagedCopy.realmSet$userIds(unmanageduserIdsList);
            int nextDepth = currentDepth + 1;
            int size = manageduserIdsList.size();
            for (int i = 0; i < size; i++) {
                com.zamba.testchat.models.MyString item = com_zamba_testchat_models_MyStringRealmProxy.createDetachedCopy(manageduserIdsList.get(i), nextDepth, maxDepth, cache);
                unmanageduserIdsList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.zamba.testchat.models.Group update(Realm realm, GroupColumnInfo columnInfo, com.zamba.testchat.models.Group realmObject, com.zamba.testchat.models.Group newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_zamba_testchat_models_GroupRealmProxyInterface realmObjectTarget = (com_zamba_testchat_models_GroupRealmProxyInterface) realmObject;
        com_zamba_testchat_models_GroupRealmProxyInterface realmObjectSource = (com_zamba_testchat_models_GroupRealmProxyInterface) newObject;
        Table table = realm.getTable(com.zamba.testchat.models.Group.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nameColKey, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.statusColKey, realmObjectSource.realmGet$status());
        builder.addString(columnInfo.imageColKey, realmObjectSource.realmGet$image());

        RealmList<com.zamba.testchat.models.MyString> userIdsList = realmObjectSource.realmGet$userIds();
        if (userIdsList != null) {
            RealmList<com.zamba.testchat.models.MyString> userIdsManagedCopy = new RealmList<com.zamba.testchat.models.MyString>();
            for (int i = 0; i < userIdsList.size(); i++) {
                com.zamba.testchat.models.MyString userIdsItem = userIdsList.get(i);
                com.zamba.testchat.models.MyString cacheuserIds = (com.zamba.testchat.models.MyString) cache.get(userIdsItem);
                if (cacheuserIds != null) {
                    userIdsManagedCopy.add(cacheuserIds);
                } else {
                    userIdsManagedCopy.add(com_zamba_testchat_models_MyStringRealmProxy.copyOrUpdate(realm, (com_zamba_testchat_models_MyStringRealmProxy.MyStringColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.MyString.class), userIdsItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.userIdsColKey, userIdsManagedCopy);
        } else {
            builder.addObjectList(columnInfo.userIdsColKey, new RealmList<com.zamba.testchat.models.MyString>());
        }

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Group = proxy[");
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
        stringBuilder.append("{userIds:");
        stringBuilder.append("RealmList<MyString>[").append(realmGet$userIds().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

}
