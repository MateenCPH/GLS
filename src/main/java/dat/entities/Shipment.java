package dat.entities;

import dat.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private Package aPackage;

    @ManyToOne
    @JoinColumn(name = "sourceLocation_id")
    private Location source;

    @ManyToOne
    @JoinColumn(name = "destinationLocation_id")
    private Location destination;


    @Column(name = "shipmentDateTime", nullable = false)
    private LocalDateTime shipmentDateTime;

}
