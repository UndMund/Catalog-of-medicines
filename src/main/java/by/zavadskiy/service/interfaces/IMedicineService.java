package by.zavadskiy.service.interfaces;

import by.zavadskiy.database.entity.Medicine;

import java.util.List;
import java.util.Optional;

public interface IMedicineService {
    Medicine save(Medicine medicine);

    List<Medicine> getAll();

    Optional<Medicine> getByName(String name);

    Optional<Medicine> getById(Long id);
}
