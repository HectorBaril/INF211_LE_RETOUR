package eu.telecom_bretagne.cabinet_recrutement.data.model;
// Generated Feb 7, 2023, 10:28:42 AM by Hibernate Tools 5.4.20.Final


import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Home object for domain model class Offresemploi.
 * @see eu.telecom_bretagne.cabinet_recrutement.data.model.Offresemploi
 * @author Hibernate Tools
 */
@Stateless
public class OffresemploiHome {

    private static final Logger logger = Logger.getLogger(OffresemploiHome.class.getName());

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Offresemploi transientInstance) {
        logger.log(Level.INFO, "persisting Offresemploi instance");
        try {
            entityManager.persist(transientInstance);
            logger.log(Level.INFO, "persist successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "persist failed", re);
            throw re;
        }
    }
    
    public void remove(Offresemploi persistentInstance) {
        logger.log(Level.INFO, "removing Offresemploi instance");
        try {
            entityManager.remove(persistentInstance);
            logger.log(Level.INFO, "remove successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "remove failed", re);
            throw re;
        }
    }
    
    public Offresemploi merge(Offresemploi detachedInstance) {
        logger.log(Level.INFO, "merging Offresemploi instance");
        try {
            Offresemploi result = entityManager.merge(detachedInstance);
            logger.log(Level.INFO, "merge successful");
            return result;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "merge failed", re);
            throw re;
        }
    }
    
    public Offresemploi findById( int id) {
        logger.log(Level.INFO, "getting Offresemploi instance with id: " + id);
        try {
            Offresemploi instance = entityManager.find(Offresemploi.class, id);
            logger.log(Level.INFO, "get successful");
            return instance;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }
}

