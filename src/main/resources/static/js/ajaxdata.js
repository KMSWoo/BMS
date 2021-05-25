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
            $("#btn_del").attr("disabled",false);
        }else {
            $("#btn_del").attr("disabled",true);
        }
    })

    //ajax删除书本
    $("#btn_book_delete").click(function () {

        var checkID = getCheckBox();

        // alert(checkID);
        // alert(JSON.stringify(checkID));
        // if (!confirm("确定删除吗？") ){
        //     return false;
        // }

        //点击确定后模态框隐藏
        $('#deletebook').modal('hide');

        $.ajax({
            type:"POST",
            url:"/deletebook",
            cache:'false',
            data:JSON.stringify(checkID),
            contentType: "application/json",
            success:function (data) {
                if (data == "ok"){
                    // alert("删除成功！");
                    $("#deletebookfeedback").modal('show');
                    $(".selected").hide();
                    //会吞噬模态框
                    // window.location.href = window.location.href;
                }else {
                    $("#deletebookfeedback .modal-body").text("删除失败！");
                    $('#deletebookfeedback').modal('show');
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