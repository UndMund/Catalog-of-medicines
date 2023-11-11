package by.zavadskiy.service.predicate;

import by.zavadskiy.database.entity.Medicine;
import by.zavadskiy.database.entity.QPharmacy;
import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;


@UtilityClass
public class PredicateBuilder {
    public static Predicate buildPharmacyPredicate(Medicine medicine, String cityName) {
        return QPredicates.builder()
                .add(cityName, QPharmacy.pharmacy.address.city::eq)
                .add(medicine, QPharmacy.pharmacy.medicines::contains)
                .build();
    }
}
