package br.def.rs.defensoria.wsssp.service.dto;

import java.io.Serializable;
import java.sql.Date;

import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.LocalDateFilter;






/**
 * Criteria class for the Assistidos entity. This class is used in AssistidosResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /assistidos?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class AssistidosCriteria implements Serializable {
    private static final long serialVersionUID = 1L;


    private LongFilter id;

    private StringFilter nome;

    private StringFilter nome_social;

    private StringFilter nome_mae;

    private StringFilter nome_pai;
    
    private LocalDateFilter data_nascimento;

    private StringFilter rg;

    private StringFilter cpf;

    private StringFilter telefones;

    private StringFilter enderecos;

    public AssistidosCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getNome() {
        return nome;
    }

    public void setNome(StringFilter nome) {
        this.nome = nome;
    }

    public StringFilter getNome_social() {
        return nome_social;
    }

    public void setNome_social(StringFilter nome_social) {
        this.nome_social = nome_social;
    }

    public StringFilter getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(StringFilter nome_mae) {
        this.nome_mae = nome_mae;
    }

    public StringFilter getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(StringFilter nome_pai) {
        this.nome_pai = nome_pai;
    }
    public LocalDateFilter getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDateFilter data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public StringFilter getRg() {
        return rg;
    }

    public void setRg(StringFilter rg) {
        this.rg = rg;
    }

    public StringFilter getCpf() {
        return cpf;
    }

    public void setCpf(StringFilter cpf) {
        this.cpf = cpf;
    }

    public StringFilter getTelefones() {
        return telefones;
    }

    public void setTelefones(StringFilter telefones) {
        this.telefones = telefones;
    }

    public StringFilter getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(StringFilter enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public String toString() {
        return "AssistidosCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (nome != null ? "nome=" + nome + ", " : "") +
                (nome_social != null ? "nome_social=" + nome_social + ", " : "") +
                (nome_mae != null ? "nome_mae=" + nome_mae + ", " : "") +
                (nome_pai != null ? "nome_pai=" + nome_pai + ", " : "") +
                (data_nascimento != null ? "data_nascimento=" + data_nascimento + ", " : "") +
                (rg != null ? "rg=" + rg + ", " : "") +
                (cpf != null ? "cpf=" + cpf + ", " : "") +
                (telefones != null ? "telefones=" + telefones + ", " : "") +
                (enderecos != null ? "enderecos=" + enderecos + ", " : "") +
            "}";
    }

}
