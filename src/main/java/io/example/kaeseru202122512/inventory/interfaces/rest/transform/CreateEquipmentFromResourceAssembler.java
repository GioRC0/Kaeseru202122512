package io.example.kaeseru202122512.inventory.interfaces.rest.transform;

import io.example.kaeseru202122512.inventory.domain.model.commands.CreateEquipmentCommand;
import io.example.kaeseru202122512.inventory.interfaces.rest.resources.CreateEquipmentResource;

public class CreateEquipmentFromResourceAssembler {
    public static CreateEquipmentCommand toCommandFrom (CreateEquipmentResource resource){
        return new CreateEquipmentCommand(resource.model(), resource.equipmentType());
    }
}
