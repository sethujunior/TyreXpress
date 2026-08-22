package za.ac.cput.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import za.ac.cput.domain.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address,Long> {

}
