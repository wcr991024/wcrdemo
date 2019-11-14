package com.xinda.model;

public class ProviderBusiness {
    private String id;

    private Integer serviceMoney;

    private Integer serviceNum;

    private Integer profitMoney;

    private Integer settleMoney;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getServiceMoney() {
        return serviceMoney;
    }

    public void setServiceMoney(Integer serviceMoney) {
        this.serviceMoney = serviceMoney;
    }

    public Integer getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(Integer serviceNum) {
        this.serviceNum = serviceNum;
    }

    public Integer getProfitMoney() {
        return profitMoney;
    }

    public void setProfitMoney(Integer profitMoney) {
        this.profitMoney = profitMoney;
    }

    public Integer getSettleMoney() {
        return settleMoney;
    }

    public void setSettleMoney(Integer settleMoney) {
        this.settleMoney = settleMoney;
    }
}