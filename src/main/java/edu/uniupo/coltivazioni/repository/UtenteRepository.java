package edu.uniupo.coltivazioni.repository;

import edu.uniupo.coltivazioni.entity.UtenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UtenteRepository extends JpaRepository<UtenteEntity, UUID> {
    Optional<UtenteEntity> findByEmail ( String email );
}
