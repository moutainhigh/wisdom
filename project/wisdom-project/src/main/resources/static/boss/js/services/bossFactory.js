var appointmentInfo = '/beauty/appointmentInfo/';
var work = '/beauty/work/';
var stock = '/beauty/stock/';
var consume = '/beauty/consume/';
var  earlyWarning =  '/beauty/earlyWarning/';
var  archives =  '/beauty/archives/';
var clerkSchedule='/beauty/clerkSchedule/';
var shopBossRelation ='/beauty/shopBossRelation/';
var user ='/user/';
var analyze = '/beauty/analyze/';
var consumes = '/beauty/consumes/';
var consume = '/beauty/consume/';
var cardInfo  = '/beauty/cardInfo/';
var projectInfo  = '/beauty/projectInfo/';
var productInfo  = '/beauty/productInfo/';
var productTypeInfo = '/beauty/productTypeInfo/';
var projectType='/beauty/projectType/';
var shop='/beauty/shop/';



define(['appBoss'], function (app) {
    app

        .factory('GetUserValidateCode',['$resource',function ($resource){
            return $resource(user + 'getUserValidateCode')
        }])
       /*根据时间查询各店预约情况*/
        .factory('GetShopAppointmentNumberInfo',['$resource',function ($resource){
            return $resource(appointmentInfo + 'getShopAppointmentNumberInfo')
        }])
        /*根据时间查询某个店的预约详情*/
        .factory('ShopDayAppointmentInfoByDate',['$resource',function ($resource){
            return $resource(appointmentInfo + 'shopDayAppointmentInfoByDate')
        }])
       /*获取某个老板下面的某个店下的某个美容师的预约列表*/
        .factory('GetShopClerkAppointmentInfo',['$resource',function ($resource){
        return $resource(appointmentInfo + 'getShopClerkAppointmentInfo')
        }])
       /*根据预约状态获取某个老板下面的某个店的预约列表*/
        .factory('GetShopAppointmentInfoByStatus',['$resource',function ($resource){
            return $resource(appointmentInfo + 'getShopAppointmentInfoByStatus')
       }])
        /*根据预约主键获取预约详情*/
        .factory('GetAppointmentInfoById',['$resource',function ($resource){
            return $resource(appointmentInfo + 'getAppointmentInfoById')
        }])
        /*根据预约主键修改此次预约信息（修改预约状态等）*/
        .factory('UpdateAppointmentInfoById',['$resource',function ($resource){
            return $resource(appointmentInfo + 'updateAppointmentInfoById')
        }])

 /*库存*/
        /*入库出库记录*/
        .factory('ShopStockRecordList',['$resource',function ($resource){
            return $resource(stock + 'shopStockRecordList')
        }])
        /*跳转更新时候获取的产品信息和库存*/
        .factory('GetProductInfoAndStock',['$resource',function ($resource){
            return $resource(stock + 'getProductInfoAndStock')
        }])
        /*更新库存实际量和价格*/
        .factory('UpdateStockNumber',['$resource',function ($resource){
            return $resource(stock + 'updateStockNumber')
        }])
        /*入库(确认入库按钮)*/
        .factory('AddStock',['$resource',function ($resource){
            return $resource(stock + 'addStock')
        }])
        /*查询家人*/
        .factory('GetClerkInfoList',['$resource',function ($resource){
            return $resource(user + 'getClerkInfoList')
        }])
        /*查询家人*/
        .factory('SaveClerkInfo',['$resource',function ($resource){
            return $resource(user + 'saveClerkInfo')
        }])







/*综合分析*/
        /*根据时间查询某个美容院的耗卡和业绩*/
        .factory('GetExpenditureAndIncome',['$resource',function ($resource){
            return $resource(work + 'getExpenditureAndIncome')
        }])
        /*根据时间获取所有美容院的列表的业绩和卡耗*/
        .factory('GetBossExpenditureAndIncome',['$resource',function ($resource){
            return $resource(work + 'getBossExpenditureAndIncome')
        }])
        /*获取具体某个美容院的业绩和耗卡（包含来源分析）*/
        .factory('GetShopConsumeAndRecharge',['$resource',function ($resource){
            return $resource(work + 'getShopConsumeAndRecharge')
        }])
        /*业绩明细(boss端)*/
        .factory('GetBossPerformance',['$resource',function ($resource){
            return $resource(work + 'getBossPerformance')
        }])
        /*账户信息记录的详细信息*/
        .factory('ConsumeFlowNo',['$resource',function ($resource){
            return $resource(consume+"consumeFlowNo")
        }])
        /*获取当前美容院当前boss的当前家人列表*/
        .factory('GetFamilyList',['$resource',function ($resource){
            return $resource(work+"getFamilyList")
        }])

/*收支分析*/
        /*根据时间获取所有店的总收入以及现金，现金，银行卡支付的收入  某个的也是这个*/
        .factory('GetInComeExpenditureDetail',['$resource',function ($resource){
            return $resource(analyze+"getInComeExpenditureDetail")
        }])
        /*获取全部分店的总收入和现金收入*/
        .factory('GetAllShopIncomeExpenditure',['$resource',function ($resource){
            return $resource(analyze+"getAllShopIncomeExpenditure")
        }])
       
        /*获取某个店的收入明细*/
        .factory('GetIncomeExpenditureAnalysisDetailList',['$resource',function ($resource){
            return $resource(analyze+"getIncomeExpenditureAnalysisDetailList")
        }])
        /*所有店近7 日现金收入趋势  某个店的也是这个*/
        .factory('GetCashEarningsTendency',['$resource',function ($resource){
            return $resource(analyze+"getCashEarningsTendency")
        }])
/*员工分析*/
        /*员工分析列表*/
        .factory('GetClerkAchievementList',['$resource',function ($resource){
            return $resource(analyze+"getClerkAchievementList")
        }])

        /*顾客到店*/
        .factory('GetCustomerArriveList',['$resource',function ($resource){
            return $resource(analyze+"getCustomerArriveList")
        }])



  /*工作首页*/
        /*获取人头数，人次数，新客，服务次数*/
        .factory('GetBossAchievement',['$resource',function ($resource){
            return $resource(work+"getBossAchievement")
        }])


   /*档案*/
        /*预警档案*/
        .factory('GetEarlyWarningList',['$resource',function ($resource){
            return $resource(earlyWarning+"getEarlyWarningList")
        }])
        /*用户档案详情*/
        .factory('Detail',['$resource',function ($resource){
            return $resource(archives+"detail/:id",{id:"@id"})
        }])
        /*用户档案详情*/
        .factory('Consumes',['$resource',function ($resource){
            return $resource(consumes)
        }])
        /*用户档案详情*/
        .factory('GetUserRechargeCardList',['$resource',function ($resource){
            return $resource(cardInfo+'getUserRechargeCardList')
        }])
        /*获取疗程卡的消费记录*/
        .factory('GetUserConsumeByFlowId',['$resource',function ($resource){
            return $resource(consume+'getUserConsumeByFlowId')
        }])




 /*行政管理*/
        /*查询老板的门店*/
        .factory('GetBossShopList',['$resource',function ($resource){
            return $resource(shopBossRelation+"getBossShopList")
        }])

      /*获取档案列表*/
        .factory('FindArchives',['$resource',function ($resource){
            return $resource(archives+"findArchives")
        }])
    /*查询美容师排班信息*/
        .factory('GetShopClerkScheduleList',['$resource',function ($resource){
            return $resource(clerkSchedule+"getShopClerkScheduleList")
        }])

      /*获取用户的疗程卡界面*/
        .factory('GetUserCourseProjectList',['$resource',function ($resource){
            return $resource(projectInfo+"getUserCourseProjectList")
        }])
       /*获取用户的产品界面*/
        .factory('GetUserProductList',['$resource',function ($resource){
            return $resource(productInfo+"getUserProductList")
        }])
        /*获取用户的套卡界面*/
        .factory('GetUserProjectGroupList',['$resource',function ($resource){
            return $resource(projectInfo+"getUserProjectGroupList")
        }])
      /* 更新用户的档案信息*/
        .factory('UpdateArchiveInfo',['$resource',function ($resource){
            return $resource(archives+"updateArchiveInfo")
        }])
/*产品品牌*/
        /* 查询某个店的产品信息*/
        .factory('SearchShopProductList',['$resource',function ($resource){
            return $resource(productInfo+"searchShopProductList")
        }])
        /* 添加产品品牌*/
        .factory('SaveProductTypeInfo',['$resource',function ($resource){
            return $resource(productTypeInfo+"saveProductTypeInfo")
        }])
        /* 修改产品品牌*/
        .factory('UpdateOneLevelTypeInfo',['$resource',function ($resource){
            return $resource(productTypeInfo+"updateOneLevelTypeInfo")
        }])
        /* 修改产品系列*/
        .factory('UpdateTwoLevelTypeInfo',['$resource',function ($resource){
            return $resource(productTypeInfo+"updateTwoLevelTypeInfo")
        }])

    /*项目大类设置*/
        /*查询项目类别信息*/
        .factory('SearchShopProjectList',['$resource',function ($resource){
            return $resource(projectInfo+"searchShopProjectList")
        }])
      /*添加项目类别接口*/
        .factory('SaveShopProjectType',['$resource',function ($resource){
            return $resource(projectType+"saveShopProjectType")
        }])
    /*修改项目类别*/
        .factory('UpdateOneLevelProjectType',['$resource',function ($resource){
            return $resource(projectType+"updateOneLevelProjectType")
        }])
    /*修改项目系列*/
        .factory('UpdateTwoLevelProjectType',['$resource',function ($resource){
            return $resource(projectType+"updateTwoLevelProjectType")
        }])
        /* 获取二级产品列表*/
        .factory('TwoLevelProduct',['$resource',function ($resource){
            return $resource(productInfo+"twoLevelProduct")
        }])
 /*美容院设置*/
        /* 查询美容院设置*/
        .factory('GetBossShopInfo',['$resource',function ($resource){
            return $resource(shop+"getBossShopInfo")
        }])
        /* 保存美容院设置*/
        .factory('UpdateShopInfo',['$resource',function ($resource){
            return $resource(shop+"updateShopInfo")
        }])
/*编辑分店*/
        /* 查询分店列表*/
        .factory('GetBossAllShopList',['$resource',function ($resource){
            return $resource(shop+"getBossAllShopList")
        }])
        /* 查询某个门店*/
        .factory('GetShopInfo',['$resource',function ($resource){
            return $resource(shop+"getShopInfo")
        }])

       /*获取二级项目列表*/
        .factory('TwoLevelProject',['$resource',function ($resource){
            return $resource(projectInfo+"twoLevelProject")
        }])
    /*删除修改产品*/
        /*获取客装产品列表*/
        .factory('GetShopProductLevelInfo',['$resource',function ($resource){
            return $resource(productTypeInfo+"getShopProductLevelInfo")
        }])
        /*查询产品的详细信息*/
        .factory('ProductInfoMess',['$resource',function ($resource){
            return $resource(productInfo+"/:productId",{ productId: '@productId' })
        }])
        /*查询产品的详细信息*/
        .factory('UpdateProductInfo',['$resource',function ($resource){
            return $resource(productInfo+"updateProductInfo")
        }])
        /*添加产品*/
        .factory('SaveProductInfo',['$resource',function ($resource){
            return $resource(productInfo+"saveProductInfo")
        }])


});
