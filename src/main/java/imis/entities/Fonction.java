package imis.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fonction {

    @Id @GeneratedValue
    private Long idFonction;

    @OneToMany(mappedBy = "fonction", orphanRemoval = true)
    private List<Contact>contacts;

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
