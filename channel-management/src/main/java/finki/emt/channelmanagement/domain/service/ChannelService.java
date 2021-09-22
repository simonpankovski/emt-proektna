package finki.emt.channelmanagement.domain.service;

import finki.emt.channelmanagement.domain.models.Channel;
import finki.emt.channelmanagement.domain.models.ChannelId;
import finki.emt.channelmanagement.domain.models.User;
import finki.emt.channelmanagement.domain.models.UserId;

import java.util.Optional;

public interface ChannelService {
    Optional<Channel> findByName(String name);
    void saveChannel(Channel channel);
    void deleteChannel(ChannelId id);

}
