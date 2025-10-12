package com.extensao.unifametro.file.manager.mapper;

import com.extensao.unifametro.file.manager.domain.financeiro.Financeiro;
import com.extensao.unifametro.file.manager.domain.financeiro.dto.FinanceiroDto;
import com.extensao.unifametro.file.manager.domain.financeiro.form.FinanceiroForm;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;



@Mapper(componentModel = "spring")
public interface FinanceiroMapper extends EntityMapper<FinanceiroDto, Financeiro, FinanceiroForm> {

    Financeiro toModel(FinanceiroForm form);

    FinanceiroDto toDto(Financeiro entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFinanceiroFromFormIgnoreNull(FinanceiroForm form, @MappingTarget Financeiro entity);

    void updateFinanceiroFromForm(FinanceiroForm form, @MappingTarget Financeiro entity);
}

