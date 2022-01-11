package co.com.sofka.mentoring35.usecases;

import co.com.sofka.mentoring35.collections.Random;
import co.com.sofka.mentoring35.mappers.Mapper;
import co.com.sofka.mentoring35.models.RequestDTO;
import co.com.sofka.mentoring35.repositories.RandomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UseCaseSaveTest {

    RandomRepository randomRepository;
    UseCaseSave useCaseSave;

    @BeforeEach
    public void setup(){
        Mapper mapper = new Mapper();
        randomRepository = mock(RandomRepository.class);
        useCaseSave = new UseCaseSave(randomRepository, mapper);
    }

    @Test
    void save() {
        Random random = new Random();
        random.setId("idRequet");
        random.setDate("2022/01/10 15:38:12");
        random.setOrginalList("hola, mundo, que");
        random.setRandomList("que, hola, mundo");

        RequestDTO dto = new RequestDTO();
        dto.setOrginalList("hola, mundo, que");

        when(randomRepository.save(any())).thenReturn(Mono.just(random));

        StepVerifier.create(useCaseSave.apply(dto))
                .expectNextMatches(id ->{
                    assert id.equals("idRequet");
                    return true;
                })
                .verifyComplete();

        verify(randomRepository).save(any());
    }

}