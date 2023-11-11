package by.zavadskiy.facade.exception;

import org.springframework.http.HttpStatus;

public class MedicineNotFoundException extends BaseException {
    public MedicineNotFoundException(String queryFilter) {
        super(ApiError.builder()
                        .errorCode("medicine.not.found")
                        .description("Medicine not found with name=" + queryFilter)
                        .build(),
                HttpStatus.NOT_FOUND);
    }

    public MedicineNotFoundException(Long queryFilter) {
        super(ApiError.builder()
                        .errorCode("medicine.not.found")
                        .description("Medicine not found with id=" + queryFilter.toString())
                        .build(),
                HttpStatus.NOT_FOUND);
    }
}
