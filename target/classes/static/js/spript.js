$(document).ready(function(){
    $("#insert").click(function () {
        var user = $("#user").val();
        var pass = $("#pass").val();
        var cv = $("#slCV").val();
        // alert(user + pass + cv);
        $.ajax({
            url: '/admin/insert',
            type: 'POST',
            dataType : "json",
            data: {
                user: user,
                pass: pass,
                idcv : cv
            }
        }).done(function(result) {
            if(result){
                alert("Them thanh cong!!");
                location.reload();
            }
            else {
                alert("Them that bai!!");
            }
        });
    });

    $(".btnDel").click(function () {
        var self = $(this);
        var idtk = self.closest("tr").find(".idTK").text();
        $.ajax({
            url: "/admin/del/"+idtk,
            type: "DELETE",
            data: {}
        }).done(function (result) {
            alert("xoa thanh cong");
            self.closest("tr").remove();
        })
    });

});