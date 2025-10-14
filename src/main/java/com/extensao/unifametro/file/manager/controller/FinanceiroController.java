package com.extensao.unifametro.file.manager.controller;

import com.extensao.unifametro.file.manager.domain.financeiro.dto.FinanceiroDto;
//import com.extensao.unifametro.file.manager.mapper.FinanceiroMapper;
import com.extensao.unifametro.file.manager.service.FinanceiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/financeiro")
public class FinanceiroController {

    private final FinanceiroService service;

    @GetMapping("/listar")
    public ResponseEntity<List<FinanceiroDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PutMapping("/comparar-dados-edi")
    public ResponseEntity<FinanceiroDto> receberDados (@RequestParam Long id) {
//        return ResponseEntity.ok(service.receberDados(id));
//        @TODO:  COMPARA  O ARQUIVO ENVIADO NO UPLOAD COM O ARQUIVO DE REMESSA JA INSERIDO NO BANCO
//          ao passar para a service compara e atualiza os campos necessarios
        return ResponseEntity.ok().build();
    }
}
