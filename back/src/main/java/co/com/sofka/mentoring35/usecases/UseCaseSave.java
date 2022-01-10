package co.com.sofka.mentoring35.usecases;

import co.com.sofka.mentoring35.collections.Random;
import co.com.sofka.mentoring35.mappers.Mapper;
import co.com.sofka.mentoring35.models.RequestDTO;
import co.com.sofka.mentoring35.repositories.RandomRepository;
import co.com.sofka.mentoring35.usecases.interfaz.SaveRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Validated
public class UseCaseSave implements SaveRandom {

    private final RandomRepository randomRepository;
    private final Mapper mapper;

    @Autowired
    public UseCaseSave(RandomRepository randomRepository, Mapper mapper) {
        this.randomRepository = randomRepository;
        this.mapper = mapper;
    }

    @Override
    public Mono<String> apply(RequestDTO dto) {
        Random random = mapper.mapperToRandom().apply(dto);
        return Mono.just(random)
                .map(getOrginalList(random))
                .map(getRandomList(random))
                .flatMap(randomRepository::save)
                        .map(Random::getId);
    }

    private Function<Random, Random> getOrginalList(Random random) {
        return entity -> {
            entity.setDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));
            entity.setOrginalList(random.getOrginalList());
            return entity;
        };
    }

    private Function<Random, Random> getRandomList(Random random) {
        return entity -> {
            List<String> list = Stream.of(random.getOrginalList().replaceAll(",", "\n").split("[\n]"))
                    .map(p -> p.trim())
                    .collect(Collectors.toList());
            Collections.shuffle(list);
            String randomList = list.stream().collect(Collectors.joining("\n"));
            entity.setRandomList(randomList);
            return entity;
        };
    }
}
