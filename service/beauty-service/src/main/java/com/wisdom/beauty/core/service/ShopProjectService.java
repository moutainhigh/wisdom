package com.wisdom.beauty.core.service;

import com.wisdom.beauty.api.dto.*;
import com.wisdom.common.dto.account.PageParamVoDTO;

import java.util.List;

/**
 * FileName: ProjectService
 *
 * @author: 赵得良
 * Date:     2018/4/3 0003 15:06
 * Description: 店员相关
 */
public interface ShopProjectService {

    /**
     * 查询某个用户预约的项目列表
     *
     * @param shopUserProjectRelationDTO
     * @return
     */
    List<ShopUserProjectRelationDTO> getUserProjectList(ShopUserProjectRelationDTO shopUserProjectRelationDTO);


    /**
     * 更新用户与项目的关系
     *
     * @param shopUserProjectRelationDTO
     * @return
     */
    int updateUserAndProjectRelation(ShopUserProjectRelationDTO shopUserProjectRelationDTO);

    /**
     * 查询某个店的项目列表信息
     *
     * @param shopProjectInfoDTO
     * @return
     */
    List<ShopProjectInfoDTO> getShopCourseProjectList(ShopProjectInfoDTO shopProjectInfoDTO);

    /**
     * 查询某个用户的所有套卡项目列表
     *
     * @param shopUserProjectGroupRelRelationDTO
     * @return
     */
    List<ShopUserProjectGroupRelRelationDTO> getUserCollectionCardProjectList(ShopUserProjectGroupRelRelationDTO shopUserProjectGroupRelRelationDTO);
    /**
    *@Author:huan
    *@Param: sysShopId
    *@Return:
    *@Description: 获取一级项目列表
    *@Date:2018/4/10 15:59
    */
    List<ShopProjectTypeDTO> getOneLevelProjectList(String sysShopId);
    /**
    *@Author:huan
    *@Param:
    *@Return:
    *@Description: 获取二级项目列表
    *@Date:2018/4/10 16:15
    */
    List<ShopProjectTypeDTO> getTwoLevelProjectList(ShopProjectTypeDTO shopProjectTypeDTO);
    /**
    *@Author:huan
    *@Param:
    *@Return:
    *@Description: 获取三级项目列表
    *@Date:2018/4/10 16:21
    */
    List<ShopProjectInfoDTO> getThreeLevelProjectList(PageParamVoDTO<ShopProjectInfoDTO> pageParamVoDTO);
    /**
    *@Author:huan
    *@Param:
    *@Return:
    *@Description: 获取项目的详细信息
    *@Date:2018/4/10 16:59
    */
    ShopProjectInfoDTO getProjectDetail(String id);

    /**
     * 保存用户与项目的关系
     *
     * @param shopUserRelationDTO
     * @return
     */
    int saveUserProjectRelation(ShopUserProjectRelationDTO shopUserRelationDTO);


    /**
     * 根据条件查询套卡与项目的关系列表
     *
     * @param shopProjectInfoGroupRelationDTO
     * @return
     */
    List<ShopProjectInfoGroupRelationDTO> getShopProjectInfoGroupRelations(ShopProjectInfoGroupRelationDTO shopProjectInfoGroupRelationDTO);
    /**
     *@Author:huan
     *@Param:
     *@Return:
     *@Description: 根据多个项目id查询
     *@Date:2018/4/11 17:26
     */
    List<ShopProjectInfoDTO> getProjectDetails(List<String> ids);
}