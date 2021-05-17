function getCheckBox() {
    var checkID = {};
    $(".selected #id").each(function (index) {
        checkID[index] = $(this).text();
    })
    return checkID;
}

$("#btn_delete").click(function () {
    $(".selected").hide();
    var checkID = getCheckBox();
    // alert(checkID);
    // alert(JSON.stringify(checkID));
    $.ajax({
        type:"POST",
        url:"/deletebook",
        cache:'false',
        data:JSON.stringify(checkID),
        contentType: "application/json",
        success:function (data) {
            if (data == "ok"){
                alert("删除成功！");
            }
        }
    })
})