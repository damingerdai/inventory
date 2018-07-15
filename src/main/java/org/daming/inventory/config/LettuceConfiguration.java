package org.daming.inventory.config;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.ByteArrayCodec;
import io.lettuce.core.support.ConnectionPoolSupport;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.daming.inventory.prop.LettuceProp;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-07 23:57
 */
@Configuration
public class LettuceConfiguration {

    private LettuceProp lettuceProp;

    @Bean(destroyMethod = "shutdown")
    @Primary
    public RedisClient redisClient() {
        return RedisClient.create(RedisURI.create(lettuceProp.getIp(), lettuceProp.getPort()));
    }

    @Bean(destroyMethod = "close")
    public GenericObjectPool<StatefulRedisConnection<byte[], byte[]>> lettucePool(RedisClient redisClient) {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setJmxEnabled(false);
        return ConnectionPoolSupport
                .createGenericObjectPool(() -> redisClient.connect(new ByteArrayCodec()), config);
    }


    public LettuceConfiguration(LettuceProp lettuceProp) {
        this.lettuceProp = lettuceProp;
    }
}
