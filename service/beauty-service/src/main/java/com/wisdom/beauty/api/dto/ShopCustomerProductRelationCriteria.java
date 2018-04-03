package com.wisdom.beauty.api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopCustomerProductRelationCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public ShopCustomerProductRelationCriteria() {
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

        public Criteria andShopProductNameIsNull() {
            addCriterion("shop_product_name is null");
            return (Criteria) this;
        }

        public Criteria andShopProductNameIsNotNull() {
            addCriterion("shop_product_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopProductNameEqualTo(String value) {
            addCriterion("shop_product_name =", value, "shopProductName");
            return (Criteria) this;
        }

        public Criteria andShopProductNameNotEqualTo(String value) {
            addCriterion("shop_product_name <>", value, "shopProductName");
            return (Criteria) this;
        }

        public Criteria andShopProductNameGreaterThan(String value) {
            addCriterion("shop_product_name >", value, "shopProductName");
            return (Criteria) this;
        }

        public Criteria andShopProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_product_name >=", value, "shopProductName");
            return (Criteria) this;
        }

        public Criteria andShopProductNameLessThan(String value) {
            addCriterion("shop_product_name <", value, "shopProductName");
            return (Criteria) this;
        }

        public Criteria andShopProductNameLessThanOrEqualTo(String value) {
            addCriterion("shop_product_name <=", value, "shopProductName");
            return (Criteria) this;
        }

        public Criteria andShopProductNameLike(String value) {
            addCriterion("shop_product_name like", value, "shopProductName");
            return (Criteria) this;
        }

        public Criteria andShopProductNameNotLike(String value) {
            addCriterion("shop_product_name not like", value, "shopProductName");
            return (Criteria) this;
        }

        public Criteria andShopProductNameIn(List<String> values) {
            addCriterion("shop_product_name in", values, "shopProductName");
            return (Criteria) this;
        }

        public Criteria andShopProductNameNotIn(List<String> values) {
            addCriterion("shop_product_name not in", values, "shopProductName");
            return (Criteria) this;
        }

        public Criteria andShopProductNameBetween(String value1, String value2) {
            addCriterion("shop_product_name between", value1, value2, "shopProductName");
            return (Criteria) this;
        }

        public Criteria andShopProductNameNotBetween(String value1, String value2) {
            addCriterion("shop_product_name not between", value1, value2, "shopProductName");
            return (Criteria) this;
        }

        public Criteria andShopProductIdIsNull() {
            addCriterion("shop_product_id is null");
            return (Criteria) this;
        }

        public Criteria andShopProductIdIsNotNull() {
            addCriterion("shop_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopProductIdEqualTo(String value) {
            addCriterion("shop_product_id =", value, "shopProductId");
            return (Criteria) this;
        }

        public Criteria andShopProductIdNotEqualTo(String value) {
            addCriterion("shop_product_id <>", value, "shopProductId");
            return (Criteria) this;
        }

        public Criteria andShopProductIdGreaterThan(String value) {
            addCriterion("shop_product_id >", value, "shopProductId");
            return (Criteria) this;
        }

        public Criteria andShopProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("shop_product_id >=", value, "shopProductId");
            return (Criteria) this;
        }

        public Criteria andShopProductIdLessThan(String value) {
            addCriterion("shop_product_id <", value, "shopProductId");
            return (Criteria) this;
        }

        public Criteria andShopProductIdLessThanOrEqualTo(String value) {
            addCriterion("shop_product_id <=", value, "shopProductId");
            return (Criteria) this;
        }

        public Criteria andShopProductIdLike(String value) {
            addCriterion("shop_product_id like", value, "shopProductId");
            return (Criteria) this;
        }

        public Criteria andShopProductIdNotLike(String value) {
            addCriterion("shop_product_id not like", value, "shopProductId");
            return (Criteria) this;
        }

        public Criteria andShopProductIdIn(List<String> values) {
            addCriterion("shop_product_id in", values, "shopProductId");
            return (Criteria) this;
        }

        public Criteria andShopProductIdNotIn(List<String> values) {
            addCriterion("shop_product_id not in", values, "shopProductId");
            return (Criteria) this;
        }

        public Criteria andShopProductIdBetween(String value1, String value2) {
            addCriterion("shop_product_id between", value1, value2, "shopProductId");
            return (Criteria) this;
        }

        public Criteria andShopProductIdNotBetween(String value1, String value2) {
            addCriterion("shop_product_id not between", value1, value2, "shopProductId");
            return (Criteria) this;
        }

        public Criteria andSysCustomerIdIsNull() {
            addCriterion("sys_customer_id is null");
            return (Criteria) this;
        }

        public Criteria andSysCustomerIdIsNotNull() {
            addCriterion("sys_customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysCustomerIdEqualTo(String value) {
            addCriterion("sys_customer_id =", value, "sysCustomerId");
            return (Criteria) this;
        }

        public Criteria andSysCustomerIdNotEqualTo(String value) {
            addCriterion("sys_customer_id <>", value, "sysCustomerId");
            return (Criteria) this;
        }

        public Criteria andSysCustomerIdGreaterThan(String value) {
            addCriterion("sys_customer_id >", value, "sysCustomerId");
            return (Criteria) this;
        }

        public Criteria andSysCustomerIdGreaterThanOrEqualTo(String value) {
            addCriterion("sys_customer_id >=", value, "sysCustomerId");
            return (Criteria) this;
        }

        public Criteria andSysCustomerIdLessThan(String value) {
            addCriterion("sys_customer_id <", value, "sysCustomerId");
            return (Criteria) this;
        }

        public Criteria andSysCustomerIdLessThanOrEqualTo(String value) {
            addCriterion("sys_customer_id <=", value, "sysCustomerId");
            return (Criteria) this;
        }

        public Criteria andSysCustomerIdLike(String value) {
            addCriterion("sys_customer_id like", value, "sysCustomerId");
            return (Criteria) this;
        }

        public Criteria andSysCustomerIdNotLike(String value) {
            addCriterion("sys_customer_id not like", value, "sysCustomerId");
            return (Criteria) this;
        }

        public Criteria andSysCustomerIdIn(List<String> values) {
            addCriterion("sys_customer_id in", values, "sysCustomerId");
            return (Criteria) this;
        }

        public Criteria andSysCustomerIdNotIn(List<String> values) {
            addCriterion("sys_customer_id not in", values, "sysCustomerId");
            return (Criteria) this;
        }

        public Criteria andSysCustomerIdBetween(String value1, String value2) {
            addCriterion("sys_customer_id between", value1, value2, "sysCustomerId");
            return (Criteria) this;
        }

        public Criteria andSysCustomerIdNotBetween(String value1, String value2) {
            addCriterion("sys_customer_id not between", value1, value2, "sysCustomerId");
            return (Criteria) this;
        }

        public Criteria andSysShopIdIsNull() {
            addCriterion("sys_shop_id is null");
            return (Criteria) this;
        }

        public Criteria andSysShopIdIsNotNull() {
            addCriterion("sys_shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysShopIdEqualTo(String value) {
            addCriterion("sys_shop_id =", value, "sysShopId");
            return (Criteria) this;
        }

        public Criteria andSysShopIdNotEqualTo(String value) {
            addCriterion("sys_shop_id <>", value, "sysShopId");
            return (Criteria) this;
        }

        public Criteria andSysShopIdGreaterThan(String value) {
            addCriterion("sys_shop_id >", value, "sysShopId");
            return (Criteria) this;
        }

        public Criteria andSysShopIdGreaterThanOrEqualTo(String value) {
            addCriterion("sys_shop_id >=", value, "sysShopId");
            return (Criteria) this;
        }

        public Criteria andSysShopIdLessThan(String value) {
            addCriterion("sys_shop_id <", value, "sysShopId");
            return (Criteria) this;
        }

        public Criteria andSysShopIdLessThanOrEqualTo(String value) {
            addCriterion("sys_shop_id <=", value, "sysShopId");
            return (Criteria) this;
        }

        public Criteria andSysShopIdLike(String value) {
            addCriterion("sys_shop_id like", value, "sysShopId");
            return (Criteria) this;
        }

        public Criteria andSysShopIdNotLike(String value) {
            addCriterion("sys_shop_id not like", value, "sysShopId");
            return (Criteria) this;
        }

        public Criteria andSysShopIdIn(List<String> values) {
            addCriterion("sys_shop_id in", values, "sysShopId");
            return (Criteria) this;
        }

        public Criteria andSysShopIdNotIn(List<String> values) {
            addCriterion("sys_shop_id not in", values, "sysShopId");
            return (Criteria) this;
        }

        public Criteria andSysShopIdBetween(String value1, String value2) {
            addCriterion("sys_shop_id between", value1, value2, "sysShopId");
            return (Criteria) this;
        }

        public Criteria andSysShopIdNotBetween(String value1, String value2) {
            addCriterion("sys_shop_id not between", value1, value2, "sysShopId");
            return (Criteria) this;
        }

        public Criteria andWaitReceiveNumberIsNull() {
            addCriterion("wait_receive_number is null");
            return (Criteria) this;
        }

        public Criteria andWaitReceiveNumberIsNotNull() {
            addCriterion("wait_receive_number is not null");
            return (Criteria) this;
        }

        public Criteria andWaitReceiveNumberEqualTo(Integer value) {
            addCriterion("wait_receive_number =", value, "waitReceiveNumber");
            return (Criteria) this;
        }

        public Criteria andWaitReceiveNumberNotEqualTo(Integer value) {
            addCriterion("wait_receive_number <>", value, "waitReceiveNumber");
            return (Criteria) this;
        }

        public Criteria andWaitReceiveNumberGreaterThan(Integer value) {
            addCriterion("wait_receive_number >", value, "waitReceiveNumber");
            return (Criteria) this;
        }

        public Criteria andWaitReceiveNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("wait_receive_number >=", value, "waitReceiveNumber");
            return (Criteria) this;
        }

        public Criteria andWaitReceiveNumberLessThan(Integer value) {
            addCriterion("wait_receive_number <", value, "waitReceiveNumber");
            return (Criteria) this;
        }

        public Criteria andWaitReceiveNumberLessThanOrEqualTo(Integer value) {
            addCriterion("wait_receive_number <=", value, "waitReceiveNumber");
            return (Criteria) this;
        }

        public Criteria andWaitReceiveNumberIn(List<Integer> values) {
            addCriterion("wait_receive_number in", values, "waitReceiveNumber");
            return (Criteria) this;
        }

        public Criteria andWaitReceiveNumberNotIn(List<Integer> values) {
            addCriterion("wait_receive_number not in", values, "waitReceiveNumber");
            return (Criteria) this;
        }

        public Criteria andWaitReceiveNumberBetween(Integer value1, Integer value2) {
            addCriterion("wait_receive_number between", value1, value2, "waitReceiveNumber");
            return (Criteria) this;
        }

        public Criteria andWaitReceiveNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("wait_receive_number not between", value1, value2, "waitReceiveNumber");
            return (Criteria) this;
        }

        public Criteria andSysShopNameIsNull() {
            addCriterion("sys_shop_name is null");
            return (Criteria) this;
        }

        public Criteria andSysShopNameIsNotNull() {
            addCriterion("sys_shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andSysShopNameEqualTo(String value) {
            addCriterion("sys_shop_name =", value, "sysShopName");
            return (Criteria) this;
        }

        public Criteria andSysShopNameNotEqualTo(String value) {
            addCriterion("sys_shop_name <>", value, "sysShopName");
            return (Criteria) this;
        }

        public Criteria andSysShopNameGreaterThan(String value) {
            addCriterion("sys_shop_name >", value, "sysShopName");
            return (Criteria) this;
        }

        public Criteria andSysShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("sys_shop_name >=", value, "sysShopName");
            return (Criteria) this;
        }

        public Criteria andSysShopNameLessThan(String value) {
            addCriterion("sys_shop_name <", value, "sysShopName");
            return (Criteria) this;
        }

        public Criteria andSysShopNameLessThanOrEqualTo(String value) {
            addCriterion("sys_shop_name <=", value, "sysShopName");
            return (Criteria) this;
        }

        public Criteria andSysShopNameLike(String value) {
            addCriterion("sys_shop_name like", value, "sysShopName");
            return (Criteria) this;
        }

        public Criteria andSysShopNameNotLike(String value) {
            addCriterion("sys_shop_name not like", value, "sysShopName");
            return (Criteria) this;
        }

        public Criteria andSysShopNameIn(List<String> values) {
            addCriterion("sys_shop_name in", values, "sysShopName");
            return (Criteria) this;
        }

        public Criteria andSysShopNameNotIn(List<String> values) {
            addCriterion("sys_shop_name not in", values, "sysShopName");
            return (Criteria) this;
        }

        public Criteria andSysShopNameBetween(String value1, String value2) {
            addCriterion("sys_shop_name between", value1, value2, "sysShopName");
            return (Criteria) this;
        }

        public Criteria andSysShopNameNotBetween(String value1, String value2) {
            addCriterion("sys_shop_name not between", value1, value2, "sysShopName");
            return (Criteria) this;
        }

        public Criteria andInitTimesIsNull() {
            addCriterion("init_times is null");
            return (Criteria) this;
        }

        public Criteria andInitTimesIsNotNull() {
            addCriterion("init_times is not null");
            return (Criteria) this;
        }

        public Criteria andInitTimesEqualTo(Integer value) {
            addCriterion("init_times =", value, "initTimes");
            return (Criteria) this;
        }

        public Criteria andInitTimesNotEqualTo(Integer value) {
            addCriterion("init_times <>", value, "initTimes");
            return (Criteria) this;
        }

        public Criteria andInitTimesGreaterThan(Integer value) {
            addCriterion("init_times >", value, "initTimes");
            return (Criteria) this;
        }

        public Criteria andInitTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("init_times >=", value, "initTimes");
            return (Criteria) this;
        }

        public Criteria andInitTimesLessThan(Integer value) {
            addCriterion("init_times <", value, "initTimes");
            return (Criteria) this;
        }

        public Criteria andInitTimesLessThanOrEqualTo(Integer value) {
            addCriterion("init_times <=", value, "initTimes");
            return (Criteria) this;
        }

        public Criteria andInitTimesIn(List<Integer> values) {
            addCriterion("init_times in", values, "initTimes");
            return (Criteria) this;
        }

        public Criteria andInitTimesNotIn(List<Integer> values) {
            addCriterion("init_times not in", values, "initTimes");
            return (Criteria) this;
        }

        public Criteria andInitTimesBetween(Integer value1, Integer value2) {
            addCriterion("init_times between", value1, value2, "initTimes");
            return (Criteria) this;
        }

        public Criteria andInitTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("init_times not between", value1, value2, "initTimes");
            return (Criteria) this;
        }

        public Criteria andSurplusTimesIsNull() {
            addCriterion("surplus_times is null");
            return (Criteria) this;
        }

        public Criteria andSurplusTimesIsNotNull() {
            addCriterion("surplus_times is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusTimesEqualTo(Integer value) {
            addCriterion("surplus_times =", value, "surplusTimes");
            return (Criteria) this;
        }

        public Criteria andSurplusTimesNotEqualTo(Integer value) {
            addCriterion("surplus_times <>", value, "surplusTimes");
            return (Criteria) this;
        }

        public Criteria andSurplusTimesGreaterThan(Integer value) {
            addCriterion("surplus_times >", value, "surplusTimes");
            return (Criteria) this;
        }

        public Criteria andSurplusTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("surplus_times >=", value, "surplusTimes");
            return (Criteria) this;
        }

        public Criteria andSurplusTimesLessThan(Integer value) {
            addCriterion("surplus_times <", value, "surplusTimes");
            return (Criteria) this;
        }

        public Criteria andSurplusTimesLessThanOrEqualTo(Integer value) {
            addCriterion("surplus_times <=", value, "surplusTimes");
            return (Criteria) this;
        }

        public Criteria andSurplusTimesIn(List<Integer> values) {
            addCriterion("surplus_times in", values, "surplusTimes");
            return (Criteria) this;
        }

        public Criteria andSurplusTimesNotIn(List<Integer> values) {
            addCriterion("surplus_times not in", values, "surplusTimes");
            return (Criteria) this;
        }

        public Criteria andSurplusTimesBetween(Integer value1, Integer value2) {
            addCriterion("surplus_times between", value1, value2, "surplusTimes");
            return (Criteria) this;
        }

        public Criteria andSurplusTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("surplus_times not between", value1, value2, "surplusTimes");
            return (Criteria) this;
        }

        public Criteria andInitAmountIsNull() {
            addCriterion("init_amount is null");
            return (Criteria) this;
        }

        public Criteria andInitAmountIsNotNull() {
            addCriterion("init_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInitAmountEqualTo(Long value) {
            addCriterion("init_amount =", value, "initAmount");
            return (Criteria) this;
        }

        public Criteria andInitAmountNotEqualTo(Long value) {
            addCriterion("init_amount <>", value, "initAmount");
            return (Criteria) this;
        }

        public Criteria andInitAmountGreaterThan(Long value) {
            addCriterion("init_amount >", value, "initAmount");
            return (Criteria) this;
        }

        public Criteria andInitAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("init_amount >=", value, "initAmount");
            return (Criteria) this;
        }

        public Criteria andInitAmountLessThan(Long value) {
            addCriterion("init_amount <", value, "initAmount");
            return (Criteria) this;
        }

        public Criteria andInitAmountLessThanOrEqualTo(Long value) {
            addCriterion("init_amount <=", value, "initAmount");
            return (Criteria) this;
        }

        public Criteria andInitAmountIn(List<Long> values) {
            addCriterion("init_amount in", values, "initAmount");
            return (Criteria) this;
        }

        public Criteria andInitAmountNotIn(List<Long> values) {
            addCriterion("init_amount not in", values, "initAmount");
            return (Criteria) this;
        }

        public Criteria andInitAmountBetween(Long value1, Long value2) {
            addCriterion("init_amount between", value1, value2, "initAmount");
            return (Criteria) this;
        }

        public Criteria andInitAmountNotBetween(Long value1, Long value2) {
            addCriterion("init_amount not between", value1, value2, "initAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountIsNull() {
            addCriterion("surplus_amount is null");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountIsNotNull() {
            addCriterion("surplus_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountEqualTo(Long value) {
            addCriterion("surplus_amount =", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountNotEqualTo(Long value) {
            addCriterion("surplus_amount <>", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountGreaterThan(Long value) {
            addCriterion("surplus_amount >", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("surplus_amount >=", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountLessThan(Long value) {
            addCriterion("surplus_amount <", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountLessThanOrEqualTo(Long value) {
            addCriterion("surplus_amount <=", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountIn(List<Long> values) {
            addCriterion("surplus_amount in", values, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountNotIn(List<Long> values) {
            addCriterion("surplus_amount not in", values, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountBetween(Long value1, Long value2) {
            addCriterion("surplus_amount between", value1, value2, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountNotBetween(Long value1, Long value2) {
            addCriterion("surplus_amount not between", value1, value2, "surplusAmount");
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