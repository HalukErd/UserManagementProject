$(document).ready(function () {


    $(document).on('click', '.btn-delete', function (e) {
        e.preventDefault();
        if (window.confirm("Are you sure?")) {
            deleteUser(this, this.id);

        }
    })



    function deleteUser(button, id) {
        let urlToDelete = "api/v1/user/" + id;

        $.ajax({
            type: "DELETE",
            url: urlToDelete,
            headers: {"Authorization": localStorage.getItem('Authorization')},
            success: function () {
                console.log("Delete success")
                $(button).closest('tr').remove();
            }
        });
    }

});

$(document).before(function () {
    $.ajax({
        type: "HEAD",
        url: "/users",
        headers: {"Authorization": localStorage.getItem("Authorization")}
    })
});