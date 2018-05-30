/**
 * Created by Administrator on 2017/12/15.
 */
angular.module('controllers',[]).controller('expenseCardRecordCtrl',
    ['$scope','$rootScope','$stateParams','$state','GetProjectConsumes','Global',
        function ($scope,$rootScope,$stateParams,$state,GetProjectConsumes,Global) {

            $scope.param = {
                pageSize:5000,
                projectConsumes : []
            }

            GetProjectConsumes.save({consumeType:'0',goodType:'6',
                pageSize:$scope.param.pageSize,shopUserId:$rootScope.shopAppointInfo.shopUserInfo.id},function (data) {
                if(data.result==Global.SUCCESS)
                {
                    $scope.param.projectConsumes = data.responseData;
                }
                console.log(data);
            })

}])