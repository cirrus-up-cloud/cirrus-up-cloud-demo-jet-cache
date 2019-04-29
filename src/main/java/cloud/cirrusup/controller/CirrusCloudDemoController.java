package cloud.cirrusup.controller;

import cloud.cirrusup.model.Book;
import cloud.cirrusup.service.BooksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@ImportResource(locations = "classpath:spring-config/applicationContext.xml")
@PropertySource("classpath:properties/config-${spring.profiles.active}.properties")
public class CirrusCloudDemoController {

    @Autowired
    private BooksService booksService;


    private static final Logger LOG = LoggerFactory.getLogger(CirrusCloudDemoController.class);

    @GetMapping("/get")
    public String get(@RequestParam(name = "id") String id) {

        LOG.info("GET /get request.");
        Book book = booksService.getBookById(id);

        if (book != null) {

            return "Title: " + book.getTitle();
        }

        return "Item not found";
    }

    @PutMapping("/put/{id}/{title}")
    public void put(@PathVariable String id, @PathVariable String title) {

        LOG.info("PUT /put request for " + id );
        booksService.put(new Book(id, title));
    }
}
