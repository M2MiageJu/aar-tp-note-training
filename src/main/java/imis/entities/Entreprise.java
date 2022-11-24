package imis.entities;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Entreprise {
    @Id @GeneratedValue
    private Long id;

    private String nomEntreprise;

    private String siret;

    private String adresse;

    @ManyToMany
    private List<MotCle>motCles;

    @OneToMany(mappedBy = "entreprise", orphanRemoval = true)
    private List<Contact> contacts;

    @OneToMany(mappedBy = "entreprise")
    private List<Vente> ventes;

    @OneToMany(mappedBy = "entreprise")
    private List<Echange> echanges;

    public Entreprise(){}

    public Entreprise(String nomEntreprise, String siret, String adresse) {
        this.nomEntreprise = nomEntreprise;
        this.siret = siret;
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nomEntreprise;
    }

    public void setNom(String nom) {
        this.nomEntreprise = nom;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<MotCle> getMotCles() {
        return motCles;
    }

    public void setMotCles(List<MotCle> motCles) {
        this.motCles = motCles;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Vente> getVentes() {
        return ventes;
    }

    public void setVentes(List<Vente> ventes) {
        this.ventes = ventes;
    }
}
