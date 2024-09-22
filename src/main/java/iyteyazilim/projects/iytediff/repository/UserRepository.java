package iyteyazilim.projects.iytediff.repository;

import iyteyazilim.projects.iytediff.dto.Role;
import iyteyazilim.projects.iytediff.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<List<User>> findByUserRole(Role userRole);
}
