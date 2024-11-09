package com.br.sapcommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class AlunoDTO {
    private Long id;

    @NotBlank(message = "O Nome é obrigatório")
    @Size(min = 3, max = 50, message = "O Nome deve ter entre 3 e 50 caracteres")
    private String nome;

    @NotBlank(message = "O Email é obrigatório")
    @Email(message = "O Email deve ser válido")
    private String email;
    private Date dataCadastro;

    public AlunoDTO(Long id, String nome, String email, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataCadastro = dataCadastro;
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
}
