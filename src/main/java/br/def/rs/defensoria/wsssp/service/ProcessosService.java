package br.def.rs.defensoria.wsssp.service;

import br.def.rs.defensoria.wsssp.domain.Processos;
import br.def.rs.defensoria.wsssp.repository.ProcessosRepository;
import br.def.rs.defensoria.wsssp.repository.search.ProcessosSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Processos.
 */
@Service
@Transactional
public class ProcessosService {

    private final Logger log = LoggerFactory.getLogger(ProcessosService.class);

    private final ProcessosRepository processosRepository;

    private final ProcessosSearchRepository processosSearchRepository;

    public ProcessosService(ProcessosRepository processosRepository, ProcessosSearchRepository processosSearchRepository) {
        this.processosRepository = processosRepository;
        this.processosSearchRepository = processosSearchRepository;
    }

    /**
     * Save a processos.
     *
     * @param processos the entity to save
     * @return the persisted entity
     */
    public Processos save(Processos processos) {
        log.debug("Request to save Processos : {}", processos);
        Processos result = processosRepository.save(processos);
        processosSearchRepository.save(result);
        return result;
    }

    /**
     * Get all the processos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Processos> findAll(Pageable pageable) {
        log.debug("Request to get all Processos");
        return processosRepository.findAll(pageable);
    }

    /**
     * Get one processos by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Processos findOne(Long id) {
        log.debug("Request to get Processos : {}", id);
        return processosRepository.findOne(id);
    }

    /**
     * Delete the processos by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Processos : {}", id);
        processosRepository.delete(id);
        processosSearchRepository.delete(id);
    }

    /**
     * Search for the processos corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Processos> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Processos for query {}", query);
        Page<Processos> result = processosSearchRepository.search(queryStringQuery(query), pageable);
        return result;
    }
}
