package iyteyazilim.projects.iytediff.entity;

import iyteyazilim.projects.iytediff.dto.SyllabusObjectDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Syllabus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    @ElementCollection
    private List<SyllabusObjectDto> syllabusObjects;
}
