package eu.telecom_bretagne.cabinet_recrutement.data.dao;
// Generated Feb 14, 2023, 4:23:56 PM by Hibernate Tools 5.4.20.Final


import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Secteurcandidat;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurcandidatId;

/**
 * Home object for domain model class Secteurcandidat.
 * @see eu.telecom_bretagne.cabinet_recrutement.data.model.Secteurcandidat
 * @author Hibernate Tools
 */
@Stateless
public class SecteurcandidatDAO {

    private static final Logger logger = Logger.getLogger(SecteurcandidatDAO.class.getName());

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Secteurcandidat transientInstance) {
        logger.log(Level.INFO, "persisting Secteurcandidat instance");
        try {
            entityManager.persist(transientInstance);
            logger.log(Level.INFO, "persist successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "persist failed", re);
            throw re;
        }
    }
    
    public void remove(Secteurcandidat persistentInstance) {
        logger.log(Level.INFO, "removing Secteurcandidat instance");
        try {
            entityManager.remove(persistentInstance);
            logger.log(Level.INFO, "remove successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "remove failed", re);
            throw re;
        }
    }
    
    public Secteurcandidat merge(Secteurcandidat detachedInstance) {
        logger.log(Level.INFO, "merging Secteurcandidat instance");
        try {
            Secteurcandidat result = entityManager.merge(detachedInstance);
            logger.log(Level.INFO, "merge successful");
            return result;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "merge failed", re);
            throw re;
        }
    }
    
    public Secteurcandidat findById( SecteurcandidatId id) {
        logger.log(Level.INFO, "getting Secteurcandidat instance with id: " + id);
        try {
            Secteurcandidat instance = entityManager.find(Secteurcandidat.class, id);
            logger.log(Level.INFO, "get successful");
            return instance;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }
}

