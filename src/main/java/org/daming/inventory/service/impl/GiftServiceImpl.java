package org.daming.inventory.service.impl;

import org.daming.inventory.dao.GiftDao;
import org.daming.inventory.pojo.Gift;
import org.daming.inventory.service.GiftService;
import org.daming.inventory.service.RedisGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-10 22:24
 */
@Service
public class GiftServiceImpl implements GiftService {

    @Autowired
    private RedisGiftService redisGiftService;
    @Autowired
    private GiftDao giftDao;

    @Override
    public List<Gift> like(String name, int pageNo, int pageSize) {
        return giftDao.like(name, pageNo, pageSize);
    }

    @Override
    public List<Gift> list() {
        return giftDao.list();
    }
}
