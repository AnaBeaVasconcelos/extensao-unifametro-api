package com.extensao.unifametro.file.manager.domain.financeiro.form;

import com.extensao.unifametro.file.manager.enums.StatusEnum;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.sql.Date;

public class FinanceiroForm {
    @NotNull
    private String codBarras;
    @NotNull
    private Long numDoc;
    @NotNull
    private BigDecimal vlrDoc;
    @NotNull
    private Date dtVen;
    private Date dtPros;
    @NotNull
    private String nomeParc;
    @NotNull
    private StatusEnum status;
    private Date dtBaixa;
}
