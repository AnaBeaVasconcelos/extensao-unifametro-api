package com.extensao.unifametro.file.manager.service;


import com.extensao.unifametro.file.manager.domain.interfaceDda.dto.InterfaceDdaDto;
import com.extensao.unifametro.file.manager.mapper.InterfaceDdaMapper;
import com.extensao.unifametro.file.manager.repository.InterfaceDdaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
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
public class InterfaceDdaService {
    private final InterfaceDdaRepository repository;
    private final InterfaceDdaMapper mapper;

    private static final Logger logger = LoggerFactory.getLogger(InterfaceDdaService.class);

    public List<InterfaceDdaDto> listar() {
        return mapper.toDto(repository.findAll());
    }

    @Transactional
    public void receberDados(@NotNull MultipartFile arquivo) throws IOException {
        File arquivoTemp = null;

        try {
            arquivoTemp = File.createTempFile("dda_", ".txt");
            arquivo.transferTo(arquivoTemp);

            try (FileReader fr = new FileReader(arquivoTemp);
                 BufferedReader br = new BufferedReader(fr)) {

                String primeiraLinha = br.readLine();
                if (primeiraLinha == null) {
                    return;
                }

                String cnpjEmp = primeiraLinha.substring(18, 32);
                String dia = primeiraLinha.substring(143, 145);
                String mes = primeiraLinha.substring(145, 147);
                String ano = primeiraLinha.substring(147, 151);
                String dtArquivo = dia + "/" + mes + "/" + ano;

                String linha;
                int contadorLinhas = 0;

                SimpleDateFormat dataFormater = new SimpleDateFormat("dd/MM/yyyy");

                while ((linha = br.readLine()) != null) {
                    contadorLinhas++;


                    if (contadorLinhas < 2) {
                        continue;
                    }

                    char segmento = linha.charAt(13);
                    if (segmento != 'G') {
                        continue;
                    }

                    String tipMov = linha.substring(15, 17);
                    if (!tipMov.equals("01") && !tipMov.equals("02")) {
                        continue;
                    }

                    String codBarras = linha.substring(16, 61).trim();
                    String cnpj = linha.substring(63, 77);
                    String nomeParc = linha.substring(77, 107).trim();

                    String dataVencimento = linha.substring(106, 116);
                    dataVencimento = dataVencimento.substring(1, 3) + "/" +
                            dataVencimento.substring(3, 5) + "/" +
                            dataVencimento.substring(5, 9);

                    Date dtVen = dataFormater.parse(dataVencimento);

//TODO: ADD ESSE CAMPO NA ENTIDADE
//                String dataEmissao = linha.substring(180, 189);
//                dataEmissao = dataEmissao.substring(1, 3) + "/" +
//                        dataEmissao.substring(3, 5) + "/" +
//                        dataEmissao.substring(5, 9);

                    //TODO:TA DANDO ERRO NO VALOR
                    String valorString = linha.substring(115, 130).replaceFirst("^0+(?!$)", "");
                    BigDecimal vlrDoc = new BigDecimal(valorString).divide(new BigDecimal(100));

                    String numDoc = linha.substring(147, 162).trim();

//                int count = verificarCodBarra(codBarras); TODO ADD VALIDATOR PELO CODIGO DE BARRAS, SE J[A HOUVER NAO INSERT
//                if (count <= 0) {
                    repository.inserirDadosArquivoDda(
                            codBarras,
//                            cnpj,
                            nomeParc,
//                            dataEmissao,
                            dtVen,
                            vlrDoc,
                            Long.valueOf(numDoc)
                    );
//                }
                }

            } catch (ParseException e) {
                throw new IOException("Erro ao parsear datas", e);
            }
        } catch (IOException e) {
            throw new IOException("Erro ao processar arquivo", e);
        } finally {
            if (arquivoTemp != null && arquivoTemp.exists()) {
                arquivoTemp.deleteOnExit();
            }
        }
    }
}
