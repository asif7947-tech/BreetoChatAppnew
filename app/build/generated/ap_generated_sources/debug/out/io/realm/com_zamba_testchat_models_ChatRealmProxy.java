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
public class com_zamba_testchat_models_ChatRealmProxy extends com.zamba.testchat.models.Chat
    implements RealmObjectProxy, com_zamba_testchat_models_ChatRealmProxyInterface {

    static final class ChatColumnInfo extends ColumnInfo {
        long messagesColKey;
        long lastMessageColKey;
        long myIdColKey;
        long chatIdColKey;
        long chatNameColKey;
        long chatImageColKey;
        long chatStatusColKey;
        long timeUpdatedColKey;
        long readColKey;
        long groupColKey;

        ChatColumnInfo(OsSchemaInfo schemaInfo) {
            super(10);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Chat");
            this.messagesColKey = addColumnDetails("messages", "messages", objectSchemaInfo);
            this.lastMessageColKey = addColumnDetails("lastMessage", "lastMessage", objectSchemaInfo);
            this.myIdColKey = addColumnDetails("myId", "myId", objectSchemaInfo);
            this.chatIdColKey = addColumnDetails("chatId", "chatId", objectSchemaInfo);
            this.chatNameColKey = addColumnDetails("chatName", "chatName", objectSchemaInfo);
            this.chatImageColKey = addColumnDetails("chatImage", "chatImage", objectSchemaInfo);
            this.chatStatusColKey = addColumnDetails("chatStatus", "chatStatus", objectSchemaInfo);
            this.timeUpdatedColKey = addColumnDetails("timeUpdated", "timeUpdated", objectSchemaInfo);
            this.readColKey = addColumnDetails("read", "read", objectSchemaInfo);
            this.groupColKey = addColumnDetails("group", "group", objectSchemaInfo);
        }

        ChatColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ChatColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ChatColumnInfo src = (ChatColumnInfo) rawSrc;
            final ChatColumnInfo dst = (ChatColumnInfo) rawDst;
            dst.messagesColKey = src.messagesColKey;
            dst.lastMessageColKey = src.lastMessageColKey;
            dst.myIdColKey = src.myIdColKey;
            dst.chatIdColKey = src.chatIdColKey;
            dst.chatNameColKey = src.chatNameColKey;
            dst.chatImageColKey = src.chatImageColKey;
            dst.chatStatusColKey = src.chatStatusColKey;
            dst.timeUpdatedColKey = src.timeUpdatedColKey;
            dst.readColKey = src.readColKey;
            dst.groupColKey = src.groupColKey;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ChatColumnInfo columnInfo;
    private ProxyState<com.zamba.testchat.models.Chat> proxyState;
    private RealmList<com.zamba.testchat.models.Message> messagesRealmList;

    com_zamba_testchat_models_ChatRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ChatColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.zamba.testchat.models.Chat>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    public RealmList<com.zamba.testchat.models.Message> realmGet$messages() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (messagesRealmList != null) {
            return messagesRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.messagesColKey);
            messagesRealmList = new RealmList<com.zamba.testchat.models.Message>(com.zamba.testchat.models.Message.class, osList, proxyState.getRealm$realm());
            return messagesRealmList;
        }
    }

    @Override
    public void realmSet$messages(RealmList<com.zamba.testchat.models.Message> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("messages")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.zamba.testchat.models.Message> original = value;
                value = new RealmList<com.zamba.testchat.models.Message>();
                for (com.zamba.testchat.models.Message item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.messagesColKey);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.zamba.testchat.models.Message linkedObject = value.get(i);
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
                com.zamba.testchat.models.Message linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        }
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$lastMessage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.lastMessageColKey);
    }

    @Override
    public void realmSet$lastMessage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.lastMessageColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.lastMessageColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.lastMessageColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.lastMessageColKey, value);
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
    public String realmGet$chatId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.chatIdColKey);
    }

    @Override
    public void realmSet$chatId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.chatIdColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.chatIdColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.chatIdColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.chatIdColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$chatName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.chatNameColKey);
    }

    @Override
    public void realmSet$chatName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.chatNameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.chatNameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.chatNameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.chatNameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$chatImage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.chatImageColKey);
    }

    @Override
    public void realmSet$chatImage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.chatImageColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.chatImageColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.chatImageColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.chatImageColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$chatStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.chatStatusColKey);
    }

    @Override
    public void realmSet$chatStatus(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.chatStatusColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.chatStatusColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.chatStatusColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.chatStatusColKey, value);
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
    public boolean realmGet$read() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.readColKey);
    }

    @Override
    public void realmSet$read(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.readColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.readColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$group() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.groupColKey);
    }

    @Override
    public void realmSet$group(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.groupColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.groupColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Chat", 10, 0);
        builder.addPersistedLinkProperty("messages", RealmFieldType.LIST, "Message");
        builder.addPersistedProperty("lastMessage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("myId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("chatId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("chatName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("chatImage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("chatStatus", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("timeUpdated", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("read", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("group", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ChatColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ChatColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Chat";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Chat";
    }

    @SuppressWarnings("cast")
    public static com.zamba.testchat.models.Chat createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        if (json.has("messages")) {
            excludeFields.add("messages");
        }
        com.zamba.testchat.models.Chat obj = realm.createObjectInternal(com.zamba.testchat.models.Chat.class, true, excludeFields);

        final com_zamba_testchat_models_ChatRealmProxyInterface objProxy = (com_zamba_testchat_models_ChatRealmProxyInterface) obj;
        if (json.has("messages")) {
            if (json.isNull("messages")) {
                objProxy.realmSet$messages(null);
            } else {
                objProxy.realmGet$messages().clear();
                JSONArray array = json.getJSONArray("messages");
                for (int i = 0; i < array.length(); i++) {
                    com.zamba.testchat.models.Message item = com_zamba_testchat_models_MessageRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$messages().add(item);
                }
            }
        }
        if (json.has("lastMessage")) {
            if (json.isNull("lastMessage")) {
                objProxy.realmSet$lastMessage(null);
            } else {
                objProxy.realmSet$lastMessage((String) json.getString("lastMessage"));
            }
        }
        if (json.has("myId")) {
            if (json.isNull("myId")) {
                objProxy.realmSet$myId(null);
            } else {
                objProxy.realmSet$myId((String) json.getString("myId"));
            }
        }
        if (json.has("chatId")) {
            if (json.isNull("chatId")) {
                objProxy.realmSet$chatId(null);
            } else {
                objProxy.realmSet$chatId((String) json.getString("chatId"));
            }
        }
        if (json.has("chatName")) {
            if (json.isNull("chatName")) {
                objProxy.realmSet$chatName(null);
            } else {
                objProxy.realmSet$chatName((String) json.getString("chatName"));
            }
        }
        if (json.has("chatImage")) {
            if (json.isNull("chatImage")) {
                objProxy.realmSet$chatImage(null);
            } else {
                objProxy.realmSet$chatImage((String) json.getString("chatImage"));
            }
        }
        if (json.has("chatStatus")) {
            if (json.isNull("chatStatus")) {
                objProxy.realmSet$chatStatus(null);
            } else {
                objProxy.realmSet$chatStatus((String) json.getString("chatStatus"));
            }
        }
        if (json.has("timeUpdated")) {
            if (json.isNull("timeUpdated")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'timeUpdated' to null.");
            } else {
                objProxy.realmSet$timeUpdated((long) json.getLong("timeUpdated"));
            }
        }
        if (json.has("read")) {
            if (json.isNull("read")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'read' to null.");
            } else {
                objProxy.realmSet$read((boolean) json.getBoolean("read"));
            }
        }
        if (json.has("group")) {
            if (json.isNull("group")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'group' to null.");
            } else {
                objProxy.realmSet$group((boolean) json.getBoolean("group"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.zamba.testchat.models.Chat createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.zamba.testchat.models.Chat obj = new com.zamba.testchat.models.Chat();
        final com_zamba_testchat_models_ChatRealmProxyInterface objProxy = (com_zamba_testchat_models_ChatRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("messages")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$messages(null);
                } else {
                    objProxy.realmSet$messages(new RealmList<com.zamba.testchat.models.Message>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.zamba.testchat.models.Message item = com_zamba_testchat_models_MessageRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$messages().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("lastMessage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lastMessage((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$lastMessage(null);
                }
            } else if (name.equals("myId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$myId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$myId(null);
                }
            } else if (name.equals("chatId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$chatId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$chatId(null);
                }
            } else if (name.equals("chatName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$chatName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$chatName(null);
                }
            } else if (name.equals("chatImage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$chatImage((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$chatImage(null);
                }
            } else if (name.equals("chatStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$chatStatus((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$chatStatus(null);
                }
            } else if (name.equals("timeUpdated")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$timeUpdated((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'timeUpdated' to null.");
                }
            } else if (name.equals("read")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$read((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'read' to null.");
                }
            } else if (name.equals("group")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$group((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'group' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_zamba_testchat_models_ChatRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.zamba.testchat.models.Chat.class), false, Collections.<String>emptyList());
        io.realm.com_zamba_testchat_models_ChatRealmProxy obj = new io.realm.com_zamba_testchat_models_ChatRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.zamba.testchat.models.Chat copyOrUpdate(Realm realm, ChatColumnInfo columnInfo, com.zamba.testchat.models.Chat object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.zamba.testchat.models.Chat) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.zamba.testchat.models.Chat copy(Realm realm, ChatColumnInfo columnInfo, com.zamba.testchat.models.Chat newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.zamba.testchat.models.Chat) cachedRealmObject;
        }

        com_zamba_testchat_models_ChatRealmProxyInterface realmObjectSource = (com_zamba_testchat_models_ChatRealmProxyInterface) newObject;

        Table table = realm.getTable(com.zamba.testchat.models.Chat.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.lastMessageColKey, realmObjectSource.realmGet$lastMessage());
        builder.addString(columnInfo.myIdColKey, realmObjectSource.realmGet$myId());
        builder.addString(columnInfo.chatIdColKey, realmObjectSource.realmGet$chatId());
        builder.addString(columnInfo.chatNameColKey, realmObjectSource.realmGet$chatName());
        builder.addString(columnInfo.chatImageColKey, realmObjectSource.realmGet$chatImage());
        builder.addString(columnInfo.chatStatusColKey, realmObjectSource.realmGet$chatStatus());
        builder.addInteger(columnInfo.timeUpdatedColKey, realmObjectSource.realmGet$timeUpdated());
        builder.addBoolean(columnInfo.readColKey, realmObjectSource.realmGet$read());
        builder.addBoolean(columnInfo.groupColKey, realmObjectSource.realmGet$group());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_zamba_testchat_models_ChatRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        RealmList<com.zamba.testchat.models.Message> messagesList = realmObjectSource.realmGet$messages();
        if (messagesList != null) {
            RealmList<com.zamba.testchat.models.Message> messagesRealmList = realmObjectCopy.realmGet$messages();
            messagesRealmList.clear();
            for (int i = 0; i < messagesList.size(); i++) {
                com.zamba.testchat.models.Message messagesItem = messagesList.get(i);
                com.zamba.testchat.models.Message cachemessages = (com.zamba.testchat.models.Message) cache.get(messagesItem);
                if (cachemessages != null) {
                    messagesRealmList.add(cachemessages);
                } else {
                    messagesRealmList.add(com_zamba_testchat_models_MessageRealmProxy.copyOrUpdate(realm, (com_zamba_testchat_models_MessageRealmProxy.MessageColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Message.class), messagesItem, update, cache, flags));
                }
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.zamba.testchat.models.Chat object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.zamba.testchat.models.Chat.class);
        long tableNativePtr = table.getNativePtr();
        ChatColumnInfo columnInfo = (ChatColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Chat.class);
        long colKey = OsObject.createRow(table);
        cache.put(object, colKey);

        RealmList<com.zamba.testchat.models.Message> messagesList = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$messages();
        if (messagesList != null) {
            OsList messagesOsList = new OsList(table.getUncheckedRow(colKey), columnInfo.messagesColKey);
            for (com.zamba.testchat.models.Message messagesItem : messagesList) {
                Long cacheItemIndexmessages = cache.get(messagesItem);
                if (cacheItemIndexmessages == null) {
                    cacheItemIndexmessages = com_zamba_testchat_models_MessageRealmProxy.insert(realm, messagesItem, cache);
                }
                messagesOsList.addRow(cacheItemIndexmessages);
            }
        }
        String realmGet$lastMessage = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$lastMessage();
        if (realmGet$lastMessage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastMessageColKey, colKey, realmGet$lastMessage, false);
        }
        String realmGet$myId = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$myId();
        if (realmGet$myId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.myIdColKey, colKey, realmGet$myId, false);
        }
        String realmGet$chatId = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatId();
        if (realmGet$chatId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.chatIdColKey, colKey, realmGet$chatId, false);
        }
        String realmGet$chatName = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatName();
        if (realmGet$chatName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.chatNameColKey, colKey, realmGet$chatName, false);
        }
        String realmGet$chatImage = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatImage();
        if (realmGet$chatImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.chatImageColKey, colKey, realmGet$chatImage, false);
        }
        String realmGet$chatStatus = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatStatus();
        if (realmGet$chatStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.chatStatusColKey, colKey, realmGet$chatStatus, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.timeUpdatedColKey, colKey, ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$timeUpdated(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.readColKey, colKey, ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$read(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.groupColKey, colKey, ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$group(), false);
        return colKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.zamba.testchat.models.Chat.class);
        long tableNativePtr = table.getNativePtr();
        ChatColumnInfo columnInfo = (ChatColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Chat.class);
        com.zamba.testchat.models.Chat object = null;
        while (objects.hasNext()) {
            object = (com.zamba.testchat.models.Chat) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long colKey = OsObject.createRow(table);
            cache.put(object, colKey);

            RealmList<com.zamba.testchat.models.Message> messagesList = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$messages();
            if (messagesList != null) {
                OsList messagesOsList = new OsList(table.getUncheckedRow(colKey), columnInfo.messagesColKey);
                for (com.zamba.testchat.models.Message messagesItem : messagesList) {
                    Long cacheItemIndexmessages = cache.get(messagesItem);
                    if (cacheItemIndexmessages == null) {
                        cacheItemIndexmessages = com_zamba_testchat_models_MessageRealmProxy.insert(realm, messagesItem, cache);
                    }
                    messagesOsList.addRow(cacheItemIndexmessages);
                }
            }
            String realmGet$lastMessage = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$lastMessage();
            if (realmGet$lastMessage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lastMessageColKey, colKey, realmGet$lastMessage, false);
            }
            String realmGet$myId = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$myId();
            if (realmGet$myId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.myIdColKey, colKey, realmGet$myId, false);
            }
            String realmGet$chatId = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatId();
            if (realmGet$chatId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.chatIdColKey, colKey, realmGet$chatId, false);
            }
            String realmGet$chatName = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatName();
            if (realmGet$chatName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.chatNameColKey, colKey, realmGet$chatName, false);
            }
            String realmGet$chatImage = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatImage();
            if (realmGet$chatImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.chatImageColKey, colKey, realmGet$chatImage, false);
            }
            String realmGet$chatStatus = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatStatus();
            if (realmGet$chatStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.chatStatusColKey, colKey, realmGet$chatStatus, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.timeUpdatedColKey, colKey, ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$timeUpdated(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.readColKey, colKey, ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$read(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.groupColKey, colKey, ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$group(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.zamba.testchat.models.Chat object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.zamba.testchat.models.Chat.class);
        long tableNativePtr = table.getNativePtr();
        ChatColumnInfo columnInfo = (ChatColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Chat.class);
        long colKey = OsObject.createRow(table);
        cache.put(object, colKey);

        OsList messagesOsList = new OsList(table.getUncheckedRow(colKey), columnInfo.messagesColKey);
        RealmList<com.zamba.testchat.models.Message> messagesList = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$messages();
        if (messagesList != null && messagesList.size() == messagesOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = messagesList.size();
            for (int i = 0; i < objects; i++) {
                com.zamba.testchat.models.Message messagesItem = messagesList.get(i);
                Long cacheItemIndexmessages = cache.get(messagesItem);
                if (cacheItemIndexmessages == null) {
                    cacheItemIndexmessages = com_zamba_testchat_models_MessageRealmProxy.insertOrUpdate(realm, messagesItem, cache);
                }
                messagesOsList.setRow(i, cacheItemIndexmessages);
            }
        } else {
            messagesOsList.removeAll();
            if (messagesList != null) {
                for (com.zamba.testchat.models.Message messagesItem : messagesList) {
                    Long cacheItemIndexmessages = cache.get(messagesItem);
                    if (cacheItemIndexmessages == null) {
                        cacheItemIndexmessages = com_zamba_testchat_models_MessageRealmProxy.insertOrUpdate(realm, messagesItem, cache);
                    }
                    messagesOsList.addRow(cacheItemIndexmessages);
                }
            }
        }

        String realmGet$lastMessage = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$lastMessage();
        if (realmGet$lastMessage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastMessageColKey, colKey, realmGet$lastMessage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.lastMessageColKey, colKey, false);
        }
        String realmGet$myId = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$myId();
        if (realmGet$myId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.myIdColKey, colKey, realmGet$myId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.myIdColKey, colKey, false);
        }
        String realmGet$chatId = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatId();
        if (realmGet$chatId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.chatIdColKey, colKey, realmGet$chatId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.chatIdColKey, colKey, false);
        }
        String realmGet$chatName = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatName();
        if (realmGet$chatName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.chatNameColKey, colKey, realmGet$chatName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.chatNameColKey, colKey, false);
        }
        String realmGet$chatImage = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatImage();
        if (realmGet$chatImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.chatImageColKey, colKey, realmGet$chatImage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.chatImageColKey, colKey, false);
        }
        String realmGet$chatStatus = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatStatus();
        if (realmGet$chatStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.chatStatusColKey, colKey, realmGet$chatStatus, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.chatStatusColKey, colKey, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.timeUpdatedColKey, colKey, ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$timeUpdated(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.readColKey, colKey, ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$read(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.groupColKey, colKey, ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$group(), false);
        return colKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.zamba.testchat.models.Chat.class);
        long tableNativePtr = table.getNativePtr();
        ChatColumnInfo columnInfo = (ChatColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Chat.class);
        com.zamba.testchat.models.Chat object = null;
        while (objects.hasNext()) {
            object = (com.zamba.testchat.models.Chat) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long colKey = OsObject.createRow(table);
            cache.put(object, colKey);

            OsList messagesOsList = new OsList(table.getUncheckedRow(colKey), columnInfo.messagesColKey);
            RealmList<com.zamba.testchat.models.Message> messagesList = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$messages();
            if (messagesList != null && messagesList.size() == messagesOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = messagesList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.zamba.testchat.models.Message messagesItem = messagesList.get(i);
                    Long cacheItemIndexmessages = cache.get(messagesItem);
                    if (cacheItemIndexmessages == null) {
                        cacheItemIndexmessages = com_zamba_testchat_models_MessageRealmProxy.insertOrUpdate(realm, messagesItem, cache);
                    }
                    messagesOsList.setRow(i, cacheItemIndexmessages);
                }
            } else {
                messagesOsList.removeAll();
                if (messagesList != null) {
                    for (com.zamba.testchat.models.Message messagesItem : messagesList) {
                        Long cacheItemIndexmessages = cache.get(messagesItem);
                        if (cacheItemIndexmessages == null) {
                            cacheItemIndexmessages = com_zamba_testchat_models_MessageRealmProxy.insertOrUpdate(realm, messagesItem, cache);
                        }
                        messagesOsList.addRow(cacheItemIndexmessages);
                    }
                }
            }

            String realmGet$lastMessage = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$lastMessage();
            if (realmGet$lastMessage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lastMessageColKey, colKey, realmGet$lastMessage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.lastMessageColKey, colKey, false);
            }
            String realmGet$myId = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$myId();
            if (realmGet$myId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.myIdColKey, colKey, realmGet$myId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.myIdColKey, colKey, false);
            }
            String realmGet$chatId = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatId();
            if (realmGet$chatId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.chatIdColKey, colKey, realmGet$chatId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.chatIdColKey, colKey, false);
            }
            String realmGet$chatName = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatName();
            if (realmGet$chatName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.chatNameColKey, colKey, realmGet$chatName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.chatNameColKey, colKey, false);
            }
            String realmGet$chatImage = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatImage();
            if (realmGet$chatImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.chatImageColKey, colKey, realmGet$chatImage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.chatImageColKey, colKey, false);
            }
            String realmGet$chatStatus = ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$chatStatus();
            if (realmGet$chatStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.chatStatusColKey, colKey, realmGet$chatStatus, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.chatStatusColKey, colKey, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.timeUpdatedColKey, colKey, ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$timeUpdated(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.readColKey, colKey, ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$read(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.groupColKey, colKey, ((com_zamba_testchat_models_ChatRealmProxyInterface) object).realmGet$group(), false);
        }
    }

    public static com.zamba.testchat.models.Chat createDetachedCopy(com.zamba.testchat.models.Chat realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.zamba.testchat.models.Chat unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.zamba.testchat.models.Chat();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.zamba.testchat.models.Chat) cachedObject.object;
            }
            unmanagedObject = (com.zamba.testchat.models.Chat) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_zamba_testchat_models_ChatRealmProxyInterface unmanagedCopy = (com_zamba_testchat_models_ChatRealmProxyInterface) unmanagedObject;
        com_zamba_testchat_models_ChatRealmProxyInterface realmSource = (com_zamba_testchat_models_ChatRealmProxyInterface) realmObject;

        // Deep copy of messages
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$messages(null);
        } else {
            RealmList<com.zamba.testchat.models.Message> managedmessagesList = realmSource.realmGet$messages();
            RealmList<com.zamba.testchat.models.Message> unmanagedmessagesList = new RealmList<com.zamba.testchat.models.Message>();
            unmanagedCopy.realmSet$messages(unmanagedmessagesList);
            int nextDepth = currentDepth + 1;
            int size = managedmessagesList.size();
            for (int i = 0; i < size; i++) {
                com.zamba.testchat.models.Message item = com_zamba_testchat_models_MessageRealmProxy.createDetachedCopy(managedmessagesList.get(i), nextDepth, maxDepth, cache);
                unmanagedmessagesList.add(item);
            }
        }
        unmanagedCopy.realmSet$lastMessage(realmSource.realmGet$lastMessage());
        unmanagedCopy.realmSet$myId(realmSource.realmGet$myId());
        unmanagedCopy.realmSet$chatId(realmSource.realmGet$chatId());
        unmanagedCopy.realmSet$chatName(realmSource.realmGet$chatName());
        unmanagedCopy.realmSet$chatImage(realmSource.realmGet$chatImage());
        unmanagedCopy.realmSet$chatStatus(realmSource.realmGet$chatStatus());
        unmanagedCopy.realmSet$timeUpdated(realmSource.realmGet$timeUpdated());
        unmanagedCopy.realmSet$read(realmSource.realmGet$read());
        unmanagedCopy.realmSet$group(realmSource.realmGet$group());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Chat = proxy[");
        stringBuilder.append("{messages:");
        stringBuilder.append("RealmList<Message>[").append(realmGet$messages().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lastMessage:");
        stringBuilder.append(realmGet$lastMessage() != null ? realmGet$lastMessage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{myId:");
        stringBuilder.append(realmGet$myId() != null ? realmGet$myId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{chatId:");
        stringBuilder.append(realmGet$chatId() != null ? realmGet$chatId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{chatName:");
        stringBuilder.append(realmGet$chatName() != null ? realmGet$chatName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{chatImage:");
        stringBuilder.append(realmGet$chatImage() != null ? realmGet$chatImage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{chatStatus:");
        stringBuilder.append(realmGet$chatStatus() != null ? realmGet$chatStatus() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{timeUpdated:");
        stringBuilder.append(realmGet$timeUpdated());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{read:");
        stringBuilder.append(realmGet$read());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{group:");
        stringBuilder.append(realmGet$group());
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
        com_zamba_testchat_models_ChatRealmProxy aChat = (com_zamba_testchat_models_ChatRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aChat.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aChat.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aChat.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
