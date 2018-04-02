/**
 * Created by Administrator on 2018/3/2.
 */
angular.module('controllers',[]).controller('orderDetailsCtrl',
    ['$scope','$rootScope','$stateParams','$state','Global','GetOrderAddressDetail','GetOrderDetailInfo',
        function ($scope,$rootScope,$stateParams,$state,Global,GetOrderAddressDetail,GetOrderDetailInfo) {

            $rootScope.title = "订单详情";

            $scope.param = {
                orderId : $stateParams.orderId,
                orderAddressDetail : {},
                orderDetailInfo : {},
                orderProductInfo:{}

            }
            //根据orderId，获取此订单的收货地址
            GetOrderAddressDetail.get({orderId:$scope.param.orderId},function(data){
                if(data.result==Global.SUCCESS)
                {
                    $scope.param.orderAddressDetail = data.responseData;
                    console.log(data.responseData)
                }
            });
            $scope.goOffline=function () {
                $state.go("offlineProductDetail",{productId:$scope.param.orderDetailInfo.businessProductId})

            };
            //根据orderId，获取此订单的详情信息
            GetOrderDetailInfo.get({orderId:$scope.param.orderId},function(data){
                if(data.result==Global.SUCCESS)
                {
                    $scope.param.orderDetailInfo = data.responseData;
                    console.log($scope.param.orderDetailInfo);
                    console.log(data.responseData.businessProductId)
                }
            })

}])
