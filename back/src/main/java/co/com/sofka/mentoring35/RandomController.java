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


    @GetMapping("/get/{id}")
    public Mono<Random> getById(@PathVariable String id){
        return randomRepository.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteById(@PathVariable String id){
        return randomRepository.deleteById(id);
    }
}
