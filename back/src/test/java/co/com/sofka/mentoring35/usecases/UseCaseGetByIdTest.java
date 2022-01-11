package co.com.sofka.mentoring35.usecases;

import co.com.sofka.mentoring35.collections.Random;
import co.com.sofka.mentoring35.mappers.Mapper;
import co.com.sofka.mentoring35.repositories.RandomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class UseCaseGetByIdTest {

    RandomRepository randomRepository;
    UseCaseGetById useCaseGetById;

    @BeforeEach
    public void setup(){
        Mapper mapper = new Mapper();
        randomRepository = mock(RandomRepository.class);
        useCaseGetById = new UseCaseGetById(randomRepository, mapper);
    }

    @Test
    void getById() {
        Random random = new Random();
        random.setId("idRequest");
        random.setDate("2022/01/10 15:38:12");
        random.setOrginalList("hola, mundo, que");
        random.setRandomList("que, hola, mundo");

        when(randomRepository.findById("idRequest")).thenReturn(Mono.just(random));

        StepVerifier.create(useCaseGetById.apply("idRequest"))
                .expectNextMatches(requestDTO ->{
                    assert requestDTO.getId().equals("idRequest");
                    assert requestDTO.getDate().equals("2022/01/10 15:38:12");
                    assert requestDTO.getOrginalList().equals("hola, mundo, que");
                    assert requestDTO.getRandomList().equals("que, hola, mundo");
                    return true;
                })
                .verifyComplete();

        verify(randomRepository).findById("idRequest");
    }
}