package co.com.sofka.mentoring35.usecases;

import co.com.sofka.mentoring35.mappers.Mapper;
import co.com.sofka.mentoring35.repositories.RandomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class UseCaseDelete implements Function<String, Mono<Void>> {

    private final RandomRepository randomRepository;
    private final Mapper mapper;

    @Autowired
    public UseCaseDelete(RandomRepository randomRepository, Mapper mapper) {
        this.randomRepository = randomRepository;
        this.mapper = mapper;
    }


    @Override
    public Mono<Void> apply(String id) {
        Objects.requireNonNull(id, "El id no puede ser nulo");
        return randomRepository.deleteById(id);
    }
}
