package edu.uniupo.pissir.repository;

import edu.uniupo.pissir.entity.AttuatoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttuatoreRepository extends JpaRepository<AttuatoreEntity, UUID> {
    Optional<List<AttuatoreEntity>> findBySerraEntityIdSerra ( UUID idSerra );
}
