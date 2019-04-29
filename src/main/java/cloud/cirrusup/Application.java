package cloud.cirrusup;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Service entry point.
 */
@SpringBootApplication
@EnableMethodCache(basePackages = "cloud.cirrusup")
@EnableCreateCacheAnnotation
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        LOG.info("Starting application... ");
        SpringApplication.run(Application.class, args);
    }
}
