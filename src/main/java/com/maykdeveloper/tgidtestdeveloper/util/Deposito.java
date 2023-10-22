package com.maykdeveloper.tgidtestdeveloper.util;

import com.maykdeveloper.tgidtestdeveloper.callbacks.CallbackEmpresa;
import com.maykdeveloper.tgidtestdeveloper.models.TgidEmpresa;
import com.maykdeveloper.tgidtestdeveloper.util.Taxa;

public class Deposito {
    private double taxa = 0.2;
    private String tipo = "Deposito";

    public TgidEmpresa depositar(double deposito, TgidEmpresa empresa){
        double valor_liquido = deposito - Taxa.criarTaxa(deposito, taxa);
        empresa.setSaldo((empresa.getSaldo() + valor_liquido));
        call(tipo, valor_liquido, taxa);
        return empresa;
    }

    private void call(String tipo, double valor, double taxa){
        CallbackEmpresa callback = new CallbackEmpresa();
        callback.callback(tipo, valor, taxa);
    }
}
