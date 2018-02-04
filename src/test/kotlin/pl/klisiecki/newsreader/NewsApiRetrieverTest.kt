package pl.klisiecki.newsreader

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.client.ExpectedCount
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.support.RestGatewaySupport
import pl.klisiecki.newsreader.model.NewsHeadlines
import pl.klisiecki.newsreader.model.NewsHeadlines.Article
import pl.klisiecki.newsreader.model.NewsHeadlines.Article.Source

import java.util.Arrays.asList
import org.junit.Assert.assertEquals
import org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo
import org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess

@RunWith(SpringRunner::class)
@SpringBootTest
class NewsApiRetrieverTest {

    @Autowired
    private val retriever: NewsApiRetriever? = null

    private var mockServer: MockRestServiceServer? = null

    @Autowired
    private val restTemplate: RestTemplate? = null

    @Before
    fun setUp() {
        val gateway = RestGatewaySupport()
        gateway.restTemplate = restTemplate
        mockServer = MockRestServiceServer.createServer(gateway)
    }

    @Test
    fun retrieveHeadlines() {
        val responseBody = """{
                      "status": "ok",
                      "totalResults": 2,
                      "articles": [
                        {
                          "source": {
                            "id": null,
                            "name": "s1"
                          },
                          "author": "author 1",
                          "title": "title 1",
                          "description": "desc",
                          "url": "http://www.example.com/1",
                          "urlToImage": null,
                          "publishedAt": "2018-02-04T19:47:08Z"
                        },
                        {
                          "source": {
                            "id": "id2",
                            "name": "s2"
                          },
                          "author": null,
                          "title": "title title 2",
                          "description": "desc 2",
                          "url": "http://www.example.com/2",
                          "urlToImage": "http://example.com/images/1.jpg",
                          "publishedAt": "2018-02-04T18:37:49Z"
                        }
                      ]
                    }"""

        val expectedHeadlines = NewsHeadlines("ok", 2,
                asList(Article(Source(null, "s1"), "author 1", "title 1", "desc", "http://www.example.com/1", null,
                        "2018-02-04T19:47:08Z"),
                        Article(Source("id2", "s2"), null, "title title 2", "desc 2", "http://www.example.com/2",
                                "http://example.com/images/1.jpg", "2018-02-04T18:37:49Z")))

        val country = "pl"
        val category = "technology"
        mockServer!!.expect(ExpectedCount.once(), requestTo(retriever!!.prepareUrl(country, category)))
                .andRespond(withSuccess(responseBody, MediaType.APPLICATION_JSON))

        val headlines = retriever.getHeadlines(country, category)

        mockServer!!.verify()

        assertEquals(expectedHeadlines, headlines)
    }
}