/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usd.csci.manufacturer;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Joseph
 */
public abstract class AbstractFacade<T> {

    static private ManufacturerEntity manufacturer;
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    // Required to Override in derived class
    protected abstract EntityManager getEntityManager();

    // Edited ...
    public void create(T entity) throws InvalidEntityException {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) throws InvalidEntityException {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) throws InvalidEntityException {
        
        return getEntityManager().find(entityClass, id);

    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
//    public ManufacturerEntity findName(String name) throws InvalidEntityException{
//        if(name == null){
//            throw new InvalidEntityException("FindByName parameter name cannot be null");
//        }
//        // Create naned query
//        TypedQuery<ManufacturerEntity> query = em.
//    }

}
