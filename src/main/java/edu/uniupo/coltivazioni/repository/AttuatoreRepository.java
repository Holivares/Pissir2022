package edu.uniupo.coltivazioni.repository;

import edu.uniupo.coltivazioni.entity.AttuatoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttuatoreRepository extends JpaRepository<AttuatoreEntity, UUID> {
    Optional<AttuatoreEntity> findBySerraEntityIdSerra ( UUID idSerra );
}
