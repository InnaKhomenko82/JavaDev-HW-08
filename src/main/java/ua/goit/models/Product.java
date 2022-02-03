package ua.goit.models;

import lombok.*;
import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product implements BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name", nullable = false, unique = true)
    private String name;

    @Column(name="price", nullable = false)
    private Long price;

    @ManyToOne
    @JoinColumn(name="producer_id", nullable = false)
    private Producer producer;
}
