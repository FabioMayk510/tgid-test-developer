package com.maykdeveloper.tgidtestdeveloper.requests;

import com.maykdeveloper.tgidtestdeveloper.models.TgidEmpresa;

public class DepositoRequest {
    private double deposito;
    private TgidEmpresa empresa;

    public double getDeposito() {
        return deposito;
    }

    public TgidEmpresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(TgidEmpresa empresa) {
        this.empresa = empresa;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }
}
