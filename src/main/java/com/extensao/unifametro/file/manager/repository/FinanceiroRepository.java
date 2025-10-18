package com.extensao.unifametro.file.manager.repository;

import com.extensao.unifametro.file.manager.domain.financeiro.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {

    Boolean existsByCodBarras (String codBarras);

    @Modifying
    @Query(value = "UPDATE financeiro SET dtbaixa = CURRENT_DATE(), status = 1, dtpros = CURRENT_DATE() WHERE codbarras = :codBarras", nativeQuery = true)
    void atualizarDataBaixa(@Param("codBarras") String codBarras);
}
