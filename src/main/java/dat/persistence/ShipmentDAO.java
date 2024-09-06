package dat.persistence;

import dat.entities.Shipment;
import dat.exceptions.JpaException;
import dat.entities.Package;
import dat.enums.HibernateConfigState;
import jakarta.persistence.*;

public class ShipmentDAO implements iDAO<Shipment> {
    private static ShipmentDAO instance;
    private static EntityManagerFactory emf;


    private ShipmentDAO() {
    }

    public static ShipmentDAO getInstance(HibernateConfigState state) {
        if (instance == null) {
            emf = HibernateConfig.getEntityManagerFactoryConfig(state, "gls");
            instance = new ShipmentDAO();
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
    public Shipment create(Shipment shipment) {
        return null;
    }

    @Override
    public Shipment findById(Long id) {
        return null;
    }

    @Override
    public Shipment findByTrackingNumber(String trackingNumber) {
        return null;
    }

    @Override
    public Shipment update(Shipment shipment) {
        return null;
    }

    @Override
    public boolean delete(Shipment shipment) {
        return false;
    }
}
