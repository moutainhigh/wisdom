/**
 * Created by Administrator on 2018/5/6.
 */
angular.module('controllers',[]).controller('cardListCtrl',
    ['$scope','$rootScope','$stateParams','$state',
        function ($scope,$rootScope,$stateParams,$state) {

            $rootScope.title = "套卡列表";

        }]);