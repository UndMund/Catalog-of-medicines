package by.zavadskiy.database.repository;

import by.zavadskiy.database.entity.Medicine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicineRepository extends CrudRepository<Medicine, Long> {
    Optional<Medicine> findByName(String name);
}
