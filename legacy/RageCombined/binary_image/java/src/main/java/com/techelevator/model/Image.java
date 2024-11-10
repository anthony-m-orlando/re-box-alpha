package com.techelevator.model;

public class Image {
    private int id;
    private byte[] data;
    private String mediatype;

    public Image(int id, byte[] data, String mediatype){
        this.id = id;
        this.data = data;
        this.mediatype = mediatype;
    }
    public Image(byte[] data, String mediatype) {
        this(-1, data, mediatype);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getMediatype() {
        return mediatype;
    }

    public void setMediatype(String mediatype) {
        this.mediatype = mediatype;
    }
}
