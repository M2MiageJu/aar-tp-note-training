package imis.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fonction {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFonction;

    private String intituleFonction;

    public Fonction(){}

    public Fonction(Long idFonction, String intituleFonction) {
        this.idFonction = idFonction;
        this.intituleFonction = intituleFonction;
    }

}
