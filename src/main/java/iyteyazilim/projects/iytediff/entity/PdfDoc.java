package iyteyazilim.projects.iytediff.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import iyteyazilim.projects.iytediff.dto.pdfdoc.PdfType;
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
public class PdfDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String additionalUrl;
    private Integer chapter;

    @Enumerated(EnumType.STRING)
    private PdfType type;

    @Lob
    @JsonIgnore
    @Column(columnDefinition = "LONGBLOB")
    private byte[] pdf;

    @Column(name = "ddate")
    @CreationTimestamp
    private Date date;

    @ManyToOne
    private User sender;

}
