package by.zavadskiy.facade.impl;

import by.zavadskiy.facade.dto.medicine.MedicineDtoCreateRequest;
import by.zavadskiy.facade.dto.medicine.MedicineDtoResponse;
import by.zavadskiy.facade.interfaces.IMedicineFacade;
import by.zavadskiy.facade.interfaces.IMedicineValidationFacade;
import by.zavadskiy.facade.mappers.MedicineMapper;
import by.zavadskiy.service.interfaces.IMedicineService;
import by.zavadskiy.service.interfaces.IMedicineValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MedicineFacade implements IMedicineFacade, IMedicineValidationFacade {
    private final IMedicineService medicineService;
    private final IMedicineValidationService medicineValidationService;
    private final MedicineMapper medicineMapper;

    @Override
    public List<MedicineDtoResponse> getAllMedicines() {
        return medicineService.getAll()
                .stream()
                .map(medicineMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public MedicineDtoResponse createMedicine(MedicineDtoCreateRequest medicineDto) {
        return Optional.of(medicineDto)
                .map(medicineMapper::toEntity)
                .map(medicineService::save)
                .map(medicineMapper::toDto)
                .get();
    }

    @Override
    public boolean isValidName(String name) {
        return medicineValidationService.isValidName(name);
    }
}
