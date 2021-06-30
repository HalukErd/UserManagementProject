$(document).ready(function () {
    console.log("document ready")
    var urlUserAuthorityCheck = contextPath + "api/v1/user/check";

    $.get(urlUserAuthorityCheck, function (responseAllAuthoritiesJson) {
        var hasUserReadAuthority = hasAuthority(responseAllAuthoritiesJson, "user:read");
        if (hasUserReadAuthority) {
            window.location.replace("/users");
        }
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
});