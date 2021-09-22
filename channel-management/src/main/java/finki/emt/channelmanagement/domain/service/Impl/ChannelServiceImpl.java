package finki.emt.channelmanagement.domain.service.Impl;

import finki.emt.channelmanagement.domain.models.Channel;
import finki.emt.channelmanagement.domain.models.ChannelId;
import finki.emt.channelmanagement.domain.repository.ChannelRepository;
import finki.emt.channelmanagement.domain.service.ChannelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepository channelRepository;

    @Override
    public Optional<Channel> findByName(String name) {
        return channelRepository.findByName(name);
    }

    @Override
    public void saveChannel(Channel channel) {
        channelRepository.saveAndFlush(channel);
    }

    @Override
    public void deleteChannel(ChannelId id) {
        channelRepository.deleteById(id);
    }
}
