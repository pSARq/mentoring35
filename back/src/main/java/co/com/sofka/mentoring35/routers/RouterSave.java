package co.com.sofka.mentoring35.routers;

import co.com.sofka.mentoring35.models.RequestDTO;
import co.com.sofka.mentoring35.usecases.UseCaseSave;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterSave {

    @Bean
    public RouterFunction<ServerResponse> save(UseCaseSave useCaseSave){
        return route(POST("/random/save").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RequestDTO.class)
                        .flatMap(saveRequestDTO -> useCaseSave.apply(saveRequestDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.TEXT_PLAIN)
                                        .bodyValue(result)))
                        .onErrorResume(throwable -> ServerResponse.badRequest().body(throwable.getMessage(), String.class))
        );
    }
}
