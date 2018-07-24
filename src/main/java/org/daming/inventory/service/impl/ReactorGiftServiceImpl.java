package org.daming.inventory.service.impl;

import org.daming.inventory.dao.ReactorGiftDao;
import org.daming.inventory.pojo.Gift;
import org.daming.inventory.pojo.PageInfo;
import org.daming.inventory.pojo.response.CommonResponse;
import org.daming.inventory.pojo.response.DataResponse;
import org.daming.inventory.pojo.response.PageResponse;
import org.daming.inventory.service.ReactorGiftService;
import org.daming.inventory.service.RedisGiftService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-14 23:31
 */
@Service
public class ReactorGiftServiceImpl implements ReactorGiftService {

    private ReactorGiftDao reactorGiftDao;
    private RedisGiftService redisGiftService;

    @Override
    public Mono<CommonResponse> add(Gift gift) {
        return reactorGiftDao.add(gift).map(integer -> new CommonResponse());
    }

    @Override
    public Mono<CommonResponse> update(Gift gift) {
        return reactorGiftDao.update(gift).map(integer -> new CommonResponse());
    }

    @Override
    public Mono<DataResponse<Gift>> get(int id) {
        return Mono.justOrEmpty(redisGiftService.getGift(id)).map(this::giftDataResponse);
    }

    private DataResponse<Gift> giftDataResponse(Gift gift) {
        return new DataResponse<Gift>().setData(gift);
    }

    @Override
    public Mono<PageResponse<Gift>> list(String name, int pageNo, int pageSize) {
        return reactorGiftDao.like(name, pageNo, pageSize).collect(toList()).map(this::giftPageResponse)
                .flatMap(value -> reactorGiftDao.getPageInfo(name, pageNo, pageSize).map(value::setPageInfo));

    }

    private PageResponse<Gift> giftPageResponse(PageInfo pageInfo) {
        PageResponse<Gift> pageResponse = new PageResponse<>();
        pageResponse.setPageInfo(pageInfo);
        return pageResponse;
    }

    private PageResponse<Gift> giftPageResponse(List<Gift> gifts) {
        PageResponse<Gift> pageResponse = new PageResponse<>();
        pageResponse.setData(gifts);
        return pageResponse;
    }

    @Override
    public Mono<CommonResponse> delete(int id) {
        return reactorGiftDao.delete(id).map(integer -> new CommonResponse());
    }

    @Override
    public Mono<CommonResponse> updateInventory(int id, int num) {
        return reactorGiftDao.updateInventory(id, num > 0 ? num : 0).map(integer -> new CommonResponse());
    }

    public ReactorGiftServiceImpl(ReactorGiftDao reactorGiftDao, RedisGiftService redisGiftService) {
        super();
        this.reactorGiftDao = reactorGiftDao;
        this.redisGiftService = redisGiftService;
    }
}
