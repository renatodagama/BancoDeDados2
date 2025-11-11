package com.javaspringatt.atividadebancodedados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttBancoService {
    @Autowired
    private AttBancoRepository attBancoRepository;

    public List<AttBancoModel> listarTodos() {
        return attBancoRepository.findAll();
    }

    public AttBancoModel buscarPorId(){
        Optional<AttBancoModel> produto = attBancoRepository.findById(id);
        return produto.orElse(null);
    }

}
