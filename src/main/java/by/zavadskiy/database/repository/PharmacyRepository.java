package by.zavadskiy.database.repository;

import by.zavadskiy.database.entity.Pharmacy;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends CrudRepository<Pharmacy, Long>, QuerydslPredicateExecutor<Pharmacy> {

}
