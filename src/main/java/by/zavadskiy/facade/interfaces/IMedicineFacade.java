package by.zavadskiy.facade.interfaces;

import by.zavadskiy.facade.dto.medicine.MedicineDtoCreateRequest;
import by.zavadskiy.facade.dto.medicine.MedicineDtoResponse;

import java.util.List;

public interface IMedicineFacade {
    List<MedicineDtoResponse> getAllMedicines();

    MedicineDtoResponse createMedicine(MedicineDtoCreateRequest medicineDtoCreateRequest);
}
