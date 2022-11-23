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
        MotCle motCle = new MotCle();
        Contact contact = new Contact();
        Vente vente = new Vente();
        Entreprise entreprise = new Entreprise(nom, siret, adresse);
        entreprise.getVentes().add(vente);
        entreprise.getContacts().add(contact);
        entreprise.getMotCles().add(motCle);
        em.getTransaction().begin();
        em.persist(entreprise);
        em.getTransaction().commit();
    }

    @Transactional
    public void nouvelleFonction(String intitule){
        Fonction fonction = new Fonction(intitule);
        em.getTransaction().begin();
        em.persist(fonction);
        em.getTransaction().commit();
    }

    @Transactional
    public void nouveauxContact(String nom, String prenom, String email, String telephone, Entreprise entreprise, Fonction fonction){
        Contact contact = new Contact(nom, prenom, email, telephone);
        contact.setEntreprise(entreprise);
        contact.setFonction(fonction);
        em.getTransaction().begin();
        em.persist(contact);
        em.getTransaction().commit();
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
        Query q=em.createQuery("SELECT e FROM Entreprise e WHERE e.motCles =:motcle").setParameter("motcle", mcle);
        q.setHint("javax.persistence.loadgraph",eg);
        return q.getResultList();
    }

    public List<EntrepriseDto> getEntrepriseMotCle(String mcle){
        List<Entreprise> entreprises = findEntrepriseMotCleEntityGraph(mcle);
        return entreprises.stream().map(e -> new EntrepriseDto(e)).collect(Collectors.toCollection(ArrayList::new));
    }

    public EntrepriseDto getEntreprisePlusCont(){
        Entreprise entreprise = (Entreprise) em.createQuery("SELECT e FROM Entreprise e HAVING MAX(e.contacts)").getSingleResult();
        return new EntrepriseDto(entreprise);
    }

}
