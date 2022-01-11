package co.com.sofka.mentoring35.usecases;

import co.com.sofka.mentoring35.collections.Random;
import co.com.sofka.mentoring35.mappers.Mapper;
import co.com.sofka.mentoring35.repositories.RandomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class UseCaseGetAllTest {

    RandomRepository randomRepository;
    UseCaseGetAll useCaseGetAll;

    @BeforeEach
    public void setup(){
        Mapper mapper = new Mapper();
        randomRepository = mock(RandomRepository.class);
        useCaseGetAll = new UseCaseGetAll(randomRepository, mapper);
    }

    @Test
    void getAll() {
        Random random = new Random();
        random.setId("idRequet");
        random.setDate("2022/01/10 15:38:12");
        random.setOrginalList("hola, mundo, que");
        random.setRandomList("que, hola, mundo");


        when(randomRepository.findAll()).thenReturn(Flux.just(random));

        StepVerifier.create(useCaseGetAll.get())
                .expectNextMatches(requestDTO ->{
                    assert requestDTO.getId().equals("idRequet");
                    assert requestDTO.getDate().equals("2022/01/10 15:38:12");
                    assert requestDTO.getOrginalList().equals("hola, mundo, que");
                    assert requestDTO.getRandomList().equals("que, hola, mundo");
                    return true;
                })
                .verifyComplete();

        verify(randomRepository).findAll();
    }
}