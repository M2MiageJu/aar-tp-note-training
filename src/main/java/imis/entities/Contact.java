package imis.entities;

import javax.persistence.ManyToOne;

public class Contact extends Personne {

    private String numTelephone;

    @ManyToOne
    private Entreprise entreprise;

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

}
