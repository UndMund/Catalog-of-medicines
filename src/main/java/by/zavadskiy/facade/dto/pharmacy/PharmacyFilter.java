package by.zavadskiy.facade.dto.pharmacy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PharmacyFilter {
    String medicineName;
    String cityName;

    @JsonCreator
    public PharmacyFilter(@JsonProperty String medicineName,
                          @JsonProperty String cityName) {
        this.medicineName = medicineName;
        this.cityName = cityName;
    }
}
