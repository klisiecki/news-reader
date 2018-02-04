package pl.klisiecki.newsreader;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.klisiecki.newsreader.model.MyNews;

import static java.util.Collections.emptyList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("news")
public class NewsController {

    @RequestMapping(value = "/{lang}/{category}", method = GET)
    public MyNews news(@PathVariable String lang, @PathVariable String category) {
        return new MyNews(lang, category, emptyList());
    }
}
