package br.def.rs.defensoria.wsssp.service.dto;

import java.io.Serializable;
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
public class ProcessosCriteria implements Serializable {
    private static final long serialVersionUID = 1L;


    private LongFilter id;

    private LongFilter assistido_id;

    private StringFilter numero;

    private LocalDateFilter data_processo_dpe;

    private StringFilter area;

  

    public ProcessosCriteria() {
    }

    public LongFilter getId() {
        return id;
    }
    public void setId(LongFilter id) {
        this.id = id;
    }

    public LongFilter getAssistido_id() {
        return assistido_id;
    }
    public void setAssistido_id(LongFilter assistido_id) {
        this.assistido_id = assistido_id;
    }

   
    public StringFilter getNumero() {
        return numero;
    }

    public void setNumero(StringFilter numero) {
        this.numero = numero;
    }

    public LocalDateFilter getData_processo_dpe() {
        return data_processo_dpe;
    }

    public void setData_processo_dpe(LocalDateFilter data_processo_dpe) {
        this.data_processo_dpe = data_processo_dpe;
    }

    public StringFilter getArea() {
        return area;
    }

    public void setArea(StringFilter area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "ProcessosCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (assistido_id != null ? "assistido_id=" + assistido_id + ", " : "") +
                (numero != null ? "numero=" + numero + ", " : "") +
                (data_processo_dpe != null ? "data_processo_dpe=" + data_processo_dpe + ", " : "") +
                (area != null ? "area=" + area + ", " : "") +
            "}";
    }

}
