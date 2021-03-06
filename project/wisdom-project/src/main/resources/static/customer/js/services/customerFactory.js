
var product = '/business/product/';
var account = '/business/account/';
var withdraw = '/business/withdraw/';
var transaction = '/business/transaction/';
var userType = '/business/userType/';
var bannerList = '/system/banner/';
var suggest = '/system/feedback/';
var customer  = '/user/customer/';
var user = '/user/';
var weixin = '/weixin/customer/';
var projectInfo = '/beauty/projectInfo/';
var appointInfo = '/beauty/appointmentInfo/';
var clerkSchedule = '/beauty/clerkSchedule/';
var mine = '/beauty/mine/';
var userIP = '/user/';
var cardInfo = '/beauty/cardInfo/'
var seckillProduct = '/business/seckillProduct'
var seckillOrder = '/business/seckillOrder'

define(['appCustomer'], function (app) {
    app

        .factory('GetUserValidateCode',['$resource',function ($resource){
            return $resource(user + 'getUserValidateCode')
        }])
        .factory('UserLogin',['$resource',function ($resource){
            return $resource(user + 'userLogin')
        }])
        .factory('UserLoginOut',['$resource',function ($resource){
            return $resource(user + 'userLoginOut')
        }])
        .factory('BeautyUserLogin',['$resource',function ($resource){
            return $resource(user + 'beautyLogin')
        }])
        .factory('BeautyUserLoginOut',['$resource',function ($resource){
            return $resource(user + 'beautyLoginOut')
        }])
        .factory('GetUserInfo',['$resource',function ($resource){
            return $resource(customer + 'getUserInfo')
        }])
        .factory('GetUserInfoByOpenId',['$resource',function ($resource){
            return $resource(customer + 'getUserInfoByOpenId')
        }])
        .factory('GetUserNextLevelStruct',['$resource',function ($resource){
            return $resource(userType + 'getUserNextLevelStruct')
        }])

        .factory('GetHomeBannerList',['$resource',function ($resource){
            return $resource(bannerList + 'getHomeBannerList')
        }])

        .factory('GetTrainingProductDetail',['$resource',function ($resource){
            return $resource(product + 'getTrainingProductDetail')
        }])
        .factory('GetBusinessProductInfo',['$resource',function ($resource){
            return $resource(product + 'getBusinessProductInfo')
        }])
        .factory('GetTrainingProductPlayNum',['$resource',function ($resource){
            return $resource(product + 'getTrainingProductPlayNum')
        }])
        .factory('GetOfflineProductList',['$resource',function ($resource){
            return $resource(product + 'getOfflineProductList')
        }])
        .factory('GetTrainingProductListNeedPay',['$resource',function ($resource){
            return $resource(product + 'getTrainingProductListNeedPay')
        }])
        .factory('GetTrainingProductListNoNeedPay',['$resource',function ($resource){
            return $resource(product + 'getTrainingProductListNoNeedPay')
        }])
        .factory('GetOfflineProductDetail',['$resource',function ($resource){
            return $resource(product + 'getOfflineProductDetail')
        }])
        .factory('AddTrainingProductPlayNum',['$resource',function ($resource){
            return $resource(product + 'AddTrainingProductPlayNum')
        }])
        //发票
        .factory('AddInvoiceInfo',['$resource',function ($resource){
            return $resource( product+ 'addInvoiceInfo')
        }])
        /*获取一级类目*/
        .factory('GetOneProductClassList',['$resource',function ($resource){
            return $resource( product+ 'getOneProductClassList')
        }])
        /*获取二级类目*/
        .factory('GetTwoProductClassList',['$resource',function ($resource){
            return $resource( product+ 'getTwoProductClassList')
        }])
        .factory('GetAttentionTeacherStatus',['$resource',function ($resource){
            return $resource( transaction+ 'getAttentionTeacherStatus')
        }])
        .factory('AttentionTeacher',['$resource',function ($resource){
            return $resource( transaction+ 'attentionTeacher')
        }])
        .factory('BuriedPoint',['$resource',function ($resource){
            return $resource( "http://mx99test1.kpbeauty.com.cn:3000/dotLog");
        }])
        .factory('GetOrderAddressDetail',['$resource',function ($resource){
            return $resource( transaction+ 'orderAddressDetail')
        }])
        .factory('GetOrderDetailInfo',['$resource',function ($resource){
            return $resource( transaction+ 'orderDetailInfo')
        }])
        .factory('GetTripleMonthBonus',['$resource',function ($resource){
            return $resource( transaction+ 'getTripleMonthBonus')
        }])
        //获取
        .factory('QueryOrderCopRelationById',['$resource',function ($resource){
            return $resource(transaction+'queryOrderCopRelationById')
        }])
        .factory('GetBusinessOrderByProductId',['$resource',function ($resource){
            return $resource(transaction + 'getBusinessOrderByProductId')
        }])
        .factory('CheckTripleMonthBonus',['$resource',function ($resource){
            return $resource( transaction + 'checkTripleMonthBonus');
        }])
        // 点击查看是否购买视频
         .factory('GetTrainingBusinessOrder',['$resource',function ($resource){
             return $resource(transaction + 'getTrainingBusinessOrder')
         }])

        .factory('AddProduct2BuyCart',['$resource',function ($resource){
            return $resource('/business/transaction/addProduct2BuyCart')
        }])
        .factory('MinusProduct2BuyCart',['$resource',function ($resource){
            return $resource('/business/transaction/minusProduct2BuyCart')
        }])



        .factory('MinusProduct2BuyCart',['$resource',function ($resource){
            return $resource(transaction + 'minusProduct2BuyCart')
        }])
        .factory('GetProductNumFromBuyCart',['$resource',function ($resource){
            return $resource(transaction + 'getProductNumFromBuyCart')
        }])
        .factory('GetBuyCartInfo',['$resource',function ($resource){
            return $resource(transaction + 'buyCart')
        }])
        .factory('DeleteOrderFromBuyCart',['$resource',function ($resource){
            return $resource(transaction + 'deleteOrderFromBuyCart')
        }])
        .factory('PutNeedPayOrderListToRedis',['$resource',function ($resource){
            return $resource(transaction + 'putNeedPayOrderListToRedis')
        }])
        .factory('GetUserAddressList',['$resource',function ($resource){
            return $resource(transaction + 'userAddressList')
        }])
        .factory('AddUserAddress',['$resource',function ($resource){
            return $resource(transaction + 'addUserAddress')
        }])
        .factory('UpdateUserAddress',['$resource',function ($resource){
            return $resource(transaction + 'updateUserAddress')
        }])
        .factory('DeleteUserAddress',['$resource',function ($resource){
            return $resource(transaction + 'deleteUserAddress')
        }])
        .factory('GetTransactionList',['$resource',function ($resource){
            return $resource(transaction + 'getTransactionList')
        }])
        .factory('GetUserTransactionDetail',['$resource',function ($resource){
            return $resource(transaction + 'getUserTransactionDetail')
        }])
        .factory('GetBusinessOrderList',['$resource',function ($resource){
            return $resource(transaction + 'businessOrderList')
        }])
        .factory('UpdateBusinessOrderStatus',['$resource',function ($resource){
            return $resource(transaction + 'updateBusinessOrderStatus')
        }])
        .factory('CreateBusinessOrder',['$resource',function ($resource){
            return $resource(transaction + 'createBusinessOrder')
        }])
        .factory('FindUserAddressById',['$resource',function ($resource){
            return $resource(transaction + 'findUserAddressById')
        }])
        .factory('GetUserAccountInfo',['$resource',function ($resource){
            return $resource(account + 'getUserAccountInfo')
        }])
        .factory('WithDrawMoneyFromAccount',['$resource',function ($resource){
            return $resource( withdraw+'withDrawMoneyFromAccount')
        }])

        .factory('SuggestionDetail',['$resource',function ($resource){
            return $resource(suggest + 'suggestionDetail')
        }])

        //获取物流信息
        .factory('GetlogisticsQuery',['$resource',function ($resource){
            return $resource('http://47.100.102.37:3000/logisticsQuery')
        }])

        //获取用户的推广二维码
        .factory('GetCustomerQRCode',['$resource',function ($resource){
            return $resource(weixin + 'getUserQRCode')
        }])

        //获取用户的推广二维码
        .factory('GetSpecialProductList',['$resource',function ($resource){
            return $resource(product + 'getSpecialProductList')
        }])

        .factory('GetSpecialShopInfo',['$resource',function ($resource){
            return $resource(product + 'getSpecialShopInfo')
        }])
        //
        .factory('FindProductById',['$resource',function ($resource){
            return $resource(product + 'findProductById');
        }])

        .factory('FindProductBargainPriceTimeById',['$resource',function ($resource){
            return $resource(product + 'findProductBargainPriceTimeById');
        }])

        .factory('GetSpecialBossCondition',['$resource',function ($resource){
            return $resource(customer + 'getSpecialBossCondition');
        }])

        .factory('GetUserIsBoss',['$resource',function ($resource){
                return $resource(account + 'isShopKeeper');
         }])

         .factory('FindShopKeeperOrderS',['$resource',function ($resource){
                return $resource(account + 'findShopKeeperOrderS');
         }])
         .factory('FindOrderByTransactionId',['$resource',function ($resource){
                return $resource(account + 'findOrderByTransactionId');
          }])
         .factory('IsLogin',['$resource',function ($resource){
              return $resource(account + 'isLogin');
         }])

        //美容院用户侧接口
        .factory('GetUserClientShopProjectList',['$resource',function ($resource){
            return $resource(projectInfo + 'getUserClientShopProjectList')
        }])
        .factory('GetShopClerkList',['$resource',function ($resource){
            return $resource(appointInfo + 'getShopClerkList')
        }])
        .factory('GetClerkScheduleInfo',['$resource',function ($resource){
            return $resource(clerkSchedule + 'getClerkScheduleInfo')
        }])
        .factory('GetBeautyShopInfo',['$resource','$http','$q',function ($resource,$http,$q){
                return {
                    clerkInfo: function (clerkId) {
                        lazyClerkDeferred = $q.defer();
                        $http({
                            url: user + 'clerkInfo/' + clerkId,
                            method: 'GET'
                        }).success(function (response, status, header, config, statusText) {
                            //成功处理
                            lazyClerkDeferred.resolve(response);
                        });
                        return lazyClerkDeferred.promise;
                    },
                    shopProjectInfo: function (shopProjectId) {
                        lazyProjectDeferred = $q.defer();
                        $http({
                            url: '/beauty/projectInfo/' + shopProjectId,
                            method: 'GET'
                        }).success(function (response, status, header, config, statusText) {
                            //成功处理
                            lazyProjectDeferred.resolve(response);
                        });
                        return lazyProjectDeferred.promise;
                    }
                }
        }])
        .factory('SaveUserAppointInfo',['$resource',function ($resource){
            return $resource(appointInfo + 'saveUserAppointInfo')
        }])
        .factory('GetAppointmentInfoById',['$resource',function ($resource){
            return $resource(appointInfo + 'getAppointmentInfoById')
        }])
        .factory('GetMyAppointInfoList',['$resource',function ($resource){
            return $resource(appointInfo + 'getMyAppointInfoList')
        }])
        .factory('GetUserClientInfo',['$resource',function ($resource){
            return $resource(mine + 'getUserClientInfo')
        }])
        .factory('ChangeUserShop',['$resource',function ($resource){
            return $resource(mine + 'changeUserShop')
        }])
        .factory('GetUserRechargeCardList',['$resource',function ($resource){
            return $resource(cardInfo + 'getUserRechargeCardList')
        }])
        .factory('GetUserCourseProjectList',['$resource',function ($resource){
            return $resource(projectInfo + 'getUserCourseProjectList')
        }])
        .factory('GetCurrentLoginUserInfo',['$resource',function ($resource){
            return $resource(mine + 'getCurrentLoginUserInfo')
        }])
        .factory('BeautyLoginOut',['$resource',function ($resource){
            return $resource(userIP + 'beautyLoginOut')
        }])
        .factory('GetProjectCardConsumeByFlowId',['$resource',function ($resource){
            return $resource('/beauty/consume/getUserConsumeByFlowId')
        }])
        .factory('GetProjectCardConsume',['$resource',function ($resource){
            return $resource('/beauty/consume/consumeFlowNo')
        }])
        .factory('GetUserQrCode',['$resource',function ($resource){
            return $resource(mine + 'getUserQrCode')
        }])
        .factory('GetProjectConsumes',['$resource',function ($resource){
            return $resource('/beauty/consumes')
        }])
        .factory('GetRankingsList',['$resource',function ($resource){
            return $resource('/business/income/getIncomeRanking')
        }])
         /*用户端选择项目 查看项目详情接口*/
        .factory('ProjectInfo',['$resource',function ($resource){
            return $resource(projectInfo+"/:id", { id: '@id' })
        }])
        .factory('SeckillList',['$resource',function ($resource){
            return $resource(seckillProduct+"/getSeckillProductList")
        }])
        .factory('SeckillInfo',['$resource',function ($resource){
            return $resource(seckillProduct+"/getseckillProductDetailById")
        }])
        .factory('CreateSeckillOrder',['$resource',function ($resource){
            return $resource(seckillOrder+"/createSeckillOrder")
        }])


});
