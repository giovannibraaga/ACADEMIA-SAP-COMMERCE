package com.br.sapcommerce.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "inscricao")
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @Column(name = "data_inscricao")
    private Date dataInscricao;

    @Deprecated
    public Inscricao() {

    }

    public Inscricao(Curso curso, Aluno aluno, Date dataInscricao) {
        this.curso = curso;
        this.aluno = aluno;
        this.dataInscricao = dataInscricao;
    }

    public Long getId() {
        return id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso_id) {
        this.curso = curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno_id) {
        this.aluno = aluno;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }
}
