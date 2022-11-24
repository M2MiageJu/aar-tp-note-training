package imis.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contact extends Personne {

    private String numTelephone;

    @ManyToOne(cascade = CascadeType.ALL)
    private Entreprise entrepriseContact;

    @ManyToOne(cascade = CascadeType.ALL)
    private Fonction fonction;

    @ManyToMany
    private List<Echange>echanges;

    public Contact() {
    }

    public Contact(String nom, String prenom, String email, String numTelephone) {
        super(nom, prenom, email);
        this.numTelephone = numTelephone;
    }

    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }

    public Entreprise getEntreprise() {
        return entrepriseContact;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entrepriseContact = entreprise;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

    public List<Echange> getEchanges() {
        return echanges;
    }

    public void setEchanges(List<Echange> echanges) {
        this.echanges = echanges;
    }
}
