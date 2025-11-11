package com.javaspringatt.atividadebancodedados.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<AttBancoModel> buscarPorId(@PathVariable int id) {
        AttBancoModel produto = attService.buscarPorId(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();    
    }

    @PostMapping
    public ResponseEntity<AttBancoModel> adicionarProduto(@RequestBody AttBancoModel produto) {
        AttBancoModel produtoSalvo = attService.adicionarProduto(produto);
            return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttBancoModel> atualizarProduto(@PathVariable int id, @RequestBody produto) {
        AttBancoModel produtoAtualizado = attService.atualizarProduto(id, produto);
        if (produtoAtualizado != null) {
            return ResponseEntity.ok(produtoAtualizado);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable int id) {
        AttBancoModel produto = attService.buscarPorId(id);
        if (produto != null) {
            attService.deletarProduto(id);
            return ResponseEntity.noContent().build();  
        }
        
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/total")
        public ResponseEntity<Double> calcularTotal() {
            double total = attService.calcularValorTotal();
            return ResponseEntity.ok(total);
        }

}
