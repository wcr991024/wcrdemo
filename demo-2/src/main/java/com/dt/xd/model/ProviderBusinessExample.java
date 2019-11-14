package com.xinda.model;

import java.util.ArrayList;
import java.util.List;

public class ProviderBusinessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProviderBusinessExample() {
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

        public Criteria andServiceMoneyIsNull() {
            addCriterion("SERVICE_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyIsNotNull() {
            addCriterion("SERVICE_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyEqualTo(Integer value) {
            addCriterion("SERVICE_MONEY =", value, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyNotEqualTo(Integer value) {
            addCriterion("SERVICE_MONEY <>", value, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyGreaterThan(Integer value) {
            addCriterion("SERVICE_MONEY >", value, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_MONEY >=", value, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyLessThan(Integer value) {
            addCriterion("SERVICE_MONEY <", value, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_MONEY <=", value, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyIn(List<Integer> values) {
            addCriterion("SERVICE_MONEY in", values, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyNotIn(List<Integer> values) {
            addCriterion("SERVICE_MONEY not in", values, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_MONEY between", value1, value2, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_MONEY not between", value1, value2, "serviceMoney");
            return (Criteria) this;
        }

        public Criteria andServiceNumIsNull() {
            addCriterion("SERVICE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andServiceNumIsNotNull() {
            addCriterion("SERVICE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNumEqualTo(Integer value) {
            addCriterion("SERVICE_NUM =", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumNotEqualTo(Integer value) {
            addCriterion("SERVICE_NUM <>", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumGreaterThan(Integer value) {
            addCriterion("SERVICE_NUM >", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_NUM >=", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumLessThan(Integer value) {
            addCriterion("SERVICE_NUM <", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumLessThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_NUM <=", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumIn(List<Integer> values) {
            addCriterion("SERVICE_NUM in", values, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumNotIn(List<Integer> values) {
            addCriterion("SERVICE_NUM not in", values, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_NUM between", value1, value2, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumNotBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_NUM not between", value1, value2, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andProfitMoneyIsNull() {
            addCriterion("PROFIT_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andProfitMoneyIsNotNull() {
            addCriterion("PROFIT_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andProfitMoneyEqualTo(Integer value) {
            addCriterion("PROFIT_MONEY =", value, "profitMoney");
            return (Criteria) this;
        }

        public Criteria andProfitMoneyNotEqualTo(Integer value) {
            addCriterion("PROFIT_MONEY <>", value, "profitMoney");
            return (Criteria) this;
        }

        public Criteria andProfitMoneyGreaterThan(Integer value) {
            addCriterion("PROFIT_MONEY >", value, "profitMoney");
            return (Criteria) this;
        }

        public Criteria andProfitMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROFIT_MONEY >=", value, "profitMoney");
            return (Criteria) this;
        }

        public Criteria andProfitMoneyLessThan(Integer value) {
            addCriterion("PROFIT_MONEY <", value, "profitMoney");
            return (Criteria) this;
        }

        public Criteria andProfitMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("PROFIT_MONEY <=", value, "profitMoney");
            return (Criteria) this;
        }

        public Criteria andProfitMoneyIn(List<Integer> values) {
            addCriterion("PROFIT_MONEY in", values, "profitMoney");
            return (Criteria) this;
        }

        public Criteria andProfitMoneyNotIn(List<Integer> values) {
            addCriterion("PROFIT_MONEY not in", values, "profitMoney");
            return (Criteria) this;
        }

        public Criteria andProfitMoneyBetween(Integer value1, Integer value2) {
            addCriterion("PROFIT_MONEY between", value1, value2, "profitMoney");
            return (Criteria) this;
        }

        public Criteria andProfitMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("PROFIT_MONEY not between", value1, value2, "profitMoney");
            return (Criteria) this;
        }

        public Criteria andSettleMoneyIsNull() {
            addCriterion("SETTLE_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andSettleMoneyIsNotNull() {
            addCriterion("SETTLE_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andSettleMoneyEqualTo(Integer value) {
            addCriterion("SETTLE_MONEY =", value, "settleMoney");
            return (Criteria) this;
        }

        public Criteria andSettleMoneyNotEqualTo(Integer value) {
            addCriterion("SETTLE_MONEY <>", value, "settleMoney");
            return (Criteria) this;
        }

        public Criteria andSettleMoneyGreaterThan(Integer value) {
            addCriterion("SETTLE_MONEY >", value, "settleMoney");
            return (Criteria) this;
        }

        public Criteria andSettleMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("SETTLE_MONEY >=", value, "settleMoney");
            return (Criteria) this;
        }

        public Criteria andSettleMoneyLessThan(Integer value) {
            addCriterion("SETTLE_MONEY <", value, "settleMoney");
            return (Criteria) this;
        }

        public Criteria andSettleMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("SETTLE_MONEY <=", value, "settleMoney");
            return (Criteria) this;
        }

        public Criteria andSettleMoneyIn(List<Integer> values) {
            addCriterion("SETTLE_MONEY in", values, "settleMoney");
            return (Criteria) this;
        }

        public Criteria andSettleMoneyNotIn(List<Integer> values) {
            addCriterion("SETTLE_MONEY not in", values, "settleMoney");
            return (Criteria) this;
        }

        public Criteria andSettleMoneyBetween(Integer value1, Integer value2) {
            addCriterion("SETTLE_MONEY between", value1, value2, "settleMoney");
            return (Criteria) this;
        }

        public Criteria andSettleMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("SETTLE_MONEY not between", value1, value2, "settleMoney");
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