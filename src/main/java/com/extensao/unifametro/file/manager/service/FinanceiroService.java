package com.extensao.unifametro.file.manager.service;

import com.extensao.unifametro.file.manager.domain.financeiro.dto.FinanceiroDto;
import com.extensao.unifametro.file.manager.mapper.FinanceiroMapper;
import com.extensao.unifametro.file.manager.repository.FinanceiroRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FinanceiroService {
    private final FinanceiroRepository repository;
    private final FinanceiroMapper mapper;

    private static final Logger logger = LoggerFactory.getLogger(InterfaceDdaService.class);

    public List<FinanceiroDto> listar() {
        return mapper.toDto(repository.findAll());
    }

    @Transactional
    public void leituraDados(@NotNull MultipartFile arquivo) throws IOException {
        File arquivoTemp = null;
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

        try {
            arquivoTemp = File.createTempFile("financeiro_", ".txt");
            arquivo.transferTo(arquivoTemp);

            try (FileReader fr = new FileReader(arquivoTemp);
                 BufferedReader br = new BufferedReader(fr)) {

                String linha;
                int contadorLinhas = 0;

                while ((linha = br.readLine()) != null) {
                    contadorLinhas++;

                    if (contadorLinhas < 2) {
                        continue;
                    }

                    char segmento = linha.charAt(13);

                    // Segmento J → título financeiro
                    if (segmento == 'J') {

                        String codBarras = linha.substring(16, 61).trim(); // Posições 18-61 (1-based)

                            if (validarMatchFinanceiro(codBarras)) {
                                repository.atualizarDataBaixa(codBarras);
                            }

                    }
                }
            }
        } finally {
            if (arquivoTemp != null && arquivoTemp.exists()) {
                arquivoTemp.delete();
            }
        }
    }


    private boolean validarMatchFinanceiro(String codBarras) {
        return repository.existsByCodBarras(codBarras);
    }
}

