package by.zavadskiy.facade.interfaces;

import by.zavadskiy.facade.dto.pharmacy.PharmacyDtoCreateRequest;

public interface IPharmacyValidationFacade {
    boolean isValidAddress(PharmacyDtoCreateRequest pharmacyDto);
}
