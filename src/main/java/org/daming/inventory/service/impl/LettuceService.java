package org.daming.inventory.service.impl;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.daming.inventory.service.RedisService;
import org.daming.inventory.utils.Exceptions;
import org.daming.inventory.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-08 20:30
 */
@Service
@Primary
public class LettuceService implements RedisService {

    @Autowired
    @Qualifier("lettucePool")
    GenericObjectPool<StatefulRedisConnection<byte[], byte[]>> pool;

    @Override
    public Object get(String key) {
        try (StatefulRedisConnection<byte[], byte[]> connection = pool.borrowObject()) {
            RedisCommands<byte[], byte[]> commands = connection.sync();
            return SerializeUtil.unserialize(commands.get(key.getBytes()));
        } catch (Exception ex) {
            throw Exceptions.unchecked(ex);
        }
    }

    @Override
    public void set(String key, Object value) {
        try (StatefulRedisConnection<byte[], byte[]> connection = pool.borrowObject()) {
            RedisCommands<byte[], byte[]> commands = connection.sync();
            commands.multi();
            String result = commands.set(key.getBytes(), SerializeUtil.serialize(value));
            commands.exec();
        } catch (Exception ex) {
            throw Exceptions.unchecked(ex);
        }
    }

    @Override
    public void set(String key, Object value, long expireSeconds) {
        try (StatefulRedisConnection<byte[], byte[]> connection = pool.borrowObject()) {
            RedisCommands<byte[], byte[]> commands = connection.sync();
            commands.multi();
            commands.setex(SerializeUtil.serialize(key), expireSeconds, SerializeUtil.serialize(value));
            commands.exec();
        } catch (Exception ex) {
            throw Exceptions.unchecked(ex);
        }
    }


    @Override
    public void del(String key) {
        try (StatefulRedisConnection<byte[], byte[]> connection = pool.borrowObject()) {
            RedisCommands<byte[], byte[]> commands = connection.sync();
            commands.multi();
            commands.del(key.getBytes());
            commands.exec();
        } catch (Exception ex) {
            throw Exceptions.unchecked(ex);
        }
    }

    @Override
    public void expire(String key, long seconds) {
        try (StatefulRedisConnection<byte[], byte[]> connection = pool.borrowObject()) {
            RedisCommands<byte[], byte[]> commands = connection.sync();
            commands.multi();
            commands.expire(key.getBytes(), seconds);
            commands.exec();
        } catch (Exception ex) {
            throw Exceptions.unchecked(ex);
        }
    }

    @Override
    public void pexpire(String key, long millisSeconds) {
        try (StatefulRedisConnection<byte[], byte[]> connection = pool.borrowObject()) {
            RedisCommands<byte[], byte[]> commands = connection.sync();
            commands.multi();
            commands.pexpire(key.getBytes(), millisSeconds);
            commands.exec();
        } catch (Exception ex) {
            throw Exceptions.unchecked(ex);
        }
    }

    @Override
    public void lpush(String key, String value) {
        try (StatefulRedisConnection<byte[], byte[]> connection = pool.borrowObject()) {
            RedisCommands<byte[], byte[]> commands = connection.sync();
            commands.multi();
            commands.lpush(key.getBytes(), SerializeUtil.serialize(value));
            commands.exec();
        } catch (Exception ex) {
            throw Exceptions.unchecked(ex);
        }
    }



}
