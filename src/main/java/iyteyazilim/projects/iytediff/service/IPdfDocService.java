package iyteyazilim.projects.iytediff.service;

import iyteyazilim.projects.iytediff.dto.pdfdoc.PdfType;
import iyteyazilim.projects.iytediff.entity.PdfDoc;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface IPdfDocService {
    public PdfDoc addPdf(MultipartFile file, String name, PdfType type, Long senderId, String additionalUrl, Integer chapter);
    public List<PdfDoc> getPdfs();
    public PdfDoc getPdf(Long id);
    public void updatePdf(Long id, PdfDoc pdf);
    public void deletePdf(Long id);
}
