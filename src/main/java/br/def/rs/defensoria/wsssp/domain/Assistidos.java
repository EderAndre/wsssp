package br.def.rs.defensoria.wsssp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Assistidos.
 */
@Entity
@Table(name = "assistidos")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "assistidos")
public class Assistidos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nome_social")
    private String nome_social;

    @Column(name = "nome_mae")
    private String nome_mae;

    @Column(name = "nome_pai")
    private String nome_pai;

    @Column(name = "data_nascimento")
    private LocalDate data_nascimento;
    
    @Column(name = "rg")
    private String rg;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "telefones")
    private String telefones;

    @Column(name = "enderecos")
    private String enderecos;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Assistidos nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_social() {
        return nome_social;
    }

    public Assistidos nome_social(String nome_social) {
        this.nome_social = nome_social;
        return this;
    }

    public void setNome_social(String nome_social) {
        this.nome_social = nome_social;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public Assistidos nome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
        return this;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public String getNome_pai() {
        return nome_pai;
    }

    public Assistidos nome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
        return this;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }
    
    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public Assistidos data_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
        return this;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getRg() {
        return rg;
    }

    public Assistidos rg(String rg) {
        this.rg = rg;
        return this;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public Assistidos cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefones() {
        return telefones;
    }

    public Assistidos telefones(String telefones) {
        this.telefones = telefones;
        return this;
    }

    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    public String getEnderecos() {
        return enderecos;
    }

    public Assistidos enderecos(String enderecos) {
        this.enderecos = enderecos;
        return this;
    }

    public void setEnderecos(String enderecos) {
        this.enderecos = enderecos;
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
        Assistidos assistidos = (Assistidos) o;
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
        return "Assistidos{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", nome_social='" + getNome_social() + "'" +
            ", nome_mae='" + getNome_mae() + "'" +
            ", nome_pai='" + getNome_pai() + "'" +
            ", data_nascimento='" + getData_nascimento() + "'" +
            ", rg='" + getRg() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", telefones='" + getTelefones() + "'" +
            ", enderecos='" + getEnderecos() + "'" +
            "}";
    }
}
