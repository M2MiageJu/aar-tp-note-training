package imis.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fonction {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFonction;

    @OneToMany(mappedBy = "fonction", cascade = CascadeType.ALL)
    private List<Contact>contacts = new ArrayList<>();

    private String intituleFonction;

    public Fonction(){}

    public Fonction(String intituleFonction) {
        this.intituleFonction = intituleFonction;
    }

    public Long getIdFonction() {
        return idFonction;
    }

    public void setIdFonction(Long idFonction) {
        this.idFonction = idFonction;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getIntituleFonction() {
        return intituleFonction;
    }

    public void setIntituleFonction(String intituleFonction) {
        this.intituleFonction = intituleFonction;
    }
}
