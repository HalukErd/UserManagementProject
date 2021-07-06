$(document).ready(function () {
    let citySelect = $("#citySelect");
    let townSelect = $("#townSelect");
    const urlToGetCities = "http://localhost:8085/api/cityandtowns/getcities";

    getCities();

    citySelect.change(function () {
        getTowns(citySelect.val());
    });

    function getCities() {
        $.get(urlToGetCities, function (responseCityList) {
            $.each(responseCityList, function (index, city) {
                $("<option>").text(city).appendTo(citySelect);
            });
        });
    }

    function getTowns(city) {
        const urlToGetTowns = "http://localhost:8085/api/cityandtowns/gettowns/" + city;
        $.get(urlToGetTowns, function (resposeTownList){
            townSelect.empty();
            $("<option>")
                .attr("disabled", true)
                .attr("selected", true)
                .text("Select a town")
                .appendTo(townSelect);
            $.each(resposeTownList, function (index, town) {
                $("<option>").text(town).appendTo(townSelect);
            });
        });
    }
});