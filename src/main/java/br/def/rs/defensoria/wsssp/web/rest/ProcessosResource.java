package br.def.rs.defensoria.wsssp.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.def.rs.defensoria.wsssp.domain.Processos;
import br.def.rs.defensoria.wsssp.service.ProcessosService;
import br.def.rs.defensoria.wsssp.web.rest.errors.BadRequestAlertException;
import br.def.rs.defensoria.wsssp.web.rest.util.HeaderUtil;
import br.def.rs.defensoria.wsssp.web.rest.util.PaginationUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import br.def.rs.defensoria.wsssp.service.dto.ProcessosCriteria;
import br.def.rs.defensoria.wsssp.service.ProcessosQueryService;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing Processos.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ProcessosResource {

    private final Logger log = LoggerFactory.getLogger(ProcessosResource.class);

    private static final String ENTITY_NAME = "processos";

    private final ProcessosService processosService;

    private final ProcessosQueryService processosQueryService;

    public ProcessosResource(ProcessosService processosService, ProcessosQueryService processosQueryService) {
        this.processosService = processosService;
        this.processosQueryService = processosQueryService;
    }

    /**
     * POST  /processos : Create a new processos.
     *
     * @param processos the processos to create
     * @return the ResponseEntity with status 201 (Created) and with body the new processos, or with status 400 (Bad Request) if the processos has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
  // @PostMapping("/processos")
    @Timed
    public ResponseEntity<Processos> createProcessos(@RequestBody Processos processos) throws URISyntaxException {
        log.debug("REST request to save Processos : {}", processos);
        if (processos.getId() != null) {
            throw new BadRequestAlertException("A new processos cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Processos result = processosService.save(processos);
        return ResponseEntity.created(new URI("/api/processos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /processos : Updates an existing processos.
     *
     * @param processos the processos to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated processos,
     * or with status 400 (Bad Request) if the processos is not valid,
     * or with status 500 (Internal Server Error) if the processos couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
  //  @PutMapping("/processos")
    @Timed
    public ResponseEntity<Processos> updateProcessos(@RequestBody Processos processos) throws URISyntaxException {
        log.debug("REST request to update Processos : {}", processos);
        if (processos.getId() == null) {
            return createProcessos(processos);
        }
        Processos result = processosService.save(processos);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, processos.getId().toString()))
            .body(result);
    }

    /**
     * GET  /processos : get all the processos.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of processos in body
     */
    @GetMapping("/processos")
    @Timed
    public ResponseEntity<List<Processos>> getAllProcessos(ProcessosCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Processos by criteria: {}", criteria);
        Page<Processos> page = processosQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/processos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /processos/:id : get the "id" processos.
     *
     * @param id the id of the processos to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the processos, or with status 404 (Not Found)
     */
    @GetMapping("/processos/{id}")
    @Timed
    public ResponseEntity<Processos> getProcessos(@PathVariable Long id) {
        log.debug("REST request to get Processos : {}", id);
        Processos processos = processosService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(processos));
    }
    
  
    /**
     * DELETE  /processos/:id : delete the "id" processos.
     *
     * @param id the id of the processos to delete
     * @return the ResponseEntity with status 200 (OK)
     */
  //  @DeleteMapping("/processos/{id}")
    @Timed
    public ResponseEntity<Void> deleteProcessos(@PathVariable Long id) {
        log.debug("REST request to delete Processos : {}", id);
        processosService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/processos?query=:query : search for the processos corresponding
     * to the query.
     *
     * @param query the query of the processos search
     * @param pageable the pagination information
     * @return the result of the search
     */
   // @GetMapping("/_search/processos")
    @Timed
    public ResponseEntity<List<Processos>> searchProcessos(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of Processos for query {}", query);
        Page<Processos> page = processosService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/processos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
