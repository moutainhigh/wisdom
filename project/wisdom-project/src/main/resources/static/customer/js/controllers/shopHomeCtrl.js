angular.module('controllers',[]).controller('shopHomeCtrl',
    ['$scope','$rootScope','$stateParams','$state','GetHomeBannerList','GetOfflineProductList','$ionicSlideBoxDelegate',
        '$ionicLoading','GetBusinessOrderByProductId','Global','$ionicPopup',
        'LoginGlobal','BusinessUtil','CheckTripleMonthBonus','GetTripleMonthBonus',
        function ($scope,$rootScope,$stateParams,$state,GetHomeBannerList,GetOfflineProductList,$ionicSlideBoxDelegate,
                  $ionicLoading,GetBusinessOrderByProductId,Global,$ionicPopup,
                  LoginGlobal,BusinessUtil,CheckTripleMonthBonus,GetTripleMonthBonus) {
            $rootScope.title = "美享99触屏版";
            $scope.param = {
                bannerList:{},
                productList:{},
                product2List:[[]],
                promoteProduct:true,
                promoteProductId:"201803121718100012",
                redPackerFlagOne:false,
                redPackerFlagTwo:false,
                bonusValue:""
            }
            $scope.$on('$ionicView.enter', function(){
                $ionicLoading.show({
                    content: 'Loading',
                    animation: 'fade-in',
                    showBackdrop: true,
                    maxWidth: 200,
                    showDelay: 0
                });

                GetHomeBannerList.save(function(data){
                    $scope.param.bannerList = data.responseData;
                    $ionicSlideBoxDelegate.update();
                    $ionicSlideBoxDelegate.loop(true);
                });

                GetOfflineProductList.save({pageNo:0,pageSize:100},function(data){
                    $ionicLoading.hide();
                    $scope.param.productList = data.responseData;
                    var partNames = [];
                    angular.forEach($scope.param.productList,function(value1,index1){
                        var same = false;
                        angular.forEach(partNames,function(value2,index){
                            if(value2==parseInt(value1.price)) {
                                same = true;
                            }
                        })
                        if(!same) {
                            partNames.push(parseInt(value1.price))
                        }
                    })
                    partNames.sort(function(a,b){return a-b});
                    var index=0;
                    angular.forEach(partNames,function (value1,index1) {
                        $scope.param.product2List[index] = {
                            name:value1,
                            data:[]
                        };
                        angular.forEach($scope.param.productList,function(value2,index2){
                            if(value1==parseInt(value2.price)) {
                                $scope.param.product2List[index].data.push(value2);
                            }
                        })
                        index++;
                    })
                    console.log( $scope.param.product2List)
                })


                //判断用户是否购买过新人大礼包产品
                GetBusinessOrderByProductId.get({productId:$scope.param.promoteProductId},function(data){
                    if(data.result==Global.SUCCESS)
                    {
                        $scope.param.promoteProduct = true;
                    }
                    else if(data.result==Global.FAILURE)
                    {
                        $scope.param.promoteProduct = false;
                    }
                })

                //判断用户是否是3月的B店店主,如果是，则弹出红包页
                CheckTripleMonthBonus.get(function(data){
                    if(data.result==Global.SUCCESS)
                    {
                        $scope.param.redPackerFlagOne = true;
                        $scope.param.redPackerFlagTwo = false;
                        $scope.param.bonusLeftDay = data.responseData;
                        console.log($scope.param.bonusLeftDay);
                    }
                })
            });

            $scope.clickCarousel=function(item){
                BusinessUtil.twoParameters(LoginGlobal.MX_SC_BADJ,item);
            }

            $scope.enterDetails=function(item2){
                BusinessUtil.twoParameters(LoginGlobal.MX_SC_ADJ,item2);
                if(item2=="201712101718100004")
                {
                    var alertPopup = $ionicPopup.alert({
                        template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.2rem">正在补货中，敬请期待</span>',
                        okText:'确定'
                    });
                    return
                }
                $state.go("offlineProductDetail",{productId:item2})
            }

            $scope.goPromoteProduct = function(item){
                BusinessUtil.twoParameters(LoginGlobal.MX_SC_ADJ,item);
                if($scope.param.promoteProduct)
                {
                    var alertPopup = $ionicPopup.alert({
                        template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.2rem">你已经购买过促销产品，不能再次购买</span>',
                        okText:'确定'
                    });
                }
                else
                {
                    $state.go("offlineProductDetail",{productId:$scope.param.promoteProductId});

                }
            }
            
            $scope.redPackerClose = function () {
                $scope.param.redPackerFlagOne = false;
                $scope.param.redPackerFlagTwo = false
            }

            $scope.redPackerOpen = function () {
                //可以领取
                if($scope.param.redPackerFlagOne)
                {
                    //看看用户能否获取红包
                    GetTripleMonthBonus.get(function(data){

                        if(data.result==Global.SUCCESS)
                        {
                            $scope.param.redPackerFlagTwo = true;
                            $scope.param.bonusValue = data.responseData;
                            console.log($scope.param.bonusValue);
                        }
                        else if(data.result==Global.FAILURE)
                        {
                            $state.go("shopActivity");
                        }

                    });
                }
            }
        }])
