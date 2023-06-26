package rw.rca.next.pojos.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest {
    @Email
    private String username;
    @NotNull
    private String password;
}
