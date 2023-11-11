package by.zavadskiy.facade.mappers;

import by.zavadskiy.database.entity.Medicine;
import by.zavadskiy.facade.dto.medicine.MedicineDtoCreateRequest;
import by.zavadskiy.facade.dto.medicine.MedicineDtoResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface MedicineMapper {
    Medicine toEntity(MedicineDtoCreateRequest medicineDtoCreateRequest);

    MedicineDtoResponse toDto(Medicine medicine);
}
