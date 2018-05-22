package com.wisdom.beauty.core.service.impl;

import com.aliyun.oss.ServiceException;
import com.wisdom.beauty.api.dto.*;
import com.wisdom.beauty.api.enums.RechargeCardTypeEnum;
import com.wisdom.beauty.api.errorcode.BusinessErrorCode;
import com.wisdom.beauty.api.responseDto.ShopRechargeCardResponseDTO;
import com.wisdom.beauty.api.responseDto.UserConsumeRequestDTO;
import com.wisdom.beauty.client.UserServiceClient;
import com.wisdom.beauty.core.mapper.ShopUserArchivesMapper;
import com.wisdom.beauty.core.service.ShopCustomerArchivesService;
import com.wisdom.beauty.core.service.ShopRechargeCardService;
import com.wisdom.beauty.core.service.ShopService;
import com.wisdom.beauty.util.UserUtils;
import com.wisdom.common.constant.ConfigConstant;
import com.wisdom.common.constant.StatusConstant;
import com.wisdom.common.dto.account.PageParamVoDTO;
import com.wisdom.common.dto.system.ResponseDTO;
import com.wisdom.common.dto.user.SysBossDTO;
import com.wisdom.common.dto.user.SysClerkDTO;
import com.wisdom.common.dto.user.UserInfoDTO;
import com.wisdom.common.util.CommonUtils;
import com.wisdom.common.util.DateUtils;
import com.wisdom.common.util.IdGen;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * ClassName: ShopCustomerArchivesServiceImpl
 *
 * @Author： huan
 * @Description:
 * @Date:Created in 2018/4/3 16:41
 * @since JDK 1.8
 */
