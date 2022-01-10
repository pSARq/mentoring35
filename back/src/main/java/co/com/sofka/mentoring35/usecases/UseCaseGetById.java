package co.com.sofka.mentoring35.usecases;

import co.com.sofka.mentoring35.mappers.Mapper;
import co.com.sofka.mentoring35.models.RequestDTO;
import co.com.sofka.mentoring35.repositories.RandomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class UseCaseGetById  implements Function<String, Mono<RequestDTO>> {

    private final RandomRepository randomRepository;
    private final Mapper mapper;

    @Autowired
    public UseCaseGetById(RandomRepository randomRepository, Mapper mapper) {
        this.randomRepository = randomRepository;
        this.mapper = mapper;
    }

    @Override
    public Mono<RequestDTO> apply(String id) {
        return randomRepository.findById(id)
                .map(mapper.mapEntityToRequest());
    }
}
