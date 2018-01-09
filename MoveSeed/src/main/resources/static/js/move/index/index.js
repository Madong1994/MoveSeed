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
            count:0
        },
        mounted:function () {
            this.init()
            this.recordInit()
        },
        methods: {
            init:function () {
                this.$http.get("/moves/indexMove").then(function (res) {
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
            },select:function (paks) {
                $('#selected').empty();
                var html = '';
                for (var i = 0;i<paks.length;i++){
                    html += '<option  value="'+paks[i].terminals_no+'">'+paks[i].project_name+'</option>'
                }

                $('#selected').append(html)
                $('select').material_select();
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
            del:function (terminals_no) {
                var param = {
                    terminals_no:terminals_no
                }
                this.$http.post("/pak/del",param,{emulateJSON: true}).then(function (res) {
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
                    Materialize.toast(msg, 4000);
                    this.paks = resuest.result
                    console.log(resuest.result)
                    this.select(resuest.result)
                });
            },downloadEmps:function () {
                var terminals_no = $('#selected').val();
                var param = {
                    terminals_no:terminals_no
                }
                this.$http.post("/pak/updatepak",param,{emulateJSON: true}).then(function (res) {
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
                    // this.paks = resuest.result
                    // console.log(resuest.result)
                    // this.select(resuest.result)
                });
            },bindEmps:function () {
                var terminals_no = $('#selected').val();
                // alert(terminals_no)
                var param = {
                    terminals_no:terminals_no
                }
                this.$http.post("/pak/bind",param,{emulateJSON: true}).then(function (res) {
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
                    Materialize.toast(msg, 4000);
                    // this.paks = resuest.result
                    // console.log(resuest.result)
                    // this.select(resuest.result)
                });
            },uploadCheckWork:function (time,terminals_no) {
                var param = {
                    time:time,
                    terminals_no:terminals_no,
                    page:this.page,
                    pageSize:this.pageSize
                }
                this.$http.post("/pak/upload",param,{emulateJSON:true}).then(function (res) {
                    var resuest = res.data
                    var code = resuest.code
                    console.log(code)
                    var msg = resuest.msg
                    if(code == '7'){
                        var $toastContent = $('<span style = "color: red">' + msg + '</span>');
                        Materialize.toast($toastContent, 4000);
                        return;
                    }
                    Materialize.toast(msg, 4000);
                    this.attendances = resuest.result.list
                });
            },paging:function (page) {
                if(page > this.pageTotal || page < 1){
                    return;
                }
                var param = {
                    page:page,
                    pageSize:this.pageSize
                }
                this.$http.post("/pak/attendance", param, {emulateJSON: true}).then(function (res) {
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