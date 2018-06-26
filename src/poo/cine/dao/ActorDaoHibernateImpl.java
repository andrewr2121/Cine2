/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cine.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.cine.Actor;



/**
 *
 * @author Alumno
 */
public class ActorDaoHibernateImpl implements ActorDao {
    
    private final SessionFactory sessionFactory;

    public ActorDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Actor buscarPorNombre(String nombre) {
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Actor> query = builder.createQuery(Actor.class);
        Root<Actor> root = query.from(Actor.class);
        query.select(root);
        query.where(builder.equal(root.get("nombre"), nombre));
        
        Actor actor = session.createQuery(query).uniqueResult();
        
        session.close();
        
        return actor;
    }

    @Override
    public void guardar(Actor actor) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(actor);
        session.getTransaction().commit();
        session.close();
    }
    
      @Override
    public List<Actor> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Actor> retorno = session.createQuery("from Actor").list();
        session.close();
        
        return retorno;
    }
    
}
