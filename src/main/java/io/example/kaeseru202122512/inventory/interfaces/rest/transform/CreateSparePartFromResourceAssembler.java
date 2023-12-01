package io.example.kaeseru202122512.inventory.interfaces.rest.transform;

import io.example.kaeseru202122512.inventory.domain.model.commands.CreateSparePartCommand;
import io.example.kaeseru202122512.inventory.interfaces.rest.resources.CreateSparePartResource;

public class CreateSparePartFromResourceAssembler {
    public static CreateSparePartCommand toCommandFrom (CreateSparePartResource resource){
        return new CreateSparePartCommand(resource.supplierId(), resource.model(), resource.supplierProvidedSerialNumber(), resource.equipmentId());
    }
}
