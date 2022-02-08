package ua.goit.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
public class Product implements BaseEntity<UUID>{

    private static final long serialVersionUID = 8973498391380583012L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @NotEmpty
    @Column(name="name", nullable = false)
    private String name;

    @NotNull
    @Column(name="price", nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="producer_id")
    private Producer producer;
}