package iyteyazilim.projects.iytediff.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class LoginDto {
    private String username;
    private String password;
}
