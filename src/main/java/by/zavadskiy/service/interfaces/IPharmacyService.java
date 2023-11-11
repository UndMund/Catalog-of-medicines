package by.zavadskiy.service.interfaces;

import by.zavadskiy.database.entity.Medicine;
import by.zavadskiy.database.entity.Pharmacy;
import com.querydsl.core.types.Predicate;

import java.util.List;
import java.util.Optional;


public interface IPharmacyService {
    List<Pharmacy> getAll();

    List<Pharmacy> getAllByPredicate(Predicate predicates);

    Pharmacy save(Pharmacy pharmacy);

    Pharmacy updateMedicines(Medicine medicine, Pharmacy pharmacy);

    Optional<Pharmacy> getById(Long id);
}
