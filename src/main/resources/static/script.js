$(document).ready(fetchArticles);

function fetchArticles() {
    fetchArticlesFor($("#countryInput").val(), $("#categoryInput").val())
}

function fetchArticlesFor(country, category) {
    $.get("/news/" + country + "/" + category, function (data) {
        const articles = $("#articles");
        articles.html('');
        for (let i = 0; i < data.articles.length; i++) {
            const articleHtml = createHtmlContent(data.articles[i]);
            $('<div/>', {'class': 'col', 'html': articleHtml}).appendTo(articles);
            if (i % 2 === 1) {
                $('<div/>', {'class': 'w-100'}).appendTo(articles);
            }
        }
    });
}

function createHtmlContent(article) {
    let html = '<div class="media">';
    if (article.imageUrl) {
        html += createArticleImage(article);
    }
    html += '<div class="media-body">' + createArticleBody(article) + '</div>';
    html += '</div>';
    return html;
}

function createArticleImage(article) {
    return '<img style="max-width: 10em; height: auto; " class="align-self-start mr-3" ' +
        'src="' + article.imageUrl + '" alt="' + article.title + '">';
}

function createArticleBody(article) {
    let html = '';
    html += '<h3><a href="' + article.articleUrl + '">' + article.title + '</a></h3>';
    html += '<h4>' + article.date + ' | ' + article.author + ' | ' + article.sourceName + '</h4>';
    html += '<p>' + article.description + '</p>';
    return html;
}