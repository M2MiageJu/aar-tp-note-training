package imis.dtos;

import imis.entities.Contact;
import imis.entities.Entreprise;
import imis.entities.MotCle;
import imis.entities.Vente;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseDto {

    private Long id;

    private String nom;

    private String siret;

    private String adresse;

    private List<MotCle> motCles = new ArrayList<>();

    private List<Contact> contacts = new ArrayList<>();

    private List<Vente> ventes = new ArrayList<>();

    public EntrepriseDto(){}

    public EntrepriseDto(Entreprise entreprise) {
        this.id = entreprise.getId();
        this.nom = entreprise.getNom();
        this.siret = entreprise.getSiret();
        this.adresse = entreprise.getAdresse();
        this.motCles = entreprise.getMotCles();
        this.contacts = entreprise.getContacts();
        this.ventes = entreprise.getVentes();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
