package mapper;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private Integer id;

  private String email;

  private String password;

  private String firstName;

  private String lastName;

  private String phone;

  private String location;

  private LocalDateTime created;


}
