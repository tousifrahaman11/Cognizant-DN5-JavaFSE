package com.cognizant.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * Global Filter (as specified in docx step 21).
 * Logs all incoming requests passing through the API Gateway.
 */
@Component
public class LogFilter implements GlobalFilter {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {
        LOGGER.info("API Gateway received request: {}",
                exchange.getRequest().getURI());
        return chain.filter(exchange);
    }
}