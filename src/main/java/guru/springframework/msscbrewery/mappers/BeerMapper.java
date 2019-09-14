package guru.springframework.msscbrewery.mappers;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    BeerDTO beerToBeerdto(Beer beer);

    Beer beerDtoToBeer(BeerDTO beerDTO);
}
