package com.extensao.unifametro.file.manager.domain.financeiro.dto;

import com.extensao.unifametro.file.manager.enums.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
public class FinanceiroDto {

    private Long id;
    private String codBarras;
    private Long numDoc;
    private BigDecimal vlrDoc;
    private Date dtVen;
    private Date dtPros;
    private String nomeParc;
    private StatusEnum status;
    private Date dtBaixa;
}
