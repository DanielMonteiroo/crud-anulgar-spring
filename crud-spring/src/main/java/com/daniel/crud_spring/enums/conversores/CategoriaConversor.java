package com.daniel.crud_spring.enums.conversores;
import com.daniel.crud_spring.enums.Categoria;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class CategoriaConversor implements AttributeConverter<Categoria, String> {

    // Converte a categoria para o valor correspondente no banco de dados
    @Override
    public String convertToDatabaseColumn(Categoria categoria) {
        if (categoria == null) {
            return null;
        }
        return categoria.getValor();
    }

    // Converte o valor do banco de dados para a categoria correspondente
    public Categoria convertToEntityAttribute(Categoria valor) {
        if (valor == null) {
            return null;
        }
        return Stream.of(Categoria.values())
                .filter(c -> c.getValor().equals(valor.getValor()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Valor inválido para Categoria: " + valor));
    }

    // Implementação do método convertToEntityAttribute para atender à interface AttributeConverter
    @Override
    public Categoria convertToEntityAttribute(String dbData) {
        throw new UnsupportedOperationException("Unimplemented method 'convertToEntityAttribute'");
    }


}
