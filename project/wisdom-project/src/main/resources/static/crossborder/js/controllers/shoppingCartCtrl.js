angular.module('controllers',[]).controller('shoppingCartCtrl',
    ['$scope','$interval','$rootScope','$stateParams','$state','Global','$timeout','GetBorderSpecialProductOrderList',
        function ($scope,$interval,$rootScope,$stateParams,$state,Global,$timeout,GetBorderSpecialProductOrderList) {
            GetBorderSpecialProductOrderList.get({status:"all"},function (data) {
                if(data.result == Global.SUCCESS){
                    $scope.cartList = data.responseData;
                }else{
                    alert("获取信息失败")
                }
                console.log(data)
            })
        }]);