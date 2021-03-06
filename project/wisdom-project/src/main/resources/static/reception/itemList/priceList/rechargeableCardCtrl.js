PADWeb.controller("rechargeableCardCtrl", function($scope, $state, $stateParams,$rootScope,GetShopProjectGroups) {
    /*-------------------------------------------定义头部/左边信息--------------------------------*/
    $scope.$parent.$parent.param.top_bottomSelect = "jiamubiao";
    $scope.$parent.$parent.param.headerPrice.blackTitle = "套卡"
    $scope.$parent.param.priceType = "tk"
    $scope.flagFn = function (bool) {
        //左
        $scope.$parent.mainLeftSwitch.peopleListFlag = !bool
        $scope.$parent.mainLeftSwitch.priceListFlag = bool
        //头
        $scope.$parent.$parent.mainSwitch.headerReservationAllFlag = !bool
        $scope.$parent.$parent.mainSwitch.headerCashAllFlag = !bool
        $scope.$parent.$parent.mainSwitch.headerPriceListAllFlag = bool
        $scope.$parent.$parent.mainSwitch.headerLoginFlag = !bool
        $scope.$parent.$parent.mainSwitch.headerPriceListBlackFlag = bool
    }
    /*打开收银头部/档案头部/我的头部*/
    $scope.flagFn(true)
    console.log("rechargeableCardCtrl");
    $rootScope.title="充值卡";
    $scope.goRechargeableDetails=function (id) {
        $state.go("pad-web.cardDetails",{id:id})
    }
    $scope.param={
        projectGroupName:"",
        pageSize:"100",
        rechargeableCardList:{}
    }
    $scope.status = '0'
    $rootScope.loadingFlag = true;
    GetShopProjectGroups.get({
        projectGroupName: $scope.param.projectGroupName,
        // pageSize:$scope.param.pageSize,
        pageSize:"100",
        status:$scope.status
    },function (data) {
        if(data.result == "0x00001"){
            $rootScope.loadingFlag = false;
            $scope.rechargeableCardList=data.responseData;
        }
    })
})
