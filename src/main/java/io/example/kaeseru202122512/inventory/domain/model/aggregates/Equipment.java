package io.example.kaeseru202122512.inventory.domain.model.aggregates;

import io.example.kaeseru202122512.inventory.domain.model.entities.SparePart;
import io.example.kaeseru202122512.inventory.domain.model.valueobjects.EEquipmentType;
import io.example.kaeseru202122512.inventory.domain.model.valueobjects.EquipmentType;
import io.example.kaeseru202122512.inventory.domain.model.valueobjects.MaterialSerialNumber;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Equipment extends AbstractAggregateRoot<Equipment> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Embedded
    private MaterialSerialNumber materialSerialNumber;
    private String model;
    @Enumerated(EnumType.STRING)
    private EEquipmentType EEquipmentType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipment")
    private List<SparePart> spareParts;
    public Equipment(){}

    public Equipment(String model, String equipmentType){
        this.materialSerialNumber = new MaterialSerialNumber();
        this.model = model;
        this.EEquipmentType = getEquipmentType(equipmentType);
        this.spareParts = new ArrayList<>();
    }

    public void addSparePart(SparePart sparePart){
        this.spareParts.add(sparePart);
        sparePart.setEquipment(this);
    }

    EEquipmentType getEquipmentType(String equipmentType){
        var eequipmentType = new EquipmentType(equipmentType);
        return EEquipmentType.valueOf(eequipmentType.equipmentType());
    }
}
