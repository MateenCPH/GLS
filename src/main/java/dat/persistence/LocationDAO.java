package dat.persistence;

import dat.entities.Location;
import dat.entities.Shipment;
import dat.exceptions.JpaException;
import dat.entities.Package;
import dat.enums.HibernateConfigState;
import jakarta.persistence.*;

public class LocationDAO implements iDAO<Location> {
    private static LocationDAO instance;
    private static EntityManagerFactory emf;


    private LocationDAO() {
    }

    public static LocationDAO getInstance(HibernateConfigState state) {
        if (instance == null) {
            emf = HibernateConfig.getEntityManagerFactoryConfig(state, "gls");
            instance = new LocationDAO();
        }
        return instance;
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    @Override
    public Location create(Location location) {
        return null;
    }

    @Override
    public Location findById(Long id) {
        return null;
    }

    @Override
    public Location findByTrackingNumber(String trackingNumber) {
        try (EntityManager em = emf.createEntityManager()){
            TypedQuery<Location> query = em.createQuery("SELECT l FROM Location l WHERE l.trackingNumber = :trackingNumber", Location.class);
            query.setParameter("trackingNumber", trackingNumber);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new JpaException("Error finding location: " + e.getMessage());
        }
    }

    @Override
    public Location update(Location location) {
        return null;
    }

    @Override
    public boolean delete(Location location) {
        return false;
    }
}