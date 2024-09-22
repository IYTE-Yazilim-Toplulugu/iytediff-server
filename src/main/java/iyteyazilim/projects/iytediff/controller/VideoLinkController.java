package iyteyazilim.projects.iytediff.controller;

import iyteyazilim.projects.iytediff.dto.VideoLinkDto;
import iyteyazilim.projects.iytediff.entity.VideoLink;
import iyteyazilim.projects.iytediff.service.impl.VideoLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
@CrossOrigin(origins = "http://localhost:3000")
public class VideoLinkController {
    @Autowired
    private VideoLinkService videoLinkService;

    @PostMapping("/addLink")
    public ResponseEntity<VideoLink> addVideoLink(@RequestBody VideoLinkDto videoLinkDto) {
        return ResponseEntity.ok(videoLinkService.addVideo(videoLinkDto));
    }


}
