package com.br.sapcommerce.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "data-cadastro")
    private Date dataCadastro;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Inscricao> inscricoes = new ArrayList<>();

    @Deprecated
    public Aluno() {

    }

    public Aluno(String nome, String email, Date dataCadastro, List<Inscricao> inscricoes) {
        this.nome = nome;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.inscricoes = inscricoes;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }
}
