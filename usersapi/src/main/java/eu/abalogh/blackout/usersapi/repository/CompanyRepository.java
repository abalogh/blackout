package eu.abalogh.blackout.usersapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import eu.abalogh.blackout.usersapi.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {

}
