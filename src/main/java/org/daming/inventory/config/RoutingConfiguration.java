package org.daming.inventory.config;

import org.daming.inventory.handler.GiftHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * 描述： 路由配置
 *
 * @author daming
 * @date 2018-07-07 23:14
 */
@Configuration
public class RoutingConfiguration {

    private GiftHandler giftHandler;

    @Bean
    public RouterFunction<ServerResponse> giftRouter() {
        return route(GET("/gift/{id}"), giftHandler::getGift);
    }


    public RoutingConfiguration(GiftHandler giftHandler) {
        this.giftHandler = giftHandler;
    }
}
