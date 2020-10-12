package com.zamba.berreto.models;

public class DocumentModel {


   private String docs_url;
   private String docs_name;


    public DocumentModel(String docs_url, String docs_name) {
        this.docs_url = docs_url;
        this.docs_name = docs_name;
    }

    public DocumentModel() {

    }

    public String getDocs_url() {
        return docs_url;
    }

    public void setDocs_url(String docs_url) {
        this.docs_url = docs_url;
    }

    public String getDocs_name() {
        return docs_name;
    }

    public void setDocs_name(String docs_name) {
        this.docs_name = docs_name;
    }
}
