package by.zavadskiy.facade.mappers;

import by.zavadskiy.database.entity.Address;
import by.zavadskiy.facade.dto.pharmacy.PharmacyDtoCreateRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toAddress(PharmacyDtoCreateRequest pharmacyDto);
}
