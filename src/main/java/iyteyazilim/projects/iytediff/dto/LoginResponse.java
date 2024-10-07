package iyteyazilim.projects.iytediff.dto;

import lombok.*;

@AllArgsConstructor
@Data
@Getter
@Setter
public class LoginResponse {
    private String token;

    private Integer expiresIn;


}