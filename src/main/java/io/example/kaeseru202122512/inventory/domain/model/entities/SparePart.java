package io.example.kaeseru202122512.inventory.domain.model.entities;

import io.example.kaeseru202122512.inventory.domain.model.aggregates.Equipment;
import io.example.kaeseru202122512.inventory.domain.model.valueobjects.MaterialSerialNumber;
import io.example.kaeseru202122512.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SparePart extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private MaterialSerialNumber materialSerialNumber;
    private Long supplierId;
    private String model;
    private String supplierProvidedSerialNumber;
    @ManyToOne
    private Equipment equipment;
    public SparePart(){}

    public SparePart(Long supplierId, String model, String supplierProvidedSerialNumber){
        this.supplierId = supplierId;
        this.model = model;
        this.supplierProvidedSerialNumber = supplierProvidedSerialNumber;
        this.materialSerialNumber = new MaterialSerialNumber();
    }
}
