package io.example.kaeseru202122512.inventory.domain.services;

import io.example.kaeseru202122512.inventory.domain.model.aggregates.Equipment;
import io.example.kaeseru202122512.inventory.domain.model.queries.GetEquipmentByIdQuery;

import java.util.Optional;

public interface EquipmentQueryService {
    Optional<Equipment> handle(GetEquipmentByIdQuery query);
}
