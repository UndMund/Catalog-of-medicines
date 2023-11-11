package by.zavadskiy.facade.dto.pharmacy;

import by.zavadskiy.facade.dto.medicine.MedicineDtoResponse;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class PharmacyDtoResponse {
    Long id;
    String name;
    String city;
    String street;
    String houseNumber;
    Set<MedicineDtoResponse> medicinesDto;

    @JsonCreator
    public PharmacyDtoResponse(@JsonProperty("id") Long id,
                               @JsonProperty("name") String name,
                               @JsonProperty("city") String city,
                               @JsonProperty("street") String street,
                               @JsonProperty("houseNumber") String houseNumber,
                               @JsonProperty("medicinesDto") Set<MedicineDtoResponse> medicinesDto) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.medicinesDto = medicinesDto;
    }
}
