package com.maykdeveloper.tgidtestdeveloper.repositories;

import com.maykdeveloper.tgidtestdeveloper.models.TgidCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<TgidCliente, Long> {

    Optional<TgidCliente> findByCpf(String cpf);
}