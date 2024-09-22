package iyteyazilim.projects.iytediff.controller;

import iyteyazilim.projects.iytediff.dto.pdfdoc.PdfType;
import iyteyazilim.projects.iytediff.dto.pdfdoc.ResPdfDto;
import iyteyazilim.projects.iytediff.entity.PdfDoc;
import iyteyazilim.projects.iytediff.service.impl.PdfDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/pdf")
@CrossOrigin(origins = "http://localhost:3000")
public class PdfController {
    @Autowired
    private PdfDocService pdfDocService;

    @PostMapping(value = "/addPdfDoc", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResPdfDto> addPdfDoc(@RequestParam("file") MultipartFile file,
                                               @RequestParam("name") String name,
                                               @RequestParam("type") PdfType type,
                                               @RequestParam("senderId") Long senderId,
                                               @RequestParam("additionalUrl") String additionalUrl,
                                               @RequestParam("chapter") Integer chapter) {
        try {
            PdfDoc p = pdfDocService.addPdf(file, name, type, senderId, additionalUrl, chapter);
            ResPdfDto res = new ResPdfDto();
            res.setId(p.getId());
            res.setType(p.getType());
            res.setDate(p.getDate());
            res.setName(p.getName());
            res.setSender(p.getSender());
            res.setChapter(p.getChapter());
            res.setAdditionalUrl(p.getAdditionalUrl());
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while uploading PDF: " + e.getMessage());
            return null;
        }

    }

    @GetMapping("/getAllPdfs")
    public ResponseEntity<List<PdfDoc>> getAllPdf() {
        return ResponseEntity.ok(pdfDocService.getPdfs());
    }



    @GetMapping("/pdfs")
    public ResponseEntity<List<PdfDoc>> getPdfsByType(@RequestParam("type") PdfType type) {
        try {
            List<PdfDoc> pdfs = pdfDocService.getPdfsByType(type);
            return ResponseEntity.ok(pdfs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // PDF dosyasını indirmek için GET endpoint
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable Long id) {
        try {
            PdfDoc pdfDocument = pdfDocService.getPdfById(id);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pdfDocument.getName() + ".pdf\"")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfDocument.getPdf());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
