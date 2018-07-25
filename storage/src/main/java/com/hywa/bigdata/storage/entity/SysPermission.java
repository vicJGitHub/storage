package com.hywa.bigdata.storage.entity;

import java.util.Date;

public class SysPermission {
    private String GUID;

    private String CNAME;

    private String CCODE;

    private String CSTATUS;

    private String CREATEUSER;

    private Date CREATEDATE;

    private String UPDATEUSER;

    private Date UPDATEDATE;

    private String CVER;

    private String REF_SYS_APP;

    private String PARENT_ID;

    private String ICON;

    private Integer SEQ;

    private Boolean ISMENU;

    private String PERMISSION;

    private String DESCRIPTION;

    private String ISPROCESS;

    private String URL;

    public String getGUID() {
        return GUID;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID == null ? null : GUID.trim();
    }

    public String getCNAME() {
        return CNAME;
    }

    public void setCNAME(String CNAME) {
        this.CNAME = CNAME == null ? null : CNAME.trim();
    }

    public String getCCODE() {
        return CCODE;
    }

    public void setCCODE(String CCODE) {
        this.CCODE = CCODE == null ? null : CCODE.trim();
    }

    public String getCSTATUS() {
        return CSTATUS;
    }

    public void setCSTATUS(String CSTATUS) {
        this.CSTATUS = CSTATUS == null ? null : CSTATUS.trim();
    }

    public String getCREATEUSER() {
        return CREATEUSER;
    }

    public void setCREATEUSER(String CREATEUSER) {
        this.CREATEUSER = CREATEUSER == null ? null : CREATEUSER.trim();
    }

    public Date getCREATEDATE() {
        return CREATEDATE;
    }

    public void setCREATEDATE(Date CREATEDATE) {
        this.CREATEDATE = CREATEDATE;
    }

    public String getUPDATEUSER() {
        return UPDATEUSER;
    }

    public void setUPDATEUSER(String UPDATEUSER) {
        this.UPDATEUSER = UPDATEUSER == null ? null : UPDATEUSER.trim();
    }

    public Date getUPDATEDATE() {
        return UPDATEDATE;
    }

    public void setUPDATEDATE(Date UPDATEDATE) {
        this.UPDATEDATE = UPDATEDATE;
    }

    public String getCVER() {
        return CVER;
    }

    public void setCVER(String CVER) {
        this.CVER = CVER == null ? null : CVER.trim();
    }

    public String getREF_SYS_APP() {
        return REF_SYS_APP;
    }

    public void setREF_SYS_APP(String REF_SYS_APP) {
        this.REF_SYS_APP = REF_SYS_APP == null ? null : REF_SYS_APP.trim();
    }

    public String getPARENT_ID() {
        return PARENT_ID;
    }

    public void setPARENT_ID(String PARENT_ID) {
        this.PARENT_ID = PARENT_ID == null ? null : PARENT_ID.trim();
    }

    public String getICON() {
        return ICON;
    }

    public void setICON(String ICON) {
        this.ICON = ICON == null ? null : ICON.trim();
    }

    public Integer getSEQ() {
        return SEQ;
    }

    public void setSEQ(Integer SEQ) {
        this.SEQ = SEQ;
    }

    public Boolean getISMENU() {
        return ISMENU;
    }

    public void setISMENU(Boolean ISMENU) {
        this.ISMENU = ISMENU;
    }

    public String getPERMISSION() {
        return PERMISSION;
    }

    public void setPERMISSION(String PERMISSION) {
        this.PERMISSION = PERMISSION == null ? null : PERMISSION.trim();
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION == null ? null : DESCRIPTION.trim();
    }

    public String getISPROCESS() {
        return ISPROCESS;
    }

    public void setISPROCESS(String ISPROCESS) {
        this.ISPROCESS = ISPROCESS == null ? null : ISPROCESS.trim();
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL == null ? null : URL.trim();
    }
}