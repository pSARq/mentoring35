package co.com.sofka.mentoring35;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import co.com.sofka.mentoring35.collections.Random;
import co.com.sofka.mentoring35.models.RequestDTO;
import co.com.sofka.mentoring35.repositories.RandomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/random")
public class RandomController {

    private RandomRepository randomRepository;

    @Autowired
    public RandomController(RandomRepository randomRepository) {
        this.randomRepository = randomRepository;
    }



    @PutMapping("/update")
    public Mono<Random> update(@RequestBody RequestDTO request){
        return Mono.just(new Random()).map(entity -> {
            entity.setDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));
            entity.setOrginalList(request.getOrginalList());
            return entity;
        }).map(entity -> {
            List<String> list = Stream.of(request.getOrginalList().replaceAll(",", "\n").split("[\n]"))
                    .map(p -> p.trim())
                    .collect(Collectors.toList());
            Collections.shuffle(list);
            String randomList = list.stream().collect(Collectors.joining("\n"));
            entity.setRandomList(randomList);
            return entity;
        }).flatMap(randomRepository::save);
    }


    @GetMapping("/get/{id}")
    public Mono<Random> getById(@PathVariable String id){
        return randomRepository.findById(id);
    }

    @GetMapping("/get")
    public Flux<Random> get() {
        return randomRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteById(@PathVariable String id){
        return randomRepository.deleteById(id);
    }
}
