package br.def.rs.defensoria.wsssp.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import br.def.rs.defensoria.wsssp.domain.Processos;
import br.def.rs.defensoria.wsssp.domain.*; // for static metamodels
import br.def.rs.defensoria.wsssp.repository.ProcessosRepository;
import br.def.rs.defensoria.wsssp.repository.search.ProcessosSearchRepository;
import br.def.rs.defensoria.wsssp.service.dto.ProcessosCriteria;


/**
 * Service for executing complex queries for Processos entities in the database.
 * The main input is a {@link ProcessosCriteria} which get's converted to {@link Specifications},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Processos} or a {@link Page} of {@link Processos} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ProcessosQueryService extends QueryService<Processos> {

    private final Logger log = LoggerFactory.getLogger(ProcessosQueryService.class);


    private final ProcessosRepository processosRepository;

    private final ProcessosSearchRepository processosSearchRepository;

    public ProcessosQueryService(ProcessosRepository processosRepository, ProcessosSearchRepository processosSearchRepository) {
        this.processosRepository = processosRepository;
        this.processosSearchRepository = processosSearchRepository;
    }

    /**
     * Return a {@link List} of {@link Processos} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Processos> findByCriteria(ProcessosCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specifications<Processos> specification = createSpecification(criteria);
        return processosRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Processos} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Processos> findByCriteria(ProcessosCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specifications<Processos> specification = createSpecification(criteria);
        return processosRepository.findAll(specification, page);
    }

    /**
     * Function to convert ProcessosCriteria to a {@link Specifications}
     */
    private Specifications<Processos> createSpecification(ProcessosCriteria criteria) {
        Specifications<Processos> specification = Specifications.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), Processos_.id));
            }
            if (criteria.getAssistido_id() != null) {
                specification = specification.and(buildSpecification(criteria.getAssistido_id(), Processos_.assistido_id));
            }
            if (criteria.getNumero() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNumero(), Processos_.numero));
            }
        //    if (criteria.getData_processo_dpe() != null) {
        //        specification = specification.and(buildSpecification(criteria.getData_processo_dpe(), Processos_.data_processo_dpe));
         //   }
            if (criteria.getArea() != null) {
                specification = specification.and(buildStringSpecification(criteria.getArea(), Processos_.area));
            }
            
        }
        return specification;
    }

}
