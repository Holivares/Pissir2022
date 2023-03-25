package edu.uniupo.coltivazioni.repository;

import edu.uniupo.coltivazioni.entity.AziendaAgricolaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AziendaAgricolaRepository extends JpaRepository<AziendaAgricolaEntity, UUID> {
    Optional<AziendaAgricolaEntity> findByUtenteEntityIdUtente ( UUID IdUtente );

    Optional<AziendaAgricolaEntity> findByNome ( String nome );
}
