angular.module('controllers',[]).controller('accountDetailsCtrl',
    ['$scope','$rootScope','$stateParams','$state','$ionicLoading','GetUserConsumeByFlowId','Global',
        function ($scope,$rootScope,$stateParams,$state,$ionicLoading,GetUserConsumeByFlowId,Global) {
            $rootScope.title = "账户记录";
            GetUserConsumeByFlowId.get({
                flowId:"10b939362aca4680b1634718106cf840" /*$stateParams.id*/
            },function(data){
                if(data.result==Global.SUCCESS&&data.responseData!=null){
                    $scope.accountDetails =data.responseData
                }
            })
        }])