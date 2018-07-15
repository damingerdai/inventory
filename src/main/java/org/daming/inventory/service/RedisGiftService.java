package org.daming.inventory.service;

import org.daming.inventory.pojo.Gift;
import org.daming.inventory.pojo.RedisGift;

import java.util.Optional;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-10 22:43
 */
public interface RedisGiftService {

    Optional<RedisGift> getGift(int id);

    Gift doGetGift(int id);

    void saveGift(RedisGift gift);
}
