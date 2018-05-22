angular.module('controllers',[]).controller('archivesCtrl',
    ['$scope','$rootScope','$stateParams','$state','$ionicLoading','Detail',"Global",
        function ($scope,$rootScope,$stateParams,$state,$ionicLoading,Detail,Global) {
            $rootScope.title = "档案";

            Detail.get({
               id:$stateParams.id
            },function(data){
                if(data.result==Global.SUCCESS&&data.responseData!=null){
                    $scope.archives = data.responseData
                }
            });
            /*点击账户记录跳转到账户详情*/
             $scope.accountRecordsGo=function () {
                 $state.go("accountRecords")
             };
             /*点击产品跳转到产品详情*/
            $scope.goProduct=function () {
                $state.go("product")
            };
            /*点击疗程卡跳转到来疗程卡页面*/
            $scope.treatmentCardGo=function () {
                $state.go("treatmentCard")
            };
            /*点击套卡跳转到套卡页面*/
            $scope.collectionCardGo=function () {
                $state.go("collectionCard")
            };
            /*点击头像跳转到编辑档案页面*/
            $scope.newUserGo=function () {
                $state.go("newUser")
            };
            /*点击总金额跳转到相对应的页面*/
            $scope.refillCardGo=function () {
                $state.go("refillCard")
            };
            /*点击总欠款跳转到相应的页面*/
            $scope.balanceRecordGo=function () {
                $state.go("balanceRecord")
            };

        }]);
