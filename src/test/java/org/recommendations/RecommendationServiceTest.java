package org.recommendations;

import org.mockito.MockitoAnnotations;
import org.recommendations.exception.*;
import org.recommendations.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.recommendations.model.Video;
import org.recommendations.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RecommendationServiceTest {

    @Autowired
    private RecommendationService recommendationService;

    @MockBean
    private VideoRepository videoRepository;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Testcase for validting the size of recommendations
     */
    @Test
    public void testGetTopNRecommendations() {
        // Given
        List<Video> mockVideos = Arrays.asList(
                new Video(1L, "Video 1", "Description 1", "Author 1", "https://example.com/video1", 1500),
                new Video(2L, "Video 2", "Description 2", "Author 2", "https://example.com/video2", 2300),
                new Video(3L, "Video 3", "Description 3", "Author 3", "https://example.com/video3", 800)
        );

        when(videoRepository.findTopVideos(3)).thenReturn(mockVideos);

        // When
        List<Video> recommendedVideos = recommendationService.getTopNRecommendations(3);

        // Then
        assertEquals(3, recommendedVideos.size());
        assertEquals("Video 1", recommendedVideos.get(0).getTitle()); // Most viewed video
        assertEquals("Video 2", recommendedVideos.get(1).getTitle()); // Second most viewed video
        assertEquals("Video 3", recommendedVideos.get(2).getTitle()); // Third most viewed video
    }

    /**
     * Testcase when no videos recommendation exists
     */
    @Test
    public void testGetTopNRecommendations_WithNoRecommendations() {
        // Given
        when(videoRepository.findTopVideos(3)).thenReturn(Collections.emptyList());

        // When & Then
        NoRecommendationsException thrown = assertThrows(NoRecommendationsException.class, () -> {
            recommendationService.getTopNRecommendations(3);
        });
        assertEquals("No video recommendations available", thrown.getMessage());
    }

    /**
     * Testcase with invalid input
     */
    @Test
    public void testGetTopNRecommendations_WithInvalidInput() {
        // When & Then
        InvalidRecommendationParameterException thrown = assertThrows(InvalidRecommendationParameterException.class, () -> {
            recommendationService.getTopNRecommendations(0);
        });
        assertEquals("Number of recommendations must be at least 1", thrown.getMessage());
    }

    /**
     * Testcase when limit is greater than existing videos count
     */
    @Test
    public void testGetTopNRecommendations_WithLessVideosThanRequested() {
        // Given
        List<Video> mockVideos = Arrays.asList(
                new Video(1L, "Video 1", "Description 1", "Author 1", "http://example.com/video1", 1500)
        );

        when(videoRepository.findTopVideos(3)).thenReturn(mockVideos);

        // When
        List<Video> recommendedVideos = recommendationService.getTopNRecommendations(3);

        // Then
        assertEquals(1, recommendedVideos.size());
        assertEquals("Video 1", recommendedVideos.get(0).getTitle());
    }
}

