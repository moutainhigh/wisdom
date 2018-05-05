package com.wisdom.beauty.core.service.stock;

import java.util.List;

import com.wisdom.beauty.api.dto.*;
import com.wisdom.beauty.api.extDto.ExtShopStoreDTO;
import com.wisdom.beauty.api.responseDto.ShopStockResponseDTO;
import com.wisdom.common.dto.account.PageParamVoDTO;
import com.wisdom.common.dto.system.PageParamDTO;

/**
 * FileName: ShopStockService
 *
 * @author: 张超
 * Date:     2018/4/23  14:06
 * Description: 仓库和库存相关
 */
public interface ShopStockService {

    /**
     * 查询仓库列表
     *
     * @param pageParamDTO 分页对象
     * @return
     */

    PageParamDTO<List<ExtShopStoreDTO>> findStoreListS(PageParamDTO<ExtShopStoreDTO> pageParamDTO);


    /**
     * 插入一条出/入库记录
     *
     * @param shopStockRecordDTO 出入库表实体对象
     * @return
     */
    void insertStockRecord(ShopStockRecordDTO shopStockRecordDTO);

    /**
     * @Author:zhanghuan
     * @Param:
     * @Return:
     * @Description: 根据记录id获取产品入库单详情
     * @Date:2018/5/2 16:54
     */
    ShopStockResponseDTO getShopStock(ShopStockRecordDTO shopStockRecordDTO);

    /**
     * @Author:zhanghuan
     * @Param: bossId   shopStoreId
     * @Return:
     * @Description: 获取出库/入库记录
     * @Date:2018/5/2 17:57
     */
    List<ShopStockRecordDTO> getShopStockRecordList(PageParamVoDTO<ShopStockRecordDTO> pageParamVoDTO);

    /**
     * @Author:zhanghuan
     * @Param:
     * @Return:
     * @Description: 获取boss和仓库的关系
     * @Date:2018/5/2 18:16
     */
    List<ShopStockBossRelationDTO> getShopStockBossRelationList(ShopStockBossRelationDTO shopStockBossRelation);

    /**
     * @Author:zhanghuan
     * @Param:
     * @Return:
     * @Description: 根据条件获取库存
     * @Date:2018/5/3 14:40
     */
    List<ShopStockDTO> getShopStockList(ShopStockDTO ShopStockDTO);
    /**
    *@Author:zhanghuan
    *@Param:
    *@Return:
    *@Description: 批量插入ShopStockDTO, 接收json字符串数组，然后换成java对象
    *@Date:2018/5/3 16:47
    */
    int insertShopStockDTO(String shopStockDTOs);

}
