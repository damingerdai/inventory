package org.daming.inventory.service;

import java.util.List;

/**
 * 描述： RedisService
 *
 * @author daming
 * @date 2018-07-08 20:12
 */
public interface RedisService {

    Object get(String key);

    void set(String key, Object value);

    void set(String key, Object value, long expireSeconds);

    void del(String key);

    void expire(String key, long seconds);

    void pexpire(String key, long millisSeconds);

    void lpush(String key, String value);

}
