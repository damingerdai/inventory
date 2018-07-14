package org.daming.inventory.service.impl;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.daming.inventory.service.RedisLockService;
import org.daming.inventory.utils.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 描述： redis锁之luttuce实现
 *
 * @author daming
 * @date 2018-07-08 22:46
 */
@Service
public class LettuceLockService implements RedisLockService {

    private static final long DEFAULT_EXPIRE_TIME = 3L;

    private GenericObjectPool<StatefulRedisConnection<byte[], byte[]>> pool;

    @Override
    public boolean acquireLock(String lockName, long acquireTimeout) {
        return acquireLock(lockName, acquireTimeout, DEFAULT_EXPIRE_TIME);
    }

    @Override
    public boolean acquireLock(String lockName, long acquireTimeout, long expiresTime) {
        long in = System.currentTimeMillis();
        try (StatefulRedisConnection<byte[], byte[]> connection = pool.borrowObject()){
            RedisCommands<byte[], byte[]> commands = connection.sync();
            do {
                String result = commands.setex(lockName.getBytes(), expiresTime, "1".getBytes());
                if ("OK".equalsIgnoreCase(result)) {
                    return true;
                }
                if (acquireTimeout == 0L) {
                    break;
                }
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            } while ((System.currentTimeMillis() - in) < acquireTimeout);
        } catch (Exception ex) {
            throw Exceptions.unchecked(ex);
        }
        return false;
    }

    @Override
    public void unlock(String lockName) {
        try (StatefulRedisConnection<byte[], byte[]> connection = pool.borrowObject()){

        } catch (Exception ex) {
            throw Exceptions.unchecked(ex);
        }
    }

    @Autowired
    @Qualifier("lettucePool")
    public LettuceLockService setPool(GenericObjectPool<StatefulRedisConnection<byte[], byte[]>> pool) {
        this.pool = pool;
        return this;
    }
}
