/**
 * Created by Administrator on 2018/5/6.
 */
angular.module('controllers',[]).controller('productBrandCtrl',
    ['$scope','$rootScope','$stateParams','$state','SearchShopProductList',
        function ($scope,$rootScope,$stateParams,$state,SearchShopProductList) {

            $rootScope.title = "产品品牌";

            $scope.addSeriesGo = function(){
                $state.go("addSeries")
            };
            $scope.addBrandOneGo = function(type,id){
                $state.go("productSetting",{type:type,id:id});
            };
            $scope.checkSeries=function () {
                $state.go("addSeries")
            }
            SearchShopProductList.get({filterStr:''},function (date) {
                $scope.productBrand = date.responseData.detailLevel

            })



        }]);