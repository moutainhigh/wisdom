PADWeb.controller('modificationDataCtrl', function($scope, $stateParams,ClerkInfo,UpdateClerkInfo,ImageBase64UploadToOSS,GetCurrentLoginUserInfo) {
    /*-------------------------------------------定义头部信息----------------------------------------------*/
    $scope.$parent.$parent.param.headerCash.title="修改资料"
    $scope.$parent.$parent.param.headerCash.backContent="取消"
    $scope.$parent.$parent.param.headerCash.leftTip="保存"
    $scope.$parent.$parent.mainSwitch.headerCashFlag.headerCashRightFlag.leftBackFlag = false
    $scope.$parent.$parent.mainSwitch.headerCashFlag.headerCashRightFlag.leftFlag = false
    $scope.$parent.$parent.mainSwitch.headerCashFlag.headerCashRightFlag.rightBackFlag = true
    $scope.$parent.$parent.mainSwitch.headerCashFlag.headerCashRightFlag.rightFlag = true
    console.log("修改资料");

    $scope.param = {
        openSexFlag:false
    };

    /*个人信息*/
    $scope.getUserInfo = function () {
        GetCurrentLoginUserInfo.get(function (data) {
            if(data.result="0x00001"){
                ClerkInfo.query({
                    clerkId: data.responseData.id
                }, function(data) {
                    $scope.userInfoDataMod = data[0];
                    $scope.param.imgSrc = data[0].photo;
                })
            }
        })

    }
    $scope.getUserInfo()
    /*---------------------------------------------方法--------------------------------------------------*/
    $scope.selectSex = function (sexType) {
        $scope.$parent.$parent.mainSwitch.headerCashFlag.headerCashRightFlag.rightFlag = false
        $scope.param.openSexFlag = true
    };
    
    $scope.selectFn = function (sexType) {
        $scope.$parent.$parent.mainSwitch.headerCashFlag.headerCashRightFlag.rightFlag = true
        $scope.userInfoDataMod.sex = sexType
        $scope.param.openSexFlag = false
    }

    /*上传图片*/
    /*上传图片*/
    $scope.reader = new FileReader();   //创建一个FileReader接口
    $scope.thumb = "";      //用于存放图片的base64
    $scope.img_upload = function(files) {
        var file = files[0];
        if (window.FileReader) {
            var fr = new FileReader();
            fr.onloadend = function (e) {
                console.log(e)
                $scope.thumb = e.target.result
            };
            fr.readAsDataURL(file);
        } else {
            alert("浏览器不支持")
        }
        debugger
        console.log($scope.thumb)
        ImageBase64UploadToOSS.save($scope.thumb, function (data) {
            $scope.param.imgSrc = data.responseData//图片地址
        })
    }

    $scope.$parent.$parent.leftTipFn = function () {
        UpdateClerkInfo.save({
            id:$scope.userInfoDataMod.id,
            sysUserId:$scope.userInfoDataMod.sysUserId,
            sex:$scope.userInfoDataMod.sex,
            photo:$scope.param.imgSrc,
            name:$scope.userInfoDataMod.name,
            role:$scope.userInfoDataMod.role,
            address:$scope.userInfoDataMod.address,
            workinglife:$scope.userInfoDataMod.workinglife,
            speciality:$scope.userInfoDataMod.speciality,
            dream:$scope.userInfoDataMod.dream,
            wechat:$scope.userInfoDataMod.wechat,
            qq:$scope.userInfoDataMod.qq
        },function (data) {
            if(data.result == "0x00001"){
                alert("保存成功")
                // window.location.href = "/reception#/pad-web/userInfo/todayPerformance"
                window.location.reload();
            }
        })
    }
});