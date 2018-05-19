package microservice.beans;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String faction;

    protected Card() {

    }

    public Card(String name, String type, String faction) {
        super();
        this.name = name;
        this.type = type;
        this.faction = faction;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type + '\'' +
                ", faction=" + faction +
                '}';
    }
}
