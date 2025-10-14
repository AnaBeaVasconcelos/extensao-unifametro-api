package com.extensao.unifametro.file.manager.mapper;

import com.extensao.unifametro.file.manager.domain.interfaceDda.InterfaceDda;
import com.extensao.unifametro.file.manager.domain.interfaceDda.dto.InterfaceDdaDto;
import com.extensao.unifametro.file.manager.domain.interfaceDda.form.InterfaceDdaForm;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring")
public interface InterfaceDdaMapper extends EntityMapper<InterfaceDdaDto, InterfaceDda, InterfaceDdaForm> {

    InterfaceDda toModel(InterfaceDdaForm form);

    InterfaceDdaDto toDto(InterfaceDda entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateInterfaceDdaFromFormIgnoreNull(InterfaceDdaForm form, @MappingTarget InterfaceDda entity);

    void updateInterfaceDdaFromForm(InterfaceDdaForm form, @MappingTarget InterfaceDda entity);
}

