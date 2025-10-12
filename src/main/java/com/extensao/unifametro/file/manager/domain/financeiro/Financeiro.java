package com.extensao.unifametro.file.manager.domain.financeiro;

import com.extensao.unifametro.file.manager.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity(name = "Financeiro")
@Table(name = "financeiro")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Financeiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codbarras")
    private String codBarras;

    @Column(name = "numdoc")
    private Long numDoc;

    @Column(name = "vlrdoc")
    private BigDecimal vlrDoc;

    @Column(name = "dtven")
    private Date dtVen;

    @Column(name = "dtpros")
    private Date dtPros;

    @Column(name = "nomeparc")
    private String nomeParc;

    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "dtbaixa")
    private Date dtBaixa;
}
