package iyteyazilim.projects.iytediff.repository;

import iyteyazilim.projects.iytediff.dto.pdfdoc.PdfType;
import iyteyazilim.projects.iytediff.entity.PdfDoc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PdfDocRepository extends JpaRepository<PdfDoc, Long> {
    List<PdfDoc> findByType(PdfType type);
}
