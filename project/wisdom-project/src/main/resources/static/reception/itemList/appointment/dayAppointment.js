PADWeb.controller("dayAppointmentCtrl", function ($scope, $state
    , $stateParams, $filter, ngDialog, $http, $timeout, ShopDayAppointmentInfoByDate, GetUserCardProjectList
    , GetAppointmentInfoById, GetUserProjectGroupList, GetUserProductList, GetUserCourseProjectList
    , SearchShopProjectList, SearchShopProductList, GetShopProjectGroups
    , GetRechargeCardList, ThreeLevelProject, productInfoThreeLevelProject
    , GetUserShopProjectList, ConsumeCourseCard, GetShopClerkList, UpdateAppointmentInfoById
    , FindArchives, GetShopProjectList, ShopWeekAppointmentInfoByDate, GetShopClerkScheduleList
    ,SaveUserAppointInfo,GetClerkScheduleInfo,UpdateUserAppointInfo,SaveArchiveInfo) {
    $scope.$parent.param.top_bottomSelect = "yuyue";
    $scope.date = $filter("date")(Date.parse(new Date()), "yyyy-MM-dd");
    //切换时间更新数据
    laydate.render({
        elem: '#test1',
        done: function(value, date){
            $scope.param.nowTime = value
            if($scope.param.dayWeekFlag){
                $scope.dayAll()
            }else {
                $scope.weekAll()
            }
        }
    });


    /*
     * NOT_STARTED("0", "未开始"),粉色
     CONFIRM("1", "已确认"), 粉色
     ON_SERVICE("2", "服务中"), 蓝色
     OVER("3", "已完成"), 灰色
     CANCEL("4", "取消预约"),灰色
     ONGOING("5", "进行中"), 蓝色
     ENDED("6", "已结束"); 灰色
     * */
    var startIndex
    var endIndex
    $scope.param = {
        //新建预约修改预约查询对应每个美容师可用时间
        mrLeisureTime:"",
        nowTime:new Date().getFullYear()+"-"+(parseInt(new Date().getMonth()+1)<10?"0"+parseInt(new Date().getMonth()+1):parseInt(new Date().getMonth()+1))+"-"+(parseInt(new Date().getDate())<10?"0"+parseInt(new Date().getDate()):parseInt(new Date().getDate())),
        endTime:"",
        newChangeContent:"修改预约",
        changeYuyueFlag: "",
        zhongjiList: {},
        hahaList: [],
        tswTimeAll: [],
        timeLocation: [],
        week: [],
        btnActive: ['btnActive', 'common'],
        code: [
            {"0": "00:00"},
            {"1": "00:30"},
            {"2": "01:00"},
            {"3": "01:30"},
            {"4": "02:00"},
            {"5": "02:30"},
            {"6": "03:00"},
            {"7": "03:30"},
            {"8": "04:00"},
            {"9": "04:30"},
            {"10": "05:00"},
            {"11": "05:30"},
            {"12": "06:00"},
            {"13": "06:30"},
            {"14": "07:00"},
            {"15": "07:30"},
            {"16": "08:00"},
            {"17": "08:30"},
            {"18": "09:00"},
            {"19": "09:30"},
            {"20": "10:00"},
            {"21": "10:30"},
            {"22": "11:00"},
            {"23": "11:30"},
            {"24": "12:00"},
            {"25": "12:30"},
            {"26": "13:00"},
            {"27": "13:30"},
            {"28": "14:00"},
            {"29": "14:30"},
            {"30": "15:00"},
            {"31": "15:30"},
            {"32": "16:00"},
            {"33": "16:30"},
            {"34": "17:00"},
            {"35": "17:30"},
            {"36": "18:00"},
            {"37": "18:30"},
            {"38": "19:00"},
            {"39": "19:30"},
            {"40": "20:00"},
            {"41": "20:30"},
            {"42": "21:00"},
            {"43": "21:30"},
            {"44": "22:00"},
            {"45": "22:30"},
            {"46": "23:00"},
            {"47": "23:30"}
        ],
        theOtherCode: {
            "00:00": "0",
            "00:30": "1",
            "01:00": "2",
            "01:30": "3",
            "02:00": "4",
            "02:30": "5",
            "03:00": "6",
            "03:30": "7",
            "04:00": "8",
            "04:30": "9",
            "05:00": "10",
            "05:30": "11",
            "06:00": "12",
            "06:30": "13",
            "07:00": "14",
            "07:30": "15",
            "08:00": "16",
            "08:30": "17",
            "09:00": "18",
            "09:30": "19",
            "10:00": "20",
            "10:30": "21",
            "11:00": "22",
            "11:30": "23",
            "12:00": "24",
            "12:30": "25",
            "13:00": "26",
            "13:30": "27",
            "14:00": "28",
            "14:30": "29",
            "15:00": "30",
            "15:30": "31",
            "16:00": "32",
            "16:30": "33",
            "17:00": "34",
            "17:30": "35",
            "18:00": "36",
            "18:30": "37",
            "19:00": "38",
            "19:30": "39",
            "20:00": "40",
            "20:30": "41",
            "21:00": "42",
            "21:30": "43",
            "22:00": "44",
            "22:30": "45",
            "23:00": "46",
            "23:30": "47",
        },
        bgBlack: false,
        serachContent: '',
        /*搜索内容*/
        givingIndex: 0,
        /*赠送Index*/
        dayWeekFlag: true,
        ModifyAppointment: true,
        /*修预约改*/
        ModifyAppointmentObject: {
            /*修预约改对象*/
            hoursTime: [],
            hoursType: [],
            hoursTimeShow: "",

        },
        cancellationFlag: true,
        /*取消预约按钮的显示隐藏*/
        newProductObject: {
            /*新建预约 - 选择项目*/
            index: 0,
            titleFlag: false,
            content: true,
            filterStr: "",
            /*搜索文本*/
            newProjectData: "",
            selfProductData: "",
            shopProjectId: "",
            shopProjectName: "",
        },
        scratchCardObj: {
            scratchCardData: {},
            note: ""
        },
        ModifyAppointmentObject: {
            /*新建预约*/
            appointPeriod: '1',
            /*时长*/
            beauticianName: "",
            type: "",
            newProjectDataFlag: [],
            /*疗程卡的选中显示*/
            selfProductDataFlag: [],
            /*本店项目的选中显示*/
            productData: [],
            productNum: '0',
            /*项目个数*/
            customerIndex: "-1",
            appointStartTime: "",
            /*预约开始时间*/
            appointEndTime: "",
            /*预约结束时间*/
            detail: "",
            /*备注*/
            status: "0",
            ModifyAppointmentData: ""
        },
        selectCustomersObject: {
            /*选择顾客*/
            data: "",
            sysUserId: "",
            /*客户id*/
            sysUserName: "",
            /*客户名*/
            sysUserPhone: "",
            /*客户手机*/
            queryField: "" /*查询条件，可为空*/
        },
        appointmentNew: "",
        appointmentObject: {
            /*日预约对象*/
            appointmentDate: '',
            beautician: [],
            /*美容师*/
            appointmentInfo: [],
            /*美容师下的预约列表*/
            point: [],
            /*点*/
            list: [],
            /*数据处理后 -- */
        },
        addCustomersObject: {
            /*添加顾客对象*/
            sex: "女",
            picSrc: "",
            userName: "",
            userPhone: ""
        },
        week: {
            weekData: '' /*周预约数据*/
        },
        index: {
            index1: "",
            index2: ""
        },
        details: "",
        /**/
        consumptionObj: {
            sysUserId: "",
            sysShopId: "",
            singleByshopId: {
                detailProject: "",
                /*三级*/

            },
            /*某个店的单次 疗程卡 产品  数据*/
            /*  singleMessByshopId:{},/!*某个店的单次 疗程卡 产品  的三级 数据*!/*/
            collectionCardByShowId: "",
            /*某个店的套卡数据*/
            singleByUserId: "",
            /*某个用户的单次数据*/
            singleFilterStr: "",
            /*项目名称模糊过滤*/
            treatmentCardByUserId: "",
            /*某个用户的疗程数据*/
            productByUserId: "",
            /*某个用户的产品数据*/
            collectionCardByUserId: "",
            /*某个用户的套卡数据*/
            singleByUserIdFlag: true,
            treatmentCardByUserIdFlag: true,
            productByUserIdFlag: true,
            collectionCardByUserIdFlag: true,
            consumptionType: "",
            balancePrepaidCtrlData: "" /*充值卡数据*/

        },
        individualTravelerAppointmentObj: {
            /*日预约详情 （包含预约卡项）*/
            individualTravelerAppointment: "",
            scratchCardFlag: true,
            /*划卡按钮*/
            consumptionFlag: true /*消费按钮*/
        },
        selectBeautician: false,
        /*修改预约-选择美容师*/
        relatedAtaffData: "",
        /*关联员工数据*/
        num: 1,
        day: [],
        /*用于寻找预约颜色的其中一个数据*/
        day: [],
        /*侧边时间循环*/
    };



    $scope.scheduling = true;
    $scope.param.ModifyAppointmentObject.hoursTimeShow = ["00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30"]
    /*获取日预约列表*/
    $scope.dayAll = function () {
        ShopDayAppointmentInfoByDate.get({
            startDate: $scope.param.nowTime,
        }, function (data) {
            $scope.memeda = data.responseData;
            $scope.startTime = data.responseData.startTime;
            $scope.endTime = data.responseData.endTime;
            $scope.meirongshiList = []
            $scope.tswTimeList = []
            $scope.param.code //所有时间点对应的是否选中状态值
            for (var i = 0; i < $scope.param.code.length; i++) {
                for (timeItem in $scope.param.code[i]) {
                    $scope.param.tswTimeAll.push($scope.param.code[i][timeItem])
                }
            }
            for (var i = 0; i < $scope.param.tswTimeAll.length; i++) {
                if ($scope.param.tswTimeAll[i] == $scope.startTime) {
                    $scope.param.timeLocation[0] = i
                }
                if ($scope.param.tswTimeAll[i] == $scope.endTime) {
                    $scope.param.timeLocation[1] = i
                }
            }
            $scope.tswTimeList = $scope.param.tswTimeAll.slice($scope.param.timeLocation[0], $scope.param.timeLocation[1] + 1)
            console.log($scope.tswTimeList); //拿到需要的所有的时间节点
            //计算每一行有多少个美容师
            delete $scope.memeda.startTime //删除对象中的开始结束时间
            delete $scope.memeda.endTime
            for (key in $scope.memeda) {
                $scope.meirongshiList[$scope.memeda[key].sysClerkDTO.name] = {
                    appointmentInfo: $scope.memeda[key].appointmentInfo
                }
                $scope.meirongshiList.length++
            }


            for (var d = 0; d < $scope.tswTimeList.length; d++) { //所有需要的时间节点
                $scope.param.zhongjiList[$scope.tswTimeList[d]] = {};
                for (mrname in $scope.meirongshiList) {
                    $scope.param.zhongjiList[$scope.tswTimeList[d]][mrname] = $scope.meirongshiList[mrname]
                }
            }
            console.log($scope.param.zhongjiList);
            var cloneObj = function (obj) {
                var newObj = {};
                if (obj instanceof Array) {
                    newObj = [];
                }
                for (var key in obj) {
                    var val = obj[key];
                    //newObj[key] = typeof val === 'object' ? arguments.callee(val) : val; //arguments.callee 在哪一个函数中运行，它就代表哪个函数, 一般用在匿名函数中。
                    newObj[key] = typeof val === 'object' ? cloneObj(val) : val;
                }
                return newObj;
            };
            $scope.tempZhongjiList = ""
            $scope.tempZhongjiList = cloneObj($scope.param.zhongjiList)

            //拿到对应时间下的所有美容师
            for (timeItem in $scope.param.zhongjiList) {

                for (var e = 0; e < $scope.param.code.length; e++) {
                    for (codekey in $scope.param.code[e]) {
                        if (timeItem == $scope.param.code[e][codekey]) {
                            //具体时间相等 可以拿到code 因为下面的appinfo有对应的code
                            $scope.param.zhongjiList[timeItem].timeCode = codekey
                        }
                    }
                }
                //拿到美容师对应的属性
                for (mrname in $scope.tempZhongjiList[timeItem]) {
                    //循环对应的appointmentInfo数组
                    for (var i = 0; i < $scope.tempZhongjiList[timeItem][mrname].appointmentInfo.length; i++) {
                        $scope.tempZhongjiList[timeItem][mrname].appointmentInfo[i].scheduling.split(",")
                        for (var q = 0; q < $scope.tempZhongjiList[timeItem][mrname].appointmentInfo[i].scheduling.split(",").length; q++) {
                            if ($scope.param.zhongjiList[timeItem]['timeCode'] == $scope.tempZhongjiList[timeItem][mrname].appointmentInfo[i].scheduling.split(",")[q]) {
                                $scope.param.zhongjiList[timeItem][mrname].statusList = {
                                    status: $scope.tempZhongjiList[timeItem][mrname].appointmentInfo[i].status,
                                    flag: "1", //flag 1选中 其他未选中
                                    sysUserName: $scope.tempZhongjiList[timeItem][mrname].appointmentInfo[i].sysUserName,
                                    shopProjectName: $scope.tempZhongjiList[timeItem][mrname].appointmentInfo[i].shopProjectName,
                                    sysShopId: $scope.tempZhongjiList[timeItem][mrname].appointmentInfo[i].sysShopId,
                                    sysUserId: $scope.tempZhongjiList[timeItem][mrname].appointmentInfo[i].sysUserId,
                                }
                            }

                        }
                    }
                }
            }
        });

    }
    //调用固定表头类
    var tiemInt = setInterval(function () {
        if ($("#tbTest1 thead tr td").length > 1) {
            var ofix1 = new oFixedTable('ofix1', document.getElementById('tbTest1'), {rows: 1, cols: 1});
            clearTimeout(tiemInt)
        }
    }, 100)
    /*获取周预约列表*/
    $scope.weekAll = function () {
        ShopWeekAppointmentInfoByDate.get({
            startDate: $scope.param.nowTime,
        }, function (data) {
            $scope.param.week.weekData = data.responseData;
            $scope.navLeftWeekTime = "";
            var arrWeek = [];
            for (var key in $scope.param.week.weekData) {
                arrWeek.push($scope.param.week.weekData[key]);
            }
            $scope.navLeftWeekTime = arrWeek[0];
            //拿到一周时间节点
            $scope.tempMr = []
            for(timeKey in data.responseData){
                $scope.tempMr.push(timeKey)
            }
            $scope.leftTimeList = data.responseData[$scope.tempMr[0]]
            var weekTime = setInterval(function () {
                if($(".infoitem_sty").length != 0){
                    $(".week_right_box").width($(".infoitem_sty").width()*$(".infoitem_sty").length)
                    clearInterval(weekTime)
                }
            },100)
        })
    };

    //切换日周预约
    $scope.appointmentChange = function(type) {
     if (type == "week") {
        $scope.weekAll()
        // $scope.arrTime = $scope.param.week;
        $scope.param.btnActive[0] = 'common';
        $scope.param.btnActive[1] = 'btnActive';
        $scope.param.dayWeekFlag = false;
     } else {
         $scope.param.dayWeekFlag = true;
        $scope.param.appointmentObject.appointmentDate = [];
        $scope.param.appointmentObject.beautician = [];
        $scope.param.appointmentObject.point = [];
        $scope.param.appointmentObject.list = [];
        $scope.param.days = [];
        $scope.dayAll()
        // $scope.arrTime = $scope.param.day;
        $scope.param.btnActive[0] = 'btnActive';
        $scope.param.btnActive[1] = 'common';
     }
     };


    $scope.dayAll();
    //银行卡
    $scope.bank = function () {
        $scope.ngDialog = ngDialog;
        ngDialog.open({
            template: 'bank',
            scope: $scope, //这样就可以传递参数
            controller: ['$scope', '$interval', function ($scope, $interval) {
                $scope.close = function () {
                    $scope.closeThisDialog();
                };
            }],
            className: 'payType ngdialog-theme-custom',
            disableAnimation: true,

        });
    };


    /*长按新建*/
    $scope.onHold = function (index1, index2, type) {
        $scope.param.newChangeContent = "新建预约"
        // $scope.param.index.index1 = index1;
        // $scope.param.index.index2 = index2;
        $scope.param.ModifyAppointmentObject.status = "0";
        // $scope.param.appointmentObject.list[index1].status[index2] = 5;
        // $scope.param.appointmentObject.list[index1].sysUserName[index2] = "新建预约";
        $scope.param.ModifyAppointmentObject.ModifyAppointmentData = "";
        $scope.param.ModifyAppointmentObject.appointStartTime = ""
        $scope.param.ModifyAppointmentObject.appointEndTime = ""
        $scope.param.ModifyAppointmentObject.appointPeriod = ""
        $scope.param.ModifyAppointmentObject.detail = ""
        $scope.param.newProductObject.shopProjectId = ""
        $scope.param.selectCustomersObject.sysUserId = ""
        $scope.param.selectCustomersObject.sysUserName = ""
        $scope.param.selectCustomersObject.sysUserPhone = ""
        $scope.param.ModifyAppointmentObject.status = "";
        $scope.param.ModifyAppointmentObject.productNum = "0";
        ngDialog.open({
            template: 'appointmentType',
            scope: $scope, //这样就可以传递参数
            controller: ['$scope', '$interval', function ($scope, $interval) {
                //$scope.param.bgBlack = true;
                $scope.close = function () {
                    $scope.closeThisDialog();
                    // $scope.param.appointmentObject.list[index1].status[index2] = 6;
                    // $scope.param.appointmentObject.list[index1].sysUserName[index2] = null;
                };
            }],
            className: ' ngdialog-theme-default ngdialog-theme-custom',
        })

    };
    /*加载预约详情项目 根据预约主键查询预约项目*/
    $scope.detailsWrap = function (type, sysUserId, sysShopId, id) {
        $scope.appointmentId = id
        if (type == undefined || sysUserId == undefined || sysShopId == undefined || id == undefined) {
            return
        }
        $scope.param.newChangeContent = "修改预约"
        $scope.param.changeYuyueFlag = type//0才可以修改预约
        ngDialog.open({
            template: 'individual',
            scope: $scope, //这样就可以传递参数
            controller: ['$scope', '$interval', function ($scope, $interval) {
                GetUserCardProjectList.get({
                    appointmentId: id
                }, function (data) {
                    $scope.param.individualTravelerAppointmentObj.individualTravelerAppointment = data.responseData;
                    if (data.responseData.consume.length >= 0) {
                        $scope.param.individualTravelerAppointmentObj.consumptionFlag = true
                    } else {
                        $scope.param.individualTravelerAppointmentObj.consumptionFlag = false;
                    }
                    if (data.responseData.punchCard.length >= 0) {
                        $scope.param.individualTravelerAppointmentObj.scratchCardFlag = true
                    } else {
                        $scope.param.individualTravelerAppointmentObj.scratchCardFlag = false;
                    }
                });
                /*预约详情*/
                GetAppointmentInfoById.get({
                    shopAppointServiceId: id
                }, function (data) {
                    $scope.param.week.details = data.responseData;
                });
                $scope.close = function () {
                    $scope.closeThisDialog();

                };


                /*确认预约*/
                $scope.startAppointmentIndivdual = function () {

                    UpdateAppointmentInfoById.get({
                        shopAppointServiceId: id,
                        status: "0"
                    }, function (data) {
                        if (data.result == "0x00001") {
                            $scope.param.changeYuyueFlag = "0"
                            $scope.param.ModifyAppointment = false;
                        }
                    })
                };
                /*开始服务*/
                $scope.startSevier = function () {
                    UpdateAppointmentInfoById.get({
                        shopAppointServiceId: id,
                        status: "1"
                    }, function (data) {
                        if (data.result == "0x00001") {
                            $scope.seriverColor = false;
                            $scope.param.changeYuyueFlag = "1"
                        }
                    })
                };
            }],
            className: 'ngdialog-theme-default',

        });
        detailsReservation && detailsReservation($scope, ngDialog, GetUserProjectGroupList, GetUserProductList, GetUserCourseProjectList, SearchShopProjectList, SearchShopProductList, GetShopProjectGroups, GetRechargeCardList, ThreeLevelProject, productInfoThreeLevelProject, GetUserShopProjectList, GetUserShopProjectList, FindArchives, GetShopProjectList, GetShopProjectList, ShopWeekAppointmentInfoByDate);

    };

    console.log($scope.param.appointmentObject.appointmentInfo);
    console.log($scope.param.appointmentObject.list);




    /*关联员工*/
    $scope.getShopClerkList = function (obj, attribute) {
        $scope.relatedAtaffFlag = [];
        GetShopClerkList.get({
            pageNo: 1,
            pageSize: 100
        }, function (data) {
            $scope.param.relatedAtaffData = data.responseData;
            $scope.obj = obj;
            $scope.attribute = attribute;
            for (var i = 0; i < $scope.param.relatedAtaffData.length; i++) {
                $scope.relatedAtaffFlag[i] = false;
                for (j = 0; j < obj.length; j++) {
                    if (obj[j][attribute] == $scope.param.relatedAtaffData.name) {
                        $scope.relatedAtaffFlag[i] = true;
                    }
                }

            }

            $scope.showOrhideRelateStaff = function (index) {
                for (var i = 0; i < $scope.param.relatedAtaffData.length; i++) {
                    $scope.relatedAtaffFlag[i] = false;
                }
                $scope.relatedAtaffFlag[index] = !$scope.relatedAtaffFlag[index];

            }
            $scope.finsh = function (obj, attribute) {
                for (var i = 0; i < $scope.param.relatedAtaffData.length; i++) {
                    if ($scope.relatedAtaffFlag[i] == true) {
                        console.log(obj[$scope.relatedAtaffIndex]);
                        obj[$scope.relatedAtaffIndex][attribute] = $scope.param.relatedAtaffData[i].name
                    }
                }
                console.log(obj[$scope.relatedAtaffIndex][attribute])
            }

        })
    };



    /*修改预约*/
    $scope.shopAppointServiceDTO = {
        appointStartTime: $scope.param.ModifyAppointmentObject.appointStartTime,
        appointEndTime: $scope.param.ModifyAppointmentObject.appointEndTime,
        appointPeriod: $scope.param.ModifyAppointmentObject.appointPeriod,
        detail: $scope.param.ModifyAppointmentObject.detail,
        shopProjectId: $scope.param.newProductObject.shopProjectId,
        shopProjectName: $scope.param.newProductObject.shopProjectName,
        sysUserId: $scope.param.selectCustomersObject.sysUserId,
        sysUserName: $scope.param.selectCustomersObject.sysUserName,
        sysUserPhone: $scope.param.selectCustomersObject.sysUserPhone,
        status: $scope.param.ModifyAppointmentObject.status
    }
    //点击修改预约
    $scope.modifyingAppointment = function () {
        /*$scope.param.AppointmentType="长客";
         $scope.param.appointmentNew = "no";*/
        $scope.param.cancellationFlag = true;
        ngDialog.open({
            template: 'modifyingAppointment',
            scope: $scope, //这样就可以传递参数
            controller: ['$scope', '$interval', function ($scope, $interval) {
                $scope.param.cancellationFlag = true;
                GetAppointmentInfoById.get({
                    shopAppointServiceId: $scope.appointmentId
                }, function (data) {
                    $scope.param.ModifyAppointmentObject.ModifyAppointmentData = data.responseData;
                    $scope.param.ModifyAppointmentObject.appointStartTime = data.responseData.appointStartTime
                    $scope.param.ModifyAppointmentObject.appointEndTime = data.responseData.appointEndTime
                    $scope.param.ModifyAppointmentObject.appointPeriod = data.responseData.appointPeriod
                    $scope.param.ModifyAppointmentObject.detail = data.responseData.detail.detail
                    $scope.param.newProductObject.shopProjectId = data.responseData.shopProjectId
                    $scope.param.selectCustomersObject.sysUserId = data.responseData.sysUserId
                    $scope.param.selectCustomersObject.sysUserName = data.responseData.sysUserName
                    $scope.param.selectCustomersObject.sysUserPhone = data.responseData.sysUserPhone
                    $scope.param.ModifyAppointmentObject.status = data.responseData.status;

                    $scope.dates={
                        startTime: "00:00",
                        endTime: "23:00",
                        scheduling:"",
                    };
                    for(key in $scope.param.code){
                        $scope.param.codeNum.push(key)
                    }
                    //选择时间
                    /*选择时间*/

                    $scope.dates.scheduling = diff($scope.param.codeNum,$scope.param.mrLeisureTime.split(",")).join(",")

                    for (var i = 0; i < $scope.param.code.length; i++) {
                        $scope.param.ModifyAppointmentObject.hoursType[i] = "0";
                        for (key in $scope.param.code[i]) {
                            for (var k = 0; k < $scope.dates.scheduling.split(",").length; k++) {
                                if ($scope.dates.scheduling.split(",")[k] == key) {
                                    $scope.param.ModifyAppointmentObject.hoursType[i] = "1";
                                }
                            }
                            $scope.param.ModifyAppointmentObject.hoursTime[i] = $scope.param.code[i][key];
                            if ($scope.param.code[i][key] == $scope.dates.startTime) {
                                startIndex = i;
                            }
                            if ($scope.param.code[i][key] == $scope.dates.endTime) {
                                endIndex = i;
                            }
                        }
                    }
                    $scope.param.ModifyAppointmentObject.hoursTimeShow = $scope.param.ModifyAppointmentObject.hoursTime.slice(startIndex, endIndex + 1);
                    $scope.param.selectedTime = $scope.param.ModifyAppointmentObject.hoursType.slice(startIndex, endIndex + 1);
                    console.log(1)


                });

                GetUserCardProjectList.get({
                    appointmentId: $scope.appointmentId
                }, function (data) {
                    $scope.param.individualTravelerAppointmentObj.individualTravelerAppointment = data.responseData;
                    $scope.param.ModifyAppointmentObject.productNum = data.responseData.consume.length + data.responseData.punchCard.length


                });
                $scope.close = function (status) {
                    if(status == 1){//保存预约
                        $scope.importData = {
                            shopProjectId:$scope.param.newProductObject.shopProjectId,
                            sysClerkId:$scope.param.ModifyAppointmentObject.beauticianId,
                            // appointStartTimeS:"2018-04-27 11:00:00",
                            appointStartTimeS:new Date().format("yyyy-MM-dd")+" "+$scope.param.ModifyAppointmentObject.appointStartTime,
                            // appointStartTimeS:new Date().getFullYear()+"-"+parseInt(new Date().getMonth()+1)+"-"+parseInt(new Date().getDate())+" "+$scope.param.ModifyAppointmentObject.appointStartTime,
                            shopProjectName:$scope.param.newProductObject.shopProjectName,
                            appointPeriod:$scope.param.ModifyAppointmentObject.appointPeriod,
                            detail:$scope.param.ModifyAppointmentObject.detail,
                            status:'0'
                        }

                        UpdateUserAppointInfo.save($scope.importData,function (data) {
                            if(data.result == "0x00001"){
                                alert("修改预约成功")
                                ngDialog.closeAll()
                            }else {
                                alert(data.errorInfo)
                            }

                        })
                        if(status == 3){//取消预约
                            UpdateAppointmentInfoById.get({
                                shopAppointServiceId:id,
                                status:0
                            },function(data){
                                if(data.result == "0x00001"){
                                    alert("取消成功")
                                    ngDialog.closeAll()
                                }
                            })
                        }
                        if(status == 0){//取消预约
                            ngDialog.closeAll()
                        }
                        console.log($scope.shopAppointServiceDTO)

                    }
                };
            }],
            className: 'ngdialog-theme-default ngdialog-theme-custom'
        });

    }

    /*选择顾客*/
    $scope.selectCustomersFun = function () {
        FindArchives.get({
            queryField: "",
            pageNo: 1,
            pageSize: 100
        }, function (data) {
            $scope.param.selectCustomersObject.data = data.responseData.info;
        })
        /* {
         queryField:$scope.param.selectCustomersObject.queryField,/!*顾客查询条件，可为空*!/
         pageNo:1,
         pageSize:100
         }*/
        /*选择顾客参数  get*/
    }
    $scope.selectCustomersCtrl = function () {
        ngDialog.open({
            template: 'selectCustomersWrap',
            scope: $scope, //这样就可以传递参数
            controller: ['$scope', '$interval', function ($scope, $interval) {
                $scope.selectCustomersFun();
                $scope.close = function () {
                    if (status == 0) {
                        /*$scope.param.selectCustomersObject.sysUserName = "";
                         $scope.param.selectCustomersObject.sysUserId = "";
                         $scope.param.selectCustomersObject.sysUserPhone = "";*/
                    }
                    $scope.closeThisDialog();
                };
            }],
            className: 'newProject ngdialog-theme-custom'
        });
    };
    $scope.searchCustomer = function () {
        console.log($scope.param.selectCustomersObject.queryField)
        $scope.selectCustomersFun()

    }
    //选择顾客点击
    $scope.selectTheCustomer = function (index, sysUserName, sysUserId, sysUserPhone) {
        $scope.param.ModifyAppointmentObject.customerIndex = index;
        $scope.param.selectCustomersObject.sysUserName = sysUserName;
        $scope.param.selectCustomersObject.sysUserId = sysUserId;
        $scope.param.selectCustomersObject.sysUserPhone = sysUserPhone;
        if ($scope.param.ModifyAppointmentObject.productNum == "0") {
            setTimeout(function () {
                $scope.selectNewProduct();
                ngDialog.close("selectCustomersWrap")
            }, 800)
        }
    }


    /*预约 选择项目*/
    /*疗程卡*/

    $scope.newProjectFun = function (filterStr) {
        /*{useStyle:"0",
         filterStr:$scope.param.newProductObject.filterStr  //参数
         }*/
        GetUserProjectGroupList.get({
            cardStyle: "0",
            sysUserId: $scope.param.selectCustomersObject.sysUserId,
            filterStr:filterStr
        }, function (data) {
            $scope.param.newProductObject.newProjectData = data.responseData;
        })
    };
    /*本店项目*/
    $scope.selfProduct = function (filterStr) {
        GetShopProjectList.get({
            filterStr: filterStr,
            pageNo: "",
            pageSize: ""
        }, function (data) {
            $scope.param.newProductObject.selfProductData = data.responseData;
        });
    }
    $scope.newProductSearch = function () {
        console.log($scope.param.newProductObject.filterStr)
        if($scope.param.newProductObject.content){
            $scope.newProjectFun($scope.param.newProductObject.filterStr)
        }else{
            $scope.selfProduct($scope.param.newProductObject.filterStr)
        }
    }

    /*选择项目*/
    $scope.selectNewProduct = function () {
        if ($scope.param.selectCustomersObject.sysUserName == "") {
            $scope.selectCustomersCtrl()
        } else {
            ngDialog.open({
                template: 'newProduct',
                scope: $scope, //这样就可以传递参数
                controller: ['$scope', '$interval', function ($scope, $interval) {
                    $scope.newProjectFun();
                    $scope.close = function (status) {
                        if (status == 1) {
                            /*$scope.param.newProductObject.shopProjectIdArr = [];
                            /!*Id数组*!/
                            $scope.param.newProductObject.shopProjectNameArr = [];
                            /!*项目名数组*!/
                            var timeLength = 0;
                            /!*项目时长*!/
                            /!* $scope.param.ModifyAppointmentObject.productNum = 0;/!*项目个数*!/!*!/
                            for (var i = 0; i < $scope.param.ModifyAppointmentObject.selfProductDataFlag.length; i++) {
                                if ($scope.param.ModifyAppointmentObject.selfProductDataFlag[i] == true) {
                                    $scope.param.newProductObject.shopProjectIdArr.push($(".selfProductDataIndex").eq(i).attr('shopProjectId'))
                                    $scope.param.newProductObject.shopProjectNameArr.push($(".selfProductDataIndex").eq(i).attr('projectName'));
                                    timeLength += $(".selfProductDataIndex").eq(i).attr('appointPeriod') / 1;
                                    $scope.param.ModifyAppointmentObject.productNum++;
                                }
                            }
                            for (var i = 0; i < $scope.param.newProductObject.newProjectData.length; i++) {
                                if ($scope.param.ModifyAppointmentObject.newProjectDataFlag[i] == true) {
                                    $scope.param.newProductObject.shopProjectIdArr.push($(".newProjectIndex").eq(i).attr('shopProjectId'))
                                    $scope.param.newProductObject.shopProjectNameArr.push($(".newProjectIndex").eq(i).attr('projectName'));
                                    timeLength += $(".newProjectIndex").eq(i).attr('appointPeriod') / 1;
                                    $scope.param.ModifyAppointmentObject.productNum++;

                                }
                            }
                            /!*项目ID*!/
                            $scope.param.newProductObject.shopProjectId = $scope.param.newProductObject.shopProjectIdArr.join(",");
                            /!*项目名称*!/
                            $scope.param.newProductObject.shopProjectName = $scope.param.newProductObject.shopProjectNameArr.join(",");
                            /!*项目时长*!/
                            $scope.param.ModifyAppointmentObject.appointPeriod = timeLength;
                            console.log($scope.param.ModifyAppointmentObject.appointPeriod)*/
                            ngDialog.close("selectCustomersWrap")
                        } else {
                            $scope.param.ModifyAppointmentObject.productNum = "0";
                            $scope.falseAll()
                            $scope.param.newProductObject.shopProjectId = '';
                            $scope.param.newProductObject.shopProjectName = ""
                        }
                        $scope.closeThisDialog();

                    };
                }],
                className: 'newProject ngdialog-theme-custom'
            });
        }


    }
    $scope.param.newProductObject.content = true;
    $scope.newProductBtn = function (index) {
        $scope.param.newProductObject.index = index;
        if (index == 1) {
            $scope.param.newProductObject.titleFlag = true;
            $scope.param.newProductObject.content = false;
            $scope.selfProduct();
        } else {
            $scope.param.newProductObject.titleFlag = false;
            $scope.param.newProductObject.content = true;
            $scope.newProjectFun();
        }
    };
    $scope.falseAll = function () {
        for (var i = 0; i < $scope.param.newProductObject.newProjectData.length; i++) {
            $scope.param.ModifyAppointmentObject.newProjectDataFlag[i] = false;
        }
        for (var i = 0; i < $scope.param.newProductObject.selfProductData.length; i++) {
            for (var key in $scope.param.newProductObject.selfProductData[i]) {
                $scope.param.ModifyAppointmentObject.selfProductDataFlag.push(false);
            }
        }
    }
    $scope.tempRedgArr = []//控制前台样式
    $scope.checkProjectArr = []
    //选择项目包括控制样式
    $scope.selectTheProduct = function (items,parentIndex,index, type) {
        //重构
        $scope.redCorrectFlag = items.id
        if($scope.tempRedgArr.indexOf(items.id) != -1){
            $scope.tempRedgArr.remove(items.id)
        }else {
            $scope.tempRedgArr.push(items.id)
            $scope.checkProjectArr.push(items)
        }
        //计算时长 项目名称 项目id
        $scope.checkprojectId = ""
        $scope.checkprojectName = ""
        $scope.checkprojectDuration = new Number()
        for(var i = 0; i < $scope.checkProjectArr.length; i++){
            $scope.checkprojectId += $scope.checkProjectArr[i].id+";"
            $scope.checkprojectName += $scope.checkProjectArr[i].projectName+";"
            $scope.checkprojectDuration += parseInt($scope.checkProjectArr[i].projectDuration)
        }

        /*if (type == "疗程") {
            $scope.param.ModifyAppointmentObject.newProjectDataFlag[index] = !$scope.param.ModifyAppointmentObject.newProjectDataFlag[index];
        } else {
            $scope.param.ModifyAppointmentObject.selfProductDataFlag[index] = !$scope.param.ModifyAppointmentObject.selfProductDataFlag[index];
        }*/
    }


    /*选择美容师*/
    $scope.selectBeautician = function () {
        // if ($scope.param.selectCustomersObject.sysUserName == "") {
        //     /*$scope.selectCustomersCtrl()*/
        //
        // } else {
            ngDialog.open({
                template: 'selectBeautician',
                scope: $scope, //这样就可以传递参数
                controller: ['$scope', '$interval', function ($scope, $interval) {


                    $scope.param.timeLengthIndex = -1;
                    GetShopClerkList.get({
                        pageNo: 1,
                        pageSize: 100
                    }, function (data) {
                        $scope.param.timeLength = data.responseData;
                    })


                    //选中美容师并返回
                    $scope.selectbeauticianIndex = function(index,beauticianName,beauticianId){
                        $scope.param.beauticianIndex = index;
                        $scope.param.ModifyAppointmentObject.beauticianName =beauticianName;
                        $scope.param.ModifyAppointmentObject.beauticianId =beauticianId;//美容师id


                        /*setTimeout(function(){
                            ngDialog.close("timeLength");
                        },600)*/

                        //拿到美容师id调取时间段是否能选中的接口$scope.param.ModifyAppointmentObject.beauticianId
                        GetClerkScheduleInfo.get({
                            appointmentId:"",
                            clerkId:$scope.param.ModifyAppointmentObject.beauticianId,
                            searchDate:$scope.param.nowTime
                        },function (data) {
                            //拿到可用时间
                            if(data.result == "0x00001"){
                                //空闲时间
                                $scope.param.mrLeisureTime = data.responseData
                                //计算出不可点击时间

                                $scope.param.dayTime=[];
                                $scope.param.curDate=new Date();
                                $scope.bgf5f5f5 = "bgf5f5f5";
                                $scope.param.codeNum = []//所有节点
                                $scope.param.schedulingArr = []//所有节点
                                $scope.dates={
                                    startTime: "00:00",
                                    endTime: "23:00",
                                    scheduling:"",
                                };
                                for(key in $scope.param.code){
                                    $scope.param.codeNum.push(key)
                                }
                                //选择时间
                                /*选择时间*/

                                $scope.dates.scheduling = diff($scope.param.codeNum,$scope.param.mrLeisureTime.split(",")).join(",")


                                /* var a = $filter("date")(Date.parse($scope.param.ModifyAppointmentObject.appointStartTime),"yyyy-MM-dd");
                                 console.log(a);*/
                                $scope.param.ModifyAppointmentObject.hoursType=[];
                                $scope.param.ModifyAppointmentObject.hoursTime=[];
                                for(var i=0;i<$scope.param.code.length;i++){
                                    $scope.param.ModifyAppointmentObject.hoursType[i]="0";
                                    for(key in $scope.param.code[i] ){
                                        for (var k = 0;k <$scope.dates.scheduling.split(",").length; k++) {
                                            if($scope.dates.scheduling.split(",")[k]==key){
                                                $scope.param.ModifyAppointmentObject.hoursType[i]="1";
                                            }
                                        }

                                        $scope.param.ModifyAppointmentObject.hoursTime[i] = $scope.param.code[i][key];
                                        if($scope.param.code[i][key] == $scope.dates.startTime ){
                                            startIndex= i;
                                        }
                                        if($scope.param.code[i][key] == $scope.dates.endTime ){
                                            endIndex= i;
                                        }
                                    }
                                }
                                $scope.param.ModifyAppointmentObject.hoursTimeShow=$scope.param.ModifyAppointmentObject.hoursTime.slice(startIndex,endIndex+1);
                                $scope.param.selectedTime = $scope.param.ModifyAppointmentObject.hoursType.slice(startIndex,endIndex+1);


                                /*默认选择时间段*/
                                /*if($scope.param.ModifyAppointmentObject.appointStartTime ==""){
                                    var time=$scope.param.ModifyAppointmentObject.appointPeriod/1/0.5;
                                    $scope.timeLength = $scope.param.ModifyAppointmentObject.appointPeriod/1/0.5;
                                    var numTime = [];
                                    var timeIntervalArr = [];
                                    for(var i=0;i<$scope.param.selectedTime.length;i++){
                                        if($scope.param.selectedTime[i] !=1){
                                            for(var j=1;j<time;j++){
                                                if($scope.param.selectedTime[i] ==$scope.param.selectedTime[i+j]){
                                                    numTime.push(i)
                                                    for(var j=0;j<time;j++){
                                                        $scope.param.selectedTime[numTime[0]+j] ="2";
                                                        for(var i=0;i<$scope.param.code.length;i++){
                                                            for(key in $scope.param.code[i] ){
                                                                if($scope.param.code[i][key] == $scope.param.ModifyAppointmentObject.hoursTimeShow[numTime[0]+j] ){
                                                                    timeIntervalArr.push($scope.param.code[i][key])
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    $scope.param.ModifyAppointmentObject.appointStartTime=timeIntervalArr[0];
                                    $scope.param.ModifyAppointmentObject.appointEndTime=timeIntervalArr[timeIntervalArr.length-1]
                                }*/
                            }

                        })

                        $scope.closeThisDialog();

                    }

                    $scope.close = function (status) {
                        if (status == 0) {
                            /* $scope.param.ModifyAppointmentObject.beauticianName =""*/
                        }
                        $scope.closeThisDialog();
                    };
                }],
                className: 'selectBeautician ngdialog-theme-custom'
            });
        // }
    }
    /*选择时长*/
    $scope.selectTimeLength = function(){
        //如果没有选择美容师先选择美容师
        if($scope.param.selectCustomersObject.sysUserName == ""){
            alert("请先选择顾客")
            // $scope.selectCustomersCtrl()
        }else if($scope.param.ModifyAppointmentObject.beauticianId == ""){
            alert("请先选择美容师")
        } else{
            ngDialog.open({
                template: 'timeLength',
                scope: $scope, //这样就可以传递参数
                controller: ['$scope', '$interval', function ($scope, $interval) {
                    $scope.param.timeLengthIndex = -1;
                    $scope.param.timeLengthArr = ["1", "1.5", "2", "2.5", "3", "3.5", "4"];

                    $scope.close = function (status) {
                        if(status == 0){
                            $scope.param.ModifyAppointmentObject.time =""
                        }
                        $scope.closeThisDialog();
                    };
                    // 选中时长并返回
                    $scope.selectTimeLengthIndex = function(index,item){
                        $scope.param.timeLengthPic = index;
                        $scope.param.ModifyAppointmentObject.appointPeriod = item;
                        $scope.closeThisDialog();
                    }

                }],
                className: 'timeLength ngdialog-theme-custom'
            });
        }
    };

    //新建.保存.修改.取消.预约
    $scope.newAppointment = function(){
        $scope.param.appointmentNew = "yes";
        ngDialog.open({
            template: 'modifyingAppointment',
            scope: $scope, //这样就可以传递参数
            controller: ['$scope', '$interval', function($scope, $interval) {
                $scope.param.cancellationFlag = false;
                $scope.param.curDate=new Date();
                $scope.param.dayTime=[];
                $scope.bgf5f5f5 = "bgf5f5f5";
                //初始化日期
                for(var i=1;i<=6;i++){
                    nextDate = new Date($scope.param.curDate.getTime() +  24*60*60*1000*i); //后一天
                    $scope.param.dayTime.push(nextDate)
                }

                /*选择时间（天为单位）*/
                $scope.selectDayTime = function(index){
                    $scope.bgff6666 = 'bgff6666';
                    $scope.index = index;
                };
                /*选择时间（半小时为单位）*/

                $scope.selectTime = function(index,NoOrYes){
                   /* var timeIntervalArr = [];
                    $scope.param.selectedTime = $scope.param.ModifyAppointmentObject.hoursType.slice(a,b+1);
                    if($scope.param.ModifyAppointmentObject.appointPeriod/60 == ""){
                        $scope.selectTimeLength()
                    }
                    if(NoOrYes == 1)return;
                    $scope.bgff9b9b = 'bgff9b9b';
                    $scope.index1 = index;
                    var time=$scope.param.ModifyAppointmentObject.appointPeriod/60/1/0.5;
                    for(var i=index;i<time+index;i++){
                        if($scope.param.selectedTime[i] ==1){
                            alert("请重新选择时间");
                            $scope.param.selectedTime = $scope.param.ModifyAppointmentObject.hoursType.slice(a,b+1);
                            return;
                        }else{

                            $scope.param.selectedTime[i] = "2";
                            for(var j=0;j<$scope.param.code.length;j++){
                                for(key in $scope.param.code[j] ){
                                    if($scope.param.code[j][key] == $scope.param.ModifyAppointmentObject.hoursTimeShow[i] ){
                                        timeIntervalArr.push($scope.param.code[j][key])
                                    }
                                }
                            }
                        }
                    }
                    $scope.param.ModifyAppointmentObject.appointStartTime=timeIntervalArr[0];
                    $scope.param.ModifyAppointmentObject.appointEndTime=timeIntervalArr[timeIntervalArr.length-1]*/
                    var timeIntervalArr = [];
                   if(NoOrYes == 1){
                       //0空闲时间 1非空闲时间
                       return
                   }
                    if($scope.param.selectCustomersObject.sysUserName == ""){
                        alert("请先选择顾客")
                        // $scope.selectCustomersCtrl()
                    }else if($scope.param.ModifyAppointmentObject.beauticianId == "" || $scope.param.ModifyAppointmentObject.beauticianId == undefined){
                        alert("请先选择美容师")
                    }else{
                        $scope.param.selectedTime = $scope.param.ModifyAppointmentObject.hoursType.slice(startIndex,endIndex+1);


                        $scope.bgff9b9b = 'bgff9b9b';
                        $scope.index1 = index;
                        var time=$scope.checkprojectDuration/60/1/0.5;
                        for(var i=index;i<time+index;i++){
                            $scope.param.selectedTime[i] = "2";
                            for(var j=0;j<$scope.param.code.length;j++){
                                for(key in $scope.param.code[j] ){
                                    if($scope.param.code[j][key] == $scope.param.ModifyAppointmentObject.hoursTimeShow[i] ){
                                        timeIntervalArr.push($scope.param.code[j][key])
                                        }
                                    }
                                }
                        }

                        $scope.param.ModifyAppointmentObject.appointStartTime=timeIntervalArr[0];
                        $scope.param.ModifyAppointmentObject.appointEndTime=timeIntervalArr[timeIntervalArr.length-1]
                    }
                };

                $scope.close = function(status) {
                    if($scope.param.appointmentNew =="yes"){

                        // $scope.param.appointmentObject.list[$scope.param.index.index1].status[$scope.param.index.index2] = 0;
                        // $scope.param.appointmentObject.list[$scope.param.index.index1].sysUserName[$scope.param.index.index2] = null;
                    }
                    if(status == 1){//保存预约
                        $scope.importData = {
                            shopProjectId:$scope.checkprojectId,
                            sysClerkId:$scope.param.ModifyAppointmentObject.beauticianId,
                            appointStartTimeS:new Date().format("yyyy-MM-dd")+" "+$scope.param.ModifyAppointmentObject.appointStartTime,
                            shopProjectName:$scope.checkprojectName,
                            appointPeriod:$scope.checkprojectDuration,
                            detail:$scope.param.ModifyAppointmentObject.detail,
                            status:'0'
                        }

                        SaveUserAppointInfo.save($scope.importData,function (data) {
                            if(data.result == "0x00001"){
                                alert("预约成功")
                                ngDialog.closeAll()
                            }else {
                                alert(data.errorInfo)
                            }
                            
                        })
                        if(status == 3){//取消预约
                            UpdateAppointmentInfoById.get({
                                shopAppointServiceId:id,
                                status:0
                            },function(data){
                                if(data.result == "0x00001"){
                                    alert("取消成功")
                                    ngDialog.closeAll()
                                }
                            })
                        }
                        if(status == 0){//取消预约
                            ngDialog.closeAll()
                        }
                        console.log($scope.shopAppointServiceDTO)

                    }

                };
            }],
            className: 'modifyingAppointment ngdialog-theme-custom'
        });
    }


    $scope.goArrangeWorkList = function () {
        $state.go("pad-web.arrangeWorkList")
    }

    var pattern = /^1[34578]\d{9}$/;
    /*添加顾客*/
    $scope.addCustomersCtrl = function(){
        ngDialog.open({
            template: 'addCustomers',
            scope: $scope, //这样就可以传递参数
            controller: ['$scope', '$interval', function($scope, $interval) {
                console.log($scope.$parent.content);
                $scope.close = function(type) {
                    if(type==1){
                        console.log($scope.param.addCustomersObject)
                        if($scope.param.addCustomersObject.userPhone == ""){
                            $scope.param.addCustomersObject.userPhone='请填写手机号';
                            return;
                        }
                        if(pattern.test($scope.param.addCustomersObject.userPhone)==false){
                            $scope.param.addCustomersObject.userPhone='请填写正确的手机号';
                            return
                        }
                        $scope.ShopUserArchivesDTO = {
                            age	:$scope.param.selectContentAge,//年龄
                            birthday:"",//生日
                            bloodType:"",//血型
                            channel:'',//渠道
                            constellation:"",//星座
                            detail:'',//备注
                            height:"",//身高
                            imageUrl:$scope.param.addCustomersObject.picSrc,//头像地址
                            phone:$scope.param.addCustomersObject.userPhone,//手机号
                            sex:$scope.param.addCustomersObject.sex,//性别
                            sysClerkId:'',
                            sysClerkName:"",
                            sysShopId:'',
                            sysShopName:'',
                            sysUserName:$scope.param.addCustomersObject.userName,
                        }

                        SaveArchiveInfo.save($scope.ShopUserArchivesDTO,function (data) {
                            if(data.result == "0x00001"){
                                alert("保存成功")
                                $scope.selectCustomersFun()
                            }else if(data.result == "0x00002"){
                                alert(data.responseData)
                            }
                        })
                    }
                    $scope.closeThisDialog();

                };
            }],
            className: 'newProject ngdialog-theme-custom'
        });

    };

    $scope.selectSex = function(sex){
        $scope.param.addCustomersObject.sex=sex
    }






    detailsReservation && detailsReservation($scope, ngDialog, GetUserProjectGroupList, GetUserProductList, GetUserCourseProjectList, SearchShopProjectList, SearchShopProductList, GetShopProjectGroups, GetRechargeCardList, ThreeLevelProject, productInfoThreeLevelProject, GetUserShopProjectList, GetUserShopProjectList, ConsumeCourseCard, GetShopClerkList, FindArchives, GetShopProjectList);
    //预约详情
    individualTravelerAppointment && individualTravelerAppointment($scope, ngDialog, UpdateAppointmentInfoById, FindArchives, GetShopProjectList);
    //周预约
    weeklyReservation && weeklyReservation($scope, ngDialog, FindArchives);
    //选择点客排课
    appointmentTypeCtrl && appointmentTypeCtrl($scope, ngDialog, UpdateAppointmentInfoById, FindArchives);
    /*新建预约*/
    relatedStaffCtrl && relatedStaffCtrl($scope, ngDialog, GetShopClerkList, FindArchives)
});

Date.prototype.format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function diff(arr,arr1){
    var a=[];var b=[];var r;
    for(var i=0;i<arr.length;i++){
        var index=arr1.indexOf(arr[i]);
        if(index!=-1){
            var r=a[i];
            for(var j=index;j<arr1.length;j++){
                if(arr1[j]==arr[i]){
                    arr1.splice(j,1);
                    j=j-1;
                }
            }
            for(var k=i+1;k<arr.length;k++){
                if(arr[k]==arr[i]){
                    arr.splice(k,1);
                    k=k-1;
                }
            }
            arr.splice(i,1);
            i=i-1;
        }
    }
    return arr.concat(arr1);
}
Array.prototype.indexOf = function (val) {
    for (var i = 0; i < this.length; i++) {
        if (this[i] == val) return i;
    }
    return -1;
}
Array.prototype.remove = function (val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
}