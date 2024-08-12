package org.recommendations.service;

import org.recommendations.model.Video;
import org.recommendations.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    /**
     *
     * @param video : details of entire video object to be created
     * @return : generated video object with id
     */
    public Video createVideo(Video video) {
        return videoRepository.save(video);
    }
}
