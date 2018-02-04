package pl.klisiecki.newsreader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.klisiecki.newsreader.model.MyNews;

import static java.util.Collections.emptyList;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(NewsController.class)
public class NewsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private NewsController newsController;

    @Test
    public void news() throws Exception {
        MyNews myNews = new MyNews("pl", "technology", emptyList());

        given(newsController.news(myNews.getCountry(), myNews.getCategory())).willReturn(myNews);

        mvc.perform(get("/news/pl/technology")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("category", is(myNews.getCategory())))
                .andExpect(jsonPath("country", is(myNews.getCountry())));
    }
}