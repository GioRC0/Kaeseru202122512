package io.example.kaeseru202122512.inventory.domain.services;

import io.example.kaeseru202122512.inventory.domain.model.commands.CreateEquipmentCommand;

public interface EquipmentCommandService {
    Long handle (CreateEquipmentCommand command);
}
