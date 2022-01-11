package co.com.sofka.mentoring35.routers;

import co.com.sofka.mentoring35.models.RequestDTO;
import co.com.sofka.mentoring35.usecases.UseCaseGetById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterGetById {

    @Bean
    public RouterFunction<ServerResponse> getById(UseCaseGetById useCaseGetById){
        return route(GET("/random/get/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseGetById.apply(
                                        request.pathVariable("id")), RequestDTO.class
                        )).onErrorResume(throwable -> ServerResponse.badRequest().body(throwable.getMessage(), String.class))
        );
    }
}
