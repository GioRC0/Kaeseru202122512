package io.example.kaeseru202122512.inventory.domain.model.valueobjects;

public record EquipmentType(String equipmentType) {
    public EquipmentType(){this("");}

    public EquipmentType{
        if (equipmentType.equals("ScrewCompressor") || equipmentType.equals("AirTreatment")) ;
        else {
            throw new IllegalArgumentException("Equipment type cannot be different of screw compressor or air treatment");
        }
    }
}
