package com.maykdeveloper.tgidtestdeveloper.controllers;


import com.maykdeveloper.tgidtestdeveloper.requests.ClienteRequest;
import com.maykdeveloper.tgidtestdeveloper.models.TgidCliente;
import com.maykdeveloper.tgidtestdeveloper.models.TgidEmpresa;
import com.maykdeveloper.tgidtestdeveloper.services.ClienteService;
import com.maykdeveloper.tgidtestdeveloper.services.EmpresaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")

public class TgidClienteControllers {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EmpresaServiceImpl empresaService;

    @GetMapping
    public ResponseEntity<List<TgidCliente>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TgidCliente>> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TgidCliente> create(@RequestBody ClienteRequest clienteRequest){
        TgidCliente novoCliente = new TgidCliente(clienteRequest.getNome(), clienteRequest.getIdade(), clienteRequest.getCpf(), clienteRequest.getEmail(), clienteRequest.getEmpresa());

        if (novoCliente.getEmpresa() != null) {
            TgidEmpresa existingEmpresa = empresaService.findByRazao(novoCliente.getEmpresa().getRazao());

            if (existingEmpresa != null) {
                novoCliente.setEmpresa(existingEmpresa);
                TgidCliente savedCliente = clienteService.save(novoCliente);
                return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(novoCliente));
            } else {
                // Se a empresa não existe, salve-a no banco de dados e associe-a ao cliente
                //TgidEmpresa newEmpresa = empresaService.save(cliente.getEmpresa());
                //cliente.setEmpresa(newEmpresa);
                System.out.println("Empresa nao existe");
            }
        } else {
            System.out.println("Nao enviada nenhuma empresa");
        }
        return null;
    }

    @PutMapping
    public ResponseEntity<TgidCliente> update(@RequestBody TgidCliente cliente){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        clienteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
