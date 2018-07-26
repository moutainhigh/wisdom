package com.wisdom.business.controller.product;

import com.wisdom.business.service.product.SeckillProductService;
import com.wisdom.common.dto.account.PageParamVoDTO;
import com.wisdom.common.dto.product.SeckillActivityDTO;
import com.wisdom.common.dto.product.SeckillProductDTO;
import com.wisdom.common.dto.system.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *微商城秒杀控制端
 *
 * Created by wangbaowei on 2018/7/25.
 */

@Controller
@RequestMapping(value = "seckillProduct")
public class SeckillProductController {

    Logger logger = LoggerFactory.getLogger(SeckillProductController.class);

    @Autowired
    private SeckillProductService seckillProductService;


    /**
     * 获取秒杀商品活动列表
     *
     */
    @RequestMapping(value = "getSeckillProductList", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamVoDTO> getSeckillProductList(@RequestBody PageParamVoDTO<SeckillProductDTO> pageParamVoDTO) {
        long startTime = System.currentTimeMillis();
        logger.info("获取某个商品的基本信息==={}开始" , startTime);
        ResponseDTO<PageParamVoDTO> responseDTO = new ResponseDTO<>();
        PageParamVoDTO<List<SeckillProductDTO>> page = seckillProductService.queryAllProducts(pageParamVoDTO);
        responseDTO.setResponseData(page);
        logger.info("获取某个商品的基本信息,耗时{}毫秒", (System.currentTimeMillis() - startTime));
        return responseDTO;
    }

    /**
     * 获取秒杀商品活动列表
     *
     */
    @RequestMapping(value = "getseckillProductDetailById", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    SeckillProductDTO getseckillProductDetailById(String activtyId) {
        return seckillProductService.getseckillProductDetailById(activtyId);
    }


    /**
     * 根据场次id获取库存量
     */
    @RequestMapping(value = "getSeckillProductInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<Integer> getSeckillProductInfo(@RequestParam String fieldId) {
        long startTime = System.currentTimeMillis();
        ResponseDTO<Integer> responseDTO = new ResponseDTO<>();
        logger.info("获取某个商品的基本信息==={}开始" , startTime);
        int productAmount = seckillProductService.getProductAmout(fieldId);
        responseDTO.setResponseData(productAmount);
        logger.info("获取某个商品的基本信息,耗时{}毫秒", (System.currentTimeMillis() - startTime));
        return responseDTO;
    }

    /**
     * 获取活动列表
     *
     * */
    @RequestMapping(value ="findSeckillActivityList",method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamVoDTO<List<SeckillActivityDTO>>> findSeckillActivityList(PageParamVoDTO<SeckillActivityDTO> pageParamVoDTO){
        long startTime = System.currentTimeMillis();
        ResponseDTO<PageParamVoDTO<List<SeckillActivityDTO>>> responseDTO = new ResponseDTO<>();
        SeckillActivityDTO seckillActivityDTO = new SeckillActivityDTO();
        seckillActivityDTO = pageParamVoDTO.getRequestData();
        seckillActivityDTO.setPageNo(pageParamVoDTO.getPageNo());
        seckillActivityDTO.setPageSize(pageParamVoDTO.getPageSize());
        logger.info("获取某个商品的基本信息==={}开始" , startTime);
        PageParamVoDTO<List<SeckillActivityDTO>> page = seckillProductService.findSeckillActivitylist(seckillActivityDTO);
        responseDTO.setResponseData(page);
        return responseDTO;
    }
}