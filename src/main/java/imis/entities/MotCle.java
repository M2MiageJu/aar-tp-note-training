package imis.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MotCle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @OneToMany(mappedBy = "motcle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Entreprise> entreprises = new ArrayList<>();

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<Entreprise> getEntreprises() {
        return entreprises;
    }

    public void setEntreprises(List<Entreprise> entreprises) {
        this.entreprises = entreprises;
    }
}
