package org.recommendations.service;

import org.recommendations.exception.InvalidRecommendationParameterException;
import org.recommendations.exception.NoRecommendationsException;
import org.recommendations.repository.VideoRepository;
import org.recommendations.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private final VideoRepository videoRepository;

    @Autowired
    public RecommendationService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    //This Approach would help in less load but as the load increases
    // shifting this towards the database side makes more sense as database column is indexed
    // and it can efficiently process it, this would reduce server load and in case of huge data would help/**/
    /*public List<Video> getTopNRecommendations(int n) {
        return videoRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Video::getViews).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }*/

    /**
     *
     * @param limit : define the limit of videos requested
     * @return : entire list of videos to be recommended
     */
    public List<Video> getTopNRecommendations(int limit) {
        if (limit < 1) {
            throw new InvalidRecommendationParameterException("Number of recommendations must be at least 1");
        }
        List<Video> videos = videoRepository.findTopVideos(limit);
        if (videos.isEmpty()) {
            throw new NoRecommendationsException("No video recommendations available");
        }
        return videos;
    }
}
