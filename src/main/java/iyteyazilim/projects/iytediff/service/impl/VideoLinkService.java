package iyteyazilim.projects.iytediff.service.impl;

import iyteyazilim.projects.iytediff.dto.VideoLinkDto;
import iyteyazilim.projects.iytediff.entity.PdfDoc;
import iyteyazilim.projects.iytediff.entity.User;
import iyteyazilim.projects.iytediff.entity.VideoLink;
import iyteyazilim.projects.iytediff.repository.UserRepository;
import iyteyazilim.projects.iytediff.repository.VideoLinkRepository;
import iyteyazilim.projects.iytediff.service.IVideoLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class VideoLinkService implements IVideoLinkService {
    @Autowired
    private VideoLinkRepository videoLinkRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public VideoLink addVideo(VideoLinkDto videoLinkDto) {
        VideoLink videoLink = new VideoLink();
        videoLink.setName(videoLinkDto.getName());
        videoLink.setUrl(videoLinkDto.getUrl());
        videoLink.setVideoType(videoLinkDto.getVideoType());

        User sender = userRepository.findById(videoLinkDto.getSenderId())
                .orElseThrow(() -> new RuntimeException("Sender not found"));
        videoLink.setSender(sender);

        return videoLinkRepository.save(videoLink);
    }

    @Override
    public List<VideoLink> getVideo() {
        return videoLinkRepository.findAll();
    }

    @Override
    public VideoLink getVideo(Long id) {
        return videoLinkRepository.getById(id);
    }

    @Override
    public void updateVideo(Long id, VideoLink pdf) {

    }

    @Override
    public void deleteVideo(Long id) {

    }
}
