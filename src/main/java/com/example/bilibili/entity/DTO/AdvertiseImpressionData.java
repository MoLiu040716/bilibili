package com.example.bilibili.entity.DTO;

public class AdvertiseImpressionData {
    private int id;
    private int impressionNum;
    private int UploadID;

    public int getUploadID() {
        return UploadID;
    }

    public void setUploadID(int uploadID) {
        UploadID = uploadID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImpressionNum() {
        return impressionNum;
    }

    public void setImpressionNum(int impressionNum) {
        this.impressionNum = impressionNum;
    }
}
