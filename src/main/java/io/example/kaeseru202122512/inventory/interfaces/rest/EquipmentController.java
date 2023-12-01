package io.example.kaeseru202122512.inventory.interfaces.rest;

import io.example.kaeseru202122512.inventory.domain.model.aggregates.Equipment;
import io.example.kaeseru202122512.inventory.domain.model.queries.GetEquipmentByIdQuery;
import io.example.kaeseru202122512.inventory.domain.services.EquipmentCommandService;
import io.example.kaeseru202122512.inventory.domain.services.EquipmentQueryService;
import io.example.kaeseru202122512.inventory.interfaces.rest.resources.CreateEquipmentResource;
import io.example.kaeseru202122512.inventory.interfaces.rest.transform.CreateEquipmentFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/equipment", produces = MediaType.APPLICATION_JSON_VALUE)
public class EquipmentController {
    private final EquipmentCommandService equipmentCommandService;
    private final EquipmentQueryService equipmentQueryService;

    public EquipmentController(EquipmentCommandService equipmentCommandService, EquipmentQueryService equipmentQueryService){
        this.equipmentCommandService = equipmentCommandService;
        this.equipmentQueryService = equipmentQueryService;
    }

    @PostMapping
    public ResponseEntity<CreateEquipmentResource> createEquipment(@RequestBody CreateEquipmentResource resource){
        var command = CreateEquipmentFromResourceAssembler.toCommandFrom(resource);
        var equipmentId = equipmentCommandService.handle(command);

        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }

    @GetMapping("/{equipmentId}")
    public ResponseEntity<CreateEquipmentResource> getEquipmentById(@PathVariable Long equipmentId){
        var query = new GetEquipmentByIdQuery(equipmentId);
        var equipment = equipmentQueryService.handle(query).get();
        var equipmentResponse = new CreateEquipmentResource(equipment.getModel(),equipment.getEEquipmentType().toString());
        return ResponseEntity.ok(equipmentResponse);
    }
}
