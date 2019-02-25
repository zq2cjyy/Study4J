package luzq.std.jstd.base.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

public class RedisDemo {
    private static JedisPool jedisPool;

    private static void initPool() {
        /**
         * config参考
         * https://www.cnblogs.com/jklk/p/7095067.html
         */
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000l);
        config.setTestOnBorrow(false);

        jedisPool = new JedisPool(config, "192.168.182.143", 6379);
    }

    public static void run() {
        initPool();

        Jedis jedis = jedisPool.getResource();
        String mykey = jedis.get("mykey");
        System.out.println("mykey->" + mykey);
        Set<String> keys = jedis.keys("my*");
        System.out.println(keys.size());

        for (String k : keys) {
            System.out.println(k + "-->" + jedis.type(k));
        }

        jedis.close();
        jedisPool.close();
    }


    public static void main(String[] args) {
        run();
    }
}
