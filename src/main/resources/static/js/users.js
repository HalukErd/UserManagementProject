$(document).ready(function () {
    var urlUserAuthorityCheck = contextPath + "api/v1/user/check";
    var urlToGetAllUsers = contextPath + "api/v1/user/all";

    var updateModal = document.getElementById("updateModal")
    var userId = $("#userId");
    var username = $("#username");
    var password = $("#newPassword");
    var name = $("#name");
    var lastName = $("#lastname");
    var email = $("#email");
    var phoneNumber = $("#phoneNumber");
    var birthDay = $("#birthDay");

    var tableString = '';
    var startRow = '<tr><td>';
    var midRow = '</td><td>';
    var endRow = '</td></tr>';
    var updateButtonModal = $('#updateButton');
    var hasUserDeleteAuthority;

    $.get(urlUserAuthorityCheck, function (responseAllAuthoritiesJson) {
        hasUserDeleteAuthority = hasAuthority(responseAllAuthoritiesJson, "user:delete");
        console.log(hasUserDeleteAuthority);
    })

    $.get(urlToGetAllUsers, function (responseAllUsersJson) {
        $('#thetable tr').not(':first').not(':last').remove();
        if (hasUserDeleteAuthority) {
            $("table tr:first th:last").after("<th>Delete</th>");
            $("table tr:first th:last").after("<th>Update</th>");
        }
        $.each(responseAllUsersJson, function (index, userResponseJson) {

            tableString += startRow +
                userResponseJson.id + midRow +
                userResponseJson.username + midRow +
                userResponseJson.userRole + midRow +
                userResponseJson.userInformation.name + midRow +
                userResponseJson.userInformation.lastName + midRow +
                userResponseJson.userInformation.email + midRow +
                userResponseJson.userInformation.phoneNumber + midRow +
                userResponseJson.userInformation.birthDay + midRow;
            if (hasUserDeleteAuthority) {
                tableString +=
                    "<input type='button' id='"+ userResponseJson.id +"' value='Delete' class=btn-delete></button>"
                    + midRow +
                    "<input type='button' id='"+ userResponseJson.id +"' value='Update' class=btn-update></button>";
            }
            tableString += endRow;
        });
        $("table tr:first").after(tableString);
    })

    function hasAuthority(responseAllAuthoritiesJson, authorityToCheck) {
        var exists;
        $.each(responseAllAuthoritiesJson, function (index, authoritiesResponse) {
            if (authoritiesResponse.authority === authorityToCheck) {
                console.log("exists");
                exists = true;
                return false;
            }
        });
        return exists;
    }

    $(document).on('click', '.btn-delete', function (e) {
        e.preventDefault();
        if (window.confirm("Are you sure?")) {
            deleteUser(this.id);
            $(this).closest('tr').remove();
        }
    })

    $(document).on('click', '.btn-update', function (e) {
        e.preventDefault();
        updateModal.style.display = "block";
        fillUpdateFields(this.id);
    })

    $(document).on('click', '.close-modal-button', function (e) {
        e.preventDefault();
        updateModal.style.display = "none";
    });

    function fillUpdateFields(id) {
        urlToUpdate = contextPath + "api/v1/user/" + id;
        console.log(urlToUpdate);
        $.get(urlToUpdate, function (responseUserJson) {
            console.log(responseUserJson);
            userId.val(id);
            username.val(responseUserJson.username);
            name.val(responseUserJson.userInformation.name);
            lastName.val(responseUserJson.userInformation.lastName);
            email.val(responseUserJson.userInformation.email);
            phoneNumber.val(responseUserJson.userInformation.phoneNumber);
            birthDay.val(responseUserJson.userInformation.birthDay);
        })
    }

    updateButtonModal.click(function () {
        updateUser();
        updateModal.style.display = "none";
    });

    function deleteUser(id) {
        urlToDelete = contextPath + "api/v1/user/" + id;

        $.ajax({
            type: "DELETE",
            url: urlToDelete
        });
    }

    function updateUser() {
        var urlUserApi = contextPath + "api/v1/user/"
        console.log(urlUserApi);
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
            type: "PUT",
            url: urlUserApi,
            data: JSON.stringify(jsonData),
            contentType: 'application/json',

            statusCode: {
                200: function () {
                    window.location.replace("/users" + "#userUpdated");
                },
                400: function () {
                    window.location.replace("/users" + "#userUpdateFailed");
                },
                500: function () {
                    window.location.replace("/users" + "#userUpdateFailed");
                }
            }
        });
    }
});