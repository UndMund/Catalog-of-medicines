package by.zavadskiy.api.rest.controllers;

import by.zavadskiy.facade.dto.medicine.MedicineDtoAddRequest;
import by.zavadskiy.facade.dto.pharmacy.PharmacyDtoCreateRequest;
import by.zavadskiy.facade.dto.pharmacy.PharmacyDtoResponse;
import by.zavadskiy.facade.dto.pharmacy.PharmacyFilter;
import by.zavadskiy.facade.interfaces.IPharmacyFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.zavadskiy.api.rest.utils.UrlPath.API;

@RestController
@RequestMapping(API + "/pharmacies")
@RequiredArgsConstructor
public class PharmacyRestController {
    private final IPharmacyFacade pharmacyFacade;

    @GetMapping
    public ResponseEntity<List<PharmacyDtoResponse>> getAllPharmacies() {
        var pharmacies = pharmacyFacade.getAllPharmacies();
        if (pharmacies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pharmacies, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PharmacyDtoResponse>> getAllPharmaciesByFilter(
            @RequestBody PharmacyFilter pharmacyFilter
    ) {
        var pharmacies = pharmacyFacade.getAllPharmaciesByFilter(pharmacyFilter);
        if (pharmacies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pharmacies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PharmacyDtoResponse> addNewPharmacy(
            @Validated @RequestBody PharmacyDtoCreateRequest pharmacyDto
    ) {
        return new ResponseEntity<>(
                pharmacyFacade.createPharmacy(pharmacyDto),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/{id}/medicines")
    public ResponseEntity<PharmacyDtoResponse> addMedicineToPharmacy(
            @PathVariable("id") Long id,
            @RequestBody @Validated MedicineDtoAddRequest medicineDtoAddRequest
    ) {
        return new ResponseEntity<>(
                pharmacyFacade.addMedicineToPharmacy(medicineDtoAddRequest, id),
                HttpStatus.OK
        );
    }
}
