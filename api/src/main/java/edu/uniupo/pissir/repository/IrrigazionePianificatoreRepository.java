package edu.uniupo.pissir.repository;

import edu.uniupo.pissir.entity.IrrigazionePianificatoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IrrigazionePianificatoreRepository extends JpaRepository<IrrigazionePianificatoreEntity, UUID> {
    Optional<List<IrrigazionePianificatoreEntity>> findByAziendaAgricolaEntityIdAziendaAgricola ( UUID idAziendaAgricola );

    Optional<List<IrrigazionePianificatoreEntity>> findBySerraEntityIdSerra ( UUID idSerra );
}
