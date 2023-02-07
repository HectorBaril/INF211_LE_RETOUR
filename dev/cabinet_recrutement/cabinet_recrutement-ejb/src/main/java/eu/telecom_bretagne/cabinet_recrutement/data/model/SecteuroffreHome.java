package eu.telecom_bretagne.cabinet_recrutement.data.model;
// Generated Feb 7, 2023, 10:28:42 AM by Hibernate Tools 5.4.20.Final


import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Home object for domain model class Secteuroffre.
 * @see eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuroffre
 * @author Hibernate Tools
 */
@Stateless
public class SecteuroffreHome {

    private static final Logger logger = Logger.getLogger(SecteuroffreHome.class.getName());

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Secteuroffre transientInstance) {
        logger.log(Level.INFO, "persisting Secteuroffre instance");
        try {
            entityManager.persist(transientInstance);
            logger.log(Level.INFO, "persist successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "persist failed", re);
            throw re;
        }
    }
    
    public void remove(Secteuroffre persistentInstance) {
        logger.log(Level.INFO, "removing Secteuroffre instance");
        try {
            entityManager.remove(persistentInstance);
            logger.log(Level.INFO, "remove successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "remove failed", re);
            throw re;
        }
    }
    
    public Secteuroffre merge(Secteuroffre detachedInstance) {
        logger.log(Level.INFO, "merging Secteuroffre instance");
        try {
            Secteuroffre result = entityManager.merge(detachedInstance);
            logger.log(Level.INFO, "merge successful");
            return result;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "merge failed", re);
            throw re;
        }
    }
    
    public Secteuroffre findById( SecteuroffreId id) {
        logger.log(Level.INFO, "getting Secteuroffre instance with id: " + id);
        try {
            Secteuroffre instance = entityManager.find(Secteuroffre.class, id);
            logger.log(Level.INFO, "get successful");
            return instance;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }
}

