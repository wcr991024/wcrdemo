package com.xinda.model;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductDetailExample() {
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

        public Criteria andImg1IsNull() {
            addCriterion("IMG_1 is null");
            return (Criteria) this;
        }

        public Criteria andImg1IsNotNull() {
            addCriterion("IMG_1 is not null");
            return (Criteria) this;
        }

        public Criteria andImg1EqualTo(String value) {
            addCriterion("IMG_1 =", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1NotEqualTo(String value) {
            addCriterion("IMG_1 <>", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1GreaterThan(String value) {
            addCriterion("IMG_1 >", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1GreaterThanOrEqualTo(String value) {
            addCriterion("IMG_1 >=", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1LessThan(String value) {
            addCriterion("IMG_1 <", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1LessThanOrEqualTo(String value) {
            addCriterion("IMG_1 <=", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1Like(String value) {
            addCriterion("IMG_1 like", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1NotLike(String value) {
            addCriterion("IMG_1 not like", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1In(List<String> values) {
            addCriterion("IMG_1 in", values, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1NotIn(List<String> values) {
            addCriterion("IMG_1 not in", values, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1Between(String value1, String value2) {
            addCriterion("IMG_1 between", value1, value2, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1NotBetween(String value1, String value2) {
            addCriterion("IMG_1 not between", value1, value2, "img1");
            return (Criteria) this;
        }

        public Criteria andImg2IsNull() {
            addCriterion("IMG_2 is null");
            return (Criteria) this;
        }

        public Criteria andImg2IsNotNull() {
            addCriterion("IMG_2 is not null");
            return (Criteria) this;
        }

        public Criteria andImg2EqualTo(String value) {
            addCriterion("IMG_2 =", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2NotEqualTo(String value) {
            addCriterion("IMG_2 <>", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2GreaterThan(String value) {
            addCriterion("IMG_2 >", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2GreaterThanOrEqualTo(String value) {
            addCriterion("IMG_2 >=", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2LessThan(String value) {
            addCriterion("IMG_2 <", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2LessThanOrEqualTo(String value) {
            addCriterion("IMG_2 <=", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2Like(String value) {
            addCriterion("IMG_2 like", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2NotLike(String value) {
            addCriterion("IMG_2 not like", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2In(List<String> values) {
            addCriterion("IMG_2 in", values, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2NotIn(List<String> values) {
            addCriterion("IMG_2 not in", values, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2Between(String value1, String value2) {
            addCriterion("IMG_2 between", value1, value2, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2NotBetween(String value1, String value2) {
            addCriterion("IMG_2 not between", value1, value2, "img2");
            return (Criteria) this;
        }

        public Criteria andImg3IsNull() {
            addCriterion("IMG_3 is null");
            return (Criteria) this;
        }

        public Criteria andImg3IsNotNull() {
            addCriterion("IMG_3 is not null");
            return (Criteria) this;
        }

        public Criteria andImg3EqualTo(String value) {
            addCriterion("IMG_3 =", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3NotEqualTo(String value) {
            addCriterion("IMG_3 <>", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3GreaterThan(String value) {
            addCriterion("IMG_3 >", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3GreaterThanOrEqualTo(String value) {
            addCriterion("IMG_3 >=", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3LessThan(String value) {
            addCriterion("IMG_3 <", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3LessThanOrEqualTo(String value) {
            addCriterion("IMG_3 <=", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3Like(String value) {
            addCriterion("IMG_3 like", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3NotLike(String value) {
            addCriterion("IMG_3 not like", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3In(List<String> values) {
            addCriterion("IMG_3 in", values, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3NotIn(List<String> values) {
            addCriterion("IMG_3 not in", values, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3Between(String value1, String value2) {
            addCriterion("IMG_3 between", value1, value2, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3NotBetween(String value1, String value2) {
            addCriterion("IMG_3 not between", value1, value2, "img3");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andServiceDetailIsNull() {
            addCriterion("SERVICE_DETAIL is null");
            return (Criteria) this;
        }

        public Criteria andServiceDetailIsNotNull() {
            addCriterion("SERVICE_DETAIL is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDetailEqualTo(String value) {
            addCriterion("SERVICE_DETAIL =", value, "serviceDetail");
            return (Criteria) this;
        }

        public Criteria andServiceDetailNotEqualTo(String value) {
            addCriterion("SERVICE_DETAIL <>", value, "serviceDetail");
            return (Criteria) this;
        }

        public Criteria andServiceDetailGreaterThan(String value) {
            addCriterion("SERVICE_DETAIL >", value, "serviceDetail");
            return (Criteria) this;
        }

        public Criteria andServiceDetailGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_DETAIL >=", value, "serviceDetail");
            return (Criteria) this;
        }

        public Criteria andServiceDetailLessThan(String value) {
            addCriterion("SERVICE_DETAIL <", value, "serviceDetail");
            return (Criteria) this;
        }

        public Criteria andServiceDetailLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_DETAIL <=", value, "serviceDetail");
            return (Criteria) this;
        }

        public Criteria andServiceDetailLike(String value) {
            addCriterion("SERVICE_DETAIL like", value, "serviceDetail");
            return (Criteria) this;
        }

        public Criteria andServiceDetailNotLike(String value) {
            addCriterion("SERVICE_DETAIL not like", value, "serviceDetail");
            return (Criteria) this;
        }

        public Criteria andServiceDetailIn(List<String> values) {
            addCriterion("SERVICE_DETAIL in", values, "serviceDetail");
            return (Criteria) this;
        }

        public Criteria andServiceDetailNotIn(List<String> values) {
            addCriterion("SERVICE_DETAIL not in", values, "serviceDetail");
            return (Criteria) this;
        }

        public Criteria andServiceDetailBetween(String value1, String value2) {
            addCriterion("SERVICE_DETAIL between", value1, value2, "serviceDetail");
            return (Criteria) this;
        }

        public Criteria andServiceDetailNotBetween(String value1, String value2) {
            addCriterion("SERVICE_DETAIL not between", value1, value2, "serviceDetail");
            return (Criteria) this;
        }

        public Criteria andCommonQusIsNull() {
            addCriterion("COMMON_QUS is null");
            return (Criteria) this;
        }

        public Criteria andCommonQusIsNotNull() {
            addCriterion("COMMON_QUS is not null");
            return (Criteria) this;
        }

        public Criteria andCommonQusEqualTo(String value) {
            addCriterion("COMMON_QUS =", value, "commonQus");
            return (Criteria) this;
        }

        public Criteria andCommonQusNotEqualTo(String value) {
            addCriterion("COMMON_QUS <>", value, "commonQus");
            return (Criteria) this;
        }

        public Criteria andCommonQusGreaterThan(String value) {
            addCriterion("COMMON_QUS >", value, "commonQus");
            return (Criteria) this;
        }

        public Criteria andCommonQusGreaterThanOrEqualTo(String value) {
            addCriterion("COMMON_QUS >=", value, "commonQus");
            return (Criteria) this;
        }

        public Criteria andCommonQusLessThan(String value) {
            addCriterion("COMMON_QUS <", value, "commonQus");
            return (Criteria) this;
        }

        public Criteria andCommonQusLessThanOrEqualTo(String value) {
            addCriterion("COMMON_QUS <=", value, "commonQus");
            return (Criteria) this;
        }

        public Criteria andCommonQusLike(String value) {
            addCriterion("COMMON_QUS like", value, "commonQus");
            return (Criteria) this;
        }

        public Criteria andCommonQusNotLike(String value) {
            addCriterion("COMMON_QUS not like", value, "commonQus");
            return (Criteria) this;
        }

        public Criteria andCommonQusIn(List<String> values) {
            addCriterion("COMMON_QUS in", values, "commonQus");
            return (Criteria) this;
        }

        public Criteria andCommonQusNotIn(List<String> values) {
            addCriterion("COMMON_QUS not in", values, "commonQus");
            return (Criteria) this;
        }

        public Criteria andCommonQusBetween(String value1, String value2) {
            addCriterion("COMMON_QUS between", value1, value2, "commonQus");
            return (Criteria) this;
        }

        public Criteria andCommonQusNotBetween(String value1, String value2) {
            addCriterion("COMMON_QUS not between", value1, value2, "commonQus");
            return (Criteria) this;
        }

        public Criteria andFormModelIsNull() {
            addCriterion("FORM_MODEL is null");
            return (Criteria) this;
        }

        public Criteria andFormModelIsNotNull() {
            addCriterion("FORM_MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andFormModelEqualTo(String value) {
            addCriterion("FORM_MODEL =", value, "formModel");
            return (Criteria) this;
        }

        public Criteria andFormModelNotEqualTo(String value) {
            addCriterion("FORM_MODEL <>", value, "formModel");
            return (Criteria) this;
        }

        public Criteria andFormModelGreaterThan(String value) {
            addCriterion("FORM_MODEL >", value, "formModel");
            return (Criteria) this;
        }

        public Criteria andFormModelGreaterThanOrEqualTo(String value) {
            addCriterion("FORM_MODEL >=", value, "formModel");
            return (Criteria) this;
        }

        public Criteria andFormModelLessThan(String value) {
            addCriterion("FORM_MODEL <", value, "formModel");
            return (Criteria) this;
        }

        public Criteria andFormModelLessThanOrEqualTo(String value) {
            addCriterion("FORM_MODEL <=", value, "formModel");
            return (Criteria) this;
        }

        public Criteria andFormModelLike(String value) {
            addCriterion("FORM_MODEL like", value, "formModel");
            return (Criteria) this;
        }

        public Criteria andFormModelNotLike(String value) {
            addCriterion("FORM_MODEL not like", value, "formModel");
            return (Criteria) this;
        }

        public Criteria andFormModelIn(List<String> values) {
            addCriterion("FORM_MODEL in", values, "formModel");
            return (Criteria) this;
        }

        public Criteria andFormModelNotIn(List<String> values) {
            addCriterion("FORM_MODEL not in", values, "formModel");
            return (Criteria) this;
        }

        public Criteria andFormModelBetween(String value1, String value2) {
            addCriterion("FORM_MODEL between", value1, value2, "formModel");
            return (Criteria) this;
        }

        public Criteria andFormModelNotBetween(String value1, String value2) {
            addCriterion("FORM_MODEL not between", value1, value2, "formModel");
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