package imis.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Personne {

    @Id
    @GeneratedValue
    private Long idPersonne;

    private String nomPersonne;
    private String prenomPersonne;

    public Personne(){}

    public Personne(String nomPersonne, String prenomPersonne, String email) {
        this.nomPersonne = nomPersonne;
        this.prenomPersonne = prenomPersonne;
        this.email = email;
    }

    public String getNom() {
        return nomPersonne;
    }

    public void setNom(String nomPersonne) {
        this.nomPersonne = nomPersonne;
    }

    public String getPrenom() {
        return prenomPersonne;
    }

    public void setPrenom(String prenomPersonne) {
        this.prenomPersonne = prenomPersonne;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public Long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Long idPersonne) {
        this.idPersonne = idPersonne;
    }
}
