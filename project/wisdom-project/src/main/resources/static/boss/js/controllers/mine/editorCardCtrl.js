/**
 * Created by Administrator on 2018/5/5.
 */
angular.module('controllers',[]).controller('editorCardCtrl',
    ['$scope','$rootScope','$stateParams','$state','GetShopProjectGroupDetail','Global','$filter','UpdateProjectGroupInfo','ImageBase64UploadToOSS','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,GetShopProjectGroupDetail,Global,$filter,UpdateProjectGroupInfo,ImageBase64UploadToOSS,$ionicLoading) {

            $rootScope.title = "编辑套卡";
            $scope.param = {
                id:$stateParams.id,
                status:true,
                type:""
            }

            $ionicLoading.show({
                content: 'Loading',
                animation: 'fade-in',
                showBackdrop: true,
                maxWidth: 200,
                showDelay: 0
            })
            GetShopProjectGroupDetail.get({id:$stateParams.id
            },function(data){
                if(data.result==Global.SUCCESS&&data.responseData!=null){
                    $ionicLoading.hide();
                    $rootScope.settingAddsome.editorCard = data.responseData;
                    if($rootScope.settingAddsome.editorCard.status =='0'){
                        $scope.param.status = true
                    }else{
                        $scope.param.status = false
                    }

                    $scope.delList = function(index){
                        $rootScope.settingAddsome.editorCard.shopProjectInfoDTOS.splice(index,1)
                        $scope.numMarkerPrice()

                    }
                }
            })

            $scope.expirationDate = function(){
                $rootScope.settingAddsome.editorCard.expirationDate ='0'
            };
            $scope.numLimit=function (style,value) {
                $rootScope.settingAddsome.editorCard[style]=value.replace(/[^0-9.0-9]+/,'')
            };

            /*日期插件*/
            var date = function () {
                var disabledDates = [
                    new Date(1437719836326),
                    new Date(),
                    new Date(2015, 7, 10), //months are 0-based, this is August, 10th!
                    new Date('Wednesday, August 12, 2015'), //Works with any valid Date formats like long format
                    new Date("08-14-2015"), //Short format
                    new Date(1439676000000) //UNIX format
                ];
                //方便的年月日设置方式，正和我意，可以随便改了。
                var weekDaysList = ["日", "一", "二", "三", "四", "五", "六"];
                var monthList = ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"];

                // 日期选择后的回调函数
                var datePickerCallback = function (val) {
                    if (typeof (val) === 'undefined') {
                    } else {
                        var dateValue = $filter('date')(val, 'yyyy-MM-dd') + " 00:00:00";
                        if($scope.param.type == 'effectiveDate'){
                            $rootScope.settingAddsome.editorCard.effectiveDate = $filter('date')(val, 'yyyy-MM-dd')
                        }else{
                            $rootScope.settingAddsome.editorCard.expirationDate = $filter('date')(val, 'yyyy-MM-dd')
                        }

                    }
                };
                //主体对象
                $scope.datepickerObjectEnd = {
                    titleLabel: '选择日期',  //可选
                    todayLabel: '今天',  //可选
                    closeLabel: '关闭',  //可选
                    setLabel: '确定',  //可选
                    setButtonType: 'button-assertive',  //可选
                    todayButtonType: 'button-assertive',  //可选
                    closeButtonType: 'button-assertive',  //可选
                    inputDate: new Date(),  //可选，输入值
                    mondayFirst: true,  //可选,星期一开头
                    disabledDates: disabledDates, //可选
                    weekDaysList: weekDaysList, //可选
                    monthList: monthList, //可选
                    templateType: 'modal', //可选i.e.的模式 modal or popup(兼容模式？)
                    showTodayButton: 'true', //可选
                    modalHeaderColor: 'bar-positive', //可选
                    modalFooterColor: 'bar-positive', //可选
                    from: new Date(2008, 8, 2), //可选
                    to: new Date(2030, 8, 25),  //可选
                    callback: function (val) {  //Mandatory
                        datePickerCallback(val);
                    },
                    dateFormat: 'yyyy-MM-dd', //可选
                    closeOnSelect: true, //可选,设置选择日期后是否要关掉界面。呵呵，原本是false。
                };

            }
            date()
            /*上传图片*/
            $scope.reader = new FileReader();   //创建一个FileReader接口
            $scope.thumb = "";      //用于存放图片的base64
            $scope.img_upload = function(files) {
                if($rootScope.settingAddsome.editorCard.imageList == null){
                    $rootScope.settingAddsome.editorCard.imageList=[]
                }
                if($rootScope.settingAddsome.editorCard.imageList.length>=6){
                    alert("图片上传不能大于6张")
                    return
                }
                var file = files[0];
                if(window.FileReader) {
                    var fr = new FileReader();
                    fr.onloadend = function(e) {
                        $scope.thumb = e.target.result
                        ImageBase64UploadToOSS.save($scope.thumb,function (data) {
                            if(data.result==Global.SUCCESS&&data.responseData!=null){
                                $rootScope.settingAddsome.editorCard.imageList.push(data.responseData)
                            }

                        })
                    };
                    fr.readAsDataURL(file);

                }else {
                    alert("浏览器不支持")
                }


            };
            $scope.delPic = function (index) {
                $rootScope.settingAddsome.editorCard.imageList.splice(index,1)
            };
            $scope.listOfItemsGo = function () {
                $state.go('listOfItems',{id:$scope.param.id,url:'editorCard'})
            }
            $scope.today = function (){
                $rootScope.settingAddsome.editorCard.expirationDate =$filter('date')(new Date(), 'yyyy-MM-dd')
            }
            $scope.type = function (type) {
                $scope.param.type = type
            }
            $scope.numMarkerPrice = function () {
                $rootScope.settingAddsome.editorCard.initialPrice =0
                for(var i=0;i<$rootScope.settingAddsome.editorCard.shopProjectInfoDTOS.length;i++){
                    $rootScope.settingAddsome.editorCard.initialPrice +=$rootScope.settingAddsome.editorCard.shopProjectInfoDTOS[i].oncePrice*$rootScope.settingAddsome.editorCard.shopProjectInfoDTOS[i].serviceTimes
                }
            }
            $scope.save = function (type) {
                if(type == 0){
                    $rootScope.settingAddsome.editorCard.status ='1'

                }else{
                     if($scope.param.status == true){
                         $rootScope.settingAddsome.editorCard.status ='0'
                     }else{
                         $rootScope.settingAddsome.editorCard.status ='1'
                     }
                }
                if($rootScope.settingAddsome.editorCard.projectGroupName =="" || $rootScope.settingAddsome.editorCard.shopProjectInfoDTOS.length<=0|| $rootScope.settingAddsome.editorCard.initialPrice ==''|| $rootScope.settingAddsome.editorCard.marketPrice ==''|| $rootScope.settingAddsome.editorCard.effectiveDate ==''|| $rootScope.settingAddsome.editorCard.expirationDate ==''||$rootScope.settingAddsome.editorCard.initialPrice ==null||$rootScope.settingAddsome.editorCard.marketPrice ==null){
                    alert('信息不完整');
                    return
                }

                var effectiveDate=$rootScope.settingAddsome.editorCard.effectiveDate;
                effectiveDate = effectiveDate.replace(/-/g,"/");//替换字符，变成标准格式
                var expirationDate = $rootScope.settingAddsome.editorCard.expirationDate;
                expirationDate = expirationDate.replace(/-/g,"/");//替换字符，变成标准格式
                var d1 = new Date(Date.parse(effectiveDate));
                var d2 =  new Date(Date.parse(expirationDate));

                if(d1>d2 &&$rootScope.settingAddsome.editorCard.expirationDate!='0'){
                    alert("活动有效期小于生效日期");
                    return
                }
                UpdateProjectGroupInfo.save( $rootScope.settingAddsome.editorCard,function(data){
                    if(data.result==Global.SUCCESS){
                        $state.go('cardList')
                    }else{
                        alert("保存未成功")
                    }

                })
                
            }





        }]);