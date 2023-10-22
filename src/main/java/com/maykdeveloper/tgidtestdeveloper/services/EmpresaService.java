package com.maykdeveloper.tgidtestdeveloper.services;

import com.maykdeveloper.tgidtestdeveloper.models.TgidEmpresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {

    TgidEmpresa save(TgidEmpresa empresa);

    List<TgidEmpresa> findAll();

    Optional<TgidEmpresa> findById(Long id);

    TgidEmpresa findByRazao(String razao);

    TgidEmpresa update(TgidEmpresa empresa);

    void deleteById(Long id);

    TgidEmpresa findByCnpj(String cnpj);
}
