package co.com.sofka.mentoring35.repositories;

import co.com.sofka.mentoring35.collections.Random;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandomRepository extends ReactiveCrudRepository<Random, String> {
    
}
