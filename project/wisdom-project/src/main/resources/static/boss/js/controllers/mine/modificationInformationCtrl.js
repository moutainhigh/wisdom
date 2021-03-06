/**
 * Created by Administrator on 2018/5/5.
 */
angular.module('controllers',[]).controller('modificationInformationCtrl',
    ['$scope','$rootScope','$stateParams','$state','GetCurrentLoginUserInfo','UpdateBossInfo','ImageBase64UploadToOSS','Global','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,GetCurrentLoginUserInfo,UpdateBossInfo,ImageBase64UploadToOSS,Global,$ionicLoading) {

            $rootScope.title = "修改资料";
            $scope.userInfo={
                sex:"女"
            };

            /*点击女*/
            $scope.female=function () {
                $scope.userInfo.sex = '女'
            };
            /*点击男*/
            $scope.male=function () {
                $scope.userInfo.sex = '男'
            };

            $scope.getInfo = function () {
                $ionicLoading.show({
                    content: 'Loading',
                    animation: 'fade-in',
                    showBackdrop: true,
                    maxWidth: 200,
                    showDelay: 0
                });
                GetCurrentLoginUserInfo.get(function (data) {
                    $ionicLoading.hide();
                    $scope.userInfo=data.responseData;
                });
            }
            $scope.getInfo()




            /*上传图片*/
            $scope.reader = new FileReader();   //创建一个FileReader接口
            $scope.thumb = "";      //用于存放图片的base64
            $scope.img_upload = function(files) {
                var file = files[0];
                if(window.FileReader) {
                    var fr = new FileReader();
                    fr.onloadend = function(e) {
                        $scope.thumb = e.target.result
                        ImageBase64UploadToOSS.save($scope.thumb,function (data) {
                            if(data.result==Global.SUCCESS&&data.responseData!=null){
                                $scope.userInfo.photo=data.responseData
                            }

                        })
                    };
                    fr.readAsDataURL(file);

                }else {
                    alert("浏览器不支持")
                }


            };
            /*修改我的信息*/
            $scope.Preservation=function () {
                /*查询到的所有内容全部保存到修改的接口*/
                UpdateBossInfo.save( $scope.userInfo,function (data) {
                    /*这里面点击保存的时候用户不修改也可以保存，所以不需要判断修改的数据是否为空：（依据美业邦）*/
                    if(data.result=="0x00001"){
                       $state.go("myself")
                    }
                })
            }
        }]);