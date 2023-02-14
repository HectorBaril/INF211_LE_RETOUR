package eu.telecom_bretagne.cabinet_recrutement.data.dao;
// Generated Feb 14, 2023, 4:23:56 PM by Hibernate Tools 5.4.20.Final


import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuractivite;

/**
 * Home object for domain model class Secteuractivite.
 * @see eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuractivite
 * @author Hibernate Tools
 */
@Stateless
public class SecteuractiviteDAO {

    private static final Logger logger = Logger.getLogger(SecteuractiviteDAO.class.getName());

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Secteuractivite transientInstance) {
        logger.log(Level.INFO, "persisting Secteuractivite instance");
        try {
            entityManager.persist(transientInstance);
            logger.log(Level.INFO, "persist successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "persist failed", re);
            throw re;
        }
    }
    
    public void remove(Secteuractivite persistentInstance) {
        logger.log(Level.INFO, "removing Secteuractivite instance");
        try {
            entityManager.remove(persistentInstance);
            logger.log(Level.INFO, "remove successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "remove failed", re);
            throw re;
        }
    }
    
    public Secteuractivite merge(Secteuractivite detachedInstance) {
        logger.log(Level.INFO, "merging Secteuractivite instance");
        try {
            Secteuractivite result = entityManager.merge(detachedInstance);
            logger.log(Level.INFO, "merge successful");
            return result;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "merge failed", re);
            throw re;
        }
    }
    
    public Secteuractivite findById( int id) {
        logger.log(Level.INFO, "getting Secteuractivite instance with id: " + id);
        try {
            Secteuractivite instance = entityManager.find(Secteuractivite.class, id);
            logger.log(Level.INFO, "get successful");
            return instance;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }
}

