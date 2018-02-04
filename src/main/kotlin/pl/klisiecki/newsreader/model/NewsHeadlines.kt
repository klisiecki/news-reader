package pl.klisiecki.newsreader.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Represents response of /top-headlines from News API
 * @see <a href="https://newsapi.org/docs/endpoints/top-headlines">Top headlines on News API</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class NewsHeadlines(
        val status: String = "",
        val totalResults: Int = 0,
        val articles: List<Article> = emptyList()) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Article(
            val source: Source = Source("", ""),
            val author: String? = null,
            val title: String = "",
            val description: String = "",
            val url: String = "",
            val urlToImage: String? = null,
            val publishedAt: String = "") {

        @JsonIgnoreProperties(ignoreUnknown = true)
        data class Source(
                val id: String? = null,
                val name: String = ""
        )
    }
}