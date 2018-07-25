package com.hywa.bigdata.storage.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysPermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysPermissionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andGUIDIsNull() {
            addCriterion("GUID is null");
            return (Criteria) this;
        }

        public Criteria andGUIDIsNotNull() {
            addCriterion("GUID is not null");
            return (Criteria) this;
        }

        public Criteria andGUIDEqualTo(String value) {
            addCriterion("GUID =", value, "GUID");
            return (Criteria) this;
        }

        public Criteria andGUIDNotEqualTo(String value) {
            addCriterion("GUID <>", value, "GUID");
            return (Criteria) this;
        }

        public Criteria andGUIDGreaterThan(String value) {
            addCriterion("GUID >", value, "GUID");
            return (Criteria) this;
        }

        public Criteria andGUIDGreaterThanOrEqualTo(String value) {
            addCriterion("GUID >=", value, "GUID");
            return (Criteria) this;
        }

        public Criteria andGUIDLessThan(String value) {
            addCriterion("GUID <", value, "GUID");
            return (Criteria) this;
        }

        public Criteria andGUIDLessThanOrEqualTo(String value) {
            addCriterion("GUID <=", value, "GUID");
            return (Criteria) this;
        }

        public Criteria andGUIDLike(String value) {
            addCriterion("GUID like", value, "GUID");
            return (Criteria) this;
        }

        public Criteria andGUIDNotLike(String value) {
            addCriterion("GUID not like", value, "GUID");
            return (Criteria) this;
        }

        public Criteria andGUIDIn(List<String> values) {
            addCriterion("GUID in", values, "GUID");
            return (Criteria) this;
        }

        public Criteria andGUIDNotIn(List<String> values) {
            addCriterion("GUID not in", values, "GUID");
            return (Criteria) this;
        }

        public Criteria andGUIDBetween(String value1, String value2) {
            addCriterion("GUID between", value1, value2, "GUID");
            return (Criteria) this;
        }

        public Criteria andGUIDNotBetween(String value1, String value2) {
            addCriterion("GUID not between", value1, value2, "GUID");
            return (Criteria) this;
        }

        public Criteria andCNAMEIsNull() {
            addCriterion("CNAME is null");
            return (Criteria) this;
        }

        public Criteria andCNAMEIsNotNull() {
            addCriterion("CNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCNAMEEqualTo(String value) {
            addCriterion("CNAME =", value, "CNAME");
            return (Criteria) this;
        }

        public Criteria andCNAMENotEqualTo(String value) {
            addCriterion("CNAME <>", value, "CNAME");
            return (Criteria) this;
        }

        public Criteria andCNAMEGreaterThan(String value) {
            addCriterion("CNAME >", value, "CNAME");
            return (Criteria) this;
        }

        public Criteria andCNAMEGreaterThanOrEqualTo(String value) {
            addCriterion("CNAME >=", value, "CNAME");
            return (Criteria) this;
        }

        public Criteria andCNAMELessThan(String value) {
            addCriterion("CNAME <", value, "CNAME");
            return (Criteria) this;
        }

        public Criteria andCNAMELessThanOrEqualTo(String value) {
            addCriterion("CNAME <=", value, "CNAME");
            return (Criteria) this;
        }

        public Criteria andCNAMELike(String value) {
            addCriterion("CNAME like", value, "CNAME");
            return (Criteria) this;
        }

        public Criteria andCNAMENotLike(String value) {
            addCriterion("CNAME not like", value, "CNAME");
            return (Criteria) this;
        }

        public Criteria andCNAMEIn(List<String> values) {
            addCriterion("CNAME in", values, "CNAME");
            return (Criteria) this;
        }

        public Criteria andCNAMENotIn(List<String> values) {
            addCriterion("CNAME not in", values, "CNAME");
            return (Criteria) this;
        }

        public Criteria andCNAMEBetween(String value1, String value2) {
            addCriterion("CNAME between", value1, value2, "CNAME");
            return (Criteria) this;
        }

        public Criteria andCNAMENotBetween(String value1, String value2) {
            addCriterion("CNAME not between", value1, value2, "CNAME");
            return (Criteria) this;
        }

        public Criteria andCCODEIsNull() {
            addCriterion("CCODE is null");
            return (Criteria) this;
        }

        public Criteria andCCODEIsNotNull() {
            addCriterion("CCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCCODEEqualTo(String value) {
            addCriterion("CCODE =", value, "CCODE");
            return (Criteria) this;
        }

        public Criteria andCCODENotEqualTo(String value) {
            addCriterion("CCODE <>", value, "CCODE");
            return (Criteria) this;
        }

        public Criteria andCCODEGreaterThan(String value) {
            addCriterion("CCODE >", value, "CCODE");
            return (Criteria) this;
        }

        public Criteria andCCODEGreaterThanOrEqualTo(String value) {
            addCriterion("CCODE >=", value, "CCODE");
            return (Criteria) this;
        }

        public Criteria andCCODELessThan(String value) {
            addCriterion("CCODE <", value, "CCODE");
            return (Criteria) this;
        }

        public Criteria andCCODELessThanOrEqualTo(String value) {
            addCriterion("CCODE <=", value, "CCODE");
            return (Criteria) this;
        }

        public Criteria andCCODELike(String value) {
            addCriterion("CCODE like", value, "CCODE");
            return (Criteria) this;
        }

        public Criteria andCCODENotLike(String value) {
            addCriterion("CCODE not like", value, "CCODE");
            return (Criteria) this;
        }

        public Criteria andCCODEIn(List<String> values) {
            addCriterion("CCODE in", values, "CCODE");
            return (Criteria) this;
        }

        public Criteria andCCODENotIn(List<String> values) {
            addCriterion("CCODE not in", values, "CCODE");
            return (Criteria) this;
        }

        public Criteria andCCODEBetween(String value1, String value2) {
            addCriterion("CCODE between", value1, value2, "CCODE");
            return (Criteria) this;
        }

        public Criteria andCCODENotBetween(String value1, String value2) {
            addCriterion("CCODE not between", value1, value2, "CCODE");
            return (Criteria) this;
        }

        public Criteria andCSTATUSIsNull() {
            addCriterion("CSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andCSTATUSIsNotNull() {
            addCriterion("CSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCSTATUSEqualTo(String value) {
            addCriterion("CSTATUS =", value, "CSTATUS");
            return (Criteria) this;
        }

        public Criteria andCSTATUSNotEqualTo(String value) {
            addCriterion("CSTATUS <>", value, "CSTATUS");
            return (Criteria) this;
        }

        public Criteria andCSTATUSGreaterThan(String value) {
            addCriterion("CSTATUS >", value, "CSTATUS");
            return (Criteria) this;
        }

        public Criteria andCSTATUSGreaterThanOrEqualTo(String value) {
            addCriterion("CSTATUS >=", value, "CSTATUS");
            return (Criteria) this;
        }

        public Criteria andCSTATUSLessThan(String value) {
            addCriterion("CSTATUS <", value, "CSTATUS");
            return (Criteria) this;
        }

        public Criteria andCSTATUSLessThanOrEqualTo(String value) {
            addCriterion("CSTATUS <=", value, "CSTATUS");
            return (Criteria) this;
        }

        public Criteria andCSTATUSLike(String value) {
            addCriterion("CSTATUS like", value, "CSTATUS");
            return (Criteria) this;
        }

        public Criteria andCSTATUSNotLike(String value) {
            addCriterion("CSTATUS not like", value, "CSTATUS");
            return (Criteria) this;
        }

        public Criteria andCSTATUSIn(List<String> values) {
            addCriterion("CSTATUS in", values, "CSTATUS");
            return (Criteria) this;
        }

        public Criteria andCSTATUSNotIn(List<String> values) {
            addCriterion("CSTATUS not in", values, "CSTATUS");
            return (Criteria) this;
        }

        public Criteria andCSTATUSBetween(String value1, String value2) {
            addCriterion("CSTATUS between", value1, value2, "CSTATUS");
            return (Criteria) this;
        }

        public Criteria andCSTATUSNotBetween(String value1, String value2) {
            addCriterion("CSTATUS not between", value1, value2, "CSTATUS");
            return (Criteria) this;
        }

        public Criteria andCREATEUSERIsNull() {
            addCriterion("CREATEUSER is null");
            return (Criteria) this;
        }

        public Criteria andCREATEUSERIsNotNull() {
            addCriterion("CREATEUSER is not null");
            return (Criteria) this;
        }

        public Criteria andCREATEUSEREqualTo(String value) {
            addCriterion("CREATEUSER =", value, "CREATEUSER");
            return (Criteria) this;
        }

        public Criteria andCREATEUSERNotEqualTo(String value) {
            addCriterion("CREATEUSER <>", value, "CREATEUSER");
            return (Criteria) this;
        }

        public Criteria andCREATEUSERGreaterThan(String value) {
            addCriterion("CREATEUSER >", value, "CREATEUSER");
            return (Criteria) this;
        }

        public Criteria andCREATEUSERGreaterThanOrEqualTo(String value) {
            addCriterion("CREATEUSER >=", value, "CREATEUSER");
            return (Criteria) this;
        }

        public Criteria andCREATEUSERLessThan(String value) {
            addCriterion("CREATEUSER <", value, "CREATEUSER");
            return (Criteria) this;
        }

        public Criteria andCREATEUSERLessThanOrEqualTo(String value) {
            addCriterion("CREATEUSER <=", value, "CREATEUSER");
            return (Criteria) this;
        }

        public Criteria andCREATEUSERLike(String value) {
            addCriterion("CREATEUSER like", value, "CREATEUSER");
            return (Criteria) this;
        }

        public Criteria andCREATEUSERNotLike(String value) {
            addCriterion("CREATEUSER not like", value, "CREATEUSER");
            return (Criteria) this;
        }

        public Criteria andCREATEUSERIn(List<String> values) {
            addCriterion("CREATEUSER in", values, "CREATEUSER");
            return (Criteria) this;
        }

        public Criteria andCREATEUSERNotIn(List<String> values) {
            addCriterion("CREATEUSER not in", values, "CREATEUSER");
            return (Criteria) this;
        }

        public Criteria andCREATEUSERBetween(String value1, String value2) {
            addCriterion("CREATEUSER between", value1, value2, "CREATEUSER");
            return (Criteria) this;
        }

        public Criteria andCREATEUSERNotBetween(String value1, String value2) {
            addCriterion("CREATEUSER not between", value1, value2, "CREATEUSER");
            return (Criteria) this;
        }

        public Criteria andCREATEDATEIsNull() {
            addCriterion("CREATEDATE is null");
            return (Criteria) this;
        }

        public Criteria andCREATEDATEIsNotNull() {
            addCriterion("CREATEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andCREATEDATEEqualTo(Date value) {
            addCriterion("CREATEDATE =", value, "CREATEDATE");
            return (Criteria) this;
        }

        public Criteria andCREATEDATENotEqualTo(Date value) {
            addCriterion("CREATEDATE <>", value, "CREATEDATE");
            return (Criteria) this;
        }

        public Criteria andCREATEDATEGreaterThan(Date value) {
            addCriterion("CREATEDATE >", value, "CREATEDATE");
            return (Criteria) this;
        }

        public Criteria andCREATEDATEGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE >=", value, "CREATEDATE");
            return (Criteria) this;
        }

        public Criteria andCREATEDATELessThan(Date value) {
            addCriterion("CREATEDATE <", value, "CREATEDATE");
            return (Criteria) this;
        }

        public Criteria andCREATEDATELessThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE <=", value, "CREATEDATE");
            return (Criteria) this;
        }

        public Criteria andCREATEDATEIn(List<Date> values) {
            addCriterion("CREATEDATE in", values, "CREATEDATE");
            return (Criteria) this;
        }

        public Criteria andCREATEDATENotIn(List<Date> values) {
            addCriterion("CREATEDATE not in", values, "CREATEDATE");
            return (Criteria) this;
        }

        public Criteria andCREATEDATEBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE between", value1, value2, "CREATEDATE");
            return (Criteria) this;
        }

        public Criteria andCREATEDATENotBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE not between", value1, value2, "CREATEDATE");
            return (Criteria) this;
        }

        public Criteria andUPDATEUSERIsNull() {
            addCriterion("UPDATEUSER is null");
            return (Criteria) this;
        }

        public Criteria andUPDATEUSERIsNotNull() {
            addCriterion("UPDATEUSER is not null");
            return (Criteria) this;
        }

        public Criteria andUPDATEUSEREqualTo(String value) {
            addCriterion("UPDATEUSER =", value, "UPDATEUSER");
            return (Criteria) this;
        }

        public Criteria andUPDATEUSERNotEqualTo(String value) {
            addCriterion("UPDATEUSER <>", value, "UPDATEUSER");
            return (Criteria) this;
        }

        public Criteria andUPDATEUSERGreaterThan(String value) {
            addCriterion("UPDATEUSER >", value, "UPDATEUSER");
            return (Criteria) this;
        }

        public Criteria andUPDATEUSERGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATEUSER >=", value, "UPDATEUSER");
            return (Criteria) this;
        }

        public Criteria andUPDATEUSERLessThan(String value) {
            addCriterion("UPDATEUSER <", value, "UPDATEUSER");
            return (Criteria) this;
        }

        public Criteria andUPDATEUSERLessThanOrEqualTo(String value) {
            addCriterion("UPDATEUSER <=", value, "UPDATEUSER");
            return (Criteria) this;
        }

        public Criteria andUPDATEUSERLike(String value) {
            addCriterion("UPDATEUSER like", value, "UPDATEUSER");
            return (Criteria) this;
        }

        public Criteria andUPDATEUSERNotLike(String value) {
            addCriterion("UPDATEUSER not like", value, "UPDATEUSER");
            return (Criteria) this;
        }

        public Criteria andUPDATEUSERIn(List<String> values) {
            addCriterion("UPDATEUSER in", values, "UPDATEUSER");
            return (Criteria) this;
        }

        public Criteria andUPDATEUSERNotIn(List<String> values) {
            addCriterion("UPDATEUSER not in", values, "UPDATEUSER");
            return (Criteria) this;
        }

        public Criteria andUPDATEUSERBetween(String value1, String value2) {
            addCriterion("UPDATEUSER between", value1, value2, "UPDATEUSER");
            return (Criteria) this;
        }

        public Criteria andUPDATEUSERNotBetween(String value1, String value2) {
            addCriterion("UPDATEUSER not between", value1, value2, "UPDATEUSER");
            return (Criteria) this;
        }

        public Criteria andUPDATEDATEIsNull() {
            addCriterion("UPDATEDATE is null");
            return (Criteria) this;
        }

        public Criteria andUPDATEDATEIsNotNull() {
            addCriterion("UPDATEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andUPDATEDATEEqualTo(Date value) {
            addCriterion("UPDATEDATE =", value, "UPDATEDATE");
            return (Criteria) this;
        }

        public Criteria andUPDATEDATENotEqualTo(Date value) {
            addCriterion("UPDATEDATE <>", value, "UPDATEDATE");
            return (Criteria) this;
        }

        public Criteria andUPDATEDATEGreaterThan(Date value) {
            addCriterion("UPDATEDATE >", value, "UPDATEDATE");
            return (Criteria) this;
        }

        public Criteria andUPDATEDATEGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATEDATE >=", value, "UPDATEDATE");
            return (Criteria) this;
        }

        public Criteria andUPDATEDATELessThan(Date value) {
            addCriterion("UPDATEDATE <", value, "UPDATEDATE");
            return (Criteria) this;
        }

        public Criteria andUPDATEDATELessThanOrEqualTo(Date value) {
            addCriterion("UPDATEDATE <=", value, "UPDATEDATE");
            return (Criteria) this;
        }

        public Criteria andUPDATEDATEIn(List<Date> values) {
            addCriterion("UPDATEDATE in", values, "UPDATEDATE");
            return (Criteria) this;
        }

        public Criteria andUPDATEDATENotIn(List<Date> values) {
            addCriterion("UPDATEDATE not in", values, "UPDATEDATE");
            return (Criteria) this;
        }

        public Criteria andUPDATEDATEBetween(Date value1, Date value2) {
            addCriterion("UPDATEDATE between", value1, value2, "UPDATEDATE");
            return (Criteria) this;
        }

        public Criteria andUPDATEDATENotBetween(Date value1, Date value2) {
            addCriterion("UPDATEDATE not between", value1, value2, "UPDATEDATE");
            return (Criteria) this;
        }

        public Criteria andCVERIsNull() {
            addCriterion("CVER is null");
            return (Criteria) this;
        }

        public Criteria andCVERIsNotNull() {
            addCriterion("CVER is not null");
            return (Criteria) this;
        }

        public Criteria andCVEREqualTo(String value) {
            addCriterion("CVER =", value, "CVER");
            return (Criteria) this;
        }

        public Criteria andCVERNotEqualTo(String value) {
            addCriterion("CVER <>", value, "CVER");
            return (Criteria) this;
        }

        public Criteria andCVERGreaterThan(String value) {
            addCriterion("CVER >", value, "CVER");
            return (Criteria) this;
        }

        public Criteria andCVERGreaterThanOrEqualTo(String value) {
            addCriterion("CVER >=", value, "CVER");
            return (Criteria) this;
        }

        public Criteria andCVERLessThan(String value) {
            addCriterion("CVER <", value, "CVER");
            return (Criteria) this;
        }

        public Criteria andCVERLessThanOrEqualTo(String value) {
            addCriterion("CVER <=", value, "CVER");
            return (Criteria) this;
        }

        public Criteria andCVERLike(String value) {
            addCriterion("CVER like", value, "CVER");
            return (Criteria) this;
        }

        public Criteria andCVERNotLike(String value) {
            addCriterion("CVER not like", value, "CVER");
            return (Criteria) this;
        }

        public Criteria andCVERIn(List<String> values) {
            addCriterion("CVER in", values, "CVER");
            return (Criteria) this;
        }

        public Criteria andCVERNotIn(List<String> values) {
            addCriterion("CVER not in", values, "CVER");
            return (Criteria) this;
        }

        public Criteria andCVERBetween(String value1, String value2) {
            addCriterion("CVER between", value1, value2, "CVER");
            return (Criteria) this;
        }

        public Criteria andCVERNotBetween(String value1, String value2) {
            addCriterion("CVER not between", value1, value2, "CVER");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_APPIsNull() {
            addCriterion("REF_SYS_APP is null");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_APPIsNotNull() {
            addCriterion("REF_SYS_APP is not null");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_APPEqualTo(String value) {
            addCriterion("REF_SYS_APP =", value, "REF_SYS_APP");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_APPNotEqualTo(String value) {
            addCriterion("REF_SYS_APP <>", value, "REF_SYS_APP");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_APPGreaterThan(String value) {
            addCriterion("REF_SYS_APP >", value, "REF_SYS_APP");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_APPGreaterThanOrEqualTo(String value) {
            addCriterion("REF_SYS_APP >=", value, "REF_SYS_APP");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_APPLessThan(String value) {
            addCriterion("REF_SYS_APP <", value, "REF_SYS_APP");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_APPLessThanOrEqualTo(String value) {
            addCriterion("REF_SYS_APP <=", value, "REF_SYS_APP");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_APPLike(String value) {
            addCriterion("REF_SYS_APP like", value, "REF_SYS_APP");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_APPNotLike(String value) {
            addCriterion("REF_SYS_APP not like", value, "REF_SYS_APP");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_APPIn(List<String> values) {
            addCriterion("REF_SYS_APP in", values, "REF_SYS_APP");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_APPNotIn(List<String> values) {
            addCriterion("REF_SYS_APP not in", values, "REF_SYS_APP");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_APPBetween(String value1, String value2) {
            addCriterion("REF_SYS_APP between", value1, value2, "REF_SYS_APP");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_APPNotBetween(String value1, String value2) {
            addCriterion("REF_SYS_APP not between", value1, value2, "REF_SYS_APP");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDIsNull() {
            addCriterion("PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDIsNotNull() {
            addCriterion("PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDEqualTo(String value) {
            addCriterion("PARENT_ID =", value, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDNotEqualTo(String value) {
            addCriterion("PARENT_ID <>", value, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDGreaterThan(String value) {
            addCriterion("PARENT_ID >", value, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ID >=", value, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDLessThan(String value) {
            addCriterion("PARENT_ID <", value, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ID <=", value, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDLike(String value) {
            addCriterion("PARENT_ID like", value, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDNotLike(String value) {
            addCriterion("PARENT_ID not like", value, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDIn(List<String> values) {
            addCriterion("PARENT_ID in", values, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDNotIn(List<String> values) {
            addCriterion("PARENT_ID not in", values, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDBetween(String value1, String value2) {
            addCriterion("PARENT_ID between", value1, value2, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andPARENT_IDNotBetween(String value1, String value2) {
            addCriterion("PARENT_ID not between", value1, value2, "PARENT_ID");
            return (Criteria) this;
        }

        public Criteria andICONIsNull() {
            addCriterion("ICON is null");
            return (Criteria) this;
        }

        public Criteria andICONIsNotNull() {
            addCriterion("ICON is not null");
            return (Criteria) this;
        }

        public Criteria andICONEqualTo(String value) {
            addCriterion("ICON =", value, "ICON");
            return (Criteria) this;
        }

        public Criteria andICONNotEqualTo(String value) {
            addCriterion("ICON <>", value, "ICON");
            return (Criteria) this;
        }

        public Criteria andICONGreaterThan(String value) {
            addCriterion("ICON >", value, "ICON");
            return (Criteria) this;
        }

        public Criteria andICONGreaterThanOrEqualTo(String value) {
            addCriterion("ICON >=", value, "ICON");
            return (Criteria) this;
        }

        public Criteria andICONLessThan(String value) {
            addCriterion("ICON <", value, "ICON");
            return (Criteria) this;
        }

        public Criteria andICONLessThanOrEqualTo(String value) {
            addCriterion("ICON <=", value, "ICON");
            return (Criteria) this;
        }

        public Criteria andICONLike(String value) {
            addCriterion("ICON like", value, "ICON");
            return (Criteria) this;
        }

        public Criteria andICONNotLike(String value) {
            addCriterion("ICON not like", value, "ICON");
            return (Criteria) this;
        }

        public Criteria andICONIn(List<String> values) {
            addCriterion("ICON in", values, "ICON");
            return (Criteria) this;
        }

        public Criteria andICONNotIn(List<String> values) {
            addCriterion("ICON not in", values, "ICON");
            return (Criteria) this;
        }

        public Criteria andICONBetween(String value1, String value2) {
            addCriterion("ICON between", value1, value2, "ICON");
            return (Criteria) this;
        }

        public Criteria andICONNotBetween(String value1, String value2) {
            addCriterion("ICON not between", value1, value2, "ICON");
            return (Criteria) this;
        }

        public Criteria andSEQIsNull() {
            addCriterion("SEQ is null");
            return (Criteria) this;
        }

        public Criteria andSEQIsNotNull() {
            addCriterion("SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andSEQEqualTo(Integer value) {
            addCriterion("SEQ =", value, "SEQ");
            return (Criteria) this;
        }

        public Criteria andSEQNotEqualTo(Integer value) {
            addCriterion("SEQ <>", value, "SEQ");
            return (Criteria) this;
        }

        public Criteria andSEQGreaterThan(Integer value) {
            addCriterion("SEQ >", value, "SEQ");
            return (Criteria) this;
        }

        public Criteria andSEQGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEQ >=", value, "SEQ");
            return (Criteria) this;
        }

        public Criteria andSEQLessThan(Integer value) {
            addCriterion("SEQ <", value, "SEQ");
            return (Criteria) this;
        }

        public Criteria andSEQLessThanOrEqualTo(Integer value) {
            addCriterion("SEQ <=", value, "SEQ");
            return (Criteria) this;
        }

        public Criteria andSEQIn(List<Integer> values) {
            addCriterion("SEQ in", values, "SEQ");
            return (Criteria) this;
        }

        public Criteria andSEQNotIn(List<Integer> values) {
            addCriterion("SEQ not in", values, "SEQ");
            return (Criteria) this;
        }

        public Criteria andSEQBetween(Integer value1, Integer value2) {
            addCriterion("SEQ between", value1, value2, "SEQ");
            return (Criteria) this;
        }

        public Criteria andSEQNotBetween(Integer value1, Integer value2) {
            addCriterion("SEQ not between", value1, value2, "SEQ");
            return (Criteria) this;
        }

        public Criteria andISMENUIsNull() {
            addCriterion("ISMENU is null");
            return (Criteria) this;
        }

        public Criteria andISMENUIsNotNull() {
            addCriterion("ISMENU is not null");
            return (Criteria) this;
        }

        public Criteria andISMENUEqualTo(Boolean value) {
            addCriterion("ISMENU =", value, "ISMENU");
            return (Criteria) this;
        }

        public Criteria andISMENUNotEqualTo(Boolean value) {
            addCriterion("ISMENU <>", value, "ISMENU");
            return (Criteria) this;
        }

        public Criteria andISMENUGreaterThan(Boolean value) {
            addCriterion("ISMENU >", value, "ISMENU");
            return (Criteria) this;
        }

        public Criteria andISMENUGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ISMENU >=", value, "ISMENU");
            return (Criteria) this;
        }

        public Criteria andISMENULessThan(Boolean value) {
            addCriterion("ISMENU <", value, "ISMENU");
            return (Criteria) this;
        }

        public Criteria andISMENULessThanOrEqualTo(Boolean value) {
            addCriterion("ISMENU <=", value, "ISMENU");
            return (Criteria) this;
        }

        public Criteria andISMENUIn(List<Boolean> values) {
            addCriterion("ISMENU in", values, "ISMENU");
            return (Criteria) this;
        }

        public Criteria andISMENUNotIn(List<Boolean> values) {
            addCriterion("ISMENU not in", values, "ISMENU");
            return (Criteria) this;
        }

        public Criteria andISMENUBetween(Boolean value1, Boolean value2) {
            addCriterion("ISMENU between", value1, value2, "ISMENU");
            return (Criteria) this;
        }

        public Criteria andISMENUNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ISMENU not between", value1, value2, "ISMENU");
            return (Criteria) this;
        }

        public Criteria andPERMISSIONIsNull() {
            addCriterion("PERMISSION is null");
            return (Criteria) this;
        }

        public Criteria andPERMISSIONIsNotNull() {
            addCriterion("PERMISSION is not null");
            return (Criteria) this;
        }

        public Criteria andPERMISSIONEqualTo(String value) {
            addCriterion("PERMISSION =", value, "PERMISSION");
            return (Criteria) this;
        }

        public Criteria andPERMISSIONNotEqualTo(String value) {
            addCriterion("PERMISSION <>", value, "PERMISSION");
            return (Criteria) this;
        }

        public Criteria andPERMISSIONGreaterThan(String value) {
            addCriterion("PERMISSION >", value, "PERMISSION");
            return (Criteria) this;
        }

        public Criteria andPERMISSIONGreaterThanOrEqualTo(String value) {
            addCriterion("PERMISSION >=", value, "PERMISSION");
            return (Criteria) this;
        }

        public Criteria andPERMISSIONLessThan(String value) {
            addCriterion("PERMISSION <", value, "PERMISSION");
            return (Criteria) this;
        }

        public Criteria andPERMISSIONLessThanOrEqualTo(String value) {
            addCriterion("PERMISSION <=", value, "PERMISSION");
            return (Criteria) this;
        }

        public Criteria andPERMISSIONLike(String value) {
            addCriterion("PERMISSION like", value, "PERMISSION");
            return (Criteria) this;
        }

        public Criteria andPERMISSIONNotLike(String value) {
            addCriterion("PERMISSION not like", value, "PERMISSION");
            return (Criteria) this;
        }

        public Criteria andPERMISSIONIn(List<String> values) {
            addCriterion("PERMISSION in", values, "PERMISSION");
            return (Criteria) this;
        }

        public Criteria andPERMISSIONNotIn(List<String> values) {
            addCriterion("PERMISSION not in", values, "PERMISSION");
            return (Criteria) this;
        }

        public Criteria andPERMISSIONBetween(String value1, String value2) {
            addCriterion("PERMISSION between", value1, value2, "PERMISSION");
            return (Criteria) this;
        }

        public Criteria andPERMISSIONNotBetween(String value1, String value2) {
            addCriterion("PERMISSION not between", value1, value2, "PERMISSION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONLike(String value) {
            addCriterion("DESCRIPTION like", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andDESCRIPTIONNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "DESCRIPTION");
            return (Criteria) this;
        }

        public Criteria andISPROCESSIsNull() {
            addCriterion("ISPROCESS is null");
            return (Criteria) this;
        }

        public Criteria andISPROCESSIsNotNull() {
            addCriterion("ISPROCESS is not null");
            return (Criteria) this;
        }

        public Criteria andISPROCESSEqualTo(String value) {
            addCriterion("ISPROCESS =", value, "ISPROCESS");
            return (Criteria) this;
        }

        public Criteria andISPROCESSNotEqualTo(String value) {
            addCriterion("ISPROCESS <>", value, "ISPROCESS");
            return (Criteria) this;
        }

        public Criteria andISPROCESSGreaterThan(String value) {
            addCriterion("ISPROCESS >", value, "ISPROCESS");
            return (Criteria) this;
        }

        public Criteria andISPROCESSGreaterThanOrEqualTo(String value) {
            addCriterion("ISPROCESS >=", value, "ISPROCESS");
            return (Criteria) this;
        }

        public Criteria andISPROCESSLessThan(String value) {
            addCriterion("ISPROCESS <", value, "ISPROCESS");
            return (Criteria) this;
        }

        public Criteria andISPROCESSLessThanOrEqualTo(String value) {
            addCriterion("ISPROCESS <=", value, "ISPROCESS");
            return (Criteria) this;
        }

        public Criteria andISPROCESSLike(String value) {
            addCriterion("ISPROCESS like", value, "ISPROCESS");
            return (Criteria) this;
        }

        public Criteria andISPROCESSNotLike(String value) {
            addCriterion("ISPROCESS not like", value, "ISPROCESS");
            return (Criteria) this;
        }

        public Criteria andISPROCESSIn(List<String> values) {
            addCriterion("ISPROCESS in", values, "ISPROCESS");
            return (Criteria) this;
        }

        public Criteria andISPROCESSNotIn(List<String> values) {
            addCriterion("ISPROCESS not in", values, "ISPROCESS");
            return (Criteria) this;
        }

        public Criteria andISPROCESSBetween(String value1, String value2) {
            addCriterion("ISPROCESS between", value1, value2, "ISPROCESS");
            return (Criteria) this;
        }

        public Criteria andISPROCESSNotBetween(String value1, String value2) {
            addCriterion("ISPROCESS not between", value1, value2, "ISPROCESS");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}