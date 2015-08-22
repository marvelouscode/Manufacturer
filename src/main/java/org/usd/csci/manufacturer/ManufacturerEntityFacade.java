/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usd.csci.manufacturer;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * This class has the following features: - A method to find a record by name -
 * A method to find a record by email - A method to return a list of records
 * with a given city and state It also overrides the default create and edit
 * methods in order to add more functionality.
 *
 * @author Joseph Mammo
 */
@Stateless
public class ManufacturerEntityFacade extends AbstractFacade<ManufacturerEntity> {

    // Connects to the database 
    @PersistenceContext(unitName = "org.usd.csci_Manufacturer_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     */
    public ManufacturerEntityFacade() {
        super(ManufacturerEntity.class);
    }

    /**
     *
     * @param name
     * @return
     * @throws InvalidEntityException
     */
    public ManufacturerEntity findByName(String name) throws InvalidEntityException {
        if (name == null) {
            throw new InvalidEntityException("FindByName parameter name cannot be null.");
        }

        // Create named query
        TypedQuery<ManufacturerEntity> query = em.createNamedQuery("Manufacturer.findByName", ManufacturerEntity.class);

        // set the parameter
        query.setParameter("name", name);

        return query.getSingleResult();
    }

    /**
     *
     * @param email
     * @return
     * @throws InvalidEntityException
     */
    public List<ManufacturerEntity> findByEmail(String email) throws InvalidEntityException {
        if (email == null) {
            throw new InvalidEntityException("FindByEmailparameter name cannot be null.");
        }

        // Create named query
        TypedQuery<ManufacturerEntity> query = em.createNamedQuery("Manufacturer.findByEmail", ManufacturerEntity.class);

        // set the parameter
        query.setParameter("email", email);

        return (List<ManufacturerEntity>) query.getSingleResult();
    }

    /**
     *
     * @param city
     * @param state
     * @return
     * @throws InvalidEntityException
     */
    public ManufacturerEntity findByCityAndState(String city, String state) throws InvalidEntityException {
        if (city == null) {
            throw new InvalidEntityException("FindByCity parameter name cannot be null.");
        }

        if (state == null) {
            throw new InvalidEntityException("FindByCity parameter name cannot be null.");
        }
        // Create named query
        TypedQuery<ManufacturerEntity> query = em.createNamedQuery("Manufacturer.findByCityAndState", ManufacturerEntity.class);

        // set the parameter
        query.setParameter("city", city);

        // set the parameter
        query.setParameter("state", state);
        return query.getSingleResult();
    }

    /**
     * This method verifies that the entity being created is not null and throws
     * InvalidEntityException if the entity is not null or is not unique.
     *
     * @param manufacturer
     * @throws InvalidEntityException
     */
    @Override
    public void create(ManufacturerEntity manufacturer) throws InvalidEntityException {
        if (manufacturer == null) {
            throw new InvalidEntityException("Create Manufacturer parameter cannot be null.");

        }
        ManufacturerEntity locEntity = find(manufacturer.getManufacturerId());
        if (locEntity != null) {
            throw new InvalidEntityException("Manufacturer id must be unique.");
        }

        locEntity = findByName(manufacturer.getName());
        if (locEntity != null) {
            throw new InvalidEntityException("Manufacturer name must be unique.");
        }

        locEntity = (ManufacturerEntity) findByEmail(manufacturer.getEmail());
        if (locEntity != null) {
            throw new InvalidEntityException("Manufacturer email must be unique.");
            // Check rep is set or not ...
        }
        
        if(manufacturer.getRep() == null){
            throw new InvalidEntityException("Rep is a required field.");
        }
        super.create(manufacturer);
    }

    /**
     * This class checks if the id, email, and name is unique before updating
     * and throws an InvalidEntityException if the record is not unique.
     *
     * @param manufacturer
     * @throws InvalidEntityException
     */
    @Override
    public void edit(ManufacturerEntity manufacturer) throws InvalidEntityException {
        if (manufacturer == null) {
            throw new InvalidEntityException("Create Manufacturer parameter cannot be null.");

        }
        ManufacturerEntity locEntity = find(manufacturer.getManufacturerId());
        if (locEntity != null) {
            throw new InvalidEntityException("Manufacturer id must be unique.");
        }

        locEntity = findByName(manufacturer.getName());
        if (locEntity != null) {
            throw new InvalidEntityException("Manufacturer name must be unique.");
        }

        locEntity = (ManufacturerEntity) findByEmail(manufacturer.getEmail());
        if (locEntity != null) {
            throw new InvalidEntityException("Manufacturer email must be unique.");
        }
        super.edit(manufacturer);
    }

}
