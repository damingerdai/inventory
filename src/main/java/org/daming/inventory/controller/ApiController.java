package org.daming.inventory.controller;

import org.daming.inventory.pojo.RedisGift;
import org.daming.inventory.service.GiftService;
import org.daming.inventory.service.RedisGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-11 21:22
 */
@RestController
@RequestMapping(path ="api/v1")
public class ApiController {

    @Autowired
    private RedisGiftService redisGiftService;
    @Autowired
    private GiftService giftService;

    @GetMapping(path = "gift/{id}")
    public Mono<RedisGift> get(@PathVariable int id) {
        return Mono.justOrEmpty(redisGiftService.getGift(id));
    }

    @GetMapping(path = "gift")
    public Flux<RedisGift> list() {
        return Flux.fromStream(giftService.list().stream().map(RedisGift::build));
    }

}
