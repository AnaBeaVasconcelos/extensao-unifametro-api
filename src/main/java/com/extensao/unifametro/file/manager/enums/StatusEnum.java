package com.extensao.unifametro.file.manager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
    PENDENTE("Pendente"),
    BAIXADO("Baixado"),
    PROCESSADO("Processado"),
    NAO_ENCONTRADO("Não Encontrado");

    private String descricao;
}
