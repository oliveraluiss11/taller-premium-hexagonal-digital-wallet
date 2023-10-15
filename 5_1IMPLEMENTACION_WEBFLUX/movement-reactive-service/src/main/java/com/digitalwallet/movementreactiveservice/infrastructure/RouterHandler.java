package com.digitalwallet.movementreactiveservice.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
@Configuration
public class RouterHandler {
    @Bean
    public RouterFunction<ServerResponse> route(MovementHandler handler) {
        return RouterFunctions.route(POST("/movements")
                        .and(accept(APPLICATION_JSON)), handler::createMovement)
                .andRoute(GET("/movements").and(queryParam("walletId", it -> true))
                        , handler::getMovementsByWalletId);
    }
}
