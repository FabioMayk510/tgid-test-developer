package com.maykdeveloper.tgidtestdeveloper.requests;

import com.maykdeveloper.tgidtestdeveloper.models.TgidEmpresa;
import jakarta.persistence.ManyToOne;

public class ClienteRequest {
    private String nome;
    private String cpf;
    private int idade;
    private String email;
    private TgidEmpresa empresa;

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public TgidEmpresa getEmpresa() {
        return empresa;
    }

    /*
        setters
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmpresa(TgidEmpresa empresa) {
        this.empresa = empresa;
    }
}
