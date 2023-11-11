package by.zavadskiy.facade.dto.medicine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MedicineDtoAddRequest {
    Long id;

    @JsonCreator
    public MedicineDtoAddRequest(@JsonProperty("id") Long id) {
        this.id = id;
    }
}
