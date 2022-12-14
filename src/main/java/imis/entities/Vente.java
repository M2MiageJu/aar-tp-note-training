package imis.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vente {
    @Id
    @GeneratedValue
    private Long idVente;

    private Date dateVente;

    private double montant;

    private String nature;

    @ManyToOne
    private Entreprise entrepriseVente;

    public Vente(){}

    public Vente(Long id, Date dateVente, double montant, String nature, Entreprise entreprise) {
        this.idVente = id;
        this.dateVente = dateVente;
        this.montant = montant;
        this.nature = nature;
        this.entrepriseVente = entreprise;
    }

    public Long getId() {
        return idVente;
    }

    public void setId(Long id) {
        this.idVente = id;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Entreprise getEntreprise() {
        return entrepriseVente;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entrepriseVente = entreprise;
    }
}
