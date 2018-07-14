package org.daming.inventory;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.codec.ByteArrayCodec;
import io.lettuce.core.support.ConnectionPoolSupport;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.daming.inventory.prop.LettuceProp;
import org.daming.inventory.utils.SerializeUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-08 21:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private LettuceProp prop;

    @Test
    public void test1() {
        System.out.println(prop.getIp());
        System.out.println(prop.getPort());
    }

    @Test
    public void test2() throws Exception {
        RedisClient client = RedisClient.create(RedisURI.create(prop.getIp(), prop.getPort()));
        GenericObjectPool<StatefulRedisConnection<String,String>> pool = ConnectionPoolSupport
                .createGenericObjectPool(() -> client.connect(), new GenericObjectPoolConfig());
        StatefulRedisConnection<String,String> connection1 = pool.borrowObject();
        RedisCommands<String, String> commands1 = connection1.sync();
        System.out.println(commands1.multi());
        System.out.println(commands1.set("daming", "daming"));
        System.out.println(commands1.exec());
        System.out.println(connection1.sync().get("daming"));

    }

    @Test
    public void test3() throws Exception {
        RedisClient client = RedisClient.create("redis://127.0.0.1:6379");
        GenericObjectPool<StatefulRedisConnection<String, String>> pool = ConnectionPoolSupport
                .createGenericObjectPool(() -> client.connect(), new GenericObjectPoolConfig());
        try (StatefulRedisConnection<String, String> connection = pool.borrowObject()) {
            RedisAsyncCommands<String, String> commands = connection.async();
            commands.set("test", "test");
            RedisFuture<String> future = commands.get("test");
            String str = future.get();
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() throws Exception {
        RedisClient client = RedisClient.create("redis://127.0.0.1:6379");
        GenericObjectPool<StatefulRedisConnection<String, String>> pool = ConnectionPoolSupport
                .createGenericObjectPool(() -> client.connect(), new GenericObjectPoolConfig());
        try (StatefulRedisConnection<String, String> connection = pool.borrowObject()) {
            RedisCommands<String, String> commands = connection.sync();
            System.out.println(commands.setex("test", 1L,"1"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
