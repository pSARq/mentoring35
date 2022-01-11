package co.com.sofka.mentoring35.routers;

import co.com.sofka.mentoring35.models.RequestDTO;
import co.com.sofka.mentoring35.usecases.UseCaseUpdate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@CrossOrigin(origins = "http://localhost:3000")
@Configuration
public class RouterUpdate {

    @Bean
    public RouterFunction<ServerResponse> update(UseCaseUpdate useCaseUpdate){
        return route(PUT("/random/update").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RequestDTO.class)
                        .flatMap(requestDTO -> useCaseUpdate.apply(requestDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.TEXT_PLAIN)
                                        .bodyValue(result)))
                        .onErrorResume(throwable -> ServerResponse.badRequest().body(throwable.getMessage(), String.class))
        );
    }
}
