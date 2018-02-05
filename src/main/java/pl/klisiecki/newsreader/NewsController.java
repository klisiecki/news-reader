package pl.klisiecki.newsreader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.klisiecki.newsreader.model.MyNews;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("news")
public class NewsController {

    private final NewsApiRetriever newsApiRetriever;

    @Autowired
    public NewsController(NewsApiRetriever newsApiRetriever) {
        this.newsApiRetriever = newsApiRetriever;
    }

    @RequestMapping(value = "/{lang}/{category}", method = GET)
    public MyNews news(@PathVariable String lang, @PathVariable String category) {
        return newsApiRetriever.getHeadlines(lang, category).toMyNews(lang, category);
    }
}
