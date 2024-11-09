package com.br.sapcommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class CursoDTO {
    private Long id;

    @NotBlank(message = "O Nome do curso é obrigatorio.")
    @Size(min = 5, max = 35, message = "O nome do curso deve conter entre 5 e 35 caracteres.")
    private String nome;

    @NotBlank(message = "A descricao do curso é obrigatoria.")
    @Size(min = 20, max = 200, message = "A descricao do curso deve conter entre 20 e 200 caracteres.")
    private String descricao;
    private Date dataCriacao;

    public CursoDTO(Long id, String nome, String descricao, Date dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
