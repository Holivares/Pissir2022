package edu.uniupo.pissir.repository;

import edu.uniupo.pissir.entity.SerraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SerraRepository extends JpaRepository<SerraEntity, UUID> {
    Optional<List<SerraEntity>> findByAziendaAgricolaEntityIdAziendaAgricola ( UUID idAziendaAgricola );
}
