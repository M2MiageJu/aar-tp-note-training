package imis.services;

import imis.dtos.EntrepriseDto;
import imis.entities.*;
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
    public void nouveauEnt(String nom, String siret, String adresse){
        Entreprise entreprise = new Entreprise(nom, siret, adresse);
        em.persist(entreprise);
    }

    @Transactional
    public void nouvelleFonction(String intitule){
        Fonction fonction = new Fonction(intitule);
        em.persist(fonction);
    }

    @Transactional
    public void nouveauxContact(String nom, String prenom, String email, String telephone, Entreprise entreprise, Fonction fonction){
        Contact contact = new Contact(nom, prenom, email, telephone);
        contact.setEntreprise(entreprise);
        contact.setFonction(fonction);
        em.persist(contact);
    }

    public Collection<Entreprise> getAllEntreprise(){
        return  em.createQuery("SELECT e FROM Entreprise e").getResultList();
    }

    public Collection<Fonction> getAllFonction(){
        return  em.createQuery("SELECT f FROM Fonction f").getResultList();
    }

    public List<Entreprise> findEntrepriseMotCleEntityGraph(String mcle){
        EntityGraph<Entreprise> eg=em.createEntityGraph(Entreprise.class);
        Query q=em.createQuery("SELECT e FROM Entreprise e WHERE e.nomEntreprise =:motcle OR e.adresse =:motcle").setParameter("motcle", mcle);
        q.setHint("javax.persistence.loadgraph",eg);
        return q.getResultList();
    }

    public List<EntrepriseDto> getEntrepriseMotCle(String mcle){
        List<Entreprise> entreprises = findEntrepriseMotCleEntityGraph(mcle);
        return entreprises.stream().map(EntrepriseDto::new).collect(Collectors.toCollection(ArrayList::new));
    }

    public EntrepriseDto getEntreprisePlusCont(){
        Entreprise entreprise = em.createQuery("SELECT e FROM Entreprise e ORDER BY SIZE(e.contacts) DESC", Entreprise.class)
                .setMaxResults(1)
                .getSingleResult();
        return new EntrepriseDto(entreprise);
    }

}