@Service("shopCustomerArchivesService")
public class ShopCustomerArchivesServiceImpl implements ShopCustomerArchivesService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShopUserArchivesMapper shopUserArchivesMapper;

    @Autowired
    private ShopRechargeCardService shopRechargeCardService;

    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private ShopService shopService;



    @Override
    public int getArchivesCount(ShopUserArchivesDTO shopUserArchivesDTO) {
        logger.info("getArchivesCount方法传入的参数={}", shopUserArchivesDTO.getSysShopId());
        if (StringUtils.isBlank(shopUserArchivesDTO.getSysShopId())) {
            throw new ServiceException("SysShopId为空");
        }
        ShopUserArchivesCriteria criteria = new ShopUserArchivesCriteria();
        ShopUserArchivesCriteria.Criteria c = criteria.createCriteria();
        ShopUserArchivesCriteria.Criteria or = criteria.createCriteria();

        //参数
        c.andSysShopIdEqualTo(shopUserArchivesDTO.getSysShopId());
        if (StringUtils.isNotBlank(shopUserArchivesDTO.getPhone())) {
            c.andPhoneLike("%" + shopUserArchivesDTO.getPhone() + "%");
        }

        or.andSysShopIdEqualTo(shopUserArchivesDTO.getSysShopId());
        if (StringUtils.isNotBlank(shopUserArchivesDTO.getSysUserName())) {
            or.andSysUserNameLike("%" + shopUserArchivesDTO.getSysUserName() + "%");
        }
        criteria.or(or);
        int count = shopUserArchivesMapper.countByCriteria(criteria);
        return count;
    }

    @Override
    public List<ShopUserArchivesDTO> getArchivesList(PageParamVoDTO<ShopUserArchivesDTO> shopCustomerArchivesDTO) {
        logger.info("getArchivesList方法传入的参数={}", shopCustomerArchivesDTO);

        ShopUserArchivesCriteria criteria = new ShopUserArchivesCriteria();
        ShopUserArchivesCriteria.Criteria c = criteria.createCriteria();
        ShopUserArchivesCriteria.Criteria or = criteria.createCriteria();
        ShopUserArchivesDTO requestData = shopCustomerArchivesDTO.getRequestData();
        // 排序
        criteria.setOrderByClause("sys_user_name");
        // 分页
        if(shopCustomerArchivesDTO.getPaging()) {
            criteria.setLimitStart(shopCustomerArchivesDTO.getPageNo());
            criteria.setPageSize(shopCustomerArchivesDTO.getPageSize());
        }
        //参数
        if (StringUtils.isNotBlank(requestData.getSysShopId())) {
            c.andSysShopIdEqualTo(requestData.getSysShopId());
        }
        if (StringUtils.isNotBlank(requestData.getId())) {
            c.andIdEqualTo(requestData.getId());
        }
        if (StringUtils.isNotBlank(requestData.getPhone())) {
            c.andPhoneLike("%" + requestData.getPhone() + "%");
        }
        if (StringUtils.isNotBlank(requestData.getSysUserName())) {
            or.andSysUserNameLike("%" + requestData.getSysUserName() + "%");
        }

        criteria.or(or);
        List<ShopUserArchivesDTO> shopCustomerArchiveslist = shopUserArchivesMapper.selectByCriteria(criteria);

        return shopCustomerArchiveslist;
    }

    /**
     * 查询某个店某一时间段建档的个数
     *
     * @param pageParamVoDTO
     * @return
     */
    @Override
    public int getShopBuildArchivesNumbers(PageParamVoDTO<UserConsumeRequestDTO> pageParamVoDTO) {
        UserConsumeRequestDTO userConsumeRequestDTO=pageParamVoDTO.getRequestData();
        if(userConsumeRequestDTO==null){
            logger.info("userConsumeRequestDTO为空");
            return  0;
        }
        logger.info("getShopBuildArchivesNumbers方法入参是ShopId={},bossId={},startTime={},endTime={}",userConsumeRequestDTO.getSysShopId(),userConsumeRequestDTO.getSysBossId(),pageParamVoDTO.getStartTime(),pageParamVoDTO.getEndTime());
        String startDate=pageParamVoDTO.getStartTime();
        String endDate=pageParamVoDTO.getEndTime();
        Date start = DateUtils.StrToDate(startDate, "datetime");
        Date end = DateUtils.StrToDate(endDate, "datetime");
        ShopUserArchivesCriteria archivesCriteria = new ShopUserArchivesCriteria();
        ShopUserArchivesCriteria.Criteria criteria = archivesCriteria.createCriteria();

        if (StringUtils.isNotBlank(userConsumeRequestDTO.getSysShopId())) {
            criteria.andSysShopIdEqualTo(userConsumeRequestDTO.getSysShopId());
        }
        if (StringUtils.isNotBlank(userConsumeRequestDTO.getSysBossId())) {

            criteria.andSysBossIdEqualTo(userConsumeRequestDTO.getSysBossId());
        }
        if (startDate != null && endDate != endDate) {
            criteria.andCreateDateBetween(start, end);
        }

        int count = shopUserArchivesMapper.countByCriteria(archivesCriteria);
        logger.debug("查询某个店某一时间段建档的个数为， {}", count);
        return count;
    }

    /**
     * 保存用户的建档案信息
     *
     * @param shopUserArchivesDTO
     * @return
     */
    @Override
    public int saveShopUserArchivesInfo(ShopUserArchivesDTO shopUserArchivesDTO) {

        logger.info("保存用户的建档案信息传入参数={}", "shopUserArchivesDTO = [" + shopUserArchivesDTO + "]");

        if (CommonUtils.objectIsEmpty(shopUserArchivesDTO)) {
            logger.error("保存用户的建档案信息,传入参数为空{}", "shopUserArchivesDTO = [" + shopUserArchivesDTO + "]");
            return 0;
        }

        //查询某个店的充值卡特殊卡
        ShopRechargeCardDTO shopRechargeCardDTO = new ShopRechargeCardDTO();
        shopRechargeCardDTO.setSysShopId(shopRechargeCardDTO.getSysShopId());
        shopRechargeCardDTO.setRechargeCardType(RechargeCardTypeEnum.SPECIAL.getCode());
        ShopRechargeCardResponseDTO shopRechargeCard = shopRechargeCardService.getShopRechargeCard(shopRechargeCardDTO);
        if (null == shopRechargeCard) {
            logger.error("保存用户的建档案信息，查询店={}的特殊卡位空", shopUserArchivesDTO.getSysShopId());
            return 0;
        }
        //生成用户的特殊充值卡
        ShopUserRechargeCardDTO rechargeCardDTO = new ShopUserRechargeCardDTO();
        rechargeCardDTO.setId(IdGen.uuid());
        rechargeCardDTO.setShopRechargeCardId(shopRechargeCard.getId());
        rechargeCardDTO.setShopRechargeCardName("余额充值");
        rechargeCardDTO.setProductDiscount(1f);
        rechargeCardDTO.setPeriodDiscount(1f);
        rechargeCardDTO.setTimeDiscount(1f);
        rechargeCardDTO.setSysShopId(shopUserArchivesDTO.getSysShopId());
        rechargeCardDTO.setSysUserId(shopUserArchivesDTO.getSysUserId());
        rechargeCardDTO.setSurplusAmount(new BigDecimal(0));
        rechargeCardDTO.setCreateBy(shopUserArchivesDTO.getSysClerkId());
        rechargeCardDTO.setSysClerkName(shopUserArchivesDTO.getSysClerkName());
        rechargeCardDTO.setSysBossId(shopUserArchivesDTO.getSysBossId());
        rechargeCardDTO.setRechargeCardType(RechargeCardTypeEnum.SPECIAL.getCode());
        int updateRechargeCard = shopRechargeCardService.saveShopUserRechargeCardInfo(rechargeCardDTO);
        logger.info("生成用户的特殊卡{}", updateRechargeCard > 0 ? "成功" : "失败");
        return shopUserArchivesMapper.insert(shopUserArchivesDTO);
    }

    /**
     * 更新用户的档案信息
     *
     * @param shopUserArchivesDTO
     * @return
     */
    @Override
    public int updateShopUserArchivesInfo(ShopUserArchivesDTO shopUserArchivesDTO) {

        logger.info("更新用户的档案信息传入参数={}", "shopUserArchivesDTO = [" + shopUserArchivesDTO + "]");

        if (CommonUtils.objectIsEmpty(shopUserArchivesDTO)) {
            logger.error("更新用户的档案信息,传入参数为空{}", "shopUserArchivesDTO = [" + shopUserArchivesDTO + "]");
            return 0;
        }

        return shopUserArchivesMapper.updateByPrimaryKeySelective(shopUserArchivesDTO);
    }

    /**
     * 删除用户的档案信息
     *
     * @param archivesId
     * @return
     */
    @Override
    public int deleteShopUserArchivesInfo(String archivesId) {

        logger.info("保存用户的建档案信息传入参数={}", "archivesId = [" + archivesId + "]");

        if (StringUtils.isBlank(archivesId)) {
            logger.error("保存用户的建档案信息,传入参数为空{}", "archivesId = [" + archivesId + "]");
            return 0;
        }

        return shopUserArchivesMapper.deleteByPrimaryKey(archivesId);
    }

    /**
     * 查询某个用户的档案信息
     *
     * @param shopUserArchivesDTO
     * @return
     */
    @Override
    public List<ShopUserArchivesDTO> getShopUserArchivesInfo(ShopUserArchivesDTO shopUserArchivesDTO) {

        logger.info("查询某个用户的档案信息传入参数={}", "shopUserArchivesDTO = [" + shopUserArchivesDTO + "]");

        ShopUserArchivesCriteria criteria = new ShopUserArchivesCriteria();
        ShopUserArchivesCriteria.Criteria c = criteria.createCriteria();

        if (StringUtils.isNotBlank(shopUserArchivesDTO.getSysUserId())) {
            c.andSysUserIdEqualTo(shopUserArchivesDTO.getSysUserId());
        }

        if (StringUtils.isNotBlank(shopUserArchivesDTO.getPhone())) {
            c.andPhoneEqualTo(shopUserArchivesDTO.getPhone());
        }

        if (StringUtils.isNotBlank(shopUserArchivesDTO.getSysBossId())) {
            c.andSysBossIdEqualTo(shopUserArchivesDTO.getSysBossId());
        }

        List<ShopUserArchivesDTO> shopUserArchivesDTOS = shopUserArchivesMapper.selectByCriteria(criteria);

        if (CommonUtils.objectIsEmpty(shopUserArchivesDTOS)) {
            logger.error("查询某个用户的档案信息查询结果为空");
            return null;
        }
        logger.debug("查询某个用户的档案信息大小为， {}", shopUserArchivesDTOS.size());
        return shopUserArchivesDTOS;
    }

    /**
     * 保存用户档案接口
     *
     * @param shopUserArchivesDTO
     * @return
     */
    @Override
    public ResponseDTO<String> saveArchiveInfo(@RequestBody ShopUserArchivesDTO shopUserArchivesDTO) {
        ResponseDTO<String> responseDTO = new ResponseDTO<>();
        //查询是否已存在档案信息

        List<ShopUserArchivesDTO> shopUserArchivesInfo = getShopUserArchivesInfo(shopUserArchivesDTO);
        if (CommonUtils.objectIsNotEmpty(shopUserArchivesInfo)) {
            responseDTO.setResponseData("用户已经存在了");
            responseDTO.setResult(StatusConstant.FAILURE);
            return responseDTO;
        }

        shopUserArchivesDTO.setId(IdGen.uuid());
        //查询用户
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setMobile(shopUserArchivesDTO.getPhone());
        List<UserInfoDTO> userInfoDTOS = userServiceClient.getUserInfo(userInfoDTO);

        logger.debug("保存用户档案接口，查询的用户信息为，{}", "userInfoDTOS = [" + userInfoDTOS + "]");

        if (CommonUtils.objectIsEmpty(userInfoDTOS)) {
            userInfoDTO.setId(IdGen.uuid());
            userInfoDTO.setNickname(shopUserArchivesDTO.getSysUserName());
            userInfoDTO.setCreateDate(new Date());
            userInfoDTO.setUserType(ConfigConstant.beautySource);
            userInfoDTO.setPhoto(shopUserArchivesDTO.getPhone());
            logger.debug("保存用户档案接口,sys_user表中插入用户信息 {}", "shopUserArchivesDTO = [" + shopUserArchivesDTO + "]");
            userServiceClient.insertUserInfo(userInfoDTO);
        } else {
            userInfoDTO = userInfoDTOS.get(0);
        }

        SysClerkDTO clerkInfo = UserUtils.getClerkInfo();
        SysBossDTO bossInfo = UserUtils.getBossInfo();
        String sysBossId = null;
        String sysShopId = null;
        //pad端登陆
        if (null != clerkInfo) {
            sysBossId = clerkInfo.getSysBossId();
            sysShopId = clerkInfo.getSysShopId();
        }
        if (null != bossInfo) {
            sysBossId = bossInfo.getId();
        }

        shopUserArchivesDTO.setSysUserId(userInfoDTO.getId());
        shopUserArchivesDTO.setSysUserName(userInfoDTO.getNickname());
        shopUserArchivesDTO.setSysUserType(userInfoDTO.getUserType());
        shopUserArchivesDTO.setCreateDate(new Date());
        shopUserArchivesDTO.setSysShopId(sysShopId);
        SysShopDTO shopInfoByPrimaryKey = shopService.getShopInfoByPrimaryKey(sysShopId);
        if (null != shopInfoByPrimaryKey) {
            logger.error("查询的shopId为空{}", "shopUserArchivesDTO = [" + shopUserArchivesDTO + "]");
            shopUserArchivesDTO.setShopid(shopInfoByPrimaryKey.getShopId());
        }
        shopUserArchivesDTO.setSysBossId(sysBossId);
        int info = saveShopUserArchivesInfo(shopUserArchivesDTO);
        logger.info("生成用户的档案信息{}", info > 0 ? "成功" : "失败");

        responseDTO.setResponseData(BusinessErrorCode.SUCCESS.getCode());
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    @Override
    public List<ShopUserArchivesDTO> getArchivesList(List<String> userIds) {
        logger.info("getArchivesList方法出入的参数userIds={}",userIds);
        if(CollectionUtils.isEmpty(userIds)){
            return  null;
        }
        ShopUserArchivesCriteria criteria = new ShopUserArchivesCriteria();
        ShopUserArchivesCriteria.Criteria c = criteria.createCriteria();
        c.andSysUserIdIn(userIds);
        return  shopUserArchivesMapper.selectByCriteria(criteria);
    }
}
