package io.example.kaeseru202122512.inventory.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;
@Embeddable
public record MaterialSerialNumber(String materialSerialNumber) {
    public MaterialSerialNumber(){
        this(UUID.randomUUID().toString());
    }

    public MaterialSerialNumber {
        if (materialSerialNumber == null || materialSerialNumber.isBlank()){
            throw new IllegalArgumentException("Material Serial Number cannot be null or blank");
        }
    }
}
