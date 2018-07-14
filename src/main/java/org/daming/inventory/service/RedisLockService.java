package org.daming.inventory.service;

/**
 * 描述： reids锁
 *
 * @author daming
 * @date 2018-07-08 22:44
 */
public interface RedisLockService {

    boolean acquireLock(String lockName, long acquireTimeout);

    boolean acquireLock(String lockName, long acquireTimeout, long expiresTime);

    void unlock(String lockName);
}
