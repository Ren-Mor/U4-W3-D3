package RenMor.DAO;

import RenMor.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonaDAO {
    private EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(persona);
        transaction.commit();
    }

    public Persona getById(Long id) {
        return entityManager.find(Persona.class, id);
    }
    public void delete(Long id) {
        Persona found = this.getById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
    }
}
