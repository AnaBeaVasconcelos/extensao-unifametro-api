package com.extensao.unifametro.file.manager.controller;

import com.extensao.unifametro.file.manager.domain.financeiro.dto.FinanceiroDto;
//import com.extensao.unifametro.file.manager.mapper.FinanceiroMapper;
import com.extensao.unifametro.file.manager.service.FinanceiroService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/leitura-dados-edi")
    public ResponseEntity<Void> receberDados(@RequestParam("file") @NotNull MultipartFile arquivo) {
        if (arquivo.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            service.leituraDados(arquivo);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
