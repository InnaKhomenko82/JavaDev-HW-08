package ua.goit.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product implements BaseEntity<Long>{

    private static final long serialVersionUID = 8973498391380583012L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name="name", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name="price", nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="producer_id")
    private Producer producer;
}