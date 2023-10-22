package com.maykdeveloper.tgidtestdeveloper.services;

import com.maykdeveloper.tgidtestdeveloper.models.TgidCliente;
import com.maykdeveloper.tgidtestdeveloper.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public TgidCliente save(TgidCliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<TgidCliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<TgidCliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Optional<TgidCliente> findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    @Override
    public TgidCliente update(TgidCliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

}