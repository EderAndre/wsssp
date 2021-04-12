package br.def.rs.defensoria.wsssp.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.def.rs.defensoria.wsssp.domain.Assistidos;
import br.def.rs.defensoria.wsssp.service.AssistidosService;
import br.def.rs.defensoria.wsssp.web.rest.errors.BadRequestAlertException;
import br.def.rs.defensoria.wsssp.web.rest.util.HeaderUtil;
import br.def.rs.defensoria.wsssp.web.rest.util.PaginationUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import br.def.rs.defensoria.wsssp.service.dto.AssistidosCriteria;
import br.def.rs.defensoria.wsssp.service.AssistidosQueryService;
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
 * REST controller for managing Assistidos.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AssistidosResource {

    private final Logger log = LoggerFactory.getLogger(AssistidosResource.class);

    private static final String ENTITY_NAME = "assistidos";

    private final AssistidosService assistidosService;

    private final AssistidosQueryService assistidosQueryService;

    public AssistidosResource(AssistidosService assistidosService, AssistidosQueryService assistidosQueryService) {
        this.assistidosService = assistidosService;
        this.assistidosQueryService = assistidosQueryService;
    }

    /**
     * POST  /assistidos : Create a new assistidos.
     *
     * @param assistidos the assistidos to create
     * @return the ResponseEntity with status 201 (Created) and with body the new assistidos, or with status 400 (Bad Request) if the assistidos has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
  // @PostMapping("/assistidos")
    @Timed
    public ResponseEntity<Assistidos> createAssistidos(@RequestBody Assistidos assistidos) throws URISyntaxException {
        log.debug("REST request to save Assistidos : {}", assistidos);
        if (assistidos.getId() != null) {
            throw new BadRequestAlertException("A new assistidos cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Assistidos result = assistidosService.save(assistidos);
        return ResponseEntity.created(new URI("/api/assistidos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /assistidos : Updates an existing assistidos.
     *
     * @param assistidos the assistidos to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated assistidos,
     * or with status 400 (Bad Request) if the assistidos is not valid,
     * or with status 500 (Internal Server Error) if the assistidos couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
  //  @PutMapping("/assistidos")
    @Timed
    public ResponseEntity<Assistidos> updateAssistidos(@RequestBody Assistidos assistidos) throws URISyntaxException {
        log.debug("REST request to update Assistidos : {}", assistidos);
        if (assistidos.getId() == null) {
            return createAssistidos(assistidos);
        }
        Assistidos result = assistidosService.save(assistidos);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, assistidos.getId().toString()))
            .body(result);
    }

    /**
     * GET  /assistidos : get all the assistidos.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of assistidos in body
     */
    @GetMapping("/assistidos")
    @Timed
    public ResponseEntity<List<Assistidos>> getAllAssistidos(AssistidosCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Assistidos by criteria: {}", criteria);
        Page<Assistidos> page = assistidosQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/assistidos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /assistidos/:id : get the "id" assistidos.
     *
     * @param id the id of the assistidos to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the assistidos, or with status 404 (Not Found)
     */
    @GetMapping("/assistidos/{id}")
    @Timed
    public ResponseEntity<Assistidos> getAssistidos(@PathVariable Long id) {
        log.debug("REST request to get Assistidos : {}", id);
        Assistidos assistidos = assistidosService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(assistidos));
    }

    /**
     * DELETE  /assistidos/:id : delete the "id" assistidos.
     *
     * @param id the id of the assistidos to delete
     * @return the ResponseEntity with status 200 (OK)
     */
  //  @DeleteMapping("/assistidos/{id}")
    @Timed
    public ResponseEntity<Void> deleteAssistidos(@PathVariable Long id) {
        log.debug("REST request to delete Assistidos : {}", id);
        assistidosService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/assistidos?query=:query : search for the assistidos corresponding
     * to the query.
     *
     * @param query the query of the assistidos search
     * @param pageable the pagination information
     * @return the result of the search
     */
   // @GetMapping("/_search/assistidos")
    @Timed
    public ResponseEntity<List<Assistidos>> searchAssistidos(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of Assistidos for query {}", query);
        Page<Assistidos> page = assistidosService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/assistidos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
