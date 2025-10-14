package com.extensao.unifametro.file.manager.repository;

import com.extensao.unifametro.file.manager.domain.interfaceDda.InterfaceDda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface InterfaceDdaRepository extends JpaRepository<InterfaceDda, Long> {

    @Modifying
    @Query(value = "INSERT INTO interfacedda (codbarras, nomeparc, dtven, vlrdoc, numdoc, dtpros, status) " +
            "VALUES (:codBarras, :nomeParc, :dtVen, :vlrDoc, :numDoc, CURRENT_DATE, 0)", nativeQuery = true)
    void inserirDadosArquivoDda(@Param("codBarras") String codBarras,
//                                @Param("cnpj") String cnpj,
                                @Param("nomeParc") String nomeParc,
                                @Param("dtVen") Date dtVen,
                                @Param("vlrDoc") BigDecimal vlrDoc,
                                @Param("numDoc") Long numDoc);

}

