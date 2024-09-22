package iyteyazilim.projects.iytediff.dto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Embeddable
public class VideoLinkDto {
    private String name;

    @Enumerated(EnumType.STRING)
    private VideoType videoType;
    private String url;
    private Long senderId;
}
