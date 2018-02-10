function fetchArticles() {
    fetchArticlesFor($("#countryInput").val(), $("#categoryInput").val())
}

function fetchArticlesFor(country, category) {
    $.get("/news/" + country + "/" + category, function (data) {
        $("#articles").html(JSON.stringify(data));
    });
}