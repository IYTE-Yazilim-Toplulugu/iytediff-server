package iyteyazilim.projects.iytediff.dto.pdfdoc;

import iyteyazilim.projects.iytediff.entity.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Date;

@Data
@Embeddable
public class ResPdfDto {
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private PdfType type;
    private Date date;
    private User sender;

    private Integer chapter;
    private String additionalUrl;
}
