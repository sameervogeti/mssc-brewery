package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    private final BeerService beerService;

    public BeerController(BeerService beerService)
    {
        this.beerService=beerService;
    }
    @GetMapping({"/{beerId}"})
    ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId")UUID beerId)
    {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity handlePost(@Valid @RequestBody BeerDTO beerDTO)
    {
        BeerDTO savedDTO=beerService.saveBeer(beerDTO);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("location","/api/v1/beer"+savedDTO.getId().toString());
        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    ResponseEntity handlePut(@PathVariable("beerId")UUID beerId,@Valid @RequestBody BeerDTO beerDTO)
    {
        beerService.updateBeerByID(beerId,beerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("beerId")UUID beerId)
    {
        beerService.deleteBeerbyId(beerId);
    }
}
