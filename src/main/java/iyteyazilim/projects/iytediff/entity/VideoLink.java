package iyteyazilim.projects.iytediff.entity;

import iyteyazilim.projects.iytediff.dto.VideoType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "pdfdoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoLink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private VideoType videoType;

    private String url;

    @Column(name = "ddate")
    @CreationTimestamp
    private Date date;

    @ManyToOne
    private User sender;
}
