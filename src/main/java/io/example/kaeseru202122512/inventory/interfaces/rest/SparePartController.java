package io.example.kaeseru202122512.inventory.interfaces.rest;

import io.example.kaeseru202122512.inventory.domain.model.commands.CreateSparePartCommand;
import io.example.kaeseru202122512.inventory.domain.services.SparePartCommandService;
import io.example.kaeseru202122512.inventory.interfaces.rest.resources.CreateSparePartResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/sparePart", produces = MediaType.APPLICATION_JSON_VALUE)
public class SparePartController {
    private final SparePartCommandService sparePartCommandService;

    public SparePartController(SparePartCommandService sparePartCommandService) {
        this.sparePartCommandService = sparePartCommandService;
    }

    @PostMapping
    public ResponseEntity<CreateSparePartResource> createSparePart(@RequestBody CreateSparePartResource resource){
        var command = new CreateSparePartCommand(resource.supplierId(),resource.model(),resource.supplierProvidedSerialNumber(),resource.equipmentId());
        var sparePartId = sparePartCommandService.handle(command);

        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }
}
