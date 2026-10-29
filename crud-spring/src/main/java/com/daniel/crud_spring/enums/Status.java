package com.daniel.crud_spring.enums;


public enum Status {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private String valor;

    // Construtor privado para inicializar o valor do status
    Status(String valor) {
        this.valor = valor;
    }

    // Método getter para obter o valor do status
    public String getValor() {
        return valor;
    }

    //to String para exibir o valor do status
    @Override
    public String toString() {
        return valor;
    }

}
