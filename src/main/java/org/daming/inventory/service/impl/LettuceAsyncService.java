package org.daming.inventory.service.impl;

import org.daming.inventory.service.RedisService;
import org.springframework.stereotype.Service;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-08 22:32
 */
@Service
public class LettuceAsyncService implements RedisService {

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public void set(String key, Object value) {

    }

    @Override
    public void set(String key, Object value, long expireSeconds) {

    }

    @Override
    public void del(String key) {

    }

    @Override
    public void expire(String key, long seconds) {

    }

    @Override
    public void pexpire(String key, long millisSeconds) {

    }

    @Override
    public void lpush(String key, String value) {

    }
}
