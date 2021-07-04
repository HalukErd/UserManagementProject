$(document).ready(function () {
    let formData;

    $("#login-submit").click(function (e) {
        e.preventDefault();
        formData = {
            username: $("#username").val(),
            password: $("#password").val()
        };
        console.log(formData);

        $.ajax({
            url: "http://localhost:8080/login",
            type: 'POST',
            data: JSON.stringify(formData),
            error : function(err) {
                console.log('Error!', err)
            },
            success: function(data, textStatus, request) {
                console.log('Success!')
                console.log(request.getResponseHeader('Authorization'));
                localStorage.setItem('Authorization', request.getResponseHeader('Authorization'));
            }
        });
    });
});