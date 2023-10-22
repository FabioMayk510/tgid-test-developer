package com.maykdeveloper.tgidtestdeveloper.services;

import com.maykdeveloper.tgidtestdeveloper.models.TgidCliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    TgidCliente save(TgidCliente cliente);

    List<TgidCliente> findAll();

    Optional<TgidCliente> findById(Long id);

    Optional<TgidCliente> findByCpf(String cpf);


    TgidCliente update(TgidCliente cliente);

    void deleteById(Long id);

}
