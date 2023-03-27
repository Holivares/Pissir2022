package edu.uniupo.coltivazioni.repository;

import edu.uniupo.coltivazioni.entity.MisuraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MisuraRepository extends JpaRepository<MisuraEntity, UUID> {
    Optional<List<MisuraEntity>> findBySensoreEntityIdSensore ( UUID idSensore );

}
