package co.com.sofka.mentoring35.usecases;

import co.com.sofka.mentoring35.mappers.Mapper;
import co.com.sofka.mentoring35.models.RequestDTO;
import co.com.sofka.mentoring35.repositories.RandomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class UseCaseGetAll implements Supplier<Flux<RequestDTO>> {

    private final RandomRepository randomRepository;
    private final Mapper mapper;

    @Autowired
    public UseCaseGetAll(RandomRepository randomRepository, Mapper mapper) {
        this.randomRepository = randomRepository;
        this.mapper = mapper;
    }

    @Override
    public Flux<RequestDTO> get() {
        return randomRepository.findAll()
                .map(mapper.mapEntityToRequest());
    }
}
