package by.zavadskiy.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "medicine")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "pharmacies")
@EqualsAndHashCode(of = "name")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "medicines")
    private Set<Pharmacy> pharmacies = new HashSet<>();
}
