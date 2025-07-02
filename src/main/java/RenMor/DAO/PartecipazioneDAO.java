package RenMor.DAO;

import RenMor.entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(partecipazione);
        transaction.commit();
    }

    public Partecipazione getById(Long id) {
        return entityManager.find(Partecipazione.class, id);
    }

    public void delete(Long id) {
        Partecipazione found = this.getById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
    }
}
