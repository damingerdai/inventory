package org.daming.inventory.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.PathMatchConfigurer;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.ViewResolverRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-14 23:27
 */
@Configuration
// @EnableWebFlux
public class WebConfig implements WebFluxConfigurer {

    public void configurePathMatching(PathMatchConfigurer configurer) {

    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/").addResourceLocations("classpath:static/index.html");
        registry.addResourceHandler("/**.html").addResourceLocations("classpath:static/index.html");
    }

    public void configureViewResolvers(ViewResolverRegistry registry) {

    }
}
