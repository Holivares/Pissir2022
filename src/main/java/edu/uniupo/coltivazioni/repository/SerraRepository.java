package edu.uniupo.coltivazioni.repository;

import edu.uniupo.coltivazioni.entity.SerraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SerraRepository extends JpaRepository<SerraEntity, UUID> {
    Optional<SerraEntity> findByAziendaAgricolaEntityIdAziendaAgricola ( UUID idAziendaAgricola );
}
