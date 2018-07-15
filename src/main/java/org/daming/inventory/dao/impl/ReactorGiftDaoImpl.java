package org.daming.inventory.dao.impl;

import org.daming.inventory.dao.GiftDao;
import org.daming.inventory.dao.ReactorGiftDao;
import org.daming.inventory.pojo.Gift;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 描述： ReactorGiftDaoImpl
 *
 * @author daming
 * @date 2018-07-14 20:12
 */
@Repository
public class ReactorGiftDaoImpl implements ReactorGiftDao {

    private GiftDao giftDao;

    @Override
    public Mono<Gift> get(int id) {
        return Mono.justOrEmpty(giftDao.get(id));
    }

    @Override
    public Mono<Integer> add(Gift gift) {
        return Mono.just(giftDao.create(gift)).map(keyHolder -> keyHolder.getKey().intValue());
    }

    @Override
    public Flux<Gift> list() {
        return Flux.fromIterable(giftDao.list());
    }

    @Override
    public Flux<Gift> like(String name, int pageNo, int pageSize) {
        return Flux.fromIterable(giftDao.like(name, pageNo, pageSize));
    }

    @Override
    public Mono<Integer> delete(int id) {
        return Mono.just(giftDao.delete(giftDao.delete(id)));
    }

    public ReactorGiftDaoImpl(GiftDao giftDao) {
        super();
        this.giftDao = giftDao;
    }
}
