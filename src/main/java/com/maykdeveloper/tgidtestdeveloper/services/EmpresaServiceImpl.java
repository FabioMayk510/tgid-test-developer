package com.maykdeveloper.tgidtestdeveloper.services;

import com.maykdeveloper.tgidtestdeveloper.models.TgidEmpresa;
import com.maykdeveloper.tgidtestdeveloper.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService{

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public TgidEmpresa save(TgidEmpresa cliente) {
        return empresaRepository.save(cliente);
    }

    @Override
    public List<TgidEmpresa> findAll() {
        return empresaRepository.findAll();
    }

    @Override
    public Optional<TgidEmpresa> findById(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public TgidEmpresa findByRazao(String razao) {
        return empresaRepository.findByRazao(razao);
    }

    public TgidEmpresa findByCnpj(String cnpj) {
        return empresaRepository.findByCnpj(cnpj);
    }

    @Override
    public TgidEmpresa update(TgidEmpresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public void deleteById(Long id) {
        empresaRepository.deleteById(id);
    }

}