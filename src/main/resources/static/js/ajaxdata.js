$(function (){
    //返回选中的书本ID
    function getCheckBox() {
        var checkID = {};
        $(".selected #id").each(function (index) {
            checkID[index] = $(this).text();
        })
        return checkID;
    }

    //监控复选框与删除按钮联动
    $("input[name='btSelectItem'],input[name='btSelectAll']").change(function (){
        var checked = $("input:checkbox:checked").val();
        if (checked){
            $("#btn_del,#btn_add").attr("disabled",false);
        }else {
            $("#btn_del,#btn_add").attr("disabled",true);
        }
    })

    //清除特定class
    function clearClass(){
        var cls = ["btn_del","btn_add"];
        for (c of cls){
            if ($("#addclass").hasClass(c)){
                if ($("#addclass").removeClass(c));
            }
        }
    }

    //绑定点击事件触发modal
    $("#btn_del,#btn_add").click(function (){
        //修改对应确认语和class
        $("#reconfirm").text($(this).text());
        clearClass();
        $("#addclass").addClass($(this).attr("id"));
        $("#manipulatebook").modal('show');
    })

    //ajax删除书(动态捕获事件)
    $(document).on("click",".btn_del",function (){
        var checkID = getCheckBox();

        // alert(checkID);
        // alert(JSON.stringify(checkID));
        // if (!confirm("确定删除吗？") ){
        //     return false;
        // }

        //点击确定后模态框隐藏
        $('#manipulatebook').modal('hide');

        $.ajax({
            type:"POST",
            url:"/deletebook",
            cache:'false',
            data:JSON.stringify(checkID),
            contentType: "application/json",
            success:function (data) {
                if (data == "ok"){
                    // alert("删除成功！");
                    $("#bookfeedback").modal('show');
                    $(".selected").hide();
                    //会吞噬模态框
                    // window.location.href = window.location.href;
                }else {
                    $("#bookfeedback .modal-body").text("操作失败！");
                    $('#bookfeedback').modal('show');
                }
            }
        })
    })

    //ajax删除书(动态捕获事件)
    $(document).on("click",".btn_add",function (){
        var checkID = getCheckBox();
        $('#manipulatebook').modal('hide');

        $.ajax({
            type:"POST",
            url:"/reservebook",
            cache:'false',
            data:JSON.stringify(checkID),
            contentType: "application/json",
            success:function (data) {
                if (data == "ok"){
                    $("#bookfeedback").modal('show');
                    $(".selected").hide();
                    //会吞噬模态框
                    // window.location.href = window.location.href;
                }else {
                    $("#bookfeedback .modal-body").text("操作失败！");
                    $('#bookfeedback').modal('show');
                }
            }
        })
    })


    $("#btn_user_delete").click(function () {

        var checkID = getCheckBox();
        // alert(checkID);
        // alert(JSON.stringify(checkID));
        // if (!confirm("确定删除吗？")){
        //     return false;
        // }

        $('#deleteuser').modal('hide');

        $.ajax({
            type:"POST",
            url:"/deleteuser",
            cache:'false',
            data:JSON.stringify(checkID),
            contentType: "application/json",
            success:function (data) {
                if (data == "ok"){
                    $("#deleteuserfeedback").modal('show');
                    $(".selected").hide();
                }else{
                    $("#deleteuserfeedback .modal-body").text("删除失败！");
                    $('#deleteuserfeedback').modal('show');
                }
            }
        })
    })
})