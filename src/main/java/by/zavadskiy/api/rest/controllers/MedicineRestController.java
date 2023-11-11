package by.zavadskiy.api.rest.controllers;

import by.zavadskiy.facade.dto.medicine.MedicineDtoCreateRequest;
import by.zavadskiy.facade.dto.medicine.MedicineDtoResponse;
import by.zavadskiy.facade.interfaces.IMedicineFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.zavadskiy.api.rest.utils.UrlPath.API;

@RestController
@RequestMapping(API + "/medicines")
@RequiredArgsConstructor
public class MedicineRestController {
    private final IMedicineFacade medicineFacade;

    @GetMapping
    public ResponseEntity<List<MedicineDtoResponse>> getAllMedicines() {
        var medicines = medicineFacade.getAllMedicines();
        if (medicines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MedicineDtoResponse> addNewMedicine(
            @Validated @RequestBody MedicineDtoCreateRequest medicineDtoCreateRequest
    ) {
        return new ResponseEntity<>(
                medicineFacade.createMedicine(medicineDtoCreateRequest),
                HttpStatus.CREATED
        );
    }
}
