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

import br.def.rs.defensoria.wsssp.domain.Assistidos;
import br.def.rs.defensoria.wsssp.domain.*; // for static metamodels
import br.def.rs.defensoria.wsssp.repository.AssistidosRepository;
import br.def.rs.defensoria.wsssp.repository.search.AssistidosSearchRepository;
import br.def.rs.defensoria.wsssp.service.dto.AssistidosCriteria;


/**
 * Service for executing complex queries for Assistidos entities in the database.
 * The main input is a {@link AssistidosCriteria} which get's converted to {@link Specifications},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Assistidos} or a {@link Page} of {@link Assistidos} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class AssistidosQueryService extends QueryService<Assistidos> {

    private final Logger log = LoggerFactory.getLogger(AssistidosQueryService.class);


    private final AssistidosRepository assistidosRepository;

    private final AssistidosSearchRepository assistidosSearchRepository;

    public AssistidosQueryService(AssistidosRepository assistidosRepository, AssistidosSearchRepository assistidosSearchRepository) {
        this.assistidosRepository = assistidosRepository;
        this.assistidosSearchRepository = assistidosSearchRepository;
    }

    /**
     * Return a {@link List} of {@link Assistidos} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Assistidos> findByCriteria(AssistidosCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specifications<Assistidos> specification = createSpecification(criteria);
        return assistidosRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Assistidos} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Assistidos> findByCriteria(AssistidosCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specifications<Assistidos> specification = createSpecification(criteria);
        return assistidosRepository.findAll(specification, page);
    }

    /**
     * Function to convert AssistidosCriteria to a {@link Specifications}
     */
    private Specifications<Assistidos> createSpecification(AssistidosCriteria criteria) {
        Specifications<Assistidos> specification = Specifications.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), Assistidos_.id));
            }
            if (criteria.getNome() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNome(), Assistidos_.nome));
            }
            if (criteria.getNome_social() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNome_social(), Assistidos_.nome_social));
            }
            if (criteria.getNome_mae() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNome_mae(), Assistidos_.nome_mae));
            }
            if (criteria.getNome_pai() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNome_pai(), Assistidos_.nome_pai));
            }
            if (criteria.getData_nascimento() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getData_nascimento(), Assistidos_.data_nascimento));
            }
            if (criteria.getRg() != null) {
                specification = specification.and(buildStringSpecification(criteria.getRg(), Assistidos_.rg));
            }
            if (criteria.getCpf() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCpf(), Assistidos_.cpf));
            }
            if (criteria.getTelefones() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTelefones(), Assistidos_.telefones));
            }
            if (criteria.getEnderecos() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEnderecos(), Assistidos_.enderecos));
            }
        }
        return specification;
    }

}
