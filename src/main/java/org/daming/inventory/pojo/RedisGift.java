package org.daming.inventory.pojo;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-10 20:42
 */
public class RedisGift extends Gift {
    private static final long serialVersionUID = -4311380597619942034L;

    private boolean newFlag;

    private boolean updateFlag;

    public boolean isNewFlag() {
        return newFlag;
    }

    public RedisGift setNewFlag(boolean newFlag) {
        this.newFlag = newFlag;
        return this;
    }

    public boolean isUpdateFlag() {
        return updateFlag;
    }

    public RedisGift setUpdateFlag(boolean updateFlag) {
        this.updateFlag = updateFlag;
        return this;
    }

    public RedisGift() {
        super();
    }

    public static RedisGift build(Gift gift) {
        RedisGift redisGift = new RedisGift();
        redisGift.setId(gift.getId());
        redisGift.setCode(gift.getCode());
        redisGift.setName(gift.getName());
        redisGift.setNum(gift.getNum());
        return redisGift;
    }
}
