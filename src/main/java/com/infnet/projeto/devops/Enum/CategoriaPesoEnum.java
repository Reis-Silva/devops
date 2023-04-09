package com.infnet.projeto.devops.Enum;

public enum CategoriaPesoEnum {
    
    ABAIXO_PESO("Abaixo do Peso"),
    PESO_NORMAL("Peso Normal"),
    SOBRE_PESO("Sobrepeso"),
    OBESIDADE_GRAU_UM("Obesidade Grau I"),
    OBESIDADE_GRAU_DOIS("Obesidade Grau II"),
    OBESIDADE_GRAU_TRES("Obesidade Grau III");

    private String categoria;
    CategoriaPesoEnum(String imc) {
        this.categoria = imc;
    }

    @Override
    public String toString() {
        return categoria;
    }

}
