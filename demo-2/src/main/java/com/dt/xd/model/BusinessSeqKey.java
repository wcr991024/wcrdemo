package com.xinda.model;

public class BusinessSeqKey {
    private String id;

    private String seqCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSeqCode() {
        return seqCode;
    }

    public void setSeqCode(String seqCode) {
        this.seqCode = seqCode == null ? null : seqCode.trim();
    }
}