package microservice.repositories;

import microservice.beans.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CardRepository {

//    This is where I should be using JDBC or something to get the real data
    public List<Card> getCards(List<Integer> cardIdList) {
        Card sampleCard = new Card(
                0L,
                "sampleName",
                "sampleType",
                "sampleFaction"
        );

        List<Card> cardList = new ArrayList<>();
        cardList.add(sampleCard);

        return cardList;
    }
}
