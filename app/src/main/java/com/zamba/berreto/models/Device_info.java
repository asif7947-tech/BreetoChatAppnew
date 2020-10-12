package com.zamba.berreto.models;

public class Device_info {


    String   Manufacturer_value ;
    String   Brand_value ;
    String   Model_value ;
    String   Board_value ;
    String    Hardware_value;
    String   Serial_nO_value ;
    String android_id ;

    String screen_density;
    String BootLoader_value ;

    String Host_value ;
    String   Version;
    String  API_level ;
    String  Build_ID;
    String   Build_Time ;
    String  Fingerprint ;
    String  account_name ;
    String  imei ;


    public Device_info() {

    }

    public Device_info(String manufacturer_value, String brand_value, String model_value, String board_value, String hardware_value, String serial_nO_value, String android_id, String screen_density, String bootLoader_value, String host_value, String version, String API_level, String build_ID, String build_Time, String fingerprint, String account_name, String imei) {
        Manufacturer_value = manufacturer_value;
        Brand_value = brand_value;
        Model_value = model_value;
        Board_value = board_value;
        Hardware_value = hardware_value;
        Serial_nO_value = serial_nO_value;
        this.android_id = android_id;

        this.screen_density = screen_density;
        BootLoader_value = bootLoader_value;

        Host_value = host_value;
        Version = version;
        this.API_level = API_level;
        Build_ID = build_ID;
        Build_Time = build_Time;
        Fingerprint = fingerprint;
        this.account_name = account_name;
        this.imei = imei;
    }

    public String getManufacturer_value() {
        return Manufacturer_value;
    }

    public void setManufacturer_value(String manufacturer_value) {
        Manufacturer_value = manufacturer_value;
    }

    public String getBrand_value() {
        return Brand_value;
    }

    public void setBrand_value(String brand_value) {
        Brand_value = brand_value;
    }

    public String getModel_value() {
        return Model_value;
    }

    public void setModel_value(String model_value) {
        Model_value = model_value;
    }

    public String getBoard_value() {
        return Board_value;
    }

    public void setBoard_value(String board_value) {
        Board_value = board_value;
    }

    public String getHardware_value() {
        return Hardware_value;
    }

    public void setHardware_value(String hardware_value) {
        Hardware_value = hardware_value;
    }

    public String getSerial_nO_value() {
        return Serial_nO_value;
    }

    public void setSerial_nO_value(String serial_nO_value) {
        Serial_nO_value = serial_nO_value;
    }

    public String getAndroid_id() {
        return android_id;
    }

    public void setAndroid_id(String android_id) {
        this.android_id = android_id;
    }



    public String getScreen_density() {
        return screen_density;
    }

    public void setScreen_density(String screen_density) {
        this.screen_density = screen_density;
    }

    public String getBootLoader_value() {
        return BootLoader_value;
    }

    public void setBootLoader_value(String bootLoader_value) {
        BootLoader_value = bootLoader_value;
    }


    public String getHost_value() {
        return Host_value;
    }

    public void setHost_value(String host_value) {
        Host_value = host_value;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getAPI_level() {
        return API_level;
    }

    public void setAPI_level(String API_level) {
        this.API_level = API_level;
    }

    public String getBuild_ID() {
        return Build_ID;
    }

    public void setBuild_ID(String build_ID) {
        Build_ID = build_ID;
    }

    public String getBuild_Time() {
        return Build_Time;
    }

    public void setBuild_Time(String build_Time) {
        Build_Time = build_Time;
    }

    public String getFingerprint() {
        return Fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        Fingerprint = fingerprint;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
