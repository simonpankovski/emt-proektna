package finki.emt.channelmanagement.domain.repository;

import finki.emt.channelmanagement.domain.models.User;
import finki.emt.channelmanagement.domain.models.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, UserId> {
    Optional<User> findByEmail(String email);
}
