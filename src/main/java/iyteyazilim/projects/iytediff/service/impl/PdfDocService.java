package iyteyazilim.projects.iytediff.service.impl;

import iyteyazilim.projects.iytediff.dto.pdfdoc.PdfType;
import iyteyazilim.projects.iytediff.entity.PdfDoc;
import iyteyazilim.projects.iytediff.entity.User;
import iyteyazilim.projects.iytediff.repository.PdfDocRepository;
import iyteyazilim.projects.iytediff.repository.UserRepository;
import iyteyazilim.projects.iytediff.service.IPdfDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PdfDocService implements IPdfDocService {
    @Autowired
    private PdfDocRepository pdfDocRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public PdfDoc addPdf(MultipartFile file, String name, PdfType type, Long senderId, String additionalUrl, Integer chapter) {
        try {
            PdfDoc pdfDocument = new PdfDoc();
            pdfDocument.setName(name);
            pdfDocument.setType(type);
            pdfDocument.setChapter(chapter);
            pdfDocument.setAdditionalUrl(additionalUrl);
            pdfDocument.setPdf(file.getBytes()); // IOException'ı burada ele alıyoruz

            User sender = userRepository.findById(senderId)
                    .orElseThrow(() -> new RuntimeException("Sender not found"));
            pdfDocument.setSender(sender);

            return pdfDocRepository.save(pdfDocument);
        } catch (IOException e) {
            throw new RuntimeException("Error while processing the PDF file", e);
        }
    }

    public List<PdfDoc> getPdfsByType(PdfType type) {
        return pdfDocRepository.findByType(type);
    }

    // PDF dosyasını indirmek için yöntem
    public PdfDoc getPdfById(Long id) {
        return pdfDocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PDF not found with id: " + id));
    }

    @Override
    public List<PdfDoc> getPdfs() {
        return pdfDocRepository.findAll();
    }

    @Override
    public PdfDoc getPdf(Long id) {
        return pdfDocRepository.getById(id);
    }

    @Override
    public void updatePdf(Long id, PdfDoc pdf) {

    }

    @Override
    public void deletePdf(Long id) {

    }
}
