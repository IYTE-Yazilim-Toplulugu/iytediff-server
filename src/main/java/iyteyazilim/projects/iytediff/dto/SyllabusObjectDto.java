package iyteyazilim.projects.iytediff.dto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Embeddable
public class SyllabusObjectDto {
    private Date date;
    private String name;
    private String week;
    private String description;
}
