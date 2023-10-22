package com.maykdeveloper.tgidtestdeveloper.controllers;

import com.maykdeveloper.tgidtestdeveloper.models.TgidEmpresa;
import com.maykdeveloper.tgidtestdeveloper.requests.DepositoRequest;
import com.maykdeveloper.tgidtestdeveloper.services.EmpresaService;
import com.maykdeveloper.tgidtestdeveloper.util.Deposito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/depositos")
public class TgidDepositoController {
    @Autowired
    private EmpresaService empresaService;
    @PostMapping
    public ResponseEntity<String> realizarDeposito(@RequestBody DepositoRequest depositoRequest) {
        System.out.println(depositoRequest.getEmpresa().getCnpj());
        TgidEmpresa empresa = empresaService.findByCnpj(depositoRequest.getEmpresa().getCnpj());
        Deposito deposito = new Deposito();
        TgidEmpresa empresaUpdt = deposito.depositar(depositoRequest.getDeposito(), empresa);
        TgidEmpresa empresaAtz = empresaService.update(empresaUpdt);
        return ResponseEntity.ok("Depósito realizado com sucesso." + empresaAtz);
    }
}
