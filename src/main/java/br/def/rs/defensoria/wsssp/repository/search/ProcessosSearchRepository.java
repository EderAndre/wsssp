package br.def.rs.defensoria.wsssp.repository.search;

import br.def.rs.defensoria.wsssp.domain.Processos;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Processos entity.
 */
public interface ProcessosSearchRepository extends ElasticsearchRepository<Processos, Long> {
}
