package com.daniel.crud_spring.enums;

public enum Categoria {
    BACK_END("Back-end"),
    FRONT_END("Front-end");

    private String valor;

    // Construtor privado para inicializar o valor da categoria
    private Categoria(String valor) {
        this.valor = valor;
    }

    // Método getter para obter o valor da categoria
    public String getValor() {
        return valor;
    }

    //to String para exibir o valor da categoria
    @Override
    public String toString() {
        return valor;           
    }
}
