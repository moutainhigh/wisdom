package com.wisdom.beauty.api.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopUserProjectGroupRelRelationCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public ShopUserProjectGroupRelRelationCriteria() {
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

        public Criteria andShopProjectGroupNameIsNull() {
            addCriterion("shop_project_group_name is null");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupNameIsNotNull() {
            addCriterion("shop_project_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupNameEqualTo(String value) {
            addCriterion("shop_project_group_name =", value, "shopProjectGroupName");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupNameNotEqualTo(String value) {
            addCriterion("shop_project_group_name <>", value, "shopProjectGroupName");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupNameGreaterThan(String value) {
            addCriterion("shop_project_group_name >", value, "shopProjectGroupName");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_project_group_name >=", value, "shopProjectGroupName");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupNameLessThan(String value) {
            addCriterion("shop_project_group_name <", value, "shopProjectGroupName");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupNameLessThanOrEqualTo(String value) {
            addCriterion("shop_project_group_name <=", value, "shopProjectGroupName");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupNameLike(String value) {
            addCriterion("shop_project_group_name like", value, "shopProjectGroupName");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupNameNotLike(String value) {
            addCriterion("shop_project_group_name not like", value, "shopProjectGroupName");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupNameIn(List<String> values) {
            addCriterion("shop_project_group_name in", values, "shopProjectGroupName");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupNameNotIn(List<String> values) {
            addCriterion("shop_project_group_name not in", values, "shopProjectGroupName");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupNameBetween(String value1, String value2) {
            addCriterion("shop_project_group_name between", value1, value2, "shopProjectGroupName");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupNameNotBetween(String value1, String value2) {
            addCriterion("shop_project_group_name not between", value1, value2, "shopProjectGroupName");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupIdIsNull() {
            addCriterion("shop_project_group_id is null");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupIdIsNotNull() {
            addCriterion("shop_project_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupIdEqualTo(String value) {
            addCriterion("shop_project_group_id =", value, "shopProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupIdNotEqualTo(String value) {
            addCriterion("shop_project_group_id <>", value, "shopProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupIdGreaterThan(String value) {
            addCriterion("shop_project_group_id >", value, "shopProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("shop_project_group_id >=", value, "shopProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupIdLessThan(String value) {
            addCriterion("shop_project_group_id <", value, "shopProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupIdLessThanOrEqualTo(String value) {
            addCriterion("shop_project_group_id <=", value, "shopProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupIdLike(String value) {
            addCriterion("shop_project_group_id like", value, "shopProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupIdNotLike(String value) {
            addCriterion("shop_project_group_id not like", value, "shopProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupIdIn(List<String> values) {
            addCriterion("shop_project_group_id in", values, "shopProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupIdNotIn(List<String> values) {
            addCriterion("shop_project_group_id not in", values, "shopProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupIdBetween(String value1, String value2) {
            addCriterion("shop_project_group_id between", value1, value2, "shopProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andShopProjectGroupIdNotBetween(String value1, String value2) {
            addCriterion("shop_project_group_id not between", value1, value2, "shopProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIsNull() {
            addCriterion("sys_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIsNotNull() {
            addCriterion("sys_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdEqualTo(String value) {
            addCriterion("sys_user_id =", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotEqualTo(String value) {
            addCriterion("sys_user_id <>", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThan(String value) {
            addCriterion("sys_user_id >", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("sys_user_id >=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThan(String value) {
            addCriterion("sys_user_id <", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThanOrEqualTo(String value) {
            addCriterion("sys_user_id <=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLike(String value) {
            addCriterion("sys_user_id like", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotLike(String value) {
            addCriterion("sys_user_id not like", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIn(List<String> values) {
            addCriterion("sys_user_id in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotIn(List<String> values) {
            addCriterion("sys_user_id not in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdBetween(String value1, String value2) {
            addCriterion("sys_user_id between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotBetween(String value1, String value2) {
            addCriterion("sys_user_id not between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andShopProjectInfoGroupRelationIdIsNull() {
            addCriterion("shop_project_info_group_relation_id is null");
            return (Criteria) this;
        }

        public Criteria andShopProjectInfoGroupRelationIdIsNotNull() {
            addCriterion("shop_project_info_group_relation_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopProjectInfoGroupRelationIdEqualTo(String value) {
            addCriterion("shop_project_info_group_relation_id =", value, "shopProjectInfoGroupRelationId");
            return (Criteria) this;
        }

        public Criteria andShopProjectInfoGroupRelationIdNotEqualTo(String value) {
            addCriterion("shop_project_info_group_relation_id <>", value, "shopProjectInfoGroupRelationId");
            return (Criteria) this;
        }

        public Criteria andShopProjectInfoGroupRelationIdGreaterThan(String value) {
            addCriterion("shop_project_info_group_relation_id >", value, "shopProjectInfoGroupRelationId");
            return (Criteria) this;
        }

        public Criteria andShopProjectInfoGroupRelationIdGreaterThanOrEqualTo(String value) {
            addCriterion("shop_project_info_group_relation_id >=", value, "shopProjectInfoGroupRelationId");
            return (Criteria) this;
        }

        public Criteria andShopProjectInfoGroupRelationIdLessThan(String value) {
            addCriterion("shop_project_info_group_relation_id <", value, "shopProjectInfoGroupRelationId");
            return (Criteria) this;
        }

        public Criteria andShopProjectInfoGroupRelationIdLessThanOrEqualTo(String value) {
            addCriterion("shop_project_info_group_relation_id <=", value, "shopProjectInfoGroupRelationId");
            return (Criteria) this;
        }

        public Criteria andShopProjectInfoGroupRelationIdLike(String value) {
            addCriterion("shop_project_info_group_relation_id like", value, "shopProjectInfoGroupRelationId");
            return (Criteria) this;
        }

        public Criteria andShopProjectInfoGroupRelationIdNotLike(String value) {
            addCriterion("shop_project_info_group_relation_id not like", value, "shopProjectInfoGroupRelationId");
            return (Criteria) this;
        }

        public Criteria andShopProjectInfoGroupRelationIdIn(List<String> values) {
            addCriterion("shop_project_info_group_relation_id in", values, "shopProjectInfoGroupRelationId");
            return (Criteria) this;
        }

        public Criteria andShopProjectInfoGroupRelationIdNotIn(List<String> values) {
            addCriterion("shop_project_info_group_relation_id not in", values, "shopProjectInfoGroupRelationId");
            return (Criteria) this;
        }

        public Criteria andShopProjectInfoGroupRelationIdBetween(String value1, String value2) {
            addCriterion("shop_project_info_group_relation_id between", value1, value2, "shopProjectInfoGroupRelationId");
            return (Criteria) this;
        }

        public Criteria andShopProjectInfoGroupRelationIdNotBetween(String value1, String value2) {
            addCriterion("shop_project_info_group_relation_id not between", value1, value2, "shopProjectInfoGroupRelationId");
            return (Criteria) this;
        }

        public Criteria andProjectInitTimesIsNull() {
            addCriterion("project_init_times is null");
            return (Criteria) this;
        }

        public Criteria andProjectInitTimesIsNotNull() {
            addCriterion("project_init_times is not null");
            return (Criteria) this;
        }

        public Criteria andProjectInitTimesEqualTo(Integer value) {
            addCriterion("project_init_times =", value, "projectInitTimes");
            return (Criteria) this;
        }

        public Criteria andProjectInitTimesNotEqualTo(Integer value) {
            addCriterion("project_init_times <>", value, "projectInitTimes");
            return (Criteria) this;
        }

        public Criteria andProjectInitTimesGreaterThan(Integer value) {
            addCriterion("project_init_times >", value, "projectInitTimes");
            return (Criteria) this;
        }

        public Criteria andProjectInitTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_init_times >=", value, "projectInitTimes");
            return (Criteria) this;
        }

        public Criteria andProjectInitTimesLessThan(Integer value) {
            addCriterion("project_init_times <", value, "projectInitTimes");
            return (Criteria) this;
        }

        public Criteria andProjectInitTimesLessThanOrEqualTo(Integer value) {
            addCriterion("project_init_times <=", value, "projectInitTimes");
            return (Criteria) this;
        }

        public Criteria andProjectInitTimesIn(List<Integer> values) {
            addCriterion("project_init_times in", values, "projectInitTimes");
            return (Criteria) this;
        }

        public Criteria andProjectInitTimesNotIn(List<Integer> values) {
            addCriterion("project_init_times not in", values, "projectInitTimes");
            return (Criteria) this;
        }

        public Criteria andProjectInitTimesBetween(Integer value1, Integer value2) {
            addCriterion("project_init_times between", value1, value2, "projectInitTimes");
            return (Criteria) this;
        }

        public Criteria andProjectInitTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("project_init_times not between", value1, value2, "projectInitTimes");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTimesIsNull() {
            addCriterion("project_surplus_times is null");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTimesIsNotNull() {
            addCriterion("project_surplus_times is not null");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTimesEqualTo(Integer value) {
            addCriterion("project_surplus_times =", value, "projectSurplusTimes");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTimesNotEqualTo(Integer value) {
            addCriterion("project_surplus_times <>", value, "projectSurplusTimes");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTimesGreaterThan(Integer value) {
            addCriterion("project_surplus_times >", value, "projectSurplusTimes");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_surplus_times >=", value, "projectSurplusTimes");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTimesLessThan(Integer value) {
            addCriterion("project_surplus_times <", value, "projectSurplusTimes");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTimesLessThanOrEqualTo(Integer value) {
            addCriterion("project_surplus_times <=", value, "projectSurplusTimes");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTimesIn(List<Integer> values) {
            addCriterion("project_surplus_times in", values, "projectSurplusTimes");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTimesNotIn(List<Integer> values) {
            addCriterion("project_surplus_times not in", values, "projectSurplusTimes");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTimesBetween(Integer value1, Integer value2) {
            addCriterion("project_surplus_times between", value1, value2, "projectSurplusTimes");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("project_surplus_times not between", value1, value2, "projectSurplusTimes");
            return (Criteria) this;
        }

        public Criteria andProjectInitAmountIsNull() {
            addCriterion("project_init_amount is null");
            return (Criteria) this;
        }

        public Criteria andProjectInitAmountIsNotNull() {
            addCriterion("project_init_amount is not null");
            return (Criteria) this;
        }

        public Criteria andProjectInitAmountEqualTo(BigDecimal value) {
            addCriterion("project_init_amount =", value, "projectInitAmount");
            return (Criteria) this;
        }

        public Criteria andProjectInitAmountNotEqualTo(BigDecimal value) {
            addCriterion("project_init_amount <>", value, "projectInitAmount");
            return (Criteria) this;
        }

        public Criteria andProjectInitAmountGreaterThan(BigDecimal value) {
            addCriterion("project_init_amount >", value, "projectInitAmount");
            return (Criteria) this;
        }

        public Criteria andProjectInitAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_init_amount >=", value, "projectInitAmount");
            return (Criteria) this;
        }

        public Criteria andProjectInitAmountLessThan(BigDecimal value) {
            addCriterion("project_init_amount <", value, "projectInitAmount");
            return (Criteria) this;
        }

        public Criteria andProjectInitAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_init_amount <=", value, "projectInitAmount");
            return (Criteria) this;
        }

        public Criteria andProjectInitAmountIn(List<BigDecimal> values) {
            addCriterion("project_init_amount in", values, "projectInitAmount");
            return (Criteria) this;
        }

        public Criteria andProjectInitAmountNotIn(List<BigDecimal> values) {
            addCriterion("project_init_amount not in", values, "projectInitAmount");
            return (Criteria) this;
        }

        public Criteria andProjectInitAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_init_amount between", value1, value2, "projectInitAmount");
            return (Criteria) this;
        }

        public Criteria andProjectInitAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_init_amount not between", value1, value2, "projectInitAmount");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusAmountIsNull() {
            addCriterion("project_surplus_amount is null");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusAmountIsNotNull() {
            addCriterion("project_surplus_amount is not null");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusAmountEqualTo(BigDecimal value) {
            addCriterion("project_surplus_amount =", value, "projectSurplusAmount");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusAmountNotEqualTo(BigDecimal value) {
            addCriterion("project_surplus_amount <>", value, "projectSurplusAmount");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusAmountGreaterThan(BigDecimal value) {
            addCriterion("project_surplus_amount >", value, "projectSurplusAmount");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_surplus_amount >=", value, "projectSurplusAmount");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusAmountLessThan(BigDecimal value) {
            addCriterion("project_surplus_amount <", value, "projectSurplusAmount");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_surplus_amount <=", value, "projectSurplusAmount");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusAmountIn(List<BigDecimal> values) {
            addCriterion("project_surplus_amount in", values, "projectSurplusAmount");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusAmountNotIn(List<BigDecimal> values) {
            addCriterion("project_surplus_amount not in", values, "projectSurplusAmount");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_surplus_amount between", value1, value2, "projectSurplusAmount");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_surplus_amount not between", value1, value2, "projectSurplusAmount");
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

        public Criteria andSysClerkIdIsNull() {
            addCriterion("sys_clerk_id is null");
            return (Criteria) this;
        }

        public Criteria andSysClerkIdIsNotNull() {
            addCriterion("sys_clerk_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysClerkIdEqualTo(String value) {
            addCriterion("sys_clerk_id =", value, "sysClerkId");
            return (Criteria) this;
        }

        public Criteria andSysClerkIdNotEqualTo(String value) {
            addCriterion("sys_clerk_id <>", value, "sysClerkId");
            return (Criteria) this;
        }

        public Criteria andSysClerkIdGreaterThan(String value) {
            addCriterion("sys_clerk_id >", value, "sysClerkId");
            return (Criteria) this;
        }

        public Criteria andSysClerkIdGreaterThanOrEqualTo(String value) {
            addCriterion("sys_clerk_id >=", value, "sysClerkId");
            return (Criteria) this;
        }

        public Criteria andSysClerkIdLessThan(String value) {
            addCriterion("sys_clerk_id <", value, "sysClerkId");
            return (Criteria) this;
        }

        public Criteria andSysClerkIdLessThanOrEqualTo(String value) {
            addCriterion("sys_clerk_id <=", value, "sysClerkId");
            return (Criteria) this;
        }

        public Criteria andSysClerkIdLike(String value) {
            addCriterion("sys_clerk_id like", value, "sysClerkId");
            return (Criteria) this;
        }

        public Criteria andSysClerkIdNotLike(String value) {
            addCriterion("sys_clerk_id not like", value, "sysClerkId");
            return (Criteria) this;
        }

        public Criteria andSysClerkIdIn(List<String> values) {
            addCriterion("sys_clerk_id in", values, "sysClerkId");
            return (Criteria) this;
        }

        public Criteria andSysClerkIdNotIn(List<String> values) {
            addCriterion("sys_clerk_id not in", values, "sysClerkId");
            return (Criteria) this;
        }

        public Criteria andSysClerkIdBetween(String value1, String value2) {
            addCriterion("sys_clerk_id between", value1, value2, "sysClerkId");
            return (Criteria) this;
        }

        public Criteria andSysClerkIdNotBetween(String value1, String value2) {
            addCriterion("sys_clerk_id not between", value1, value2, "sysClerkId");
            return (Criteria) this;
        }

        public Criteria andSysBossIdIsNull() {
            addCriterion("sys_boss_id is null");
            return (Criteria) this;
        }

        public Criteria andSysBossIdIsNotNull() {
            addCriterion("sys_boss_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysBossIdEqualTo(String value) {
            addCriterion("sys_boss_id =", value, "sysBossId");
            return (Criteria) this;
        }

        public Criteria andSysBossIdNotEqualTo(String value) {
            addCriterion("sys_boss_id <>", value, "sysBossId");
            return (Criteria) this;
        }

        public Criteria andSysBossIdGreaterThan(String value) {
            addCriterion("sys_boss_id >", value, "sysBossId");
            return (Criteria) this;
        }

        public Criteria andSysBossIdGreaterThanOrEqualTo(String value) {
            addCriterion("sys_boss_id >=", value, "sysBossId");
            return (Criteria) this;
        }

        public Criteria andSysBossIdLessThan(String value) {
            addCriterion("sys_boss_id <", value, "sysBossId");
            return (Criteria) this;
        }

        public Criteria andSysBossIdLessThanOrEqualTo(String value) {
            addCriterion("sys_boss_id <=", value, "sysBossId");
            return (Criteria) this;
        }

        public Criteria andSysBossIdLike(String value) {
            addCriterion("sys_boss_id like", value, "sysBossId");
            return (Criteria) this;
        }

        public Criteria andSysBossIdNotLike(String value) {
            addCriterion("sys_boss_id not like", value, "sysBossId");
            return (Criteria) this;
        }

        public Criteria andSysBossIdIn(List<String> values) {
            addCriterion("sys_boss_id in", values, "sysBossId");
            return (Criteria) this;
        }

        public Criteria andSysBossIdNotIn(List<String> values) {
            addCriterion("sys_boss_id not in", values, "sysBossId");
            return (Criteria) this;
        }

        public Criteria andSysBossIdBetween(String value1, String value2) {
            addCriterion("sys_boss_id between", value1, value2, "sysBossId");
            return (Criteria) this;
        }

        public Criteria andSysBossIdNotBetween(String value1, String value2) {
            addCriterion("sys_boss_id not between", value1, value2, "sysBossId");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Float value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Float value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Float value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Float value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Float value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Float value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Float> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Float> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Float value1, Float value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Float value1, Float value2) {
            addCriterion("discount not between", value1, value2, "discount");
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