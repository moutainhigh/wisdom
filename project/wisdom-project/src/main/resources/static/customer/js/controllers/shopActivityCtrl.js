/**
 * Created by Administrator on 2018/3/6.
 */
angular.module('controllers',[]).controller('shopActivityCtrl',
    ['$scope','$rootScope','$stateParams','$state',
        function ($scope,$rootScope,$stateParams,$state) {

            $rootScope.title = "MX99活动";

            $scope.goBuy = function()
            {
                $state.go("offlineProductDetail",{productId:"201803121718100012"});
            }
        }])
