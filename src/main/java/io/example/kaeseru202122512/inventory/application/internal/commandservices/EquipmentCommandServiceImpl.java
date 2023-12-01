package io.example.kaeseru202122512.inventory.application.internal.commandservices;

import io.example.kaeseru202122512.inventory.domain.model.aggregates.Equipment;
import io.example.kaeseru202122512.inventory.domain.model.commands.CreateEquipmentCommand;
import io.example.kaeseru202122512.inventory.domain.services.EquipmentCommandService;
import io.example.kaeseru202122512.inventory.infrastructure.persistencia.jpa.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipmentCommandServiceImpl implements EquipmentCommandService {
    private EquipmentRepository equipmentRepository;

    public EquipmentCommandServiceImpl(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }
    @Override
    public Long handle(CreateEquipmentCommand command) {
        var equipment = new Equipment(command.model(), command.equipmentType());
        this.equipmentRepository.save(equipment);
        return equipment.getId();
    }
}
