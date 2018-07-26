angular.module('controllers',[]).controller('seckillInfoCtrl',
    ['$scope','$rootScope','$stateParams','$state','$ionicPopup',
        '$ionicSlideBoxDelegate','$ionicLoading',"$interval",'$timeout','IsLogin','SeckillInfo',
        function ($scope,$rootScope,$stateParams,$state,$ionicPopup,
                  $ionicSlideBoxDelegate,$ionicLoading,$interval,$timeout,IsLogin,SeckillInfo) {

            $rootScope.title = "秒杀详情";

            $scope.explain=false;// 点击24小时发货显示说明

            $scope.model=false;
           /* $scope.inputModel=false;*//*点击购买数量出现的弹框*/

            $scope.myObj = {
                background:"red",
                padding: "5px 20px",
            };

            $scope.showFlag = function (type) {
                $scope.model = type;
                if(!type){
                    $scope.param.checkFlag=""
                }
            };

            $scope.confirmProductSpec = function(spec) {
                $scope.param.checkFlag = spec
            };

            $scope.concealment=function () {
                $scope.showFlag(false);
                $scope.param.checkFlag = "";
                $scope.param.productNum = 1
            };

            $scope.chooseSpec = function () {
                $scope.model = true
            };

            $scope.viewInstructions=function(){
                $scope.explain= true;
            };

            $scope.know=function(){
                $scope.explain=false;
            };



            $scope.goPay = function(){
                /*根据商品状态来判断商品是否为下架商品*/
                if($scope.param.product.status == "0"){
                    return;
                }

                if($scope.model){

                    if($scope.param.checkFlag=="")
                    {
                        $scope.model=true;
                    }

                        if($scope.param.productNum=="0"){
                            alert("请选择正确的数量");
                            return
                        }
                        /*根据商品数量跟库存的对比，数量大于库存及库存不足，结束这一步*/
                        if($scope.param.productNum>$scope.param.product.productAmount){
                            alert("库存不足~");
                            return;
                        }
                        else
                        {
                            showToast("加载中");


                        }



                }else{
                    $scope.model = true
                }
            };
            $scope.addProductNum = function(){
                $scope.param.productNum=$scope.param.productNum+1;
                if($scope.param.productNum>$scope.param.product.productAmount){
                    $("#Car").css("background","grey");
                    $("#goPay").css("background","grey");
                }
            };

            $scope.minusProductNum = function(){
                if($scope.param.productNum>1){
                    $scope.param.productNum= $scope.param.productNum-1;
                }else{
                    $(".ion-ios-minus-outline").attr('disabled','disabled').addClass("grey");
                }
                if($scope.param.productNum<=$scope.param.product.productAmount){
                    $("#Car").css("background","#fca1a8");
                    $("#goPay").css("background","red");
                }
            };


            var showToast = function (content) {
                $ionicLoading.show({
                    template: content
                });
            };

            var hideToast = function () {
                $timeout(function () {
                    $ionicLoading.hide();
                }, 1000);
            };

            $scope.loginCart = function(){
                IsLogin.save(function(data){
                    if(data.responseData=="failure"){
                        showToast("请先登录账号");
                        hideToast();
                        $state.go("login");
                    }else{
                        $state.go("buyCart");
                    }
                })
            };

            $scope.$on('$ionicView.enter', function(){
                $scope.param = {
                    product:{},
                    productSpec:"",
                    productUnPaidNum : "0",
                    currentIndex:0,
                    totalIndex:0,
                    productNum:1,
                    checkFlag:""
                };
                $ionicLoading.show({
                    content: 'Loading',
                    animation: 'fade-in',
                    showBackdrop: true,
                    maxWidth: 200,
                    showDelay: 0
                });

                SeckillInfo.save({fieldId:$stateParams.id},function (data) {
                    console.log(data)
                })

            })

        }])
