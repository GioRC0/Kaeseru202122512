package io.example.kaeseru202122512.inventory.application.internal.commandservices;

import io.example.kaeseru202122512.inventory.domain.model.commands.CreateSparePartCommand;
import io.example.kaeseru202122512.inventory.domain.model.entities.SparePart;
import io.example.kaeseru202122512.inventory.domain.services.SparePartCommandService;
import io.example.kaeseru202122512.inventory.infrastructure.persistencia.jpa.repositories.EquipmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class SparePartCommandServiceImpl implements SparePartCommandService {
    private EquipmentRepository equipmentRepository;

    public SparePartCommandServiceImpl(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }
    @Override
    public Long handle(CreateSparePartCommand command) {
        var equipment = equipmentRepository.findEquipmentById(command.equipmentId()).get();
        var sparePart = new SparePart(command.supplierId(), command.model(), command.supplierProvidedSerialNumber());
        equipment.addSparePart(sparePart);
        equipmentRepository.save(equipment);
        return sparePart.getId();
    }
}
