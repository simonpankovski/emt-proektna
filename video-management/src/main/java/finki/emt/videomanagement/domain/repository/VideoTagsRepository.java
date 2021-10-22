package finki.emt.videomanagement.domain.repository;

import finki.emt.videomanagement.domain.models.TagId;
import finki.emt.videomanagement.domain.models.TagVideos;
import finki.emt.videomanagement.domain.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoTagsRepository extends JpaRepository<TagVideos, TagId> {
    List<TagVideos> findAllByTagName(String name);
}
