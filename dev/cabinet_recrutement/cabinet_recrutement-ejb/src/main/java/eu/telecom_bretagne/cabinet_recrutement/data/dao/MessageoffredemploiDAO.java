package eu.telecom_bretagne.cabinet_recrutement.data.dao;
// Generated Feb 14, 2023, 4:23:56 PM by Hibernate Tools 5.4.20.Final


import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Messageoffredemploi;

/**
 * Home object for domain model class Messageoffredemploi.
 * @see eu.telecom_bretagne.cabinet_recrutement.data.model.Messageoffredemploi
 * @author Hibernate Tools
 */
@Stateless
public class MessageoffredemploiDAO {

    private static final Logger logger = Logger.getLogger(MessageoffredemploiDAO.class.getName());

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Messageoffredemploi transientInstance) {
        logger.log(Level.INFO, "persisting Messageoffredemploi instance");
        try {
            entityManager.persist(transientInstance);
            logger.log(Level.INFO, "persist successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "persist failed", re);
            throw re;
        }
    }
    
    public void remove(Messageoffredemploi persistentInstance) {
        logger.log(Level.INFO, "removing Messageoffredemploi instance");
        try {
            entityManager.remove(persistentInstance);
            logger.log(Level.INFO, "remove successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "remove failed", re);
            throw re;
        }
    }
    
    public Messageoffredemploi merge(Messageoffredemploi detachedInstance) {
        logger.log(Level.INFO, "merging Messageoffredemploi instance");
        try {
            Messageoffredemploi result = entityManager.merge(detachedInstance);
            logger.log(Level.INFO, "merge successful");
            return result;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "merge failed", re);
            throw re;
        }
    }
    
    public Messageoffredemploi findById( int id) {
        logger.log(Level.INFO, "getting Messageoffredemploi instance with id: " + id);
        try {
            Messageoffredemploi instance = entityManager.find(Messageoffredemploi.class, id);
            logger.log(Level.INFO, "get successful");
            return instance;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }
}

