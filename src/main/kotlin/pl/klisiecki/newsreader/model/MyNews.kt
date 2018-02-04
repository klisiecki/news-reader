package pl.klisiecki.newsreader.model

data class MyNews(
        val country: String?,
        val category: String?,
        val articles: List<Article>) {

    data class Article(
            val author: String,
            val title: String,
            val description: String,
            val date: String,
            val sourceName: String,
            val articleUrl: String,
            val imageUrl: String)
}