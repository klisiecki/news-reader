package pl.klisiecki.newsreader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.klisiecki.newsreader.model.NewsHeadlines;

@Component
public class NewsApiRetriever {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private final RestTemplate restTemplate;

    @Autowired
    public NewsApiRetriever(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NewsHeadlines getHeadlines(String country, String category) {
        log.info("Retrieving headlines for country={} and category={}", country, category);
        return restTemplate.getForObject(prepareUrl(country, category), NewsHeadlines.class);
    }

    protected String prepareUrl(String country, String category) {
        String template =
                "https://newsapi.org/v2/top-headlines?country=%s&category=%s&apiKey=69b21ac3238245babc799f41e42ffa4c";
        return String.format(template, country, category);
    }
}
