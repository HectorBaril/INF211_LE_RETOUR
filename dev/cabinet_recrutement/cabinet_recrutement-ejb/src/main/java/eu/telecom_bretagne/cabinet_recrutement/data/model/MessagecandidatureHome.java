package eu.telecom_bretagne.cabinet_recrutement.data.model;
// Generated Feb 7, 2023, 10:28:42 AM by Hibernate Tools 5.4.20.Final


import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Home object for domain model class Messagecandidature.
 * @see eu.telecom_bretagne.cabinet_recrutement.data.model.Messagecandidature
 * @author Hibernate Tools
 */
@Stateless
public class MessagecandidatureHome {

    private static final Logger logger = Logger.getLogger(MessagecandidatureHome.class.getName());

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Messagecandidature transientInstance) {
        logger.log(Level.INFO, "persisting Messagecandidature instance");
        try {
            entityManager.persist(transientInstance);
            logger.log(Level.INFO, "persist successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "persist failed", re);
            throw re;
        }
    }
    
    public void remove(Messagecandidature persistentInstance) {
        logger.log(Level.INFO, "removing Messagecandidature instance");
        try {
            entityManager.remove(persistentInstance);
            logger.log(Level.INFO, "remove successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "remove failed", re);
            throw re;
        }
    }
    
    public Messagecandidature merge(Messagecandidature detachedInstance) {
        logger.log(Level.INFO, "merging Messagecandidature instance");
        try {
            Messagecandidature result = entityManager.merge(detachedInstance);
            logger.log(Level.INFO, "merge successful");
            return result;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "merge failed", re);
            throw re;
        }
    }
    
    public Messagecandidature findById( int id) {
        logger.log(Level.INFO, "getting Messagecandidature instance with id: " + id);
        try {
            Messagecandidature instance = entityManager.find(Messagecandidature.class, id);
            logger.log(Level.INFO, "get successful");
            return instance;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }
}

