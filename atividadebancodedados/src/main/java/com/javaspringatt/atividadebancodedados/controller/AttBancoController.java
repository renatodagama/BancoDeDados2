package com.javaspringatt.atividadebancodedados.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/attbanco")
public class AttBancoController {

    @GetMapping
    public ResponseEntity<AttBancoModel> listarTodos() {
        List<AttBancoModel> produto = attBancoService.listarTodos();
        return ResponseEntity.ok(produto);
    }

    GetMapping("/{id}")
    public ResponseEntity<AttBancoModel> buscarPorId(@PathVariable int id) {
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<> atualizar(@PathVariable int id, @RequestBody produto) {


    }

}
