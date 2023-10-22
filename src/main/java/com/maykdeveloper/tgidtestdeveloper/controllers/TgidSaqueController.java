package com.maykdeveloper.tgidtestdeveloper.controllers;

import com.maykdeveloper.tgidtestdeveloper.models.TgidCliente;
import com.maykdeveloper.tgidtestdeveloper.models.TgidEmpresa;
import com.maykdeveloper.tgidtestdeveloper.requests.SaqueRequest;
import com.maykdeveloper.tgidtestdeveloper.services.EmpresaService;
import com.maykdeveloper.tgidtestdeveloper.services.ClienteService;
import com.maykdeveloper.tgidtestdeveloper.util.Saque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/saques")
public class TgidSaqueController {
    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<String> realizarSaque(@RequestBody SaqueRequest saqueRequest) {
        // Aqui, você pode acessar os dados da solicitação, como valor do saque, empresa e cliente.
        double valorSaque = saqueRequest.getSaque();
        TgidEmpresa empresa = empresaService.findByCnpj(saqueRequest.getEmpresa().getCnpj());
        Optional<TgidCliente> cliente = clienteService.findById(saqueRequest.getCliente().getId());

        Saque saque = new Saque();
        TgidEmpresa empresaAtualizada = saque.sacar(valorSaque, empresa, cliente);
        empresaService.update(empresaAtualizada);

        return ResponseEntity.ok("Saque realizado com sucesso. Saldo atual da empresa: " + empresaAtualizada.getSaldo());
    }
}
