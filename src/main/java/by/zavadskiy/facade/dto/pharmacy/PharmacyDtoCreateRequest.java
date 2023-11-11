package by.zavadskiy.facade.dto.pharmacy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PharmacyDtoCreateRequest {
    @Size(min = 5, max = 30, message = "Name must be 5-30 characters long")
    String name;
    @Size(min = 2, max = 15, message = "City must be 2-15 characters long")
    String city;
    @Size(min = 2, max = 15, message = "Street must be 2-15 characters long")
    String street;
    @DecimalMin(value = "1", message = "Number must be more than 0")
    @DecimalMax(value = "300", message = "Number must be less than 300")
    String houseNumber;

    @JsonCreator
    public PharmacyDtoCreateRequest(
            @JsonProperty("name") String name,
            @JsonProperty("city") String city,
            @JsonProperty("street") String street,
            @JsonProperty("houseNumber") String houseNumber
    ) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }
}
