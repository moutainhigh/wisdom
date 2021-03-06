PADWeb.controller("mallCtrl", function($scope, $rootScope,$state, $stateParams) {
    console.log("top")

    /*------------------------------------初始化参数-----------------------------------------------*/
    $scope.param = {
        top_bottomSelect:"yuyue",
        tabSty:'day',
        headerCash:{
            leftContent:"档案()",
            leftAddContent:"添加档案",
            backContent:"账户明细",
            title:"详情",
            leftTip:"保存"
        },
        headerPrice:{
            backContent:"",
            title:"项目",
            blackBackContent:"",
            blackTitle:"产品",
            saveContent:"确认"
        }
    }
    //加载中浮层
    $rootScope.loadingFlag = false;
    //虚拟商品类型
    $rootScope.goodsType = {
        product : '4',
        periodCard :'1',
        rechargeCard :'2',
        timeCard :'0',
        groupCard:'3',
        project:'8'
    }
    //虚拟商品类型
    $rootScope.rootScopeGoodsType = {
        product : '4',
        periodCard :'1',
        rechargeCard :'2',
        timeCard :'0',
        groupCard:'3',
        project:'8'
    }
    $rootScope.currentTime = (new Date()).valueOf();
    //支付方式
    $rootScope.rootScopePayType = {
        weChatPay : "0",
        aliPay :'1',
        bankPay :"2",
        cashPay:'3',
        all:"4"//包括所有支付方式
    }

    //公共部分开关管理
    $scope.mainSwitch = {
        //头部总开关
        headerBoxFlag:true,
        //预约头部开关
        headerReservationAllFlag:false,
        headerReservationFlag:{
            headerReservationLeftFlag:true,
            headerReservationMiddleFlag:true,
            headerReservationRightFlag:true,
        },
        //收银头部开关
        headerCashAllFlag:true,
        headerCashFlag:{
            headerCashLeftFlag:true,
            headerCashRightFlag:{
                leftFlag:true,
                middleFlag:true,
                rightFlag:true,
                leftBackFlag:true
            },
        },

        //考勤头部开关

        //价目表头部开关
        headerPriceListAllFlag:false,
        headerPriceListBlackFlag:true,
        headerPriceListFlag:{
            headerPriceSearchFlag:false,
        },
        //我的头部开关

        //登录头部开关
        headerLoginFlag:false,

        //尾部总开关
        footerBoxFlag:true
    };
    /*--------------------------------------方法-------------------------------------------------*/
    $scope.goAddrecord = function () {
        $state.go("pad-web.left_nav.addRecord")
    }

    $scope.switchType = function (type) {
        $scope.param.tabSty = type
    }
    $scope.selectSty = function (type) {
        $scope.param.top_bottomSelect = type
        if(type == "yuyue"){
            $state.go("pad-web.dayAppointment")
        }else if(type == "shouyin"){
            $state.go("pad-web.left_nav.blankPage")
        }else if(type == "kaoqin"){
            $state.go("pad-web.attendance")
        }else if(type =="jiamubiao"){
            $state.go("pad-web.left_nav.project")
        }else if(type =="wo"){
            $state.go("pad-web.userInfo.todayPerformance")
        }
    }

    $scope.backHeaderCashFn = function () {
        if($scope.param.headerCash.leftAddContent == "添加档案"){
            // $state.go("pad-web.left_nav.addRecord")
        }else {
            window.history.back()
        }

    }
})
