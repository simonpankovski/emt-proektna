package finki.emt.channelmanagement.domain.service;

import finki.emt.channelmanagement.domain.models.Channel;
import finki.emt.channelmanagement.domain.models.ChannelId;
import finki.emt.channelmanagement.domain.models.User;
import finki.emt.channelmanagement.domain.models.UserId;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(UserId id);
    Optional<User> findByEmail(String email);
    void saveUser(User user);
    void deleteUser(UserId id);
    void addSubscribedto(UserId id, Channel channel);
    void addChannel(User id, Channel channelId);
}
