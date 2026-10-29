package com.daniel.crud_spring.enums.conversores;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.daniel.crud_spring.enums.Status;
import java.util.stream.Stream;

@Converter(autoApply = true) 
public class StatusConversor implements AttributeConverter<Status, String> {

// Converte o status para o valor correspondente no banco de dados
@Override
    public String convertToDatabaseColumn(Status status) {
        if (status == null) {
            return null;
        }
        return status.getValor();
    }

// Converte o status para o valor correspondente no banco de dados
@Override
public Status convertToEntityAttribute(String dbData) {
    if (dbData == null) {
        return null;
    }

    return Stream.of(Status.values())
            .filter(status -> status.getValor()
            .equalsIgnoreCase(dbData.trim()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(
                    "Status inválido: " + dbData
            ));
}
}
    





