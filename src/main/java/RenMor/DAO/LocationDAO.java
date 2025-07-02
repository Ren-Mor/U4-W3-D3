package RenMor.DAO;

import RenMor.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {
    private EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location location) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(location);
        transaction.commit();
    }

    public Location getById(Long id) {
        return entityManager.find(Location.class, id);
    }
    public void delete(Long id) {
        Location found = this.getById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
    }
}
