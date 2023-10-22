package com.maykdeveloper.tgidtestdeveloper.controllers;

import com.maykdeveloper.tgidtestdeveloper.requests.EmpresaRequest;
import com.maykdeveloper.tgidtestdeveloper.models.TgidEmpresa;
import com.maykdeveloper.tgidtestdeveloper.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class TgidEmpresaControllers {
    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<TgidEmpresa> criarEmpresa(@RequestBody EmpresaRequest empresaRequest) {

        TgidEmpresa novaEmpresa = new TgidEmpresa(empresaRequest.getRazao(), empresaRequest.getCnpj());
        // Verifique se a empresa já existe no banco de dados
        TgidEmpresa existingEmpresa = empresaService.findByRazao(novaEmpresa.getRazao());

        if (existingEmpresa != null) {
            // Se a empresa já existe, retorne-a
            return ResponseEntity.status(HttpStatus.OK).body(existingEmpresa);
        } else {
            // Se a empresa não existe, salve-a no banco de dados
            TgidEmpresa empresaSalva = empresaService.save(novaEmpresa);
            return ResponseEntity.status(HttpStatus.CREATED).body(empresaSalva);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<TgidEmpresa>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TgidEmpresa>> findById(@PathVariable Long id) {
        Optional<TgidEmpresa> empresa = empresaService.findById(id);
        if (empresa != null) {
            return ResponseEntity.status(HttpStatus.OK).body(empresa);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
