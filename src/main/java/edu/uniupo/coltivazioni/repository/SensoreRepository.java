package edu.uniupo.coltivazioni.repository;

import edu.uniupo.coltivazioni.entity.SensoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SensoreRepository extends JpaRepository<SensoreEntity, UUID> {
    Optional<List<SensoreEntity>> findBySerraEntityIdSerra ( UUID idSerra );
}
