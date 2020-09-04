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
public class com_zamba_testchat_models_MessageRealmProxy extends com.zamba.testchat.models.Message
    implements RealmObjectProxy, com_zamba_testchat_models_MessageRealmProxyInterface {

    static final class MessageColumnInfo extends ColumnInfo {
        long senderNameColKey;
        long senderImageColKey;
        long senderStatusColKey;
        long recipientNameColKey;
        long recipientImageColKey;
        long recipientStatusColKey;
        long bodyColKey;
        long idColKey;
        long recipientIdColKey;
        long senderIdColKey;
        long recipientGroupIdsColKey;
        long dateColKey;
        long deliveredColKey;
        long sentColKey;
        long attachmentTypeColKey;
        long attachmentColKey;

        MessageColumnInfo(OsSchemaInfo schemaInfo) {
            super(16);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Message");
            this.senderNameColKey = addColumnDetails("senderName", "senderName", objectSchemaInfo);
            this.senderImageColKey = addColumnDetails("senderImage", "senderImage", objectSchemaInfo);
            this.senderStatusColKey = addColumnDetails("senderStatus", "senderStatus", objectSchemaInfo);
            this.recipientNameColKey = addColumnDetails("recipientName", "recipientName", objectSchemaInfo);
            this.recipientImageColKey = addColumnDetails("recipientImage", "recipientImage", objectSchemaInfo);
            this.recipientStatusColKey = addColumnDetails("recipientStatus", "recipientStatus", objectSchemaInfo);
            this.bodyColKey = addColumnDetails("body", "body", objectSchemaInfo);
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.recipientIdColKey = addColumnDetails("recipientId", "recipientId", objectSchemaInfo);
            this.senderIdColKey = addColumnDetails("senderId", "senderId", objectSchemaInfo);
            this.recipientGroupIdsColKey = addColumnDetails("recipientGroupIds", "recipientGroupIds", objectSchemaInfo);
            this.dateColKey = addColumnDetails("date", "date", objectSchemaInfo);
            this.deliveredColKey = addColumnDetails("delivered", "delivered", objectSchemaInfo);
            this.sentColKey = addColumnDetails("sent", "sent", objectSchemaInfo);
            this.attachmentTypeColKey = addColumnDetails("attachmentType", "attachmentType", objectSchemaInfo);
            this.attachmentColKey = addColumnDetails("attachment", "attachment", objectSchemaInfo);
        }

        MessageColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MessageColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MessageColumnInfo src = (MessageColumnInfo) rawSrc;
            final MessageColumnInfo dst = (MessageColumnInfo) rawDst;
            dst.senderNameColKey = src.senderNameColKey;
            dst.senderImageColKey = src.senderImageColKey;
            dst.senderStatusColKey = src.senderStatusColKey;
            dst.recipientNameColKey = src.recipientNameColKey;
            dst.recipientImageColKey = src.recipientImageColKey;
            dst.recipientStatusColKey = src.recipientStatusColKey;
            dst.bodyColKey = src.bodyColKey;
            dst.idColKey = src.idColKey;
            dst.recipientIdColKey = src.recipientIdColKey;
            dst.senderIdColKey = src.senderIdColKey;
            dst.recipientGroupIdsColKey = src.recipientGroupIdsColKey;
            dst.dateColKey = src.dateColKey;
            dst.deliveredColKey = src.deliveredColKey;
            dst.sentColKey = src.sentColKey;
            dst.attachmentTypeColKey = src.attachmentTypeColKey;
            dst.attachmentColKey = src.attachmentColKey;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private MessageColumnInfo columnInfo;
    private ProxyState<com.zamba.testchat.models.Message> proxyState;
    private RealmList<com.zamba.testchat.models.MyString> recipientGroupIdsRealmList;

    com_zamba_testchat_models_MessageRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MessageColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.zamba.testchat.models.Message>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$senderName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.senderNameColKey);
    }

    @Override
    public void realmSet$senderName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.senderNameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.senderNameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.senderNameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.senderNameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$senderImage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.senderImageColKey);
    }

    @Override
    public void realmSet$senderImage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.senderImageColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.senderImageColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.senderImageColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.senderImageColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$senderStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.senderStatusColKey);
    }

    @Override
    public void realmSet$senderStatus(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.senderStatusColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.senderStatusColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.senderStatusColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.senderStatusColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$recipientName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.recipientNameColKey);
    }

    @Override
    public void realmSet$recipientName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.recipientNameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.recipientNameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.recipientNameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.recipientNameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$recipientImage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.recipientImageColKey);
    }

    @Override
    public void realmSet$recipientImage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.recipientImageColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.recipientImageColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.recipientImageColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.recipientImageColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$recipientStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.recipientStatusColKey);
    }

    @Override
    public void realmSet$recipientStatus(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.recipientStatusColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.recipientStatusColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.recipientStatusColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.recipientStatusColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$body() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.bodyColKey);
    }

    @Override
    public void realmSet$body(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.bodyColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.bodyColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.bodyColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.bodyColKey, value);
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
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.idColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$recipientId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.recipientIdColKey);
    }

    @Override
    public void realmSet$recipientId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.recipientIdColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.recipientIdColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.recipientIdColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.recipientIdColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$senderId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.senderIdColKey);
    }

    @Override
    public void realmSet$senderId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.senderIdColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.senderIdColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.senderIdColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.senderIdColKey, value);
    }

    @Override
    public RealmList<com.zamba.testchat.models.MyString> realmGet$recipientGroupIds() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (recipientGroupIdsRealmList != null) {
            return recipientGroupIdsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.recipientGroupIdsColKey);
            recipientGroupIdsRealmList = new RealmList<com.zamba.testchat.models.MyString>(com.zamba.testchat.models.MyString.class, osList, proxyState.getRealm$realm());
            return recipientGroupIdsRealmList;
        }
    }

    @Override
    public void realmSet$recipientGroupIds(RealmList<com.zamba.testchat.models.MyString> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("recipientGroupIds")) {
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
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.recipientGroupIdsColKey);
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

    @Override
    @SuppressWarnings("cast")
    public long realmGet$date() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.dateColKey);
    }

    @Override
    public void realmSet$date(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.dateColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.dateColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$delivered() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.deliveredColKey);
    }

    @Override
    public void realmSet$delivered(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.deliveredColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.deliveredColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$sent() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.sentColKey);
    }

    @Override
    public void realmSet$sent(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.sentColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.sentColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$attachmentType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.attachmentTypeColKey);
    }

    @Override
    public void realmSet$attachmentType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.attachmentTypeColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.attachmentTypeColKey, value);
    }

    @Override
    public com.zamba.testchat.models.Attachment realmGet$attachment() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.attachmentColKey)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.zamba.testchat.models.Attachment.class, proxyState.getRow$realm().getLink(columnInfo.attachmentColKey), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$attachment(com.zamba.testchat.models.Attachment value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("attachment")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.attachmentColKey);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.attachmentColKey, row.getObjectKey(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.attachmentColKey);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.attachmentColKey, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Message", 16, 0);
        builder.addPersistedProperty("senderName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("senderImage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("senderStatus", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("recipientName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("recipientImage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("recipientStatus", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("body", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("recipientId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("senderId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("recipientGroupIds", RealmFieldType.LIST, "MyString");
        builder.addPersistedProperty("date", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("delivered", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("sent", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("attachmentType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("attachment", RealmFieldType.OBJECT, "Attachment");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MessageColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new MessageColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Message";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Message";
    }

    @SuppressWarnings("cast")
    public static com.zamba.testchat.models.Message createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        if (json.has("recipientGroupIds")) {
            excludeFields.add("recipientGroupIds");
        }
        if (json.has("attachment")) {
            excludeFields.add("attachment");
        }
        com.zamba.testchat.models.Message obj = realm.createObjectInternal(com.zamba.testchat.models.Message.class, true, excludeFields);

        final com_zamba_testchat_models_MessageRealmProxyInterface objProxy = (com_zamba_testchat_models_MessageRealmProxyInterface) obj;
        if (json.has("senderName")) {
            if (json.isNull("senderName")) {
                objProxy.realmSet$senderName(null);
            } else {
                objProxy.realmSet$senderName((String) json.getString("senderName"));
            }
        }
        if (json.has("senderImage")) {
            if (json.isNull("senderImage")) {
                objProxy.realmSet$senderImage(null);
            } else {
                objProxy.realmSet$senderImage((String) json.getString("senderImage"));
            }
        }
        if (json.has("senderStatus")) {
            if (json.isNull("senderStatus")) {
                objProxy.realmSet$senderStatus(null);
            } else {
                objProxy.realmSet$senderStatus((String) json.getString("senderStatus"));
            }
        }
        if (json.has("recipientName")) {
            if (json.isNull("recipientName")) {
                objProxy.realmSet$recipientName(null);
            } else {
                objProxy.realmSet$recipientName((String) json.getString("recipientName"));
            }
        }
        if (json.has("recipientImage")) {
            if (json.isNull("recipientImage")) {
                objProxy.realmSet$recipientImage(null);
            } else {
                objProxy.realmSet$recipientImage((String) json.getString("recipientImage"));
            }
        }
        if (json.has("recipientStatus")) {
            if (json.isNull("recipientStatus")) {
                objProxy.realmSet$recipientStatus(null);
            } else {
                objProxy.realmSet$recipientStatus((String) json.getString("recipientStatus"));
            }
        }
        if (json.has("body")) {
            if (json.isNull("body")) {
                objProxy.realmSet$body(null);
            } else {
                objProxy.realmSet$body((String) json.getString("body"));
            }
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("recipientId")) {
            if (json.isNull("recipientId")) {
                objProxy.realmSet$recipientId(null);
            } else {
                objProxy.realmSet$recipientId((String) json.getString("recipientId"));
            }
        }
        if (json.has("senderId")) {
            if (json.isNull("senderId")) {
                objProxy.realmSet$senderId(null);
            } else {
                objProxy.realmSet$senderId((String) json.getString("senderId"));
            }
        }
        if (json.has("recipientGroupIds")) {
            if (json.isNull("recipientGroupIds")) {
                objProxy.realmSet$recipientGroupIds(null);
            } else {
                objProxy.realmGet$recipientGroupIds().clear();
                JSONArray array = json.getJSONArray("recipientGroupIds");
                for (int i = 0; i < array.length(); i++) {
                    com.zamba.testchat.models.MyString item = com_zamba_testchat_models_MyStringRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$recipientGroupIds().add(item);
                }
            }
        }
        if (json.has("date")) {
            if (json.isNull("date")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'date' to null.");
            } else {
                objProxy.realmSet$date((long) json.getLong("date"));
            }
        }
        if (json.has("delivered")) {
            if (json.isNull("delivered")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'delivered' to null.");
            } else {
                objProxy.realmSet$delivered((boolean) json.getBoolean("delivered"));
            }
        }
        if (json.has("sent")) {
            if (json.isNull("sent")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'sent' to null.");
            } else {
                objProxy.realmSet$sent((boolean) json.getBoolean("sent"));
            }
        }
        if (json.has("attachmentType")) {
            if (json.isNull("attachmentType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'attachmentType' to null.");
            } else {
                objProxy.realmSet$attachmentType((int) json.getInt("attachmentType"));
            }
        }
        if (json.has("attachment")) {
            if (json.isNull("attachment")) {
                objProxy.realmSet$attachment(null);
            } else {
                com.zamba.testchat.models.Attachment attachmentObj = com_zamba_testchat_models_AttachmentRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("attachment"), update);
                objProxy.realmSet$attachment(attachmentObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.zamba.testchat.models.Message createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.zamba.testchat.models.Message obj = new com.zamba.testchat.models.Message();
        final com_zamba_testchat_models_MessageRealmProxyInterface objProxy = (com_zamba_testchat_models_MessageRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("senderName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$senderName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$senderName(null);
                }
            } else if (name.equals("senderImage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$senderImage((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$senderImage(null);
                }
            } else if (name.equals("senderStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$senderStatus((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$senderStatus(null);
                }
            } else if (name.equals("recipientName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$recipientName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$recipientName(null);
                }
            } else if (name.equals("recipientImage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$recipientImage((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$recipientImage(null);
                }
            } else if (name.equals("recipientStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$recipientStatus((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$recipientStatus(null);
                }
            } else if (name.equals("body")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$body((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$body(null);
                }
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else if (name.equals("recipientId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$recipientId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$recipientId(null);
                }
            } else if (name.equals("senderId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$senderId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$senderId(null);
                }
            } else if (name.equals("recipientGroupIds")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$recipientGroupIds(null);
                } else {
                    objProxy.realmSet$recipientGroupIds(new RealmList<com.zamba.testchat.models.MyString>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.zamba.testchat.models.MyString item = com_zamba_testchat_models_MyStringRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$recipientGroupIds().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("date")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$date((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'date' to null.");
                }
            } else if (name.equals("delivered")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$delivered((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'delivered' to null.");
                }
            } else if (name.equals("sent")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sent((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'sent' to null.");
                }
            } else if (name.equals("attachmentType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$attachmentType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'attachmentType' to null.");
                }
            } else if (name.equals("attachment")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$attachment(null);
                } else {
                    com.zamba.testchat.models.Attachment attachmentObj = com_zamba_testchat_models_AttachmentRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$attachment(attachmentObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_zamba_testchat_models_MessageRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.zamba.testchat.models.Message.class), false, Collections.<String>emptyList());
        io.realm.com_zamba_testchat_models_MessageRealmProxy obj = new io.realm.com_zamba_testchat_models_MessageRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.zamba.testchat.models.Message copyOrUpdate(Realm realm, MessageColumnInfo columnInfo, com.zamba.testchat.models.Message object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.zamba.testchat.models.Message) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.zamba.testchat.models.Message copy(Realm realm, MessageColumnInfo columnInfo, com.zamba.testchat.models.Message newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.zamba.testchat.models.Message) cachedRealmObject;
        }

        com_zamba_testchat_models_MessageRealmProxyInterface realmObjectSource = (com_zamba_testchat_models_MessageRealmProxyInterface) newObject;

        Table table = realm.getTable(com.zamba.testchat.models.Message.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.senderNameColKey, realmObjectSource.realmGet$senderName());
        builder.addString(columnInfo.senderImageColKey, realmObjectSource.realmGet$senderImage());
        builder.addString(columnInfo.senderStatusColKey, realmObjectSource.realmGet$senderStatus());
        builder.addString(columnInfo.recipientNameColKey, realmObjectSource.realmGet$recipientName());
        builder.addString(columnInfo.recipientImageColKey, realmObjectSource.realmGet$recipientImage());
        builder.addString(columnInfo.recipientStatusColKey, realmObjectSource.realmGet$recipientStatus());
        builder.addString(columnInfo.bodyColKey, realmObjectSource.realmGet$body());
        builder.addString(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.recipientIdColKey, realmObjectSource.realmGet$recipientId());
        builder.addString(columnInfo.senderIdColKey, realmObjectSource.realmGet$senderId());
        builder.addInteger(columnInfo.dateColKey, realmObjectSource.realmGet$date());
        builder.addBoolean(columnInfo.deliveredColKey, realmObjectSource.realmGet$delivered());
        builder.addBoolean(columnInfo.sentColKey, realmObjectSource.realmGet$sent());
        builder.addInteger(columnInfo.attachmentTypeColKey, realmObjectSource.realmGet$attachmentType());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_zamba_testchat_models_MessageRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        RealmList<com.zamba.testchat.models.MyString> recipientGroupIdsList = realmObjectSource.realmGet$recipientGroupIds();
        if (recipientGroupIdsList != null) {
            RealmList<com.zamba.testchat.models.MyString> recipientGroupIdsRealmList = realmObjectCopy.realmGet$recipientGroupIds();
            recipientGroupIdsRealmList.clear();
            for (int i = 0; i < recipientGroupIdsList.size(); i++) {
                com.zamba.testchat.models.MyString recipientGroupIdsItem = recipientGroupIdsList.get(i);
                com.zamba.testchat.models.MyString cacherecipientGroupIds = (com.zamba.testchat.models.MyString) cache.get(recipientGroupIdsItem);
                if (cacherecipientGroupIds != null) {
                    recipientGroupIdsRealmList.add(cacherecipientGroupIds);
                } else {
                    recipientGroupIdsRealmList.add(com_zamba_testchat_models_MyStringRealmProxy.copyOrUpdate(realm, (com_zamba_testchat_models_MyStringRealmProxy.MyStringColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.MyString.class), recipientGroupIdsItem, update, cache, flags));
                }
            }
        }

        com.zamba.testchat.models.Attachment attachmentObj = realmObjectSource.realmGet$attachment();
        if (attachmentObj == null) {
            realmObjectCopy.realmSet$attachment(null);
        } else {
            com.zamba.testchat.models.Attachment cacheattachment = (com.zamba.testchat.models.Attachment) cache.get(attachmentObj);
            if (cacheattachment != null) {
                realmObjectCopy.realmSet$attachment(cacheattachment);
            } else {
                realmObjectCopy.realmSet$attachment(com_zamba_testchat_models_AttachmentRealmProxy.copyOrUpdate(realm, (com_zamba_testchat_models_AttachmentRealmProxy.AttachmentColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Attachment.class), attachmentObj, update, cache, flags));
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.zamba.testchat.models.Message object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.zamba.testchat.models.Message.class);
        long tableNativePtr = table.getNativePtr();
        MessageColumnInfo columnInfo = (MessageColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Message.class);
        long colKey = OsObject.createRow(table);
        cache.put(object, colKey);
        String realmGet$senderName = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderName();
        if (realmGet$senderName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.senderNameColKey, colKey, realmGet$senderName, false);
        }
        String realmGet$senderImage = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderImage();
        if (realmGet$senderImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.senderImageColKey, colKey, realmGet$senderImage, false);
        }
        String realmGet$senderStatus = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderStatus();
        if (realmGet$senderStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.senderStatusColKey, colKey, realmGet$senderStatus, false);
        }
        String realmGet$recipientName = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientName();
        if (realmGet$recipientName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.recipientNameColKey, colKey, realmGet$recipientName, false);
        }
        String realmGet$recipientImage = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientImage();
        if (realmGet$recipientImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.recipientImageColKey, colKey, realmGet$recipientImage, false);
        }
        String realmGet$recipientStatus = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientStatus();
        if (realmGet$recipientStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.recipientStatusColKey, colKey, realmGet$recipientStatus, false);
        }
        String realmGet$body = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$body();
        if (realmGet$body != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.bodyColKey, colKey, realmGet$body, false);
        }
        String realmGet$id = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idColKey, colKey, realmGet$id, false);
        }
        String realmGet$recipientId = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientId();
        if (realmGet$recipientId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.recipientIdColKey, colKey, realmGet$recipientId, false);
        }
        String realmGet$senderId = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderId();
        if (realmGet$senderId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.senderIdColKey, colKey, realmGet$senderId, false);
        }

        RealmList<com.zamba.testchat.models.MyString> recipientGroupIdsList = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientGroupIds();
        if (recipientGroupIdsList != null) {
            OsList recipientGroupIdsOsList = new OsList(table.getUncheckedRow(colKey), columnInfo.recipientGroupIdsColKey);
            for (com.zamba.testchat.models.MyString recipientGroupIdsItem : recipientGroupIdsList) {
                Long cacheItemIndexrecipientGroupIds = cache.get(recipientGroupIdsItem);
                if (cacheItemIndexrecipientGroupIds == null) {
                    cacheItemIndexrecipientGroupIds = com_zamba_testchat_models_MyStringRealmProxy.insert(realm, recipientGroupIdsItem, cache);
                }
                recipientGroupIdsOsList.addRow(cacheItemIndexrecipientGroupIds);
            }
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.dateColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$date(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.deliveredColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$delivered(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.sentColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$sent(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.attachmentTypeColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$attachmentType(), false);

        com.zamba.testchat.models.Attachment attachmentObj = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$attachment();
        if (attachmentObj != null) {
            Long cacheattachment = cache.get(attachmentObj);
            if (cacheattachment == null) {
                cacheattachment = com_zamba_testchat_models_AttachmentRealmProxy.insert(realm, attachmentObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.attachmentColKey, colKey, cacheattachment, false);
        }
        return colKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.zamba.testchat.models.Message.class);
        long tableNativePtr = table.getNativePtr();
        MessageColumnInfo columnInfo = (MessageColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Message.class);
        com.zamba.testchat.models.Message object = null;
        while (objects.hasNext()) {
            object = (com.zamba.testchat.models.Message) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long colKey = OsObject.createRow(table);
            cache.put(object, colKey);
            String realmGet$senderName = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderName();
            if (realmGet$senderName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.senderNameColKey, colKey, realmGet$senderName, false);
            }
            String realmGet$senderImage = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderImage();
            if (realmGet$senderImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.senderImageColKey, colKey, realmGet$senderImage, false);
            }
            String realmGet$senderStatus = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderStatus();
            if (realmGet$senderStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.senderStatusColKey, colKey, realmGet$senderStatus, false);
            }
            String realmGet$recipientName = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientName();
            if (realmGet$recipientName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.recipientNameColKey, colKey, realmGet$recipientName, false);
            }
            String realmGet$recipientImage = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientImage();
            if (realmGet$recipientImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.recipientImageColKey, colKey, realmGet$recipientImage, false);
            }
            String realmGet$recipientStatus = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientStatus();
            if (realmGet$recipientStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.recipientStatusColKey, colKey, realmGet$recipientStatus, false);
            }
            String realmGet$body = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$body();
            if (realmGet$body != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.bodyColKey, colKey, realmGet$body, false);
            }
            String realmGet$id = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idColKey, colKey, realmGet$id, false);
            }
            String realmGet$recipientId = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientId();
            if (realmGet$recipientId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.recipientIdColKey, colKey, realmGet$recipientId, false);
            }
            String realmGet$senderId = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderId();
            if (realmGet$senderId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.senderIdColKey, colKey, realmGet$senderId, false);
            }

            RealmList<com.zamba.testchat.models.MyString> recipientGroupIdsList = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientGroupIds();
            if (recipientGroupIdsList != null) {
                OsList recipientGroupIdsOsList = new OsList(table.getUncheckedRow(colKey), columnInfo.recipientGroupIdsColKey);
                for (com.zamba.testchat.models.MyString recipientGroupIdsItem : recipientGroupIdsList) {
                    Long cacheItemIndexrecipientGroupIds = cache.get(recipientGroupIdsItem);
                    if (cacheItemIndexrecipientGroupIds == null) {
                        cacheItemIndexrecipientGroupIds = com_zamba_testchat_models_MyStringRealmProxy.insert(realm, recipientGroupIdsItem, cache);
                    }
                    recipientGroupIdsOsList.addRow(cacheItemIndexrecipientGroupIds);
                }
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.dateColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$date(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.deliveredColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$delivered(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.sentColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$sent(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.attachmentTypeColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$attachmentType(), false);

            com.zamba.testchat.models.Attachment attachmentObj = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$attachment();
            if (attachmentObj != null) {
                Long cacheattachment = cache.get(attachmentObj);
                if (cacheattachment == null) {
                    cacheattachment = com_zamba_testchat_models_AttachmentRealmProxy.insert(realm, attachmentObj, cache);
                }
                table.setLink(columnInfo.attachmentColKey, colKey, cacheattachment, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.zamba.testchat.models.Message object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.zamba.testchat.models.Message.class);
        long tableNativePtr = table.getNativePtr();
        MessageColumnInfo columnInfo = (MessageColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Message.class);
        long colKey = OsObject.createRow(table);
        cache.put(object, colKey);
        String realmGet$senderName = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderName();
        if (realmGet$senderName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.senderNameColKey, colKey, realmGet$senderName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.senderNameColKey, colKey, false);
        }
        String realmGet$senderImage = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderImage();
        if (realmGet$senderImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.senderImageColKey, colKey, realmGet$senderImage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.senderImageColKey, colKey, false);
        }
        String realmGet$senderStatus = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderStatus();
        if (realmGet$senderStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.senderStatusColKey, colKey, realmGet$senderStatus, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.senderStatusColKey, colKey, false);
        }
        String realmGet$recipientName = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientName();
        if (realmGet$recipientName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.recipientNameColKey, colKey, realmGet$recipientName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.recipientNameColKey, colKey, false);
        }
        String realmGet$recipientImage = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientImage();
        if (realmGet$recipientImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.recipientImageColKey, colKey, realmGet$recipientImage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.recipientImageColKey, colKey, false);
        }
        String realmGet$recipientStatus = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientStatus();
        if (realmGet$recipientStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.recipientStatusColKey, colKey, realmGet$recipientStatus, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.recipientStatusColKey, colKey, false);
        }
        String realmGet$body = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$body();
        if (realmGet$body != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.bodyColKey, colKey, realmGet$body, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.bodyColKey, colKey, false);
        }
        String realmGet$id = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idColKey, colKey, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idColKey, colKey, false);
        }
        String realmGet$recipientId = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientId();
        if (realmGet$recipientId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.recipientIdColKey, colKey, realmGet$recipientId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.recipientIdColKey, colKey, false);
        }
        String realmGet$senderId = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderId();
        if (realmGet$senderId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.senderIdColKey, colKey, realmGet$senderId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.senderIdColKey, colKey, false);
        }

        OsList recipientGroupIdsOsList = new OsList(table.getUncheckedRow(colKey), columnInfo.recipientGroupIdsColKey);
        RealmList<com.zamba.testchat.models.MyString> recipientGroupIdsList = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientGroupIds();
        if (recipientGroupIdsList != null && recipientGroupIdsList.size() == recipientGroupIdsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = recipientGroupIdsList.size();
            for (int i = 0; i < objects; i++) {
                com.zamba.testchat.models.MyString recipientGroupIdsItem = recipientGroupIdsList.get(i);
                Long cacheItemIndexrecipientGroupIds = cache.get(recipientGroupIdsItem);
                if (cacheItemIndexrecipientGroupIds == null) {
                    cacheItemIndexrecipientGroupIds = com_zamba_testchat_models_MyStringRealmProxy.insertOrUpdate(realm, recipientGroupIdsItem, cache);
                }
                recipientGroupIdsOsList.setRow(i, cacheItemIndexrecipientGroupIds);
            }
        } else {
            recipientGroupIdsOsList.removeAll();
            if (recipientGroupIdsList != null) {
                for (com.zamba.testchat.models.MyString recipientGroupIdsItem : recipientGroupIdsList) {
                    Long cacheItemIndexrecipientGroupIds = cache.get(recipientGroupIdsItem);
                    if (cacheItemIndexrecipientGroupIds == null) {
                        cacheItemIndexrecipientGroupIds = com_zamba_testchat_models_MyStringRealmProxy.insertOrUpdate(realm, recipientGroupIdsItem, cache);
                    }
                    recipientGroupIdsOsList.addRow(cacheItemIndexrecipientGroupIds);
                }
            }
        }

        Table.nativeSetLong(tableNativePtr, columnInfo.dateColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$date(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.deliveredColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$delivered(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.sentColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$sent(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.attachmentTypeColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$attachmentType(), false);

        com.zamba.testchat.models.Attachment attachmentObj = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$attachment();
        if (attachmentObj != null) {
            Long cacheattachment = cache.get(attachmentObj);
            if (cacheattachment == null) {
                cacheattachment = com_zamba_testchat_models_AttachmentRealmProxy.insertOrUpdate(realm, attachmentObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.attachmentColKey, colKey, cacheattachment, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.attachmentColKey, colKey);
        }
        return colKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.zamba.testchat.models.Message.class);
        long tableNativePtr = table.getNativePtr();
        MessageColumnInfo columnInfo = (MessageColumnInfo) realm.getSchema().getColumnInfo(com.zamba.testchat.models.Message.class);
        com.zamba.testchat.models.Message object = null;
        while (objects.hasNext()) {
            object = (com.zamba.testchat.models.Message) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long colKey = OsObject.createRow(table);
            cache.put(object, colKey);
            String realmGet$senderName = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderName();
            if (realmGet$senderName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.senderNameColKey, colKey, realmGet$senderName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.senderNameColKey, colKey, false);
            }
            String realmGet$senderImage = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderImage();
            if (realmGet$senderImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.senderImageColKey, colKey, realmGet$senderImage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.senderImageColKey, colKey, false);
            }
            String realmGet$senderStatus = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderStatus();
            if (realmGet$senderStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.senderStatusColKey, colKey, realmGet$senderStatus, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.senderStatusColKey, colKey, false);
            }
            String realmGet$recipientName = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientName();
            if (realmGet$recipientName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.recipientNameColKey, colKey, realmGet$recipientName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.recipientNameColKey, colKey, false);
            }
            String realmGet$recipientImage = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientImage();
            if (realmGet$recipientImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.recipientImageColKey, colKey, realmGet$recipientImage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.recipientImageColKey, colKey, false);
            }
            String realmGet$recipientStatus = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientStatus();
            if (realmGet$recipientStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.recipientStatusColKey, colKey, realmGet$recipientStatus, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.recipientStatusColKey, colKey, false);
            }
            String realmGet$body = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$body();
            if (realmGet$body != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.bodyColKey, colKey, realmGet$body, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.bodyColKey, colKey, false);
            }
            String realmGet$id = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idColKey, colKey, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idColKey, colKey, false);
            }
            String realmGet$recipientId = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientId();
            if (realmGet$recipientId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.recipientIdColKey, colKey, realmGet$recipientId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.recipientIdColKey, colKey, false);
            }
            String realmGet$senderId = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$senderId();
            if (realmGet$senderId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.senderIdColKey, colKey, realmGet$senderId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.senderIdColKey, colKey, false);
            }

            OsList recipientGroupIdsOsList = new OsList(table.getUncheckedRow(colKey), columnInfo.recipientGroupIdsColKey);
            RealmList<com.zamba.testchat.models.MyString> recipientGroupIdsList = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$recipientGroupIds();
            if (recipientGroupIdsList != null && recipientGroupIdsList.size() == recipientGroupIdsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = recipientGroupIdsList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.zamba.testchat.models.MyString recipientGroupIdsItem = recipientGroupIdsList.get(i);
                    Long cacheItemIndexrecipientGroupIds = cache.get(recipientGroupIdsItem);
                    if (cacheItemIndexrecipientGroupIds == null) {
                        cacheItemIndexrecipientGroupIds = com_zamba_testchat_models_MyStringRealmProxy.insertOrUpdate(realm, recipientGroupIdsItem, cache);
                    }
                    recipientGroupIdsOsList.setRow(i, cacheItemIndexrecipientGroupIds);
                }
            } else {
                recipientGroupIdsOsList.removeAll();
                if (recipientGroupIdsList != null) {
                    for (com.zamba.testchat.models.MyString recipientGroupIdsItem : recipientGroupIdsList) {
                        Long cacheItemIndexrecipientGroupIds = cache.get(recipientGroupIdsItem);
                        if (cacheItemIndexrecipientGroupIds == null) {
                            cacheItemIndexrecipientGroupIds = com_zamba_testchat_models_MyStringRealmProxy.insertOrUpdate(realm, recipientGroupIdsItem, cache);
                        }
                        recipientGroupIdsOsList.addRow(cacheItemIndexrecipientGroupIds);
                    }
                }
            }

            Table.nativeSetLong(tableNativePtr, columnInfo.dateColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$date(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.deliveredColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$delivered(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.sentColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$sent(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.attachmentTypeColKey, colKey, ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$attachmentType(), false);

            com.zamba.testchat.models.Attachment attachmentObj = ((com_zamba_testchat_models_MessageRealmProxyInterface) object).realmGet$attachment();
            if (attachmentObj != null) {
                Long cacheattachment = cache.get(attachmentObj);
                if (cacheattachment == null) {
                    cacheattachment = com_zamba_testchat_models_AttachmentRealmProxy.insertOrUpdate(realm, attachmentObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.attachmentColKey, colKey, cacheattachment, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.attachmentColKey, colKey);
            }
        }
    }

    public static com.zamba.testchat.models.Message createDetachedCopy(com.zamba.testchat.models.Message realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.zamba.testchat.models.Message unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.zamba.testchat.models.Message();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.zamba.testchat.models.Message) cachedObject.object;
            }
            unmanagedObject = (com.zamba.testchat.models.Message) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_zamba_testchat_models_MessageRealmProxyInterface unmanagedCopy = (com_zamba_testchat_models_MessageRealmProxyInterface) unmanagedObject;
        com_zamba_testchat_models_MessageRealmProxyInterface realmSource = (com_zamba_testchat_models_MessageRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$senderName(realmSource.realmGet$senderName());
        unmanagedCopy.realmSet$senderImage(realmSource.realmGet$senderImage());
        unmanagedCopy.realmSet$senderStatus(realmSource.realmGet$senderStatus());
        unmanagedCopy.realmSet$recipientName(realmSource.realmGet$recipientName());
        unmanagedCopy.realmSet$recipientImage(realmSource.realmGet$recipientImage());
        unmanagedCopy.realmSet$recipientStatus(realmSource.realmGet$recipientStatus());
        unmanagedCopy.realmSet$body(realmSource.realmGet$body());
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$recipientId(realmSource.realmGet$recipientId());
        unmanagedCopy.realmSet$senderId(realmSource.realmGet$senderId());

        // Deep copy of recipientGroupIds
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$recipientGroupIds(null);
        } else {
            RealmList<com.zamba.testchat.models.MyString> managedrecipientGroupIdsList = realmSource.realmGet$recipientGroupIds();
            RealmList<com.zamba.testchat.models.MyString> unmanagedrecipientGroupIdsList = new RealmList<com.zamba.testchat.models.MyString>();
            unmanagedCopy.realmSet$recipientGroupIds(unmanagedrecipientGroupIdsList);
            int nextDepth = currentDepth + 1;
            int size = managedrecipientGroupIdsList.size();
            for (int i = 0; i < size; i++) {
                com.zamba.testchat.models.MyString item = com_zamba_testchat_models_MyStringRealmProxy.createDetachedCopy(managedrecipientGroupIdsList.get(i), nextDepth, maxDepth, cache);
                unmanagedrecipientGroupIdsList.add(item);
            }
        }
        unmanagedCopy.realmSet$date(realmSource.realmGet$date());
        unmanagedCopy.realmSet$delivered(realmSource.realmGet$delivered());
        unmanagedCopy.realmSet$sent(realmSource.realmGet$sent());
        unmanagedCopy.realmSet$attachmentType(realmSource.realmGet$attachmentType());

        // Deep copy of attachment
        unmanagedCopy.realmSet$attachment(com_zamba_testchat_models_AttachmentRealmProxy.createDetachedCopy(realmSource.realmGet$attachment(), currentDepth + 1, maxDepth, cache));

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Message = proxy[");
        stringBuilder.append("{senderName:");
        stringBuilder.append(realmGet$senderName() != null ? realmGet$senderName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{senderImage:");
        stringBuilder.append(realmGet$senderImage() != null ? realmGet$senderImage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{senderStatus:");
        stringBuilder.append(realmGet$senderStatus() != null ? realmGet$senderStatus() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{recipientName:");
        stringBuilder.append(realmGet$recipientName() != null ? realmGet$recipientName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{recipientImage:");
        stringBuilder.append(realmGet$recipientImage() != null ? realmGet$recipientImage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{recipientStatus:");
        stringBuilder.append(realmGet$recipientStatus() != null ? realmGet$recipientStatus() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{body:");
        stringBuilder.append(realmGet$body() != null ? realmGet$body() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{recipientId:");
        stringBuilder.append(realmGet$recipientId() != null ? realmGet$recipientId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{senderId:");
        stringBuilder.append(realmGet$senderId() != null ? realmGet$senderId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{recipientGroupIds:");
        stringBuilder.append("RealmList<MyString>[").append(realmGet$recipientGroupIds().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{date:");
        stringBuilder.append(realmGet$date());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{delivered:");
        stringBuilder.append(realmGet$delivered());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sent:");
        stringBuilder.append(realmGet$sent());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{attachmentType:");
        stringBuilder.append(realmGet$attachmentType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{attachment:");
        stringBuilder.append(realmGet$attachment() != null ? "Attachment" : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

}
