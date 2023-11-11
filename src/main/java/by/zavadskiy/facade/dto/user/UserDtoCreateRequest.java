package by.zavadskiy.facade.dto.user;

import by.zavadskiy.facade.validation.validators.annotations.UsernameUnique;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDtoCreateRequest {
    @Size(min = 5, max = 20, message = "Name must be 5-10 characters long")
    @UsernameUnique
    String username;
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,40}",
            message = "Password must have one lowercase and one uppercase letter, one number and contain at least 6 characters")
    String password;

    @JsonCreator
    public UserDtoCreateRequest(
            @JsonProperty("username") String username,
            @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }
}
