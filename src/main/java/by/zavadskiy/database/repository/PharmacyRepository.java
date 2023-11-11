package by.zavadskiy.database.repository;

import by.zavadskiy.database.entity.Address;
import by.zavadskiy.database.entity.Pharmacy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PharmacyRepository extends CrudRepository<Pharmacy, Long>, QuerydslPredicateExecutor<Pharmacy> {
    List<Pharmacy> findAllByAddressCity(String cityName);

    @Query(value = """
            select p from Pharmacy p 
            where 
            (select m from Medicine m where m.name = ?1) 
            member of p.medicines
            """)
    List<Pharmacy> findAllByMedicineName(String medicineName);

    @Query(value = """
            select p from Pharmacy p 
            where 
            (select m from Medicine m where m.name = ?1) 
            member of p.medicines
            """)
    List<Pharmacy> findAllByMedicineNameAndAddressCity(String medicineName);

    Optional<Pharmacy> findByAddress(Address address);
}
