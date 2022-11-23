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
}
