package com.extensao.unifametro.file.manager.repository;

import com.extensao.unifametro.file.manager.domain.financeiro.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {

}
