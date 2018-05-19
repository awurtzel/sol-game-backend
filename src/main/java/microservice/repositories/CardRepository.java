package microservice.repositories;

import microservice.beans.Card;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CardRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Card> getStubCards(List<Integer> cardIdList) {
        Card sampleCard = new Card(
                "sampleName",
                "sampleType",
                "sampleFaction"
        );

        List<Card> cardList = new ArrayList<>();
        cardList.add(sampleCard);

        return cardList;
    }

    public List<Card> getCards(List<Long> cardIdList) {
        List<Card> cardList = new ArrayList<>();
        cardList.add(entityManager.find(Card.class, cardIdList.get(0)));
        return cardList;
    }

    @SuppressWarnings("unchecked")
    public List<Card> getAllCards() {
        return entityManager.createQuery("Select t from Card t").getResultList();
    }

    public long insertCard(Card card) {
        entityManager.persist(card);

        return card.getId();
    }
}
