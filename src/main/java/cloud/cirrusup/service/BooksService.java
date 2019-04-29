package cloud.cirrusup.service;

import cloud.cirrusup.model.Book;
import com.alicp.jetcache.Cache;
import com.alicp.jetcache.redis.RedisCacheBuilder;
import com.alicp.jetcache.support.FastjsonKeyConvertor;
import com.alicp.jetcache.support.JavaValueDecoder;
import com.alicp.jetcache.support.JavaValueEncoder;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.TimeUnit;


/**
 * Books service.
 */
public class BooksService {

    private Cache<String, Book> bookCache;

    private BooksService(String host, int port) {

        GenericObjectPoolConfig pc = new GenericObjectPoolConfig();
        JedisPool pool = new JedisPool(pc, host, port);

        bookCache = RedisCacheBuilder.createRedisCacheBuilder()
                .keyConvertor(FastjsonKeyConvertor.INSTANCE)
                .valueEncoder(JavaValueEncoder.INSTANCE)
                .valueDecoder(JavaValueDecoder.INSTANCE)
                .jedisPool(pool)
                .keyPrefix("bookcache-")
                .expireAfterWrite(30, TimeUnit.SECONDS)
                .buildCache();
    }

    public Book getBookById(String bookId) {

        return bookCache.get(bookId);
    }

    public void put(Book book) {

        bookCache.put(book.getId(), book);
    }
}
