
package com.amirht97.myfirstapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("DoItCheck")
    @Expose
    private Boolean doItCheck;
    @SerializedName("UserCreated")
    @Expose
    private Integer userCreated;
    @SerializedName("On_Created")
    @Expose
    private String onCreated;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("SignatureImage")
    @Expose
    private String signatureImage;
    @SerializedName("On_Updated")
    @Expose
    private String onUpdated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDoItCheck() {
        return doItCheck;
    }

    public void setDoItCheck(Boolean doItCheck) {
        this.doItCheck = doItCheck;
    }

    public Integer getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Integer userCreated) {
        this.userCreated = userCreated;
    }

    public String getOnCreated() {
        return onCreated;
    }

    public void setOnCreated(String onCreated) {
        this.onCreated = onCreated;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSignatureImage() {
        return signatureImage;
    }

    public void setSignatureImage(String signatureImage) {
        this.signatureImage = signatureImage;
    }

    public String getOnUpdated() {
        return onUpdated;
    }

    public void setOnUpdated(String onUpdated) {
        this.onUpdated = onUpdated;
    }

}
