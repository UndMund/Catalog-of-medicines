package by.zavadskiy.facade.interfaces;

import by.zavadskiy.facade.dto.medicine.MedicineDtoAddRequest;
import by.zavadskiy.facade.dto.pharmacy.PharmacyDtoCreateRequest;
import by.zavadskiy.facade.dto.pharmacy.PharmacyDtoResponse;
import by.zavadskiy.facade.dto.pharmacy.PharmacyFilter;

import java.util.List;

public interface IPharmacyFacade {
    List<PharmacyDtoResponse> getAllPharmacies();

    List<PharmacyDtoResponse> getAllPharmaciesByFilter(PharmacyFilter pharmacyFilter);

    PharmacyDtoResponse createPharmacy(PharmacyDtoCreateRequest pharmacyDto);

    PharmacyDtoResponse addMedicineToPharmacy(MedicineDtoAddRequest medicineDtoAddRequest, Long pharmacyId);
}
