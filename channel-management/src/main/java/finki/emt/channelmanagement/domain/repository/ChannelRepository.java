package finki.emt.channelmanagement.domain.repository;

import finki.emt.channelmanagement.domain.models.Channel;
import finki.emt.channelmanagement.domain.models.ChannelId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, ChannelId> {
    Optional<Channel> findByName(String name);
}
