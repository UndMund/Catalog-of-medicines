package by.zavadskiy.facade.dto.medicine;

import by.zavadskiy.facade.validation.validators.annotations.MedicineNameUnique;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MedicineDtoCreateRequest {
    @MedicineNameUnique
    String name;

    @JsonCreator
    public MedicineDtoCreateRequest(@JsonProperty("name") String name) {
        this.name = name;
    }
}
