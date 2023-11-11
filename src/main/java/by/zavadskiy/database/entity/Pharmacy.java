package by.zavadskiy.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pharmacy",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"city", "street", "house_number"})
        })
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "medicines")
@EqualsAndHashCode(of = {"name", "address"})
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "city")),
            @AttributeOverride(name = "street", column = @Column(name = "street")),
            @AttributeOverride(name = "houseNumber", column = @Column(name = "house_number"))
    })
    private Address address;
    @ManyToMany
    @JoinTable(
            name = "pharmacy_medicine",
            joinColumns = @JoinColumn(name = "pharmacy_id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id")
    )
    private Set<Medicine> medicines = new HashSet<>();

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }
}
