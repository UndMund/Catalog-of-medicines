package by.zavadskiy.facade.dto.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDtoResponse {
    String username;

    @JsonCreator
    public UserDtoResponse(@JsonProperty("username") String username) {
        this.username = username;
    }
}
