/**
 * Created by 马东 on 2018/1/8.
 */
function initVue(){
    pak = new Vue({
        el:'#move_root',
        data:{
            moves:[],
            page:1,
            pageSize:30,
            pageTotal:0,
            count:0,
            url:'/moves/indexMove'
        },
        mounted:function () {
            this.init()
            this.recordInit()
        },
        methods: {
            init:function () {
                this.$http.post("/moves/indexMove").then(function (res) {
                    var resuest = res.data
                    var code = resuest.code
                    console.log(code)
                    var msg = resuest.msg
                    if(code == "7"){
                        //获取数据失败
                        var $toastContent = $('<span style = "color: red">' + msg + '</span>');
                        Materialize.toast($toastContent, 4000);
                        return;
                    }
                    this.moves = resuest.result
                    this.pageTotal = resuest.result.pages;
                    this.count = resuest.result.total;
                    this.page = resuest.result.pageNum;
                });
            },recordInit:function () {
                var param = {
                    page:this.page,
                    pageSize:this.pageSize
                }
                this.$http.post("/pak/attendance",param,{emulateJSON:true}).then(function (res) {
                    var resuest = res.data
                    var code = resuest.code
                    console.log(code)
                    var msg = resuest.msg
                    if(code == '7'){
                        var $toastContent = $('<span style = "color: red">' + msg + '</span>');
                        Materialize.toast($toastContent, 4000);
                        return;
                    }
                    this.attendances = resuest.result.list
                    this.pageTotal = resuest.result.pages;
                    this.count = resuest.result.total;
                    this.page = resuest.result.pageNum;
                });

            },Trim: function (str, is_global) {
                var result;
                result = str.replace(/(^\s+)|(\s+$)/g, "");
                if (is_global.toLowerCase() == "g") {
                    result = result.replace(/\s/g, "");
                }
                return result;
            },
            connectPak:function () {
                // var address = this.Trim($('#address').val(),"g")
                var terminano = this.Trim($('#terminano').val(),"g")
                // var token = this.Trim($('#token').val(),"g")

                if(terminano == ''){
                    return;
                }

                var param = {
                    terminals_no:terminano,
                    /*address:address,
                     token:token*/
                }

                this.$http.post("/pak/config",param,{emulateJSON: true}).then(function (res) {
                    var resuest = res.data
                    var code = resuest.code
                    console.log(code)
                    var msg = resuest.msg
                    if(code == "7"){
                        //获取数据失败
                        var $toastContent = $('<span style = "color: red">' + msg + '</span>');
                        Materialize.toast($toastContent, 4000);
                        return;
                    }
                    Materialize.toast(msg, 4000, 'rounded');
                    this.paks = resuest.result
                    console.log(resuest.result)
                    this.select(resuest.result)
                });
            },
            animationMove:function (terminals_no) {
                var aurl = "/moves/animationMove";
                this.url = aurl;
                var param = {
                    page:1,
                    pageSize:this.pageSize
                }
                this.$http.post("/moves/animationMove",param,{emulateJSON: true}).then(function (res) {
                    var resuest = res.data
                    var code = resuest.code
                    console.log(code)
                    var msg = resuest.msg
                    if(code == "7"){
                        //获取数据失败
                        var $toastContent = $('<span style = "color: red">' + msg + '</span>');
                        Materialize.toast($toastContent, 4000);
                        return;
                    }
                    this.moves = resuest.result
                    this.pageTotal = resuest.result.pages;
                    this.count = resuest.result.total;
                    this.page = resuest.result.pageNum;
                });
            },domesticMove:function () {
                var terminals_no = $('#selected').val();
                var aurl = "/moves/domesticMove";
                this.url = aurl
                var param = {
                    page:1,
                    pageSize:this.pageSize
                }
                this.$http.post("/moves/domesticMove",param,{emulateJSON: true}).then(function (res) {
                    var resuest = res.data
                    var code = resuest.code
                    console.log(code)
                    var msg = resuest.msg
                    if(code == "7"){
                        //获取数据失败
                        var $toastContent = $('<span style = "color: red">' + msg + '</span>');
                        Materialize.toast($toastContent, 4000);
                        return;
                    }
                    this.moves = resuest.result
                    this.pageTotal = resuest.result.pages;
                    this.count = resuest.result.total;
                    this.page = resuest.result.pageNum;
                });
            },jskMove:function () {
                var aurl = "/moves/jskMove";
                this.url = aurl
                var terminals_no = $('#selected').val();
                // alert(terminals_no)
                var param = {
                    page:1,
                    pageSize:this.pageSize
                }
                this.$http.post("/moves/jskMove",param,{emulateJSON: true}).then(function (res) {
                    var resuest = res.data
                    var code = resuest.code
                    console.log(code)
                    var msg = resuest.msg
                    if(code == "7"){
                        //获取数据失败
                        var $toastContent = $('<span style = "color: red">' + msg + '</span>');
                        Materialize.toast($toastContent, 4000);
                        return;
                    }
                    this.moves = resuest.result
                    this.pageTotal = resuest.result.pages;
                    this.count = resuest.result.total;
                    this.page = resuest.result.pageNum;
                });
            },eaMove:function (time,terminals_no) {
                var aurl = "/moves/eaMove";
                this.url = aurl
                var param = {
                    page:1,
                    pageSize:this.pageSize
                }
                this.$http.post("/moves/eaMove",param,{emulateJSON:true}).then(function (res) {
                    var resuest = res.data
                    var code = resuest.code
                    console.log(code)
                    var msg = resuest.msg
                    if(code == "7"){
                        //获取数据失败
                        var $toastContent = $('<span style = "color: red">' + msg + '</span>');
                        Materialize.toast($toastContent, 4000);
                        return;
                    }
                    this.moves = resuest.result
                    this.pageTotal = resuest.result.pages;
                    this.count = resuest.result.total;
                    this.page = resuest.result.pageNum;
                });
            },otherMove:function (time,terminals_no) {
                var aurl = "/moves/otherMove";
                this.url = aurl
                var param = {
                    page:1,
                    pageSize:this.pageSize
                }
                this.$http.post("/moves/otherMove",param,{emulateJSON:true}).then(function (res) {
                    var resuest = res.data
                    var code = resuest.code
                    console.log(code)
                    var msg = resuest.msg
                    if(code == "7"){
                        //获取数据失败
                        var $toastContent = $('<span style = "color: red">' + msg + '</span>');
                        Materialize.toast($toastContent, 4000);
                        return;
                    }
                    this.moves = resuest.result
                    this.pageTotal = resuest.result.pages;
                    this.count = resuest.result.total;
                    this.page = resuest.result.pageNum;
                });
            },paging:function (page) {
                if(page > this.pageTotal || page < 1){
                    return;
                }
                var param = {
                    page:page,
                    pageSize:this.pageSize
                }
                this.$http.post(this.url, param, {emulateJSON: true}).then(function (res) {
                    var resultMsg = res.data;
                    if(resultMsg.code == "7"){
                        var $toastContent = $('<span style = "color: red">'+resultMsg.msg+'</span>');
                        Materialize.toast($toastContent, 4000);
                        return;
                    }
                    this.pageTotal = resultMsg.result.pages;
                    this.count = resultMsg.result.total;
                    this.page = resultMsg.result.pageNum;
                    this.attendances = resultMsg.result.list;
                    $('#table_body')[0].scrollTop=0;
                });
            }
        }
    });
}