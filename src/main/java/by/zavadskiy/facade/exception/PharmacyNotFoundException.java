package by.zavadskiy.facade.exception;

import org.springframework.http.HttpStatus;

public class PharmacyNotFoundException extends BaseException {
    public PharmacyNotFoundException(Long queryFilter) {
        super(ApiError.builder()
                        .errorCode("pharmacy.not.found")
                        .description("Pharmacy not found with id=" + queryFilter.toString())
                        .build(),
                HttpStatus.NOT_FOUND);
    }
}
