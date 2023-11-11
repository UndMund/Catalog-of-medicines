package by.zavadskiy.service.impl;

import by.zavadskiy.database.entity.Medicine;
import by.zavadskiy.database.repository.MedicineRepository;
import by.zavadskiy.service.interfaces.IMedicineService;
import by.zavadskiy.service.interfaces.IMedicineValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicineService implements IMedicineService, IMedicineValidationService {
    private final MedicineRepository medicineRepository;

    @Override
    public Medicine save(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public List<Medicine> getAll() {
        return (List<Medicine>) medicineRepository.findAll();
    }

    @Override
    public Optional<Medicine> getByName(String name) {
        return medicineRepository.findByName(name);
    }

    @Override
    public Optional<Medicine> getById(Long id) {
        return medicineRepository.findById(id);
    }

    @Override
    public boolean isValidName(String name) {
        return medicineRepository.findByName(name)
                .isEmpty();
    }
}
