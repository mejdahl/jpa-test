package dk.domstol.test.repository;


import dk.domstol.test.model.School;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<School, UUID> {
}
