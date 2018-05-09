package microservice.beans;

import lombok.Data;

@Data
public class Card {
    private Long id;
    private String name;
    private String type;
    private String faction;

    public Card(Long id, String name, String type, String faction) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.faction = faction;
    }
}
