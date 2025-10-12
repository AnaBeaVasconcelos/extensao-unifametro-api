package com.extensao.unifametro.file.manager.domain.interfaceDda.dto;

import com.extensao.unifametro.file.manager.enums.StatusEnum;

import java.math.BigDecimal;
import java.sql.Date;

public class InterfaceDdaDto {

    private Long id;
    private String codBarras;
    private Long numDoc;
    private BigDecimal vlrDoc;
    private Date dtVen;
    private Date dtPros;
    private String nomeParc;
    private StatusEnum status;
}
