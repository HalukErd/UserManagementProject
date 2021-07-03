$(document).ready(function () {
    var username = $("#username");
    var password = $("#newPassword");
    var name = $("#name");
    var lastName = $("#lastname");
    var email = $("#email");
    var phoneNumber = $("#phoneNumber");
    const birthDay = $("#birthDay");

    var saveUserButton = $("#saveUser");

    saveUserButton.click(function () {
        console.log("saveUserButton clicked")

        saveUser();
    });

    function saveUser() {
        var urlUserApi = contextPath + "api/v1/user/signup"

        var usernameValue = username.val();
        var passwordValue = password.val();
        var nameValue = name.val();
        var lastNameValue = lastName.val();
        var emailValue = email.val();
        var phoneNumberValue = phoneNumber.val();
        var birthDayValue = birthDay.val();

        var jsonData = {
            username: usernameValue,
            password: passwordValue,
            userInformation: {
                name: nameValue,
                lastName: lastNameValue,
                email: emailValue,
                phoneNumber: phoneNumberValue,
                birthDay: birthDayValue
            }
        }

        console.log(JSON.stringify(jsonData));

        $.ajax({
            type: "POST",
            url: urlUserApi,
            data: JSON.stringify(jsonData),
            contentType: 'application/json',

            statusCode: {
                200: function () {
                    window.location.replace("/users" + "#userSaved");
                },
                400: function () {
                    window.location.replace("/signup" + "#userSaveFailed");
                },
                500: function () {
                    window.location.replace("/signup" + "#userSaveFailed");
                }
            }
        });
    }
})