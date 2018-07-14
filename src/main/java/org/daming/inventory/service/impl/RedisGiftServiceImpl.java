package org.daming.inventory.service.impl;

import org.daming.inventory.constants.CommonConstants;
import org.daming.inventory.dao.GiftDao;
import org.daming.inventory.pojo.RedisGift;
import org.daming.inventory.service.RedisGiftService;
import org.daming.inventory.service.RedisService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Objects;
import java.util.Optional;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-10 22:44
 */
@Service
public class RedisGiftServiceImpl implements RedisGiftService {

    private RedisService redisService;
    private GiftDao giftDao;

    @Override
    public Optional<RedisGift> getGift(int id) {
        Object object = redisService.get(String.format(CommonConstants.KEY_GIFT, id));
        if (Objects.nonNull(object) && object instanceof  RedisGift) {
            return Optional.of((RedisGift)object);
        } else {
            RedisGift redisGift = RedisGift.build(giftDao.get(id));
            redisGift.setNewFlag(true);
            saveGift(redisGift);
            return Optional.ofNullable(redisGift);
        }
    }

    @Override
    public void saveGift(RedisGift gift) {
        Assert.notNull(gift, "'gift' is required");
        redisService.set(String.format(CommonConstants.KEY_GIFT, gift.getId()), gift);
    }

    public RedisGiftServiceImpl(RedisService redisService, GiftDao giftDao) {
        super();
        this.redisService = redisService;
        this.giftDao = giftDao;
    }
}
