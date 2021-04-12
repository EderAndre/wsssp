package br.def.rs.defensoria.wsssp.repository.search;

import br.def.rs.defensoria.wsssp.domain.Assistidos;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Assistidos entity.
 */
public interface AssistidosSearchRepository extends ElasticsearchRepository<Assistidos, Long> {
}
