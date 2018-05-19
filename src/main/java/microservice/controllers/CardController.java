package microservice.controllers;

import microservice.beans.Card;
import microservice.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class CardController {

    private final CardRepository cardRepository;

    @Autowired
    public CardController(CardRepository cardService) {
        this.cardRepository = cardService;
    }

    @RequestMapping(
            value = "/card",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    public Card card() {
        List<Long> cardIdList = new ArrayList<>();
        cardIdList.add(1L);

        return cardRepository.getCards(cardIdList).get(0);
    }

    @RequestMapping(
            value = "/cardList",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    public List<Card> cardList() {
        List<Long> cardIdList = new ArrayList<>();
        cardIdList.add(1L);

        return cardRepository.getCards(cardIdList);
    }

    @RequestMapping(
            value = "/cards",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    public List<Card> getAllCards() {
        return cardRepository.getAllCards();
    }

    @RequestMapping(
            value = "/cards",
            consumes = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.POST)
    public ResponseEntity<?> insertCard(@RequestBody Card card) {
        long cardId = cardRepository.insertCard(card);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cardId)
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
