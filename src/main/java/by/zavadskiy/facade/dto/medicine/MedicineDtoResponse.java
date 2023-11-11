package by.zavadskiy.facade.dto.medicine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MedicineDtoResponse {
    Long id;
    String name;

    @JsonCreator
    public MedicineDtoResponse(@JsonProperty("id") Long id,
                               @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
