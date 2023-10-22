package com.maykdeveloper.tgidtestdeveloper.models;
import com.maykdeveloper.tgidtestdeveloper.util.ValidadorCpf;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TgidCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String cpf;
    private int idade;
    private String email;
    @ManyToOne
    private TgidEmpresa empresa;

    /*
        construtor padrão
     */

    public TgidCliente(){
        this.id = 0L;
        this.nome = "Fabio Mayk";
        this.idade = 20;
        this.cpf = "56041660817";
        this.email = "fabiomayk510@gmail.com";
        this.empresa = new TgidEmpresa();
    }

    /*
        construtor personalizado
     */

    public TgidCliente (String nome, int idade, String cpf, String email, TgidEmpresa empresa) {
        if (validaCpf(cpf)) {
            this.nome = nome;
            this.idade = idade;
            this.cpf = cpf;
            this.email = email;
            this.empresa = empresa;
        } else {
            System.out.println("Falha: CPF inválido. Cliente não criado.");
        }
    }

    /*
        getters
     */

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

    /*
        valida CPF
     */

    public boolean validaCpf(String cpf){
        boolean valido = ValidadorCpf.validarCpf(cpf);

        if (valido) {
            System.out.println("CPF válido.");
        } else {
            System.out.println("CPF inválido.");
        }
        return valido;
    }

    /*
        retorna cliente
     */

    @Override
    public String toString(){
        return "Cliente " + id + "\n" +
                "nome: " + nome + "\n" +
                "idade: " + idade + "\n" +
                "CPF: " + cpf + "\n" +
                "Email: " + email + "\n" +
                "Cliente de: " + empresa.getRazao() + "\n" +
                "Saldo disponível: " + empresa.getSaldo();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
