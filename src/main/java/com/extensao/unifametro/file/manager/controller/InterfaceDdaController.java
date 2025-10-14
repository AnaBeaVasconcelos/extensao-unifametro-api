package com.extensao.unifametro.file.manager.controller;

import com.extensao.unifametro.file.manager.domain.interfaceDda.dto.InterfaceDdaDto;
import com.extensao.unifametro.file.manager.service.InterfaceDdaService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/dda")
public class InterfaceDdaController {

    private final InterfaceDdaService service;

    @GetMapping("/listar")
    public ResponseEntity<List<InterfaceDdaDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }


//TODO TA RETORNANDO 201 MESMO NO ERRO
    @PostMapping("/receber-dados-edi")
    public ResponseEntity<Void> receberDados(@RequestParam("file") @NotNull MultipartFile arquivo) {
        if (arquivo.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            service.receberDados(arquivo);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
