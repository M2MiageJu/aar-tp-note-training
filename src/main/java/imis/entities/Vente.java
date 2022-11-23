package imis.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateVente;

    private double montant;

    private String nature;

    @ManyToOne
    private Entreprise entreprise;

    public Vente(){}

    public Vente(Long id, Date dateVente, double montant, String nature, Entreprise entreprise) {
        this.id = id;
        this.dateVente = dateVente;
        this.montant = montant;
        this.nature = nature;
        this.entreprise = entreprise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
}
