package imis.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employe extends Personne{

    @ManyToOne
    private ServiceInterne serviceInterne;

    @ManyToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<Echange>echanges = new ArrayList<>();

    public Employe() {
    }

    public Employe(String nom, String prenom, String email, ServiceInterne serviceInterne) {
        super(nom, prenom, email);
        this.serviceInterne = serviceInterne;
    }

    public ServiceInterne getServiceInterne() {
        return serviceInterne;
    }

    public void setServiceInterne(ServiceInterne serviceInterne) {
        this.serviceInterne = serviceInterne;
    }

    public List<Echange> getEchanges() {
        return echanges;
    }

    public void setEchanges(List<Echange> echanges) {
        this.echanges = echanges;
    }
}
