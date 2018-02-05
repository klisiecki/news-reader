package pl.klisiecki.newsreader.model

import org.junit.Test

import org.junit.Assert.*
import pl.klisiecki.newsreader.model.NewsHeadlines.Article.*

class NewsHeadlinesTest {

    @Test
    fun `empty headline mapping`() {
        val emptyHeadlines = NewsHeadlines(null, null, listOf())
        val emptyMyNews = MyNews(null, null, listOf())
        assertEquals(emptyMyNews, emptyHeadlines.toMyNews(null, null))
    }

    @Test
    fun `headline with empty article mapping`() {
        val headlines = NewsHeadlines(null, null,
                listOf(NewsHeadlines.Article(null, null, null, null, null, null, null)))
        val myNews = MyNews(null, null, listOf(MyNews.Article("", "", "", "", "", "", "")))
        assertEquals(myNews, headlines.toMyNews(null, null))
    }

    @Test
    fun `headline mapping with parameters provided`() {
        val emptyNews = NewsHeadlines(null, null, listOf())
        assertEquals(MyNews("be", "sports", listOf()), emptyNews.toMyNews("be", "sports"))
    }

    @Test
    fun `headline with multiple news mapping`() {
        val headlines = NewsHeadlines("ok", 1,
                listOf(NewsHeadlines.Article(Source("bbc", "BBC"), "a1", "t1", "d1", "ex1.com", "ex1.com/1.jpg",
                        "2018-02-05T17:51:00Z"),
                        NewsHeadlines.Article(Source("cnn", "CNN"), "a2", "t2", "d2", "ex2.com", "ex2.com/1.jpg",
                                "2017-03-04T17:52:00Z")))

        val myNews = MyNews(null, null,
                listOf(MyNews.Article("a1", "t1", "d1", "2018-02-05T17:51:00Z", "BBC", "ex1.com", "ex1.com/1.jpg"),
                        MyNews.Article("a2", "t2", "d2", "2017-03-04T17:52:00Z", "CNN", "ex2.com", "ex2.com/1.jpg")))
        assertEquals(myNews, headlines.toMyNews(null, null))
    }
}