package com.daniel.crud_spring.enums.conversores;
import com.daniel.crud_spring.enums.Categoria;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class CategoriaConversor implements AttributeConverter<Categoria, String> {

    @Override
    public String convertToDatabaseColumn(Categoria categoria) {
       if (categoria == null) {
            return null;
        }   
        return categoria.getValor();
    }

    @Override
    public Categoria convertToEntityAttribute(String valor) {
        if (valor == null) {
            return null;
        }
        return Stream.of(Categoria.values())
                .filter(c -> c.getValor().equalsIgnoreCase(valor))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Valor inválido para Categoria: " + valor));
    }
    

     
        
}

    

