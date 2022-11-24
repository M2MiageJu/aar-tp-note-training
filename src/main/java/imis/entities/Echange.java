package imis.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Echange {

    @Id @GeneratedValue
    private Long idEchange;

    private Date dateEchange;

    private String compteRendu;

    @ManyToOne
    private Entreprise entrepriseEchange;

    @ManyToMany
    private List<Employe>employes;

    @ManyToMany
    private List<Contact>contacts;

    public Echange(){}
    public Echange(Date dateEchange, String compteRendu, Entreprise entreprise) {
        this.dateEchange = dateEchange;
        this.compteRendu = compteRendu;
        this.entrepriseEchange = entreprise;
    }

    public Long getId() {
        return idEchange;
    }

    public void setId(Long id) {
        this.idEchange = id;
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
        return entrepriseEchange;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entrepriseEchange = entreprise;
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
