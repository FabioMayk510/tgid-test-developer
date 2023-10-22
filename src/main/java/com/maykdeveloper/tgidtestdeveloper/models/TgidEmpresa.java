package com.maykdeveloper.tgidtestdeveloper.models;

import com.maykdeveloper.tgidtestdeveloper.util.ValidadorCnpj;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TgidEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String razao;
    private String cnpj;

    private double saldo;

    /*
        construtor padrão
     */

    public TgidEmpresa(){
        this.id = 0L;
        this.razao = "Mayk Developer";
        this.cnpj = "12.345.678/0001-01";
        this.saldo = 9000;
    }

    /*
        construtor personalizado
     */

    public TgidEmpresa(String razao, String cnpj){
        if (validaCnpj(cnpj)){
            this.razao = razao;
            this.cnpj = cnpj;
            this.saldo = 0;
        } else {
            System.out.println("Falha: CNPJ inválido. Empresa não cadastrada");
        }
    }

    /*
        getters
     */

    public String getRazao() {
        return razao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public double getSaldo() {
        return saldo;
    }

    /*
        setters
     */

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /*
        valida CNPJ
     */

    public boolean validaCnpj(String cnpj){
        boolean valido = ValidadorCnpj.validarcnpj(cnpj);

        if (valido) {
            System.out.println("CNPJ válido.");
        } else {
            System.out.println("CNPJ inválido.");
        }
        return valido;
    }

    /*
        retorna empresa
     */

    @Override
    public String toString(){
        return "Empresa " + id + "\n" +
                "razão social: " + razao + "\n" +
                "CNPJ: " + cnpj + "\n" +
                "saldo" + saldo;
    }
}
