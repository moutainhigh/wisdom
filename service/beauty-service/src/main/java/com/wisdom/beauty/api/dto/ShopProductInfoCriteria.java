package com.wisdom.beauty.api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopProductInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public ShopProductInfoCriteria() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setPageSize(int pageSize) {
        this.pageSize=pageSize;
    }

    public int getPageSize() {
        return pageSize;
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneNameIsNull() {
            addCriterion("product_type_one_name is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneNameIsNotNull() {
            addCriterion("product_type_one_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneNameEqualTo(String value) {
            addCriterion("product_type_one_name =", value, "productTypeOneName");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneNameNotEqualTo(String value) {
            addCriterion("product_type_one_name <>", value, "productTypeOneName");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneNameGreaterThan(String value) {
            addCriterion("product_type_one_name >", value, "productTypeOneName");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_type_one_name >=", value, "productTypeOneName");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneNameLessThan(String value) {
            addCriterion("product_type_one_name <", value, "productTypeOneName");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneNameLessThanOrEqualTo(String value) {
            addCriterion("product_type_one_name <=", value, "productTypeOneName");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneNameLike(String value) {
            addCriterion("product_type_one_name like", value, "productTypeOneName");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneNameNotLike(String value) {
            addCriterion("product_type_one_name not like", value, "productTypeOneName");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneNameIn(List<String> values) {
            addCriterion("product_type_one_name in", values, "productTypeOneName");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneNameNotIn(List<String> values) {
            addCriterion("product_type_one_name not in", values, "productTypeOneName");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneNameBetween(String value1, String value2) {
            addCriterion("product_type_one_name between", value1, value2, "productTypeOneName");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneNameNotBetween(String value1, String value2) {
            addCriterion("product_type_one_name not between", value1, value2, "productTypeOneName");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneIdIsNull() {
            addCriterion("product_type_one_id is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneIdIsNotNull() {
            addCriterion("product_type_one_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneIdEqualTo(String value) {
            addCriterion("product_type_one_id =", value, "productTypeOneId");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneIdNotEqualTo(String value) {
            addCriterion("product_type_one_id <>", value, "productTypeOneId");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneIdGreaterThan(String value) {
            addCriterion("product_type_one_id >", value, "productTypeOneId");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_type_one_id >=", value, "productTypeOneId");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneIdLessThan(String value) {
            addCriterion("product_type_one_id <", value, "productTypeOneId");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneIdLessThanOrEqualTo(String value) {
            addCriterion("product_type_one_id <=", value, "productTypeOneId");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneIdLike(String value) {
            addCriterion("product_type_one_id like", value, "productTypeOneId");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneIdNotLike(String value) {
            addCriterion("product_type_one_id not like", value, "productTypeOneId");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneIdIn(List<String> values) {
            addCriterion("product_type_one_id in", values, "productTypeOneId");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneIdNotIn(List<String> values) {
            addCriterion("product_type_one_id not in", values, "productTypeOneId");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneIdBetween(String value1, String value2) {
            addCriterion("product_type_one_id between", value1, value2, "productTypeOneId");
            return (Criteria) this;
        }

        public Criteria andProductTypeOneIdNotBetween(String value1, String value2) {
            addCriterion("product_type_one_id not between", value1, value2, "productTypeOneId");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoNameIsNull() {
            addCriterion("product_type_two_name is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoNameIsNotNull() {
            addCriterion("product_type_two_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoNameEqualTo(String value) {
            addCriterion("product_type_two_name =", value, "productTypeTwoName");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoNameNotEqualTo(String value) {
            addCriterion("product_type_two_name <>", value, "productTypeTwoName");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoNameGreaterThan(String value) {
            addCriterion("product_type_two_name >", value, "productTypeTwoName");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_type_two_name >=", value, "productTypeTwoName");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoNameLessThan(String value) {
            addCriterion("product_type_two_name <", value, "productTypeTwoName");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoNameLessThanOrEqualTo(String value) {
            addCriterion("product_type_two_name <=", value, "productTypeTwoName");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoNameLike(String value) {
            addCriterion("product_type_two_name like", value, "productTypeTwoName");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoNameNotLike(String value) {
            addCriterion("product_type_two_name not like", value, "productTypeTwoName");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoNameIn(List<String> values) {
            addCriterion("product_type_two_name in", values, "productTypeTwoName");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoNameNotIn(List<String> values) {
            addCriterion("product_type_two_name not in", values, "productTypeTwoName");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoNameBetween(String value1, String value2) {
            addCriterion("product_type_two_name between", value1, value2, "productTypeTwoName");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoNameNotBetween(String value1, String value2) {
            addCriterion("product_type_two_name not between", value1, value2, "productTypeTwoName");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoIdIsNull() {
            addCriterion("product_type_two_id is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoIdIsNotNull() {
            addCriterion("product_type_two_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoIdEqualTo(String value) {
            addCriterion("product_type_two_id =", value, "productTypeTwoId");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoIdNotEqualTo(String value) {
            addCriterion("product_type_two_id <>", value, "productTypeTwoId");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoIdGreaterThan(String value) {
            addCriterion("product_type_two_id >", value, "productTypeTwoId");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_type_two_id >=", value, "productTypeTwoId");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoIdLessThan(String value) {
            addCriterion("product_type_two_id <", value, "productTypeTwoId");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoIdLessThanOrEqualTo(String value) {
            addCriterion("product_type_two_id <=", value, "productTypeTwoId");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoIdLike(String value) {
            addCriterion("product_type_two_id like", value, "productTypeTwoId");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoIdNotLike(String value) {
            addCriterion("product_type_two_id not like", value, "productTypeTwoId");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoIdIn(List<String> values) {
            addCriterion("product_type_two_id in", values, "productTypeTwoId");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoIdNotIn(List<String> values) {
            addCriterion("product_type_two_id not in", values, "productTypeTwoId");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoIdBetween(String value1, String value2) {
            addCriterion("product_type_two_id between", value1, value2, "productTypeTwoId");
            return (Criteria) this;
        }

        public Criteria andProductTypeTwoIdNotBetween(String value1, String value2) {
            addCriterion("product_type_two_id not between", value1, value2, "productTypeTwoId");
            return (Criteria) this;
        }

        public Criteria andProductUrlIsNull() {
            addCriterion("product_url is null");
            return (Criteria) this;
        }

        public Criteria andProductUrlIsNotNull() {
            addCriterion("product_url is not null");
            return (Criteria) this;
        }

        public Criteria andProductUrlEqualTo(String value) {
            addCriterion("product_url =", value, "productUrl");
            return (Criteria) this;
        }

        public Criteria andProductUrlNotEqualTo(String value) {
            addCriterion("product_url <>", value, "productUrl");
            return (Criteria) this;
        }

        public Criteria andProductUrlGreaterThan(String value) {
            addCriterion("product_url >", value, "productUrl");
            return (Criteria) this;
        }

        public Criteria andProductUrlGreaterThanOrEqualTo(String value) {
            addCriterion("product_url >=", value, "productUrl");
            return (Criteria) this;
        }

        public Criteria andProductUrlLessThan(String value) {
            addCriterion("product_url <", value, "productUrl");
            return (Criteria) this;
        }

        public Criteria andProductUrlLessThanOrEqualTo(String value) {
            addCriterion("product_url <=", value, "productUrl");
            return (Criteria) this;
        }

        public Criteria andProductUrlLike(String value) {
            addCriterion("product_url like", value, "productUrl");
            return (Criteria) this;
        }

        public Criteria andProductUrlNotLike(String value) {
            addCriterion("product_url not like", value, "productUrl");
            return (Criteria) this;
        }

        public Criteria andProductUrlIn(List<String> values) {
            addCriterion("product_url in", values, "productUrl");
            return (Criteria) this;
        }

        public Criteria andProductUrlNotIn(List<String> values) {
            addCriterion("product_url not in", values, "productUrl");
            return (Criteria) this;
        }

        public Criteria andProductUrlBetween(String value1, String value2) {
            addCriterion("product_url between", value1, value2, "productUrl");
            return (Criteria) this;
        }

        public Criteria andProductUrlNotBetween(String value1, String value2) {
            addCriterion("product_url not between", value1, value2, "productUrl");
            return (Criteria) this;
        }

        public Criteria andProductPositionIsNull() {
            addCriterion("product_position is null");
            return (Criteria) this;
        }

        public Criteria andProductPositionIsNotNull() {
            addCriterion("product_position is not null");
            return (Criteria) this;
        }

        public Criteria andProductPositionEqualTo(String value) {
            addCriterion("product_position =", value, "productPosition");
            return (Criteria) this;
        }

        public Criteria andProductPositionNotEqualTo(String value) {
            addCriterion("product_position <>", value, "productPosition");
            return (Criteria) this;
        }

        public Criteria andProductPositionGreaterThan(String value) {
            addCriterion("product_position >", value, "productPosition");
            return (Criteria) this;
        }

        public Criteria andProductPositionGreaterThanOrEqualTo(String value) {
            addCriterion("product_position >=", value, "productPosition");
            return (Criteria) this;
        }

        public Criteria andProductPositionLessThan(String value) {
            addCriterion("product_position <", value, "productPosition");
            return (Criteria) this;
        }

        public Criteria andProductPositionLessThanOrEqualTo(String value) {
            addCriterion("product_position <=", value, "productPosition");
            return (Criteria) this;
        }

        public Criteria andProductPositionLike(String value) {
            addCriterion("product_position like", value, "productPosition");
            return (Criteria) this;
        }

        public Criteria andProductPositionNotLike(String value) {
            addCriterion("product_position not like", value, "productPosition");
            return (Criteria) this;
        }

        public Criteria andProductPositionIn(List<String> values) {
            addCriterion("product_position in", values, "productPosition");
            return (Criteria) this;
        }

        public Criteria andProductPositionNotIn(List<String> values) {
            addCriterion("product_position not in", values, "productPosition");
            return (Criteria) this;
        }

        public Criteria andProductPositionBetween(String value1, String value2) {
            addCriterion("product_position between", value1, value2, "productPosition");
            return (Criteria) this;
        }

        public Criteria andProductPositionNotBetween(String value1, String value2) {
            addCriterion("product_position not between", value1, value2, "productPosition");
            return (Criteria) this;
        }

        public Criteria andProductFunctionIsNull() {
            addCriterion("product_function is null");
            return (Criteria) this;
        }

        public Criteria andProductFunctionIsNotNull() {
            addCriterion("product_function is not null");
            return (Criteria) this;
        }

        public Criteria andProductFunctionEqualTo(String value) {
            addCriterion("product_function =", value, "productFunction");
            return (Criteria) this;
        }

        public Criteria andProductFunctionNotEqualTo(String value) {
            addCriterion("product_function <>", value, "productFunction");
            return (Criteria) this;
        }

        public Criteria andProductFunctionGreaterThan(String value) {
            addCriterion("product_function >", value, "productFunction");
            return (Criteria) this;
        }

        public Criteria andProductFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("product_function >=", value, "productFunction");
            return (Criteria) this;
        }

        public Criteria andProductFunctionLessThan(String value) {
            addCriterion("product_function <", value, "productFunction");
            return (Criteria) this;
        }

        public Criteria andProductFunctionLessThanOrEqualTo(String value) {
            addCriterion("product_function <=", value, "productFunction");
            return (Criteria) this;
        }

        public Criteria andProductFunctionLike(String value) {
            addCriterion("product_function like", value, "productFunction");
            return (Criteria) this;
        }

        public Criteria andProductFunctionNotLike(String value) {
            addCriterion("product_function not like", value, "productFunction");
            return (Criteria) this;
        }

        public Criteria andProductFunctionIn(List<String> values) {
            addCriterion("product_function in", values, "productFunction");
            return (Criteria) this;
        }

        public Criteria andProductFunctionNotIn(List<String> values) {
            addCriterion("product_function not in", values, "productFunction");
            return (Criteria) this;
        }

        public Criteria andProductFunctionBetween(String value1, String value2) {
            addCriterion("product_function between", value1, value2, "productFunction");
            return (Criteria) this;
        }

        public Criteria andProductFunctionNotBetween(String value1, String value2) {
            addCriterion("product_function not between", value1, value2, "productFunction");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlIsNull() {
            addCriterion("qr_code_url is null");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlIsNotNull() {
            addCriterion("qr_code_url is not null");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlEqualTo(String value) {
            addCriterion("qr_code_url =", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlNotEqualTo(String value) {
            addCriterion("qr_code_url <>", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlGreaterThan(String value) {
            addCriterion("qr_code_url >", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("qr_code_url >=", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlLessThan(String value) {
            addCriterion("qr_code_url <", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlLessThanOrEqualTo(String value) {
            addCriterion("qr_code_url <=", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlLike(String value) {
            addCriterion("qr_code_url like", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlNotLike(String value) {
            addCriterion("qr_code_url not like", value, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlIn(List<String> values) {
            addCriterion("qr_code_url in", values, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlNotIn(List<String> values) {
            addCriterion("qr_code_url not in", values, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlBetween(String value1, String value2) {
            addCriterion("qr_code_url between", value1, value2, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andQrCodeUrlNotBetween(String value1, String value2) {
            addCriterion("qr_code_url not between", value1, value2, "qrCodeUrl");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNull() {
            addCriterion("product_type is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("product_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(String value) {
            addCriterion("product_type =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(String value) {
            addCriterion("product_type <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(String value) {
            addCriterion("product_type >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(String value) {
            addCriterion("product_type >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(String value) {
            addCriterion("product_type <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(String value) {
            addCriterion("product_type <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLike(String value) {
            addCriterion("product_type like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotLike(String value) {
            addCriterion("product_type not like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<String> values) {
            addCriterion("product_type in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<String> values) {
            addCriterion("product_type not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(String value1, String value2) {
            addCriterion("product_type between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(String value1, String value2) {
            addCriterion("product_type not between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andQualityPeriodIsNull() {
            addCriterion("quality_period is null");
            return (Criteria) this;
        }

        public Criteria andQualityPeriodIsNotNull() {
            addCriterion("quality_period is not null");
            return (Criteria) this;
        }

        public Criteria andQualityPeriodEqualTo(Integer value) {
            addCriterion("quality_period =", value, "qualityPeriod");
            return (Criteria) this;
        }

        public Criteria andQualityPeriodNotEqualTo(Integer value) {
            addCriterion("quality_period <>", value, "qualityPeriod");
            return (Criteria) this;
        }

        public Criteria andQualityPeriodGreaterThan(Integer value) {
            addCriterion("quality_period >", value, "qualityPeriod");
            return (Criteria) this;
        }

        public Criteria andQualityPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("quality_period >=", value, "qualityPeriod");
            return (Criteria) this;
        }

        public Criteria andQualityPeriodLessThan(Integer value) {
            addCriterion("quality_period <", value, "qualityPeriod");
            return (Criteria) this;
        }

        public Criteria andQualityPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("quality_period <=", value, "qualityPeriod");
            return (Criteria) this;
        }

        public Criteria andQualityPeriodIn(List<Integer> values) {
            addCriterion("quality_period in", values, "qualityPeriod");
            return (Criteria) this;
        }

        public Criteria andQualityPeriodNotIn(List<Integer> values) {
            addCriterion("quality_period not in", values, "qualityPeriod");
            return (Criteria) this;
        }

        public Criteria andQualityPeriodBetween(Integer value1, Integer value2) {
            addCriterion("quality_period between", value1, value2, "qualityPeriod");
            return (Criteria) this;
        }

        public Criteria andQualityPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("quality_period not between", value1, value2, "qualityPeriod");
            return (Criteria) this;
        }

        public Criteria andProductWarningDayIsNull() {
            addCriterion("product_warning_day is null");
            return (Criteria) this;
        }

        public Criteria andProductWarningDayIsNotNull() {
            addCriterion("product_warning_day is not null");
            return (Criteria) this;
        }

        public Criteria andProductWarningDayEqualTo(Integer value) {
            addCriterion("product_warning_day =", value, "productWarningDay");
            return (Criteria) this;
        }

        public Criteria andProductWarningDayNotEqualTo(Integer value) {
            addCriterion("product_warning_day <>", value, "productWarningDay");
            return (Criteria) this;
        }

        public Criteria andProductWarningDayGreaterThan(Integer value) {
            addCriterion("product_warning_day >", value, "productWarningDay");
            return (Criteria) this;
        }

        public Criteria andProductWarningDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_warning_day >=", value, "productWarningDay");
            return (Criteria) this;
        }

        public Criteria andProductWarningDayLessThan(Integer value) {
            addCriterion("product_warning_day <", value, "productWarningDay");
            return (Criteria) this;
        }

        public Criteria andProductWarningDayLessThanOrEqualTo(Integer value) {
            addCriterion("product_warning_day <=", value, "productWarningDay");
            return (Criteria) this;
        }

        public Criteria andProductWarningDayIn(List<Integer> values) {
            addCriterion("product_warning_day in", values, "productWarningDay");
            return (Criteria) this;
        }

        public Criteria andProductWarningDayNotIn(List<Integer> values) {
            addCriterion("product_warning_day not in", values, "productWarningDay");
            return (Criteria) this;
        }

        public Criteria andProductWarningDayBetween(Integer value1, Integer value2) {
            addCriterion("product_warning_day between", value1, value2, "productWarningDay");
            return (Criteria) this;
        }

        public Criteria andProductWarningDayNotBetween(Integer value1, Integer value2) {
            addCriterion("product_warning_day not between", value1, value2, "productWarningDay");
            return (Criteria) this;
        }

        public Criteria andProductWarningNumIsNull() {
            addCriterion("product_warning_num is null");
            return (Criteria) this;
        }

        public Criteria andProductWarningNumIsNotNull() {
            addCriterion("product_warning_num is not null");
            return (Criteria) this;
        }

        public Criteria andProductWarningNumEqualTo(Integer value) {
            addCriterion("product_warning_num =", value, "productWarningNum");
            return (Criteria) this;
        }

        public Criteria andProductWarningNumNotEqualTo(Integer value) {
            addCriterion("product_warning_num <>", value, "productWarningNum");
            return (Criteria) this;
        }

        public Criteria andProductWarningNumGreaterThan(Integer value) {
            addCriterion("product_warning_num >", value, "productWarningNum");
            return (Criteria) this;
        }

        public Criteria andProductWarningNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_warning_num >=", value, "productWarningNum");
            return (Criteria) this;
        }

        public Criteria andProductWarningNumLessThan(Integer value) {
            addCriterion("product_warning_num <", value, "productWarningNum");
            return (Criteria) this;
        }

        public Criteria andProductWarningNumLessThanOrEqualTo(Integer value) {
            addCriterion("product_warning_num <=", value, "productWarningNum");
            return (Criteria) this;
        }

        public Criteria andProductWarningNumIn(List<Integer> values) {
            addCriterion("product_warning_num in", values, "productWarningNum");
            return (Criteria) this;
        }

        public Criteria andProductWarningNumNotIn(List<Integer> values) {
            addCriterion("product_warning_num not in", values, "productWarningNum");
            return (Criteria) this;
        }

        public Criteria andProductWarningNumBetween(Integer value1, Integer value2) {
            addCriterion("product_warning_num between", value1, value2, "productWarningNum");
            return (Criteria) this;
        }

        public Criteria andProductWarningNumNotBetween(Integer value1, Integer value2) {
            addCriterion("product_warning_num not between", value1, value2, "productWarningNum");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNull() {
            addCriterion("market_price is null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNotNull() {
            addCriterion("market_price is not null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceEqualTo(Long value) {
            addCriterion("market_price =", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotEqualTo(Long value) {
            addCriterion("market_price <>", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThan(Long value) {
            addCriterion("market_price >", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("market_price >=", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThan(Long value) {
            addCriterion("market_price <", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThanOrEqualTo(Long value) {
            addCriterion("market_price <=", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIn(List<Long> values) {
            addCriterion("market_price in", values, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotIn(List<Long> values) {
            addCriterion("market_price not in", values, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceBetween(Long value1, Long value2) {
            addCriterion("market_price between", value1, value2, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotBetween(Long value1, Long value2) {
            addCriterion("market_price not between", value1, value2, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNull() {
            addCriterion("discount_price is null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNotNull() {
            addCriterion("discount_price is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceEqualTo(Long value) {
            addCriterion("discount_price =", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotEqualTo(Long value) {
            addCriterion("discount_price <>", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThan(Long value) {
            addCriterion("discount_price >", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("discount_price >=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThan(Long value) {
            addCriterion("discount_price <", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThanOrEqualTo(Long value) {
            addCriterion("discount_price <=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIn(List<Long> values) {
            addCriterion("discount_price in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotIn(List<Long> values) {
            addCriterion("discount_price not in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceBetween(Long value1, Long value2) {
            addCriterion("discount_price between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotBetween(Long value1, Long value2) {
            addCriterion("discount_price not between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("product_code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("product_code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("product_code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("product_code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("product_code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("product_code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("product_code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("product_code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("product_code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("product_code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("product_code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("product_code not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductUnitIsNull() {
            addCriterion("product_unit is null");
            return (Criteria) this;
        }

        public Criteria andProductUnitIsNotNull() {
            addCriterion("product_unit is not null");
            return (Criteria) this;
        }

        public Criteria andProductUnitEqualTo(Long value) {
            addCriterion("product_unit =", value, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitNotEqualTo(Long value) {
            addCriterion("product_unit <>", value, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitGreaterThan(Long value) {
            addCriterion("product_unit >", value, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitGreaterThanOrEqualTo(Long value) {
            addCriterion("product_unit >=", value, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitLessThan(Long value) {
            addCriterion("product_unit <", value, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitLessThanOrEqualTo(Long value) {
            addCriterion("product_unit <=", value, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitIn(List<Long> values) {
            addCriterion("product_unit in", values, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitNotIn(List<Long> values) {
            addCriterion("product_unit not in", values, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitBetween(Long value1, Long value2) {
            addCriterion("product_unit between", value1, value2, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductUnitNotBetween(Long value1, Long value2) {
            addCriterion("product_unit not between", value1, value2, "productUnit");
            return (Criteria) this;
        }

        public Criteria andProductSpecIsNull() {
            addCriterion("product_spec is null");
            return (Criteria) this;
        }

        public Criteria andProductSpecIsNotNull() {
            addCriterion("product_spec is not null");
            return (Criteria) this;
        }

        public Criteria andProductSpecEqualTo(String value) {
            addCriterion("product_spec =", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecNotEqualTo(String value) {
            addCriterion("product_spec <>", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecGreaterThan(String value) {
            addCriterion("product_spec >", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecGreaterThanOrEqualTo(String value) {
            addCriterion("product_spec >=", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecLessThan(String value) {
            addCriterion("product_spec <", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecLessThanOrEqualTo(String value) {
            addCriterion("product_spec <=", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecLike(String value) {
            addCriterion("product_spec like", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecNotLike(String value) {
            addCriterion("product_spec not like", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecIn(List<String> values) {
            addCriterion("product_spec in", values, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecNotIn(List<String> values) {
            addCriterion("product_spec not in", values, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecBetween(String value1, String value2) {
            addCriterion("product_spec between", value1, value2, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecNotBetween(String value1, String value2) {
            addCriterion("product_spec not between", value1, value2, "productSpec");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNull() {
            addCriterion("introduce is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNotNull() {
            addCriterion("introduce is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceEqualTo(String value) {
            addCriterion("introduce =", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotEqualTo(String value) {
            addCriterion("introduce <>", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThan(String value) {
            addCriterion("introduce >", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("introduce >=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThan(String value) {
            addCriterion("introduce <", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThanOrEqualTo(String value) {
            addCriterion("introduce <=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLike(String value) {
            addCriterion("introduce like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotLike(String value) {
            addCriterion("introduce not like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceIn(List<String> values) {
            addCriterion("introduce in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotIn(List<String> values) {
            addCriterion("introduce not in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceBetween(String value1, String value2) {
            addCriterion("introduce between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotBetween(String value1, String value2) {
            addCriterion("introduce not between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIsDisplayIsNull() {
            addCriterion("is_display is null");
            return (Criteria) this;
        }

        public Criteria andIsDisplayIsNotNull() {
            addCriterion("is_display is not null");
            return (Criteria) this;
        }

        public Criteria andIsDisplayEqualTo(String value) {
            addCriterion("is_display =", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayNotEqualTo(String value) {
            addCriterion("is_display <>", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayGreaterThan(String value) {
            addCriterion("is_display >", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayGreaterThanOrEqualTo(String value) {
            addCriterion("is_display >=", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayLessThan(String value) {
            addCriterion("is_display <", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayLessThanOrEqualTo(String value) {
            addCriterion("is_display <=", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayLike(String value) {
            addCriterion("is_display like", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayNotLike(String value) {
            addCriterion("is_display not like", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayIn(List<String> values) {
            addCriterion("is_display in", values, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayNotIn(List<String> values) {
            addCriterion("is_display not in", values, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayBetween(String value1, String value2) {
            addCriterion("is_display between", value1, value2, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayNotBetween(String value1, String value2) {
            addCriterion("is_display not between", value1, value2, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
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