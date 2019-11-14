package com.xinda.model;

public class ProductDetail {
    private String id;

    private String img1;

    private String img2;

    private String img3;

    private String content;

    private String serviceDetail;

    private String commonQus;

    private String formModel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1 == null ? null : img1.trim();
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2 == null ? null : img2.trim();
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3 == null ? null : img3.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getServiceDetail() {
        return serviceDetail;
    }

    public void setServiceDetail(String serviceDetail) {
        this.serviceDetail = serviceDetail == null ? null : serviceDetail.trim();
    }

    public String getCommonQus() {
        return commonQus;
    }

    public void setCommonQus(String commonQus) {
        this.commonQus = commonQus == null ? null : commonQus.trim();
    }

    public String getFormModel() {
        return formModel;
    }

    public void setFormModel(String formModel) {
        this.formModel = formModel == null ? null : formModel.trim();
    }
}