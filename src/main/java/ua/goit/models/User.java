package ua.goit.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements BaseEntity <Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Email(regexp = ".+@.+\\..+", message = "Email must have @ symbol")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "first_name", nullable = false, unique = true)
    private String firstName;

    @Column(name = "last_name", nullable = false, unique = true)
    private String lastName;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
}
