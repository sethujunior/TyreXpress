package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.OrderLine;

@Repository
public interface IOrderLineRepository extends JpaRepository<OrderLine, Long> {
}
