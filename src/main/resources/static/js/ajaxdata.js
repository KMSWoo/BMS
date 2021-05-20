function getCheckBox() {
    var checkID = {};
    $(".selected #id").each(function (index) {
        checkID[index] = $(this).text();
    })
    return checkID;
}

$("#btn_book_delete").click(function () {
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
                window.location.href = window.location.href;
            }
        }
    })
})

$("#btn_user_delete").click(function () {
    $(".selected").hide();
    var checkID = getCheckBox();
    // alert(checkID);
    // alert(JSON.stringify(checkID));
    $.ajax({
        type:"POST",
        url:"/deleteuser",
        cache:'false',
        data:JSON.stringify(checkID),
        contentType: "application/json",
        success:function (data) {
            if (data == "ok"){
                alert("删除成功！");
                window.location.href = window.location.href;
            }
        }
    })
})