package finki.emt.channelmanagement.domain.service.Impl;

import finki.emt.channelmanagement.domain.exceptions.UserNotFoundException;
import finki.emt.channelmanagement.domain.models.Channel;
import finki.emt.channelmanagement.domain.models.ChannelId;
import finki.emt.channelmanagement.domain.models.User;
import finki.emt.channelmanagement.domain.models.UserId;
import finki.emt.channelmanagement.domain.repository.UserRepository;
import finki.emt.channelmanagement.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public Optional<User> findById(UserId id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(UserId id) {
        userRepository.deleteById(id);
    }

    @Override
    public void addSubscribedto(UserId id, Channel channel) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        user.setSubscribedTo(channel);
        userRepository.saveAndFlush(user);
    }

    @Override
    public void addChannel(User user, Channel channel) {

        user.setChannel(channel);
        userRepository.saveAndFlush(user);
    }
}
