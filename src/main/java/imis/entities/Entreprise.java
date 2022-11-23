package imis.entities;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Entreprise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String siret;

    private String adresse;

    @ManyToOne
    private MotCle motCle;

    @OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();

    public Entreprise(){}

    public Entreprise(Long id, String nom, String siret, String adresse, MotCle motCle) {
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
