package iyteyazilim.projects.iytediff.service;

import iyteyazilim.projects.iytediff.dto.VideoLinkDto;
import iyteyazilim.projects.iytediff.entity.VideoLink;

import java.util.List;

public interface IVideoLinkService {
    public VideoLink addVideo(VideoLinkDto videoLinkDto);
    public List<VideoLink> getVideo();
    public VideoLink getVideo(Long id);
    public void updateVideo(Long id, VideoLink pdf);
    public void deleteVideo(Long id);

}
