package imis.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ServiceInterne {

    @Id
    @GeneratedValue
    private Long idServiceInterne;

    private String nomSi;

    @OneToMany(mappedBy = "serviceInterne", cascade = CascadeType.ALL)
    private List<Employe>employes;

    public ServiceInterne(){}

    public ServiceInterne(String nomSi) {
        this.nomSi = nomSi;
    }

    public Long getId() {
        return idServiceInterne;
    }

    public void setId(Long id) {
        this.idServiceInterne = id;
    }

    public String getNomSi() {
        return nomSi;
    }

    public void setNomSi(String nomSi) {
        this.nomSi = nomSi;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
}
