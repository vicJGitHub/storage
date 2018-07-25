package com.hywa.bigdata.storage.entity;

import java.util.Date;

public class SysDepartment {
    private String guid;

    private String cname;

    private String ccode;

    private String cstatus;

    private String createuser;

    private Date createdate;

    private String updateuser;

    private Date updatedate;

    private String cver;

    private String refSysApp;

    private String parentId;

    private String refSysUser;

    private String phone;

    private String cdesc;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode == null ? null : ccode.trim();
    }

    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus == null ? null : cstatus.trim();
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getCver() {
        return cver;
    }

    public void setCver(String cver) {
        this.cver = cver == null ? null : cver.trim();
    }

    public String getRefSysApp() {
        return refSysApp;
    }

    public void setRefSysApp(String refSysApp) {
        this.refSysApp = refSysApp == null ? null : refSysApp.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getRefSysUser() {
        return refSysUser;
    }

    public void setRefSysUser(String refSysUser) {
        this.refSysUser = refSysUser == null ? null : refSysUser.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc == null ? null : cdesc.trim();
    }
}