package backend.zip.repository;

import backend.zip.domain.user.UserOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOptionRepository extends JpaRepository<UserOption, Long> {
}
