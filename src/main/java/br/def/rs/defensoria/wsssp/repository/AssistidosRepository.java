package br.def.rs.defensoria.wsssp.repository;

import br.def.rs.defensoria.wsssp.domain.Assistidos;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Assistidos entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AssistidosRepository extends JpaRepository<Assistidos, Long>, JpaSpecificationExecutor<Assistidos> {

}
