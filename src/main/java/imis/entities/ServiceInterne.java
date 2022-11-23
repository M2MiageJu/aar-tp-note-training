package imis.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ServiceInterne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomSi;

    public ServiceInterne(){}

    public ServiceInterne(Long id, String nomSi) {
        this.id = id;
        this.nomSi = nomSi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomSi() {
        return nomSi;
    }

    public void setNomSi(String nomSi) {
        this.nomSi = nomSi;
    }
}
