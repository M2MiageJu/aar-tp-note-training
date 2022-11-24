package imis.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class MotCle {
    @Id @GeneratedValue
    private String idMotCle;

    @ManyToMany
    private List<Entreprise>entreprisesMotCles;

    public MotCle() {}

    public MotCle(String id) {
        this.idMotCle = id;
    }

    public String getId() {
        return idMotCle;
    }

    public void setId(String id) {
        this.idMotCle = id;
    }

    public List<Entreprise> getEntreprises() {
        return entreprisesMotCles;
    }

    public void setEntreprises(List<Entreprise> entreprises) {
        this.entreprisesMotCles = entreprises;
    }
}
