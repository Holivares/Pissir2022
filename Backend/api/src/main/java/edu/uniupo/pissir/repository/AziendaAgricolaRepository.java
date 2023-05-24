package edu.uniupo.pissir.repository;

import edu.uniupo.pissir.entity.AziendaAgricolaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AziendaAgricolaRepository extends JpaRepository<AziendaAgricolaEntity, UUID> {
    Optional<AziendaAgricolaEntity> findByUtenteEntitiesIdUtente ( UUID IdUtente );
    Optional<AziendaAgricolaEntity> findByUtenteEntitiesIdUtenteIn ( List<UUID> IdUtente );
    Optional<AziendaAgricolaEntity> findByNome ( String nome );
}
