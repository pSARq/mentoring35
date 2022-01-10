package co.com.sofka.mentoring35.usecases;

import co.com.sofka.mentoring35.mappers.Mapper;
import co.com.sofka.mentoring35.repositories.RandomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class UseCaseDelete {

    private final RandomRepository randomRepository;
    private final Mapper mapper;

    @Autowired
    public UseCaseDelete(RandomRepository randomRepository, Mapper mapper) {
        this.randomRepository = randomRepository;
        this.mapper = mapper;
    }
}
