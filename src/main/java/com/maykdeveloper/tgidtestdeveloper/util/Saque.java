package com.maykdeveloper.tgidtestdeveloper.util;

import com.maykdeveloper.tgidtestdeveloper.callbacks.CallbackEmpresa;
import com.maykdeveloper.tgidtestdeveloper.models.TgidCliente;
import com.maykdeveloper.tgidtestdeveloper.models.TgidEmpresa;

import java.util.Optional;

public class Saque {
    private double taxa = 0.1;
    private String tipo = "Saque";

    public TgidEmpresa sacar(double saque, TgidEmpresa empresa, Optional<TgidCliente> cliente){
        double taxa_liquida = Taxa.criarTaxa(saque, taxa);
        if ((empresa.getSaldo() > (saque + taxa_liquida))) {
            empresa.setSaldo((empresa.getSaldo() - (saque + taxa_liquida)));
            //call(tipo, (saque + taxa_liquida), taxa, cliente);
        } else {
            System.out.println("Valor inválido.");
        }
        return empresa;
    }

    private void call(String tipo, double valor, double taxa, String email){
        CallbackEmpresa callbackEmpresa = new CallbackEmpresa();
        callbackEmpresa.callback(tipo, valor, taxa);

        //CallbackCliente callbackCliente = new CallbackCliente();
        //callbackCliente.callback(email, tipo, valor);
    }
}
