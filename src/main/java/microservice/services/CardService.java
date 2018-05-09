package microservice.services;

import microservice.beans.Card;
import microservice.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    private CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getCards(List<Integer> cardIdList) {
        return cardRepository.getCards(cardIdList);
    }
}
