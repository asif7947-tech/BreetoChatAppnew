package com.zamba.testchat.models;

public class AudioModel {


    private String   audio_url;
    private String   audio_title;

    public AudioModel(String audio_url, String audio_title) {
        this.audio_url = audio_url;
        this.audio_title = audio_title;
    }

    public AudioModel() {

    }

    public String getAudio_url() {
        return audio_url;
    }

    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }

    public String getAudio_title() {
        return audio_title;
    }

    public void setAudio_title(String audio_title) {
        this.audio_title = audio_title;
    }
}
