package imis.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Echange {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateEchange;

    private String compteRendu;

    @ManyToOne
    private Entreprise entreprise;

    @ManyToMany(mappedBy = "echange", cascade = CascadeType.ALL)
    private List<Employe>employes = new ArrayList<>();

    @ManyToMany(mappedBy = "echange", cascade = CascadeType.ALL)
    private List<Contact>contacts = new ArrayList<>();

    public Echange(){}
    public Echange(Date dateEchange, String compteRendu, Entreprise entreprise) {
        this.dateEchange = dateEchange;
        this.compteRendu = compteRendu;
        this.entreprise = entreprise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateEchange() {
        return dateEchange;
    }

    public void setDateEchange(Date dateEchange) {
        this.dateEchange = dateEchange;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
