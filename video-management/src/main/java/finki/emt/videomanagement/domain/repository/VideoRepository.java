package finki.emt.videomanagement.domain.repository;

import finki.emt.videomanagement.domain.models.Tag;
import finki.emt.videomanagement.domain.models.Video;
import finki.emt.videomanagement.domain.models.VideoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface VideoRepository extends JpaRepository<Video, VideoId> {
    Optional<Video> findVideoByName(String name);



}
