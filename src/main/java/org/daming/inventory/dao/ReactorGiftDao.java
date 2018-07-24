package org.daming.inventory.dao;

import org.daming.inventory.pojo.Gift;
import org.daming.inventory.pojo.PageInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 描述： 响应式GiftDao
 *
 * @author daming
 * @date 2018-07-14 20:11
 */
public interface ReactorGiftDao {

    Mono<Gift> get(int id);

    Mono<Integer> add(Gift gift);

    Mono<Integer> update(Gift gift);

    Flux<Gift> list();

    Flux<Gift> like(String name, int pageNo, int pageSize);

    Mono<Integer> delete(int id);

    Mono<Integer> updateInventory(int id, int num);

    Mono<PageInfo> getPageInfo(String name, int pageNo, int pageSize);
}
