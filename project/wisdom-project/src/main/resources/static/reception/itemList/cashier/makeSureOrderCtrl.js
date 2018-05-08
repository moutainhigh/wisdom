PADWeb.controller('makeSureOrderCtrl', function($scope, $stateParams, $state, ngDialog, Archives, GetShopUserRecentlyOrderInfo) {
    /*-------------------------------------------定义头部/左边信息--------------------------------*/
    $scope.$parent.$parent.param.top_bottomSelect = "shouyin";
    $scope.$parent.$parent.param.headerCash.leftContent = "档案(9010)";
    $scope.$parent.$parent.param.headerCash.leftAddContent = "添加档案";
    $scope.$parent.$parent.param.headerCash.backContent = "充值记录";
    $scope.$parent.$parent.param.headerCash.leftTip = "添加更多";
    $scope.$parent.$parent.mainSwitch.headerCashFlag.headerCashRightFlag.leftFlag = true;
    $scope.$parent.$parent.mainSwitch.headerCashFlag.headerCashRightFlag.middleFlag = true;
    $scope.$parent.$parent.mainSwitch.headerCashFlag.headerCashRightFlag.rightFlag = true;
    $scope.flagFn = function(bool) {
        //左
        $scope.$parent.mainLeftSwitch.peopleListFlag = bool;
        $scope.$parent.mainLeftSwitch.priceListFlag = !bool;
        //头
        $scope.$parent.$parent.mainSwitch.headerReservationAllFlag = !bool;
        $scope.$parent.$parent.mainSwitch.headerCashAllFlag = bool;
        $scope.$parent.$parent.mainSwitch.headerPriceListAllFlag = !bool;
        $scope.$parent.$parent.mainSwitch.headerLoginFlag = !bool;
        $scope.$parent.$parent.mainSwitch.headerCashFlag.leftFlag = bool;
        $scope.$parent.$parent.mainSwitch.headerCashFlag.middleFlag = bool;
        $scope.$parent.$parent.mainSwitch.headerCashFlag.rightFlag = bool;
    }
    /*打开收银头部/档案头部/我的头部*/
    $scope.flagFn(true)
    $scope.car = 1;
    $scope.$parent.$parent.leftTipFn = function() {
        $state.go('pad-web.consumptionList');
    }
    $scope.goHousekeeper = function() {
        $state.go('pad-web.left_nav.housekeeper')
    }
    $scope.goOrderListm = function() {
        $state.go('pad-web.left_nav.orderList')
    }
    $scope.checkBoxChek = function(e) {
        $(e.target).children('.checkBox').css('background', '#FF6666')
    }
    $scope.goSelectRechargeType = function() {
        $state.go('pad-web.left_nav.selectRechargeType');
    }
    GetShopUserRecentlyOrderInfo.get({ sysUserId: '110' }, function(data) {
        $scope.projectGroupRelRelationDTOS = data.responseData.projectGroupRelRelationDTOS;
        $scope.shopUserProductRelationDTOS = data.responseData.shopUserProductRelationDTOS;
        $scope.shopUserProjectRelationDTOS = data.responseData.shopUserProjectRelationDTOS;
    })
});