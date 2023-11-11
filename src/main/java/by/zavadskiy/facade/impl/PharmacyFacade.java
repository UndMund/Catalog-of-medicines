package by.zavadskiy.facade.impl;

import by.zavadskiy.facade.dto.medicine.MedicineDtoAddRequest;
import by.zavadskiy.facade.dto.pharmacy.PharmacyDtoCreateRequest;
import by.zavadskiy.facade.dto.pharmacy.PharmacyDtoResponse;
import by.zavadskiy.facade.dto.pharmacy.PharmacyFilter;
import by.zavadskiy.facade.exception.MedicineNotFoundException;
import by.zavadskiy.facade.exception.PharmacyNotFoundException;
import by.zavadskiy.facade.interfaces.IPharmacyFacade;
import by.zavadskiy.facade.mappers.AddressMapper;
import by.zavadskiy.facade.mappers.PharmacyMapper;
import by.zavadskiy.service.interfaces.IMedicineService;
import by.zavadskiy.service.interfaces.IPharmacyService;
import by.zavadskiy.service.predicate.PredicateBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PharmacyFacade implements IPharmacyFacade {
    private final IPharmacyService pharmacyService;
    private final IMedicineService medicineService;
    private final PharmacyMapper pharmacyMapper;
    private final AddressMapper addressMapper;

    @Override
    public List<PharmacyDtoResponse> getAllPharmacies() {
        return pharmacyService.getAll()
                .stream()
                .map(pharmacyMapper::toDto)
                .toList();
    }

    @Override
    public List<PharmacyDtoResponse> getAllPharmaciesByFilter(PharmacyFilter pharmacyFilter) {
        var predicate = PredicateBuilder.buildPharmacyPredicate(
                medicineService.getByName(pharmacyFilter.getMedicineName())
                        .orElseThrow(() -> new MedicineNotFoundException(pharmacyFilter.getMedicineName())),
                pharmacyFilter.getCityName()
        );

        return pharmacyService.getAllByPredicate(predicate)
                .stream()
                .map(pharmacyMapper::toDto)
                .toList();
    }

    @Override
    public PharmacyDtoResponse createPharmacy(PharmacyDtoCreateRequest pharmacyDto) {
        return Optional.of(pharmacyDto)
                .map(pharmacyMapper::toEntity)
                .map(pharmacyService::save)
                .map(pharmacyMapper::toDto)
                .orElseThrow();
    }

    @Override
    public PharmacyDtoResponse addMedicineToPharmacy(MedicineDtoAddRequest medicineDto, Long pharmacyId) {
        return pharmacyMapper.toDto(
                pharmacyService.updateMedicines(
                        medicineService.getById(medicineDto.getId())
                                .orElseThrow(() -> new MedicineNotFoundException(medicineDto.getId())),
                        pharmacyService.getById(pharmacyId)
                                .orElseThrow(() -> new PharmacyNotFoundException(pharmacyId))
                )
        );

    }
}
