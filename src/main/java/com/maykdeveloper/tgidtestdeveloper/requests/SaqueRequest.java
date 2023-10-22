package com.maykdeveloper.tgidtestdeveloper.requests;

import com.maykdeveloper.tgidtestdeveloper.models.TgidCliente;
import com.maykdeveloper.tgidtestdeveloper.models.TgidEmpresa;

public class SaqueRequest {
    private double saque;
    private TgidEmpresa empresa;
    private TgidCliente cliente;

    public double getSaque() {
        return saque;
    }

    public void setSaque(double saque) {
        this.saque = saque;
    }

    public TgidEmpresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(TgidEmpresa empresa) {
        this.empresa = empresa;
    }

    public TgidCliente getCliente() {
        return cliente;
    }

    public void setCliente(TgidCliente cliente) {
        this.cliente = cliente;
    }
}
