package pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserInfo {

    private String email;

    private String firstName;

    private String lastName;

    private String password;
}
