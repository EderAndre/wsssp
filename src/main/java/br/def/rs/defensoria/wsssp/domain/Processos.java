package br.def.rs.defensoria.wsssp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;
import java.util.Date;

/**
 * A Processos.
 */
@Entity
@Table(name = "processos")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "processos")
public class Processos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "assistido_id")
    private Long assistido_id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "data_processo_dpe")
    private Date data_processo_dpe;

    @Column(name = "area")
    private String area;


    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssistido_id() {
        return assistido_id;
    }

    public Processos assistido_id(Long assistido_id) {
        this.assistido_id = assistido_id;
        return this;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public Processos numero(String numero) {
        this.numero = numero;
        return this;
    }
    
    public void setData_processo_dpe(Date data_processo_dpe) {
        this.data_processo_dpe = data_processo_dpe;
    }

    public Date getData_processo_dpe() {
        return data_processo_dpe;
    }

    public Processos data_processo_dpe(Date data_processo_dpe) {
        this.data_processo_dpe = data_processo_dpe;
        return this;
    }
    
    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public Processos area(String area) {
        this.area = area;
        return this;
    }


    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Processos assistidos = (Processos) o;
        if (assistidos.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), assistidos.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Processos{" +
            "id=" + getId() +
            ", assistido_id='" + getAssistido_id() + "'" +
            ", numero='" + getNumero() + "'" +
            ", data_processo_dpe='" + getData_processo_dpe() + "'" +
            ", area='" + getArea() + "'" +
            "}";
    }
}
