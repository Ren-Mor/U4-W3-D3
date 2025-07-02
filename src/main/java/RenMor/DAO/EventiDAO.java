package RenMor.DAO;

import RenMor.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventiDAO {

    private EntityManager entityManager;

    public EventiDAO(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    public void save(Evento newevento){
        EntityTransaction transaction=  entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newevento);
        transaction.commit();
    }
    public Evento getById(long id){
        return entityManager.find(Evento.class,id);
    }
    public void delete(long id){
        Evento found= this.getById(id);
        EntityTransaction transaction=  entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
    }
}
