package by.zavadskiy.facade.mappers;

import by.zavadskiy.database.entity.Pharmacy;
import by.zavadskiy.facade.dto.pharmacy.PharmacyDtoCreateRequest;
import by.zavadskiy.facade.dto.pharmacy.PharmacyDtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = MedicineMapper.class)
public interface PharmacyMapper {
    @Mapping(target = "address",
            source = "pharmacyDto")
    Pharmacy toEntity(PharmacyDtoCreateRequest pharmacyDto);

    @Mapping(target = "medicinesDto",
            source = "medicines")
    @Mapping(target = "city",
            source = "address.city")
    @Mapping(target = "street",
            source = "address.street")
    @Mapping(target = "houseNumber",
            source = "address.houseNumber")
    PharmacyDtoResponse toDto(Pharmacy pharmacy);
}
