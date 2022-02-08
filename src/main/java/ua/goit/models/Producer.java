package ua.goit.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producers")
public class Producer implements BaseEntity<Long>{

    private static final long serialVersionUID = -475982250350685554L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> $products;
}