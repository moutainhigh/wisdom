PADWeb.controller('todayPerformanceCtrl', function($scope,$state,$stateParams, ngDialog) {
    /*-------------------------------------------定义头部信息----------------------------------------------*/
    $scope.$parent.param.headerCash.backContent=""
    $scope.$parent.param.headerCash.title=""
    $scope.$parent.param.headerCash.leftTip=""
    $scope.$parent.mainSwitch.headerCashFlag.headerCashRightFlag.leftFlag = false
    $scope.$parent.mainSwitch.headerCashFlag.headerCashRightFlag.middleFlag = false
    $scope.$parent.mainSwitch.headerCashFlag.headerCashRightFlag.rightFlag = false


    /*-------------------------------------------方法----------------------------------------------*/
    $scope.goRecord = function (content) {
        $state.go("pad-web.userInfo."+content)
    }
});