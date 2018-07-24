package org.daming.inventory.service;

import org.daming.inventory.pojo.Gift;
import org.daming.inventory.pojo.response.CommonResponse;
import org.daming.inventory.pojo.response.DataResponse;
import org.daming.inventory.pojo.response.PageResponse;
import reactor.core.publisher.Mono;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-14 21:51
 */
public interface ReactorGiftService {

    Mono<CommonResponse> add(Gift gift);

    Mono<CommonResponse> update(Gift gift);

    Mono<DataResponse<Gift>> get(int id);

    Mono<PageResponse<Gift>> list(String name, int pageNo, int pageSize);

    Mono<CommonResponse> delete(int id);

    Mono<CommonResponse> updateInventory(int id, int num);
}
