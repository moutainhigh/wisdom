angular.module('controllers',[]).controller('loginCtrl',
    ['$scope','$rootScope','$stateParams','$state','$ionicLoading','GetUserValidateCode','BossUtil','$interval','Global','BossUserLogin',
        function ($scope,$rootScope,$stateParams,$state,$ionicLoading,GetUserValidateCode,BossUtil,$interval,Global,BossUserLogin) {
            $rootScope.title = "登录";

            $rootScope.title = "美享登录";

            $scope.param = {
                userPhone:'',
                validateCode:'',
                validateCodeButtonStatus:true,
                timeCount: 60
            }

            $scope.getValidateCode = function(){

                $scope.param.validateCodeButtonStatus = false;
                $scope.param.timeCount = 60;

                //每隔一秒执行
                var timer= $interval(function(){
                    $scope.param.timeCount--;
                    if($scope.param.timeCount<0){
                        $interval.cancel(timer);
                        $scope.param.validateCodeButtonStatus = true;
                    }
                },1000);

                GetUserValidateCode.get({mobile:$scope.param.userPhone},function(data){
                    if(data.result == Global.FAILURE)
                    {
                        var alertPopup = $ionicPopup.alert({
                            template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.5rem">验证码获取失败</span>',
                            okText:'确定'
                        });
                    }
                })
            }

            $scope.userLogin = function(){

                if($scope.param.validateCode=='')
                {
                    var alertPopup = $ionicPopup.alert({
                        template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.5rem">请输入验证码</span>',
                        okText:'确定'
                    });
                }
                else
                {
                    BossUserLogin.save({userPhone:$scope.param.userPhone,code:$scope.param.validateCode},function(data){
                        console.log(data);
                        if(data.result==Global.FAILURE)
                        {
                            alert(data.errorInfo);
                        }
                        else
                        {
                            if(data.responseData.beautyUserLoginToken!=Global.TOKEN_ERROR)
                            {
                                window.localStorage.removeItem("beautyUserLoginToken");
                                window.localStorage.setItem("beautyUserLoginToken",data.responseData.beautyUserLoginToken);
                            }
                            if(data.responseData.beautyBossLoginToken!=Global.TOKEN_ERROR)
                            {
                                window.localStorage.removeItem("beautyBossLoginToken");
                                window.localStorage.setItem("beautyBossLoginToken",data.responseData.beautyBossLoginToken);
                            }
                            if(data.responseData.beautyClerkLoginToken!=Global.TOKEN_ERROR)
                            {
                                window.localStorage.removeItem("beautyClerkLoginToken");
                                window.localStorage.setItem("beautyClerkLoginToken",data.responseData.beautyClerkLoginToken);
                            }

                            if($stateParams.redirectUrl=='')
                            {
                                window.location.href = "";
                            }
                            else
                            {
                                window.location.href = "#/" + $stateParams.redirectUrl.replace("&","/");
                            }
                        }
                    })
                }
            }

        }]);