package org.daming.inventory.handler;

import org.daming.inventory.pojo.Gift;
import org.daming.inventory.service.RedisGiftService;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * 描述： 礼品处理器
 *
 * @author daming
 * @date 2018-07-07 23:21
 */
@Component
public class GiftHandler {

    private RedisGiftService redisGiftService;

    public Mono<ServerResponse> getGift(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok().contentType(APPLICATION_JSON_UTF8)
                .body(Mono.just(redisGiftService.getGift(Integer.parseInt(id)).get()), Gift.class);
    }

//    public Mono<ServerResponse> listGift(ServerRequest request) {
//
//    }


    public GiftHandler(RedisGiftService redisGiftService) {
        super();
        this.redisGiftService = redisGiftService;
    }
}
