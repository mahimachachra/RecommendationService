package org.recommendations.repository;

import org.recommendations.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    @Query(value = "SELECT * FROM video ORDER BY views DESC LIMIT :limit", nativeQuery = true)
    List<Video> findTopVideos(@Param("limit") int limit);
}
