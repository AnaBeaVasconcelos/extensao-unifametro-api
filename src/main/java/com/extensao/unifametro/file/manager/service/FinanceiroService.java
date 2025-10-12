package com.extensao.unifametro.file.manager.service;

import com.extensao.unifametro.file.manager.domain.financeiro.dto.FinanceiroDto;
import com.extensao.unifametro.file.manager.mapper.FinanceiroMapper;
import com.extensao.unifametro.file.manager.repository.FinanceiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinanceiroService {
    private final FinanceiroRepository repository;
    private final FinanceiroMapper mapper;


    public List<FinanceiroDto> listar() {
        return mapper.toDto(repository.findAll());
    }
}
