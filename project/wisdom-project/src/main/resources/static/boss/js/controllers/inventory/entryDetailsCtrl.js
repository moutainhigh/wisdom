angular.module('controllers',[]).controller('entryDetailsCtrl',
    ['$scope','$rootScope','$stateParams','$state','$ionicLoading','ShopStockRecordDetail',
        function ($scope,$rootScope,$stateParams,$state,$ionicLoading,ShopStockRecordDetail) {
            $rootScope.title = "入库单详情";

            $scope.param = {
                shopEntryDetails:{}
            }

            $scope.modifyLibraryGo=function(){
                $state.go('modifyLibrary')
            }

            console.log($stateParams.entryId);

            ShopStockRecordDetail.get({id:$stateParams.entryId},function (data) {
                $scope.param.shopEntryDetails = data.responseData;
                console.log($scope.param.shopEntryDetails);
            })
}])