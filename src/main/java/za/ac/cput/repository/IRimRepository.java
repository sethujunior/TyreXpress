package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Rim;

@Repository
public interface IRimRepository extends JpaRepository<Rim, Long> {

}