/**
 * Created by Administrator on 2018/7/26.
 */
angular.module('controllers',[]).controller('distributionAreaCtrl',
    ['$scope','$rootScope','$stateParams','$state','GetOfflineProductList','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,GetOfflineProductList,$ionicLoading) {

            $scope.getInfo=function () {
                $ionicLoading.show({
                    content: 'Loading',
                    animation: 'fade-in',
                    showBackdrop: true,
                    maxWidth: 200,
                    showDelay: 0
                });
                $scope.transformation=function () {
                    $scope.param.Horizontal=!$scope.param.Horizontal
                };
                $scope.PageParamDTO ={
                    pageNo:0,
                    pageSize:100,
                    orderBy:$scope.param.orderBy,
                    orderType:$scope.param.orderType,
                    requestData:{
                        productPrefecture:""
                    }
                };
                GetOfflineProductList.save($scope.PageParamDTO,function(data){
                    $ionicLoading.hide();
                    console.log(data);
                    $scope.param.productList=data.responseData;
                });
            };
            $scope.$on('$ionicView.enter', function() {
                $scope.param={
                    Horizontal:true,
                    productList:{},
                    orderBy:"",
                    orderType:""
                };
                $scope.getInfo();
            });
            /*点击商品 进入商品详情页面*/
            $scope.enterDetails=function(item){
                $state.go("offlineProductDetail",{productId:item})
            };
               $scope.flag=true;
            $scope.checkType=function (orderType) {
                $scope.param.orderType=orderType;
                /*点击价格首次点击上升序 再次点击价格降序*/
                if($scope.param.orderType=="price"){
                  if($scope.flag==true){
                      $scope.param.orderBy="asc";
                      $scope.flag=false;
                  }else {
                      $scope.param.orderBy="desc";
                      $scope.flag=true;
                  }
                }
                $scope.getInfo()
            }
        }]);