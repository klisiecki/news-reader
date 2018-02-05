package pl.klisiecki.newsreader.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.ZonedDateTime.parse
import java.time.format.DateTimeFormatter.ofPattern


/**
 * Represents response of /top-headlines from News API
 * @see <a href="https://newsapi.org/docs/endpoints/top-headlines">Top headlines on News API</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class NewsHeadlines(
        val status: String? = null,
        val totalResults: Int? = null,
        val articles: List<Article> = emptyList()) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Article(
            val source: Source? = null,
            val author: String? = null,
            val title: String? = null,
            val description: String? = null,
            val url: String? = null,
            val urlToImage: String? = null,
            val publishedAt: String? = null) {

        @JsonIgnoreProperties(ignoreUnknown = true)
        data class Source(
                val id: String? = null,
                val name: String? = null
        )

        fun toMyArticle() = MyNews.Article(
                author = author ?: "",
                title = title ?: "",
                description = description ?: "",
                date = publishedAt?.let { d -> parse(d).toLocalDate().format(ofPattern("yyyy-MM-dd")) } ?: "",
                sourceName = source?.name ?: "",
                articleUrl = url ?: "",
                imageUrl = urlToImage ?: ""
        )

    }

    fun toMyNews(country: String?, category: String?) = MyNews(
            country = country,
            category = category,
            articles = articles.map(Article::toMyArticle)
    )

}