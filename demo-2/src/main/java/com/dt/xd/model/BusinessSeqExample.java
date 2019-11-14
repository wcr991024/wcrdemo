package com.xinda.model;

import java.util.ArrayList;
import java.util.List;

public class BusinessSeqExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusinessSeqExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSeqCodeIsNull() {
            addCriterion("SEQ_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSeqCodeIsNotNull() {
            addCriterion("SEQ_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSeqCodeEqualTo(String value) {
            addCriterion("SEQ_CODE =", value, "seqCode");
            return (Criteria) this;
        }

        public Criteria andSeqCodeNotEqualTo(String value) {
            addCriterion("SEQ_CODE <>", value, "seqCode");
            return (Criteria) this;
        }

        public Criteria andSeqCodeGreaterThan(String value) {
            addCriterion("SEQ_CODE >", value, "seqCode");
            return (Criteria) this;
        }

        public Criteria andSeqCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SEQ_CODE >=", value, "seqCode");
            return (Criteria) this;
        }

        public Criteria andSeqCodeLessThan(String value) {
            addCriterion("SEQ_CODE <", value, "seqCode");
            return (Criteria) this;
        }

        public Criteria andSeqCodeLessThanOrEqualTo(String value) {
            addCriterion("SEQ_CODE <=", value, "seqCode");
            return (Criteria) this;
        }

        public Criteria andSeqCodeLike(String value) {
            addCriterion("SEQ_CODE like", value, "seqCode");
            return (Criteria) this;
        }

        public Criteria andSeqCodeNotLike(String value) {
            addCriterion("SEQ_CODE not like", value, "seqCode");
            return (Criteria) this;
        }

        public Criteria andSeqCodeIn(List<String> values) {
            addCriterion("SEQ_CODE in", values, "seqCode");
            return (Criteria) this;
        }

        public Criteria andSeqCodeNotIn(List<String> values) {
            addCriterion("SEQ_CODE not in", values, "seqCode");
            return (Criteria) this;
        }

        public Criteria andSeqCodeBetween(String value1, String value2) {
            addCriterion("SEQ_CODE between", value1, value2, "seqCode");
            return (Criteria) this;
        }

        public Criteria andSeqCodeNotBetween(String value1, String value2) {
            addCriterion("SEQ_CODE not between", value1, value2, "seqCode");
            return (Criteria) this;
        }

        public Criteria andSeqValueIsNull() {
            addCriterion("SEQ_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andSeqValueIsNotNull() {
            addCriterion("SEQ_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andSeqValueEqualTo(Integer value) {
            addCriterion("SEQ_VALUE =", value, "seqValue");
            return (Criteria) this;
        }

        public Criteria andSeqValueNotEqualTo(Integer value) {
            addCriterion("SEQ_VALUE <>", value, "seqValue");
            return (Criteria) this;
        }

        public Criteria andSeqValueGreaterThan(Integer value) {
            addCriterion("SEQ_VALUE >", value, "seqValue");
            return (Criteria) this;
        }

        public Criteria andSeqValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEQ_VALUE >=", value, "seqValue");
            return (Criteria) this;
        }

        public Criteria andSeqValueLessThan(Integer value) {
            addCriterion("SEQ_VALUE <", value, "seqValue");
            return (Criteria) this;
        }

        public Criteria andSeqValueLessThanOrEqualTo(Integer value) {
            addCriterion("SEQ_VALUE <=", value, "seqValue");
            return (Criteria) this;
        }

        public Criteria andSeqValueIn(List<Integer> values) {
            addCriterion("SEQ_VALUE in", values, "seqValue");
            return (Criteria) this;
        }

        public Criteria andSeqValueNotIn(List<Integer> values) {
            addCriterion("SEQ_VALUE not in", values, "seqValue");
            return (Criteria) this;
        }

        public Criteria andSeqValueBetween(Integer value1, Integer value2) {
            addCriterion("SEQ_VALUE between", value1, value2, "seqValue");
            return (Criteria) this;
        }

        public Criteria andSeqValueNotBetween(Integer value1, Integer value2) {
            addCriterion("SEQ_VALUE not between", value1, value2, "seqValue");
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