$(document).ready(function () {
    $(document).on('click', '.btn-update', function (e) {
        e.preventDefault();
        const userId = this.id;
        // updateModal.style.display = "block";
        // fillUpdateFields(this.id);
        const urlToGetUser = "/api/v1/user/" + userId;
        $.ajax({
            type: "GET",
            url: urlToGetUser,
            headers: {"Authorization": localStorage.getItem('Authorization')},
            success: function (responseUserToUpdate) {
                console.log(responseUserToUpdate);
                $("#loadModalBody").load("update-view/" + userId);
                $("#myModal").modal();
            }
        });
    })

});