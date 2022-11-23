package imis.services;

import imis.dtos.EntrepriseDto;
import imis.entities.Contact;
import imis.entities.Entreprise;
import imis.entities.Fonction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Facade {


    @PersistenceContext
    EntityManager em;

    @Transactional
    public void nouveauEnt(){
       Entreprise entreprise = new Entreprise();
    }

    @Transactional
    public void nouvelleFonction(){
        Fonction fonction = new Fonction();
    }

    @Transactional
    public void nouveauxContact(){
        
    }

    public Collection<Entreprise> getAllEntreprise(){
        return  em.createQuery("SELECT e FROM Entreprise e").getResultList();
    }

    public Collection<Fonction> getAllFonction(){
        return  em.createQuery("SELECT f FROM Fonction f").getResultList();
    }

    public List<Entreprise> findEntrepriseMotCleEntityGraph(String mcle){
        EntityGraph<Entreprise> eg=em.createEntityGraph(Entreprise.class);
        eg.addSubgraph("motCle");
        Query q=em.createQuery("SELECT e FROM Entreprise e WHERE e.motCle =:motcle").setParameter("motcle", mcle);
        q.setHint("javax.persistence.loadgraph",eg);
        return q.getResultList();
    }

    public List<EntrepriseDto> getEntrepriseMotCle(String mcle){
        List<Entreprise> entreprises = findEntrepriseMotCleEntityGraph(mcle);
        return entreprises.stream().map(e -> new EntrepriseDto(e.getId(), e.getNom(), e.getSiret(), e.getAdresse(), e.getMotCle())).collect(Collectors.toCollection(ArrayList::new));
    }


    public EntrepriseDto getEntreprisePlusCont(){
        Entreprise entreprise = (Entreprise) em.createQuery("SELECT e FROM Entreprise e HAVING MAX(e.contacts)").getSingleResult();
        return new EntrepriseDto(entreprise.getId(), entreprise.getNom(), entreprise.getSiret(), entreprise.getAdresse(), entreprise.getMotCle());
    }

}
