package imis.dtos;

import imis.entities.Entreprise;
import imis.entities.MotCle;

public class EntrepriseDto {

    private Long id;

    private String nom;

    private String siret;

    private String adresse;

    private MotCle motCle;

    public EntrepriseDto(){}

    public EntrepriseDto(Long id, String nom, String siret, String adresse, MotCle motCle) {
        this.id = id;
        this.nom = nom;
        this.siret = siret;
        this.adresse = adresse;
        this.motCle = motCle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public MotCle getMotCle() {
        return motCle;
    }

    public void setMotCle(MotCle motCle) {
        this.motCle = motCle;
    }
}
