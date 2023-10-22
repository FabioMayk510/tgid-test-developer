package com.maykdeveloper.tgidtestdeveloper.repositories;

import com.maykdeveloper.tgidtestdeveloper.models.TgidEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<TgidEmpresa, Long> {

    TgidEmpresa findByRazao(String razao);

    TgidEmpresa findByCnpj(String cnpj);
}