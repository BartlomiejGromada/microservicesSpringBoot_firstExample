package pl.gromada.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gromada.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
