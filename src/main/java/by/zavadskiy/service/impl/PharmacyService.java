package by.zavadskiy.service.impl;

import by.zavadskiy.database.entity.Medicine;
import by.zavadskiy.database.entity.Pharmacy;
import by.zavadskiy.database.repository.PharmacyRepository;
import by.zavadskiy.service.interfaces.IPharmacyService;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PharmacyService implements IPharmacyService {
    private final PharmacyRepository pharmacyRepository;

    @Override
    public List<Pharmacy> getAll() {
        return (List<Pharmacy>) pharmacyRepository.findAll();
    }

    @Override
    public List<Pharmacy> getAllByPredicate(Predicate predicates) {
        return (List<Pharmacy>) pharmacyRepository.findAll(predicates);
    }

    @Override
    @Transactional
    public Pharmacy save(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    @Override
    @Transactional
    public Pharmacy updateMedicines(Medicine medicine, Pharmacy pharmacy) {
        return pharmacyRepository.findById(pharmacy.getId())
                .map(updatedPharmacy -> {
                    updatedPharmacy.addMedicine(medicine);
                    return updatedPharmacy;
                }).get();
    }

    @Override
    public Optional<Pharmacy> getById(Long id) {
        return pharmacyRepository.findById(id);
    }
}
