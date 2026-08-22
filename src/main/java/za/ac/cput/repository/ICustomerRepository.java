package za.ac.cput.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import za.ac.cput.domain.*;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
