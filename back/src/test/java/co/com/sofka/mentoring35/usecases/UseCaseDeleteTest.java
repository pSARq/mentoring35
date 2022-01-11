package co.com.sofka.mentoring35.usecases;

import co.com.sofka.mentoring35.mappers.Mapper;
import co.com.sofka.mentoring35.repositories.RandomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class UseCaseDeleteTest {

    RandomRepository randomRepository;
    UseCaseDelete useCaseDelete;

    @BeforeEach
    public void setup(){
        Mapper mapper = new Mapper();
        randomRepository = mock(RandomRepository.class);
        useCaseDelete = new UseCaseDelete(randomRepository, mapper);
    }

    @Test
    void delete() {

        when(randomRepository.deleteById("idRequest")).thenReturn(Mono.empty());

        StepVerifier.create(useCaseDelete.apply("idRequest"))
                .verifyComplete();

        verify(randomRepository).deleteById("idRequest");
    }
}