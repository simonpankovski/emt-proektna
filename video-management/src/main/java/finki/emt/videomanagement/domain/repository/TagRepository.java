package finki.emt.videomanagement.domain.repository;

import finki.emt.videomanagement.domain.models.Tag;
import finki.emt.videomanagement.domain.models.TagId;
import finki.emt.videomanagement.domain.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TagRepository extends JpaRepository<Tag, TagId> {
    Optional<Tag> findByName(String name);
    

}
