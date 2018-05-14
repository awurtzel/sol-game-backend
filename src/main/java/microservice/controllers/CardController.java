package microservice.controllers;

import microservice.beans.Card;
import microservice.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @RequestMapping(
            value = "/card",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    public Card card() {
        List<Long> cardIdList = new ArrayList<>();
        cardIdList.add(1L);

        return cardService.getCards(cardIdList).get(0);
    }

    @RequestMapping(
            value = "/cardList",
            produces = { MediaType.APPLICATION_JSON_VALUE },
            method = RequestMethod.GET)
    public List<Card> cardList() {
        List<Long> cardIdList = new ArrayList<>();
        cardIdList.add(1L);

        return cardService.getCards(cardIdList);
    }
}
