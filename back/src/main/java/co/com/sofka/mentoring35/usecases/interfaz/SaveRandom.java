package co.com.sofka.mentoring35.usecases.interfaz;

import co.com.sofka.mentoring35.models.RequestDTO;
import reactor.core.publisher.Mono;
import javax.validation.Valid;

@FunctionalInterface
public interface SaveRandom {
    Mono<String> apply(@Valid RequestDTO dto);
}
