package za.ac.cput.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import za.ac.cput.domain.User;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
//        Optional<User> findByEmail(String email);
}
