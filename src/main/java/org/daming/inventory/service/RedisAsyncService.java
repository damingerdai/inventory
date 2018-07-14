package org.daming.inventory.service;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-08 22:39
 */
public interface RedisAsyncService {

    Object getAsync(String key);

    void setAsync(String key, Object value);

    void setAsync(String key, Object value, long expireSeconds);

    void delAsync(String key);


}
