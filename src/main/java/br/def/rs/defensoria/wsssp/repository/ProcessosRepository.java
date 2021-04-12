package br.def.rs.defensoria.wsssp.repository;

import br.def.rs.defensoria.wsssp.domain.Processos;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Processos entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProcessosRepository extends JpaRepository<Processos, Long>, JpaSpecificationExecutor<Processos> {

}
