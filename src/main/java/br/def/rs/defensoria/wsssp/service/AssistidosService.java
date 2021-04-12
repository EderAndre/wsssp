package br.def.rs.defensoria.wsssp.service;

import br.def.rs.defensoria.wsssp.domain.Assistidos;
import br.def.rs.defensoria.wsssp.repository.AssistidosRepository;
import br.def.rs.defensoria.wsssp.repository.search.AssistidosSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Assistidos.
 */
@Service
@Transactional
public class AssistidosService {

    private final Logger log = LoggerFactory.getLogger(AssistidosService.class);

    private final AssistidosRepository assistidosRepository;

    private final AssistidosSearchRepository assistidosSearchRepository;

    public AssistidosService(AssistidosRepository assistidosRepository, AssistidosSearchRepository assistidosSearchRepository) {
        this.assistidosRepository = assistidosRepository;
        this.assistidosSearchRepository = assistidosSearchRepository;
    }

    /**
     * Save a assistidos.
     *
     * @param assistidos the entity to save
     * @return the persisted entity
     */
    public Assistidos save(Assistidos assistidos) {
        log.debug("Request to save Assistidos : {}", assistidos);
        Assistidos result = assistidosRepository.save(assistidos);
        assistidosSearchRepository.save(result);
        return result;
    }

    /**
     * Get all the assistidos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Assistidos> findAll(Pageable pageable) {
        log.debug("Request to get all Assistidos");
        return assistidosRepository.findAll(pageable);
    }

    /**
     * Get one assistidos by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Assistidos findOne(Long id) {
        log.debug("Request to get Assistidos : {}", id);
        return assistidosRepository.findOne(id);
    }

    /**
     * Delete the assistidos by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Assistidos : {}", id);
        assistidosRepository.delete(id);
        assistidosSearchRepository.delete(id);
    }

    /**
     * Search for the assistidos corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Assistidos> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Assistidos for query {}", query);
        Page<Assistidos> result = assistidosSearchRepository.search(queryStringQuery(query), pageable);
        return result;
    }
}
