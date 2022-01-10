package co.com.sofka.mentoring35.mappers;

import co.com.sofka.mentoring35.collections.Random;
import co.com.sofka.mentoring35.models.RequestDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class Mapper {

    public Function<RequestDTO, Random> mapperToRandom(){
        return updateRandom -> {
            Random random = new Random();
            random.setId(updateRandom.getId());
            random.setOrginalList(updateRandom.getOrginalList());
            return random;
        };
    }

    public Function<Random, RequestDTO> mapEntityToRequest(){
        return entity -> new RequestDTO(
                entity.getId(),
                entity.getOrginalList()
        );
    }
}
