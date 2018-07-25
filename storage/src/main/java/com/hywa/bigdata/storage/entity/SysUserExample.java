package com.hywa.bigdata.storage.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysUserExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysUserExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andREAL_NAMEIsNull() {
            addCriterion("REAL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andREAL_NAMEIsNotNull() {
            addCriterion("REAL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andREAL_NAMEEqualTo(String value) {
            addCriterion("REAL_NAME =", value, "REAL_NAME");
            return (Criteria) this;
        }

        public Criteria andREAL_NAMENotEqualTo(String value) {
            addCriterion("REAL_NAME <>", value, "REAL_NAME");
            return (Criteria) this;
        }

        public Criteria andREAL_NAMEGreaterThan(String value) {
            addCriterion("REAL_NAME >", value, "REAL_NAME");
            return (Criteria) this;
        }

        public Criteria andREAL_NAMEGreaterThanOrEqualTo(String value) {
            addCriterion("REAL_NAME >=", value, "REAL_NAME");
            return (Criteria) this;
        }

        public Criteria andREAL_NAMELessThan(String value) {
            addCriterion("REAL_NAME <", value, "REAL_NAME");
            return (Criteria) this;
        }

        public Criteria andREAL_NAMELessThanOrEqualTo(String value) {
            addCriterion("REAL_NAME <=", value, "REAL_NAME");
            return (Criteria) this;
        }

        public Criteria andREAL_NAMELike(String value) {
            addCriterion("REAL_NAME like", value, "REAL_NAME");
            return (Criteria) this;
        }

        public Criteria andREAL_NAMENotLike(String value) {
            addCriterion("REAL_NAME not like", value, "REAL_NAME");
            return (Criteria) this;
        }

        public Criteria andREAL_NAMEIn(List<String> values) {
            addCriterion("REAL_NAME in", values, "REAL_NAME");
            return (Criteria) this;
        }

        public Criteria andREAL_NAMENotIn(List<String> values) {
            addCriterion("REAL_NAME not in", values, "REAL_NAME");
            return (Criteria) this;
        }

        public Criteria andREAL_NAMEBetween(String value1, String value2) {
            addCriterion("REAL_NAME between", value1, value2, "REAL_NAME");
            return (Criteria) this;
        }

        public Criteria andREAL_NAMENotBetween(String value1, String value2) {
            addCriterion("REAL_NAME not between", value1, value2, "REAL_NAME");
            return (Criteria) this;
        }

        public Criteria andPASSWORDIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPASSWORDIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPASSWORDEqualTo(String value) {
            addCriterion("PASSWORD =", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDLessThan(String value) {
            addCriterion("PASSWORD <", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDLike(String value) {
            addCriterion("PASSWORD like", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDNotLike(String value) {
            addCriterion("PASSWORD not like", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDIn(List<String> values) {
            addCriterion("PASSWORD in", values, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPHOTOIsNull() {
            addCriterion("PHOTO is null");
            return (Criteria) this;
        }

        public Criteria andPHOTOIsNotNull() {
            addCriterion("PHOTO is not null");
            return (Criteria) this;
        }

        public Criteria andPHOTOEqualTo(String value) {
            addCriterion("PHOTO =", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTONotEqualTo(String value) {
            addCriterion("PHOTO <>", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTOGreaterThan(String value) {
            addCriterion("PHOTO >", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTOGreaterThanOrEqualTo(String value) {
            addCriterion("PHOTO >=", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTOLessThan(String value) {
            addCriterion("PHOTO <", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTOLessThanOrEqualTo(String value) {
            addCriterion("PHOTO <=", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTOLike(String value) {
            addCriterion("PHOTO like", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTONotLike(String value) {
            addCriterion("PHOTO not like", value, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTOIn(List<String> values) {
            addCriterion("PHOTO in", values, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTONotIn(List<String> values) {
            addCriterion("PHOTO not in", values, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTOBetween(String value1, String value2) {
            addCriterion("PHOTO between", value1, value2, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andPHOTONotBetween(String value1, String value2) {
            addCriterion("PHOTO not between", value1, value2, "PHOTO");
            return (Criteria) this;
        }

        public Criteria andSEXIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSEXIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSEXEqualTo(Integer value) {
            addCriterion("SEX =", value, "SEX");
            return (Criteria) this;
        }

        public Criteria andSEXNotEqualTo(Integer value) {
            addCriterion("SEX <>", value, "SEX");
            return (Criteria) this;
        }

        public Criteria andSEXGreaterThan(Integer value) {
            addCriterion("SEX >", value, "SEX");
            return (Criteria) this;
        }

        public Criteria andSEXGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEX >=", value, "SEX");
            return (Criteria) this;
        }

        public Criteria andSEXLessThan(Integer value) {
            addCriterion("SEX <", value, "SEX");
            return (Criteria) this;
        }

        public Criteria andSEXLessThanOrEqualTo(Integer value) {
            addCriterion("SEX <=", value, "SEX");
            return (Criteria) this;
        }

        public Criteria andSEXIn(List<Integer> values) {
            addCriterion("SEX in", values, "SEX");
            return (Criteria) this;
        }

        public Criteria andSEXNotIn(List<Integer> values) {
            addCriterion("SEX not in", values, "SEX");
            return (Criteria) this;
        }

        public Criteria andSEXBetween(Integer value1, Integer value2) {
            addCriterion("SEX between", value1, value2, "SEX");
            return (Criteria) this;
        }

        public Criteria andSEXNotBetween(Integer value1, Integer value2) {
            addCriterion("SEX not between", value1, value2, "SEX");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_DEPARTMENTIsNull() {
            addCriterion("REF_SYS_DEPARTMENT is null");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_DEPARTMENTIsNotNull() {
            addCriterion("REF_SYS_DEPARTMENT is not null");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_DEPARTMENTEqualTo(String value) {
            addCriterion("REF_SYS_DEPARTMENT =", value, "REF_SYS_DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_DEPARTMENTNotEqualTo(String value) {
            addCriterion("REF_SYS_DEPARTMENT <>", value, "REF_SYS_DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_DEPARTMENTGreaterThan(String value) {
            addCriterion("REF_SYS_DEPARTMENT >", value, "REF_SYS_DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_DEPARTMENTGreaterThanOrEqualTo(String value) {
            addCriterion("REF_SYS_DEPARTMENT >=", value, "REF_SYS_DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_DEPARTMENTLessThan(String value) {
            addCriterion("REF_SYS_DEPARTMENT <", value, "REF_SYS_DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_DEPARTMENTLessThanOrEqualTo(String value) {
            addCriterion("REF_SYS_DEPARTMENT <=", value, "REF_SYS_DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_DEPARTMENTLike(String value) {
            addCriterion("REF_SYS_DEPARTMENT like", value, "REF_SYS_DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_DEPARTMENTNotLike(String value) {
            addCriterion("REF_SYS_DEPARTMENT not like", value, "REF_SYS_DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_DEPARTMENTIn(List<String> values) {
            addCriterion("REF_SYS_DEPARTMENT in", values, "REF_SYS_DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_DEPARTMENTNotIn(List<String> values) {
            addCriterion("REF_SYS_DEPARTMENT not in", values, "REF_SYS_DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_DEPARTMENTBetween(String value1, String value2) {
            addCriterion("REF_SYS_DEPARTMENT between", value1, value2, "REF_SYS_DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andREF_SYS_DEPARTMENTNotBetween(String value1, String value2) {
            addCriterion("REF_SYS_DEPARTMENT not between", value1, value2, "REF_SYS_DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andREF_PJIsNull() {
            addCriterion("REF_PJ is null");
            return (Criteria) this;
        }

        public Criteria andREF_PJIsNotNull() {
            addCriterion("REF_PJ is not null");
            return (Criteria) this;
        }

        public Criteria andREF_PJEqualTo(String value) {
            addCriterion("REF_PJ =", value, "REF_PJ");
            return (Criteria) this;
        }

        public Criteria andREF_PJNotEqualTo(String value) {
            addCriterion("REF_PJ <>", value, "REF_PJ");
            return (Criteria) this;
        }

        public Criteria andREF_PJGreaterThan(String value) {
            addCriterion("REF_PJ >", value, "REF_PJ");
            return (Criteria) this;
        }

        public Criteria andREF_PJGreaterThanOrEqualTo(String value) {
            addCriterion("REF_PJ >=", value, "REF_PJ");
            return (Criteria) this;
        }

        public Criteria andREF_PJLessThan(String value) {
            addCriterion("REF_PJ <", value, "REF_PJ");
            return (Criteria) this;
        }

        public Criteria andREF_PJLessThanOrEqualTo(String value) {
            addCriterion("REF_PJ <=", value, "REF_PJ");
            return (Criteria) this;
        }

        public Criteria andREF_PJLike(String value) {
            addCriterion("REF_PJ like", value, "REF_PJ");
            return (Criteria) this;
        }

        public Criteria andREF_PJNotLike(String value) {
            addCriterion("REF_PJ not like", value, "REF_PJ");
            return (Criteria) this;
        }

        public Criteria andREF_PJIn(List<String> values) {
            addCriterion("REF_PJ in", values, "REF_PJ");
            return (Criteria) this;
        }

        public Criteria andREF_PJNotIn(List<String> values) {
            addCriterion("REF_PJ not in", values, "REF_PJ");
            return (Criteria) this;
        }

        public Criteria andREF_PJBetween(String value1, String value2) {
            addCriterion("REF_PJ between", value1, value2, "REF_PJ");
            return (Criteria) this;
        }

        public Criteria andREF_PJNotBetween(String value1, String value2) {
            addCriterion("REF_PJ not between", value1, value2, "REF_PJ");
            return (Criteria) this;
        }

        public Criteria andREF_ZHCC_S_ROLEIsNull() {
            addCriterion("REF_ZHCC_S_ROLE is null");
            return (Criteria) this;
        }

        public Criteria andREF_ZHCC_S_ROLEIsNotNull() {
            addCriterion("REF_ZHCC_S_ROLE is not null");
            return (Criteria) this;
        }

        public Criteria andREF_ZHCC_S_ROLEEqualTo(String value) {
            addCriterion("REF_ZHCC_S_ROLE =", value, "REF_ZHCC_S_ROLE");
            return (Criteria) this;
        }

        public Criteria andREF_ZHCC_S_ROLENotEqualTo(String value) {
            addCriterion("REF_ZHCC_S_ROLE <>", value, "REF_ZHCC_S_ROLE");
            return (Criteria) this;
        }

        public Criteria andREF_ZHCC_S_ROLEGreaterThan(String value) {
            addCriterion("REF_ZHCC_S_ROLE >", value, "REF_ZHCC_S_ROLE");
            return (Criteria) this;
        }

        public Criteria andREF_ZHCC_S_ROLEGreaterThanOrEqualTo(String value) {
            addCriterion("REF_ZHCC_S_ROLE >=", value, "REF_ZHCC_S_ROLE");
            return (Criteria) this;
        }

        public Criteria andREF_ZHCC_S_ROLELessThan(String value) {
            addCriterion("REF_ZHCC_S_ROLE <", value, "REF_ZHCC_S_ROLE");
            return (Criteria) this;
        }

        public Criteria andREF_ZHCC_S_ROLELessThanOrEqualTo(String value) {
            addCriterion("REF_ZHCC_S_ROLE <=", value, "REF_ZHCC_S_ROLE");
            return (Criteria) this;
        }

        public Criteria andREF_ZHCC_S_ROLELike(String value) {
            addCriterion("REF_ZHCC_S_ROLE like", value, "REF_ZHCC_S_ROLE");
            return (Criteria) this;
        }

        public Criteria andREF_ZHCC_S_ROLENotLike(String value) {
            addCriterion("REF_ZHCC_S_ROLE not like", value, "REF_ZHCC_S_ROLE");
            return (Criteria) this;
        }

        public Criteria andREF_ZHCC_S_ROLEIn(List<String> values) {
            addCriterion("REF_ZHCC_S_ROLE in", values, "REF_ZHCC_S_ROLE");
            return (Criteria) this;
        }

        public Criteria andREF_ZHCC_S_ROLENotIn(List<String> values) {
            addCriterion("REF_ZHCC_S_ROLE not in", values, "REF_ZHCC_S_ROLE");
            return (Criteria) this;
        }

        public Criteria andREF_ZHCC_S_ROLEBetween(String value1, String value2) {
            addCriterion("REF_ZHCC_S_ROLE between", value1, value2, "REF_ZHCC_S_ROLE");
            return (Criteria) this;
        }

        public Criteria andREF_ZHCC_S_ROLENotBetween(String value1, String value2) {
            addCriterion("REF_ZHCC_S_ROLE not between", value1, value2, "REF_ZHCC_S_ROLE");
            return (Criteria) this;
        }

        public Criteria andPHONEIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPHONEIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPHONEEqualTo(String value) {
            addCriterion("PHONE =", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONENotEqualTo(String value) {
            addCriterion("PHONE <>", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONEGreaterThan(String value) {
            addCriterion("PHONE >", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONEGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONELessThan(String value) {
            addCriterion("PHONE <", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONELessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONELike(String value) {
            addCriterion("PHONE like", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONENotLike(String value) {
            addCriterion("PHONE not like", value, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONEIn(List<String> values) {
            addCriterion("PHONE in", values, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONENotIn(List<String> values) {
            addCriterion("PHONE not in", values, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONEBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "PHONE");
            return (Criteria) this;
        }

        public Criteria andPHONENotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "PHONE");
            return (Criteria) this;
        }

        public Criteria andWEIXINIsNull() {
            addCriterion("WEIXIN is null");
            return (Criteria) this;
        }

        public Criteria andWEIXINIsNotNull() {
            addCriterion("WEIXIN is not null");
            return (Criteria) this;
        }

        public Criteria andWEIXINEqualTo(String value) {
            addCriterion("WEIXIN =", value, "WEIXIN");
            return (Criteria) this;
        }

        public Criteria andWEIXINNotEqualTo(String value) {
            addCriterion("WEIXIN <>", value, "WEIXIN");
            return (Criteria) this;
        }

        public Criteria andWEIXINGreaterThan(String value) {
            addCriterion("WEIXIN >", value, "WEIXIN");
            return (Criteria) this;
        }

        public Criteria andWEIXINGreaterThanOrEqualTo(String value) {
            addCriterion("WEIXIN >=", value, "WEIXIN");
            return (Criteria) this;
        }

        public Criteria andWEIXINLessThan(String value) {
            addCriterion("WEIXIN <", value, "WEIXIN");
            return (Criteria) this;
        }

        public Criteria andWEIXINLessThanOrEqualTo(String value) {
            addCriterion("WEIXIN <=", value, "WEIXIN");
            return (Criteria) this;
        }

        public Criteria andWEIXINLike(String value) {
            addCriterion("WEIXIN like", value, "WEIXIN");
            return (Criteria) this;
        }

        public Criteria andWEIXINNotLike(String value) {
            addCriterion("WEIXIN not like", value, "WEIXIN");
            return (Criteria) this;
        }

        public Criteria andWEIXINIn(List<String> values) {
            addCriterion("WEIXIN in", values, "WEIXIN");
            return (Criteria) this;
        }

        public Criteria andWEIXINNotIn(List<String> values) {
            addCriterion("WEIXIN not in", values, "WEIXIN");
            return (Criteria) this;
        }

        public Criteria andWEIXINBetween(String value1, String value2) {
            addCriterion("WEIXIN between", value1, value2, "WEIXIN");
            return (Criteria) this;
        }

        public Criteria andWEIXINNotBetween(String value1, String value2) {
            addCriterion("WEIXIN not between", value1, value2, "WEIXIN");
            return (Criteria) this;
        }

        public Criteria andQQIsNull() {
            addCriterion("QQ is null");
            return (Criteria) this;
        }

        public Criteria andQQIsNotNull() {
            addCriterion("QQ is not null");
            return (Criteria) this;
        }

        public Criteria andQQEqualTo(String value) {
            addCriterion("QQ =", value, "QQ");
            return (Criteria) this;
        }

        public Criteria andQQNotEqualTo(String value) {
            addCriterion("QQ <>", value, "QQ");
            return (Criteria) this;
        }

        public Criteria andQQGreaterThan(String value) {
            addCriterion("QQ >", value, "QQ");
            return (Criteria) this;
        }

        public Criteria andQQGreaterThanOrEqualTo(String value) {
            addCriterion("QQ >=", value, "QQ");
            return (Criteria) this;
        }

        public Criteria andQQLessThan(String value) {
            addCriterion("QQ <", value, "QQ");
            return (Criteria) this;
        }

        public Criteria andQQLessThanOrEqualTo(String value) {
            addCriterion("QQ <=", value, "QQ");
            return (Criteria) this;
        }

        public Criteria andQQLike(String value) {
            addCriterion("QQ like", value, "QQ");
            return (Criteria) this;
        }

        public Criteria andQQNotLike(String value) {
            addCriterion("QQ not like", value, "QQ");
            return (Criteria) this;
        }

        public Criteria andQQIn(List<String> values) {
            addCriterion("QQ in", values, "QQ");
            return (Criteria) this;
        }

        public Criteria andQQNotIn(List<String> values) {
            addCriterion("QQ not in", values, "QQ");
            return (Criteria) this;
        }

        public Criteria andQQBetween(String value1, String value2) {
            addCriterion("QQ between", value1, value2, "QQ");
            return (Criteria) this;
        }

        public Criteria andQQNotBetween(String value1, String value2) {
            addCriterion("QQ not between", value1, value2, "QQ");
            return (Criteria) this;
        }

        public Criteria andEMAILIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEMAILIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEMAILEqualTo(String value) {
            addCriterion("EMAIL =", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILGreaterThan(String value) {
            addCriterion("EMAIL >", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILLessThan(String value) {
            addCriterion("EMAIL <", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILLike(String value) {
            addCriterion("EMAIL like", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILNotLike(String value) {
            addCriterion("EMAIL not like", value, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILIn(List<String> values) {
            addCriterion("EMAIL in", values, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andEMAILNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "EMAIL");
            return (Criteria) this;
        }

        public Criteria andID_CARDIsNull() {
            addCriterion("ID_CARD is null");
            return (Criteria) this;
        }

        public Criteria andID_CARDIsNotNull() {
            addCriterion("ID_CARD is not null");
            return (Criteria) this;
        }

        public Criteria andID_CARDEqualTo(String value) {
            addCriterion("ID_CARD =", value, "ID_CARD");
            return (Criteria) this;
        }

        public Criteria andID_CARDNotEqualTo(String value) {
            addCriterion("ID_CARD <>", value, "ID_CARD");
            return (Criteria) this;
        }

        public Criteria andID_CARDGreaterThan(String value) {
            addCriterion("ID_CARD >", value, "ID_CARD");
            return (Criteria) this;
        }

        public Criteria andID_CARDGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CARD >=", value, "ID_CARD");
            return (Criteria) this;
        }

        public Criteria andID_CARDLessThan(String value) {
            addCriterion("ID_CARD <", value, "ID_CARD");
            return (Criteria) this;
        }

        public Criteria andID_CARDLessThanOrEqualTo(String value) {
            addCriterion("ID_CARD <=", value, "ID_CARD");
            return (Criteria) this;
        }

        public Criteria andID_CARDLike(String value) {
            addCriterion("ID_CARD like", value, "ID_CARD");
            return (Criteria) this;
        }

        public Criteria andID_CARDNotLike(String value) {
            addCriterion("ID_CARD not like", value, "ID_CARD");
            return (Criteria) this;
        }

        public Criteria andID_CARDIn(List<String> values) {
            addCriterion("ID_CARD in", values, "ID_CARD");
            return (Criteria) this;
        }

        public Criteria andID_CARDNotIn(List<String> values) {
            addCriterion("ID_CARD not in", values, "ID_CARD");
            return (Criteria) this;
        }

        public Criteria andID_CARDBetween(String value1, String value2) {
            addCriterion("ID_CARD between", value1, value2, "ID_CARD");
            return (Criteria) this;
        }

        public Criteria andID_CARDNotBetween(String value1, String value2) {
            addCriterion("ID_CARD not between", value1, value2, "ID_CARD");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYIsNull() {
            addCriterion("BIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYIsNotNull() {
            addCriterion("BIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTHDAY =", value, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYNotEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTHDAY <>", value, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYGreaterThan(Date value) {
            addCriterionForJDBCDate("BIRTHDAY >", value, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTHDAY >=", value, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYLessThan(Date value) {
            addCriterionForJDBCDate("BIRTHDAY <", value, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BIRTHDAY <=", value, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYIn(List<Date> values) {
            addCriterionForJDBCDate("BIRTHDAY in", values, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYNotIn(List<Date> values) {
            addCriterionForJDBCDate("BIRTHDAY not in", values, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BIRTHDAY between", value1, value2, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andBIRTHDAYNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BIRTHDAY not between", value1, value2, "BIRTHDAY");
            return (Criteria) this;
        }

        public Criteria andHEIGHTIsNull() {
            addCriterion("HEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andHEIGHTIsNotNull() {
            addCriterion("HEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andHEIGHTEqualTo(Integer value) {
            addCriterion("HEIGHT =", value, "HEIGHT");
            return (Criteria) this;
        }

        public Criteria andHEIGHTNotEqualTo(Integer value) {
            addCriterion("HEIGHT <>", value, "HEIGHT");
            return (Criteria) this;
        }

        public Criteria andHEIGHTGreaterThan(Integer value) {
            addCriterion("HEIGHT >", value, "HEIGHT");
            return (Criteria) this;
        }

        public Criteria andHEIGHTGreaterThanOrEqualTo(Integer value) {
            addCriterion("HEIGHT >=", value, "HEIGHT");
            return (Criteria) this;
        }

        public Criteria andHEIGHTLessThan(Integer value) {
            addCriterion("HEIGHT <", value, "HEIGHT");
            return (Criteria) this;
        }

        public Criteria andHEIGHTLessThanOrEqualTo(Integer value) {
            addCriterion("HEIGHT <=", value, "HEIGHT");
            return (Criteria) this;
        }

        public Criteria andHEIGHTIn(List<Integer> values) {
            addCriterion("HEIGHT in", values, "HEIGHT");
            return (Criteria) this;
        }

        public Criteria andHEIGHTNotIn(List<Integer> values) {
            addCriterion("HEIGHT not in", values, "HEIGHT");
            return (Criteria) this;
        }

        public Criteria andHEIGHTBetween(Integer value1, Integer value2) {
            addCriterion("HEIGHT between", value1, value2, "HEIGHT");
            return (Criteria) this;
        }

        public Criteria andHEIGHTNotBetween(Integer value1, Integer value2) {
            addCriterion("HEIGHT not between", value1, value2, "HEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTIsNull() {
            addCriterion("WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andWEIGHTIsNotNull() {
            addCriterion("WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andWEIGHTEqualTo(Float value) {
            addCriterion("WEIGHT =", value, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTNotEqualTo(Float value) {
            addCriterion("WEIGHT <>", value, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTGreaterThan(Float value) {
            addCriterion("WEIGHT >", value, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTGreaterThanOrEqualTo(Float value) {
            addCriterion("WEIGHT >=", value, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTLessThan(Float value) {
            addCriterion("WEIGHT <", value, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTLessThanOrEqualTo(Float value) {
            addCriterion("WEIGHT <=", value, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTIn(List<Float> values) {
            addCriterion("WEIGHT in", values, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTNotIn(List<Float> values) {
            addCriterion("WEIGHT not in", values, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTBetween(Float value1, Float value2) {
            addCriterion("WEIGHT between", value1, value2, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTNotBetween(Float value1, Float value2) {
            addCriterion("WEIGHT not between", value1, value2, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andNATIVE_PLACEIsNull() {
            addCriterion("NATIVE_PLACE is null");
            return (Criteria) this;
        }

        public Criteria andNATIVE_PLACEIsNotNull() {
            addCriterion("NATIVE_PLACE is not null");
            return (Criteria) this;
        }

        public Criteria andNATIVE_PLACEEqualTo(String value) {
            addCriterion("NATIVE_PLACE =", value, "NATIVE_PLACE");
            return (Criteria) this;
        }

        public Criteria andNATIVE_PLACENotEqualTo(String value) {
            addCriterion("NATIVE_PLACE <>", value, "NATIVE_PLACE");
            return (Criteria) this;
        }

        public Criteria andNATIVE_PLACEGreaterThan(String value) {
            addCriterion("NATIVE_PLACE >", value, "NATIVE_PLACE");
            return (Criteria) this;
        }

        public Criteria andNATIVE_PLACEGreaterThanOrEqualTo(String value) {
            addCriterion("NATIVE_PLACE >=", value, "NATIVE_PLACE");
            return (Criteria) this;
        }

        public Criteria andNATIVE_PLACELessThan(String value) {
            addCriterion("NATIVE_PLACE <", value, "NATIVE_PLACE");
            return (Criteria) this;
        }

        public Criteria andNATIVE_PLACELessThanOrEqualTo(String value) {
            addCriterion("NATIVE_PLACE <=", value, "NATIVE_PLACE");
            return (Criteria) this;
        }

        public Criteria andNATIVE_PLACELike(String value) {
            addCriterion("NATIVE_PLACE like", value, "NATIVE_PLACE");
            return (Criteria) this;
        }

        public Criteria andNATIVE_PLACENotLike(String value) {
            addCriterion("NATIVE_PLACE not like", value, "NATIVE_PLACE");
            return (Criteria) this;
        }

        public Criteria andNATIVE_PLACEIn(List<String> values) {
            addCriterion("NATIVE_PLACE in", values, "NATIVE_PLACE");
            return (Criteria) this;
        }

        public Criteria andNATIVE_PLACENotIn(List<String> values) {
            addCriterion("NATIVE_PLACE not in", values, "NATIVE_PLACE");
            return (Criteria) this;
        }

        public Criteria andNATIVE_PLACEBetween(String value1, String value2) {
            addCriterion("NATIVE_PLACE between", value1, value2, "NATIVE_PLACE");
            return (Criteria) this;
        }

        public Criteria andNATIVE_PLACENotBetween(String value1, String value2) {
            addCriterion("NATIVE_PLACE not between", value1, value2, "NATIVE_PLACE");
            return (Criteria) this;
        }

        public Criteria andNATIONIsNull() {
            addCriterion("NATION is null");
            return (Criteria) this;
        }

        public Criteria andNATIONIsNotNull() {
            addCriterion("NATION is not null");
            return (Criteria) this;
        }

        public Criteria andNATIONEqualTo(Integer value) {
            addCriterion("NATION =", value, "NATION");
            return (Criteria) this;
        }

        public Criteria andNATIONNotEqualTo(Integer value) {
            addCriterion("NATION <>", value, "NATION");
            return (Criteria) this;
        }

        public Criteria andNATIONGreaterThan(Integer value) {
            addCriterion("NATION >", value, "NATION");
            return (Criteria) this;
        }

        public Criteria andNATIONGreaterThanOrEqualTo(Integer value) {
            addCriterion("NATION >=", value, "NATION");
            return (Criteria) this;
        }

        public Criteria andNATIONLessThan(Integer value) {
            addCriterion("NATION <", value, "NATION");
            return (Criteria) this;
        }

        public Criteria andNATIONLessThanOrEqualTo(Integer value) {
            addCriterion("NATION <=", value, "NATION");
            return (Criteria) this;
        }

        public Criteria andNATIONIn(List<Integer> values) {
            addCriterion("NATION in", values, "NATION");
            return (Criteria) this;
        }

        public Criteria andNATIONNotIn(List<Integer> values) {
            addCriterion("NATION not in", values, "NATION");
            return (Criteria) this;
        }

        public Criteria andNATIONBetween(Integer value1, Integer value2) {
            addCriterion("NATION between", value1, value2, "NATION");
            return (Criteria) this;
        }

        public Criteria andNATIONNotBetween(Integer value1, Integer value2) {
            addCriterion("NATION not between", value1, value2, "NATION");
            return (Criteria) this;
        }

        public Criteria andCURR_ADDRESSIsNull() {
            addCriterion("CURR_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andCURR_ADDRESSIsNotNull() {
            addCriterion("CURR_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andCURR_ADDRESSEqualTo(String value) {
            addCriterion("CURR_ADDRESS =", value, "CURR_ADDRESS");
            return (Criteria) this;
        }

        public Criteria andCURR_ADDRESSNotEqualTo(String value) {
            addCriterion("CURR_ADDRESS <>", value, "CURR_ADDRESS");
            return (Criteria) this;
        }

        public Criteria andCURR_ADDRESSGreaterThan(String value) {
            addCriterion("CURR_ADDRESS >", value, "CURR_ADDRESS");
            return (Criteria) this;
        }

        public Criteria andCURR_ADDRESSGreaterThanOrEqualTo(String value) {
            addCriterion("CURR_ADDRESS >=", value, "CURR_ADDRESS");
            return (Criteria) this;
        }

        public Criteria andCURR_ADDRESSLessThan(String value) {
            addCriterion("CURR_ADDRESS <", value, "CURR_ADDRESS");
            return (Criteria) this;
        }

        public Criteria andCURR_ADDRESSLessThanOrEqualTo(String value) {
            addCriterion("CURR_ADDRESS <=", value, "CURR_ADDRESS");
            return (Criteria) this;
        }

        public Criteria andCURR_ADDRESSLike(String value) {
            addCriterion("CURR_ADDRESS like", value, "CURR_ADDRESS");
            return (Criteria) this;
        }

        public Criteria andCURR_ADDRESSNotLike(String value) {
            addCriterion("CURR_ADDRESS not like", value, "CURR_ADDRESS");
            return (Criteria) this;
        }

        public Criteria andCURR_ADDRESSIn(List<String> values) {
            addCriterion("CURR_ADDRESS in", values, "CURR_ADDRESS");
            return (Criteria) this;
        }

        public Criteria andCURR_ADDRESSNotIn(List<String> values) {
            addCriterion("CURR_ADDRESS not in", values, "CURR_ADDRESS");
            return (Criteria) this;
        }

        public Criteria andCURR_ADDRESSBetween(String value1, String value2) {
            addCriterion("CURR_ADDRESS between", value1, value2, "CURR_ADDRESS");
            return (Criteria) this;
        }

        public Criteria andCURR_ADDRESSNotBetween(String value1, String value2) {
            addCriterion("CURR_ADDRESS not between", value1, value2, "CURR_ADDRESS");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPIsNull() {
            addCriterion("LOGIN_IP is null");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPIsNotNull() {
            addCriterion("LOGIN_IP is not null");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPEqualTo(String value) {
            addCriterion("LOGIN_IP =", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPNotEqualTo(String value) {
            addCriterion("LOGIN_IP <>", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPGreaterThan(String value) {
            addCriterion("LOGIN_IP >", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP >=", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPLessThan(String value) {
            addCriterion("LOGIN_IP <", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP <=", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPLike(String value) {
            addCriterion("LOGIN_IP like", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPNotLike(String value) {
            addCriterion("LOGIN_IP not like", value, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPIn(List<String> values) {
            addCriterion("LOGIN_IP in", values, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPNotIn(List<String> values) {
            addCriterion("LOGIN_IP not in", values, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPBetween(String value1, String value2) {
            addCriterion("LOGIN_IP between", value1, value2, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_IPNotBetween(String value1, String value2) {
            addCriterion("LOGIN_IP not between", value1, value2, "LOGIN_IP");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATEIsNull() {
            addCriterion("LOGIN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATEIsNotNull() {
            addCriterion("LOGIN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATEEqualTo(Date value) {
            addCriterion("LOGIN_DATE =", value, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATENotEqualTo(Date value) {
            addCriterion("LOGIN_DATE <>", value, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATEGreaterThan(Date value) {
            addCriterion("LOGIN_DATE >", value, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATEGreaterThanOrEqualTo(Date value) {
            addCriterion("LOGIN_DATE >=", value, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATELessThan(Date value) {
            addCriterion("LOGIN_DATE <", value, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATELessThanOrEqualTo(Date value) {
            addCriterion("LOGIN_DATE <=", value, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATEIn(List<Date> values) {
            addCriterion("LOGIN_DATE in", values, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATENotIn(List<Date> values) {
            addCriterion("LOGIN_DATE not in", values, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATEBetween(Date value1, Date value2) {
            addCriterion("LOGIN_DATE between", value1, value2, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_DATENotBetween(Date value1, Date value2) {
            addCriterion("LOGIN_DATE not between", value1, value2, "LOGIN_DATE");
            return (Criteria) this;
        }

        public Criteria andLOGIN_COUNTIsNull() {
            addCriterion("LOGIN_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andLOGIN_COUNTIsNotNull() {
            addCriterion("LOGIN_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLOGIN_COUNTEqualTo(Long value) {
            addCriterion("LOGIN_COUNT =", value, "LOGIN_COUNT");
            return (Criteria) this;
        }

        public Criteria andLOGIN_COUNTNotEqualTo(Long value) {
            addCriterion("LOGIN_COUNT <>", value, "LOGIN_COUNT");
            return (Criteria) this;
        }

        public Criteria andLOGIN_COUNTGreaterThan(Long value) {
            addCriterion("LOGIN_COUNT >", value, "LOGIN_COUNT");
            return (Criteria) this;
        }

        public Criteria andLOGIN_COUNTGreaterThanOrEqualTo(Long value) {
            addCriterion("LOGIN_COUNT >=", value, "LOGIN_COUNT");
            return (Criteria) this;
        }

        public Criteria andLOGIN_COUNTLessThan(Long value) {
            addCriterion("LOGIN_COUNT <", value, "LOGIN_COUNT");
            return (Criteria) this;
        }

        public Criteria andLOGIN_COUNTLessThanOrEqualTo(Long value) {
            addCriterion("LOGIN_COUNT <=", value, "LOGIN_COUNT");
            return (Criteria) this;
        }

        public Criteria andLOGIN_COUNTIn(List<Long> values) {
            addCriterion("LOGIN_COUNT in", values, "LOGIN_COUNT");
            return (Criteria) this;
        }

        public Criteria andLOGIN_COUNTNotIn(List<Long> values) {
            addCriterion("LOGIN_COUNT not in", values, "LOGIN_COUNT");
            return (Criteria) this;
        }

        public Criteria andLOGIN_COUNTBetween(Long value1, Long value2) {
            addCriterion("LOGIN_COUNT between", value1, value2, "LOGIN_COUNT");
            return (Criteria) this;
        }

        public Criteria andLOGIN_COUNTNotBetween(Long value1, Long value2) {
            addCriterion("LOGIN_COUNT not between", value1, value2, "LOGIN_COUNT");
            return (Criteria) this;
        }

        public Criteria andORG_IDIsNull() {
            addCriterion("ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andORG_IDIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andORG_IDEqualTo(String value) {
            addCriterion("ORG_ID =", value, "ORG_ID");
            return (Criteria) this;
        }

        public Criteria andORG_IDNotEqualTo(String value) {
            addCriterion("ORG_ID <>", value, "ORG_ID");
            return (Criteria) this;
        }

        public Criteria andORG_IDGreaterThan(String value) {
            addCriterion("ORG_ID >", value, "ORG_ID");
            return (Criteria) this;
        }

        public Criteria andORG_IDGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_ID >=", value, "ORG_ID");
            return (Criteria) this;
        }

        public Criteria andORG_IDLessThan(String value) {
            addCriterion("ORG_ID <", value, "ORG_ID");
            return (Criteria) this;
        }

        public Criteria andORG_IDLessThanOrEqualTo(String value) {
            addCriterion("ORG_ID <=", value, "ORG_ID");
            return (Criteria) this;
        }

        public Criteria andORG_IDLike(String value) {
            addCriterion("ORG_ID like", value, "ORG_ID");
            return (Criteria) this;
        }

        public Criteria andORG_IDNotLike(String value) {
            addCriterion("ORG_ID not like", value, "ORG_ID");
            return (Criteria) this;
        }

        public Criteria andORG_IDIn(List<String> values) {
            addCriterion("ORG_ID in", values, "ORG_ID");
            return (Criteria) this;
        }

        public Criteria andORG_IDNotIn(List<String> values) {
            addCriterion("ORG_ID not in", values, "ORG_ID");
            return (Criteria) this;
        }

        public Criteria andORG_IDBetween(String value1, String value2) {
            addCriterion("ORG_ID between", value1, value2, "ORG_ID");
            return (Criteria) this;
        }

        public Criteria andORG_IDNotBetween(String value1, String value2) {
            addCriterion("ORG_ID not between", value1, value2, "ORG_ID");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_user
     *
     * @mbggenerated do_not_delete_during_merge Mon Jun 04 17:08:49 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_user
     *
     * @mbggenerated Mon Jun 04 17:08:49 CST 2018
     */
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