package rw.rca.next.pojos.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class SignupRequest {
    @NotNull
    private String name;
    @Email
    private String username;
    @NotNull
    private String phone;
    @NotNull
    private String password;
    Set<String> role;
}
