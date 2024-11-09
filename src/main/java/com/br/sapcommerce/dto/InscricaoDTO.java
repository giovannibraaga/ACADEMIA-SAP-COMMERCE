package com.br.sapcommerce.dto;

import java.util.Date;

public class InscricaoDTO {
    private Long id;
    private Long idAluno;
    private Long idCurso;
    private Date dataInscricao;

    public InscricaoDTO() {
    }

    public InscricaoDTO(Long id, Long idAluno, Long idCurso, Date dataInscricao) {
        this.id = id;
        this.idAluno = idAluno;
        this.idCurso = idCurso;
        this.dataInscricao = dataInscricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }
}
